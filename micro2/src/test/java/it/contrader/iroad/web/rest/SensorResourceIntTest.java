package it.contrader.iroad.web.rest;

import it.contrader.iroad.Micro2App;

import it.contrader.iroad.domain.Sensor;
import it.contrader.iroad.domain.Street;
import it.contrader.iroad.repository.SensorRepository;
import it.contrader.iroad.service.SensorService;
import it.contrader.iroad.service.dto.SensorDTO;
import it.contrader.iroad.service.mapper.SensorMapper;
import it.contrader.iroad.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


import static it.contrader.iroad.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import it.contrader.iroad.domain.enumeration.Sensortype;
/**
 * Test class for the SensorResource REST controller.
 *
 * @see SensorResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Micro2App.class)
public class SensorResourceIntTest {

    private static final Sensortype DEFAULT_SENSOR_TYPE = Sensortype.AUTOVELOX;
    private static final Sensortype UPDATED_SENSOR_TYPE = Sensortype.DINAMOMETRO;

    private static final Float DEFAULT_LONG_SENSOR = 1F;
    private static final Float UPDATED_LONG_SENSOR = 2F;

    private static final Float DEFAULT_LAT_SENSOR = 1F;
    private static final Float UPDATED_LAT_SENSOR = 2F;

    @Autowired
    private SensorRepository sensorRepository;


    @Autowired
    private SensorMapper sensorMapper;
    

    @Autowired
    private SensorService sensorService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restSensorMockMvc;

    private Sensor sensor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SensorResource sensorResource = new SensorResource(sensorService);
        this.restSensorMockMvc = MockMvcBuilders.standaloneSetup(sensorResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Sensor createEntity(EntityManager em) {
        Sensor sensor = new Sensor()
            .sensorType(DEFAULT_SENSOR_TYPE)
            .longSensor(DEFAULT_LONG_SENSOR)
            .latSensor(DEFAULT_LAT_SENSOR);
        // Add required entity
        Street street = StreetResourceIntTest.createEntity(em);
        em.persist(street);
        em.flush();
        sensor.setStreet(street);
        return sensor;
    }

    @Before
    public void initTest() {
        sensor = createEntity(em);
    }

    @Test
    @Transactional
    public void createSensor() throws Exception {
        int databaseSizeBeforeCreate = sensorRepository.findAll().size();

        // Create the Sensor
        SensorDTO sensorDTO = sensorMapper.toDto(sensor);
        restSensorMockMvc.perform(post("/api/sensors")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sensorDTO)))
            .andExpect(status().isCreated());

        // Validate the Sensor in the database
        List<Sensor> sensorList = sensorRepository.findAll();
        assertThat(sensorList).hasSize(databaseSizeBeforeCreate + 1);
        Sensor testSensor = sensorList.get(sensorList.size() - 1);
        assertThat(testSensor.getSensorType()).isEqualTo(DEFAULT_SENSOR_TYPE);
        assertThat(testSensor.getLongSensor()).isEqualTo(DEFAULT_LONG_SENSOR);
        assertThat(testSensor.getLatSensor()).isEqualTo(DEFAULT_LAT_SENSOR);
    }

    @Test
    @Transactional
    public void createSensorWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sensorRepository.findAll().size();

        // Create the Sensor with an existing ID
        sensor.setId(1L);
        SensorDTO sensorDTO = sensorMapper.toDto(sensor);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSensorMockMvc.perform(post("/api/sensors")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sensorDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Sensor in the database
        List<Sensor> sensorList = sensorRepository.findAll();
        assertThat(sensorList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkSensorTypeIsRequired() throws Exception {
        int databaseSizeBeforeTest = sensorRepository.findAll().size();
        // set the field null
        sensor.setSensorType(null);

        // Create the Sensor, which fails.
        SensorDTO sensorDTO = sensorMapper.toDto(sensor);

        restSensorMockMvc.perform(post("/api/sensors")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sensorDTO)))
            .andExpect(status().isBadRequest());

        List<Sensor> sensorList = sensorRepository.findAll();
        assertThat(sensorList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkLongSensorIsRequired() throws Exception {
        int databaseSizeBeforeTest = sensorRepository.findAll().size();
        // set the field null
        sensor.setLongSensor(null);

        // Create the Sensor, which fails.
        SensorDTO sensorDTO = sensorMapper.toDto(sensor);

        restSensorMockMvc.perform(post("/api/sensors")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sensorDTO)))
            .andExpect(status().isBadRequest());

        List<Sensor> sensorList = sensorRepository.findAll();
        assertThat(sensorList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkLatSensorIsRequired() throws Exception {
        int databaseSizeBeforeTest = sensorRepository.findAll().size();
        // set the field null
        sensor.setLatSensor(null);

        // Create the Sensor, which fails.
        SensorDTO sensorDTO = sensorMapper.toDto(sensor);

        restSensorMockMvc.perform(post("/api/sensors")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sensorDTO)))
            .andExpect(status().isBadRequest());

        List<Sensor> sensorList = sensorRepository.findAll();
        assertThat(sensorList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllSensors() throws Exception {
        // Initialize the database
        sensorRepository.saveAndFlush(sensor);

        // Get all the sensorList
        restSensorMockMvc.perform(get("/api/sensors?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sensor.getId().intValue())))
            .andExpect(jsonPath("$.[*].sensorType").value(hasItem(DEFAULT_SENSOR_TYPE.toString())))
            .andExpect(jsonPath("$.[*].longSensor").value(hasItem(DEFAULT_LONG_SENSOR.doubleValue())))
            .andExpect(jsonPath("$.[*].latSensor").value(hasItem(DEFAULT_LAT_SENSOR.doubleValue())));
    }
    

    @Test
    @Transactional
    public void getSensor() throws Exception {
        // Initialize the database
        sensorRepository.saveAndFlush(sensor);

        // Get the sensor
        restSensorMockMvc.perform(get("/api/sensors/{id}", sensor.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(sensor.getId().intValue()))
            .andExpect(jsonPath("$.sensorType").value(DEFAULT_SENSOR_TYPE.toString()))
            .andExpect(jsonPath("$.longSensor").value(DEFAULT_LONG_SENSOR.doubleValue()))
            .andExpect(jsonPath("$.latSensor").value(DEFAULT_LAT_SENSOR.doubleValue()));
    }
    @Test
    @Transactional
    public void getNonExistingSensor() throws Exception {
        // Get the sensor
        restSensorMockMvc.perform(get("/api/sensors/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSensor() throws Exception {
        // Initialize the database
        sensorRepository.saveAndFlush(sensor);

        int databaseSizeBeforeUpdate = sensorRepository.findAll().size();

        // Update the sensor
        Sensor updatedSensor = sensorRepository.findById(sensor.getId()).get();
        // Disconnect from session so that the updates on updatedSensor are not directly saved in db
        em.detach(updatedSensor);
        updatedSensor
            .sensorType(UPDATED_SENSOR_TYPE)
            .longSensor(UPDATED_LONG_SENSOR)
            .latSensor(UPDATED_LAT_SENSOR);
        SensorDTO sensorDTO = sensorMapper.toDto(updatedSensor);

        restSensorMockMvc.perform(put("/api/sensors")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sensorDTO)))
            .andExpect(status().isOk());

        // Validate the Sensor in the database
        List<Sensor> sensorList = sensorRepository.findAll();
        assertThat(sensorList).hasSize(databaseSizeBeforeUpdate);
        Sensor testSensor = sensorList.get(sensorList.size() - 1);
        assertThat(testSensor.getSensorType()).isEqualTo(UPDATED_SENSOR_TYPE);
        assertThat(testSensor.getLongSensor()).isEqualTo(UPDATED_LONG_SENSOR);
        assertThat(testSensor.getLatSensor()).isEqualTo(UPDATED_LAT_SENSOR);
    }

    @Test
    @Transactional
    public void updateNonExistingSensor() throws Exception {
        int databaseSizeBeforeUpdate = sensorRepository.findAll().size();

        // Create the Sensor
        SensorDTO sensorDTO = sensorMapper.toDto(sensor);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restSensorMockMvc.perform(put("/api/sensors")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sensorDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Sensor in the database
        List<Sensor> sensorList = sensorRepository.findAll();
        assertThat(sensorList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSensor() throws Exception {
        // Initialize the database
        sensorRepository.saveAndFlush(sensor);

        int databaseSizeBeforeDelete = sensorRepository.findAll().size();

        // Get the sensor
        restSensorMockMvc.perform(delete("/api/sensors/{id}", sensor.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Sensor> sensorList = sensorRepository.findAll();
        assertThat(sensorList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Sensor.class);
        Sensor sensor1 = new Sensor();
        sensor1.setId(1L);
        Sensor sensor2 = new Sensor();
        sensor2.setId(sensor1.getId());
        assertThat(sensor1).isEqualTo(sensor2);
        sensor2.setId(2L);
        assertThat(sensor1).isNotEqualTo(sensor2);
        sensor1.setId(null);
        assertThat(sensor1).isNotEqualTo(sensor2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SensorDTO.class);
        SensorDTO sensorDTO1 = new SensorDTO();
        sensorDTO1.setId(1L);
        SensorDTO sensorDTO2 = new SensorDTO();
        assertThat(sensorDTO1).isNotEqualTo(sensorDTO2);
        sensorDTO2.setId(sensorDTO1.getId());
        assertThat(sensorDTO1).isEqualTo(sensorDTO2);
        sensorDTO2.setId(2L);
        assertThat(sensorDTO1).isNotEqualTo(sensorDTO2);
        sensorDTO1.setId(null);
        assertThat(sensorDTO1).isNotEqualTo(sensorDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(sensorMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(sensorMapper.fromId(null)).isNull();
    }
}
