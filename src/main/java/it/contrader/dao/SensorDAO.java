package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Sensor;

/**
 * 
 * @author Antonio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class SensorDAO implements DAO<Sensor> {

	private final String QUERY_ALL = "SELECT * FROM sensor";
	private final String QUERY_CREATE = "INSERT INTO sensor (SensorPosition, SensorType) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM sensor WHERE idSensor=?";
	private final String QUERY_UPDATE = "UPDATE sensor SET SensorPosition=?, SensorType=? WHERE idSensor=?";
	private final String QUERY_DELETE = "DELETE FROM sensor WHERE idSensor=?";
	
	public SensorDAO() {

	}

	public List<Sensor> getAll() {
		List<Sensor> sensorList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Sensor sensor;
			while (resultSet.next()) {
				int idSensor = resultSet.getInt("idSensor");
				String SensorPosition = resultSet.getString("SensorPosition");
				String SensorType = resultSet.getString("SensorType");
				sensor = new Sensor(SensorPosition, SensorType);
				sensor.setIdSensor(idSensor);
				sensorList.add(sensor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sensorList;
	}

	public boolean insert(Sensor sensorToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, sensorToInsert.getSensorPosition());
			preparedStatement.setString(2, sensorToInsert.getSensorType());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Sensor read(int userIdSensor) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, userIdSensor);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String SensorPosition, SensorType;

			SensorPosition = resultSet.getString("SensorPosition");
			SensorType = resultSet.getString("SensorType");
			Sensor sensor = new Sensor(SensorPosition, SensorType);
			sensor.setIdSensor(resultSet.getInt("idSensor"));

			return sensor;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Sensor sensorToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if sensor is present
		if (sensorToUpdate.getIdSensor() == 0)
			return false;

		Sensor sensorRead = read(sensorToUpdate.getIdSensor());
		if (!sensorRead.equals(sensorToUpdate)) {
			try {
				// Fill the sensorToUpdate object
				if (sensorToUpdate.getSensorPosition() == null || sensorToUpdate.getSensorPosition().equals("")) {
					sensorToUpdate.setSensorPosition(sensorRead.getSensorPosition());
				}

				if (sensorToUpdate.getSensorType() == null || sensorToUpdate.getSensorType().equals("")) {
					sensorToUpdate.setSensorType(sensorRead.getSensorType());
				}

				if (sensorToUpdate.getSensorType() == null || sensorToUpdate.getSensorType().equals("")) {
					sensorToUpdate.setSensorType(sensorRead.getSensorType());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, sensorToUpdate.getSensorPosition());
				preparedStatement.setString(2, sensorToUpdate.getSensorType());
				preparedStatement.setInt(3, sensorToUpdate.getIdSensor());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int idSensor) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idSensor);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}
