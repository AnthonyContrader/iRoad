package it.contrader.iroad.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.contrader.iroad.service.StreetService;
import it.contrader.iroad.web.rest.errors.BadRequestAlertException;
import it.contrader.iroad.web.rest.util.HeaderUtil;
import it.contrader.iroad.service.dto.StreetDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Street.
 */
@RestController
@RequestMapping("/api")
public class StreetResource {

    private final Logger log = LoggerFactory.getLogger(StreetResource.class);

    private static final String ENTITY_NAME = "street";

    private final StreetService streetService;

    public StreetResource(StreetService streetService) {
        this.streetService = streetService;
    }

    /**
     * POST  /streets : Create a new street.
     *
     * @param streetDTO the streetDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new streetDTO, or with status 400 (Bad Request) if the street has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/streets")
    @Timed
    public ResponseEntity<StreetDTO> createStreet(@Valid @RequestBody StreetDTO streetDTO) throws URISyntaxException {
        log.debug("REST request to save Street : {}", streetDTO);
        if (streetDTO.getId() != null) {
            throw new BadRequestAlertException("A new street cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StreetDTO result = streetService.save(streetDTO);
        return ResponseEntity.created(new URI("/api/streets/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /streets : Updates an existing street.
     *
     * @param streetDTO the streetDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated streetDTO,
     * or with status 400 (Bad Request) if the streetDTO is not valid,
     * or with status 500 (Internal Server Error) if the streetDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/streets")
    @Timed
    public ResponseEntity<StreetDTO> updateStreet(@Valid @RequestBody StreetDTO streetDTO) throws URISyntaxException {
        log.debug("REST request to update Street : {}", streetDTO);
        if (streetDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        StreetDTO result = streetService.save(streetDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, streetDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /streets : get all the streets.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of streets in body
     */
    @GetMapping("/streets")
    @Timed
    public List<StreetDTO> getAllStreets() {
        log.debug("REST request to get all Streets");
        return streetService.findAll();
    }

    /**
     * GET  /streets/:id : get the "id" street.
     *
     * @param id the id of the streetDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the streetDTO, or with status 404 (Not Found)
     */
    @GetMapping("/streets/{id}")
    @Timed
    public ResponseEntity<StreetDTO> getStreet(@PathVariable Long id) {
        log.debug("REST request to get Street : {}", id);
        Optional<StreetDTO> streetDTO = streetService.findOne(id);
        return ResponseUtil.wrapOrNotFound(streetDTO);
    }

    /**
     * DELETE  /streets/:id : delete the "id" street.
     *
     * @param id the id of the streetDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/streets/{id}")
    @Timed
    public ResponseEntity<Void> deleteStreet(@PathVariable Long id) {
        log.debug("REST request to delete Street : {}", id);
        streetService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
