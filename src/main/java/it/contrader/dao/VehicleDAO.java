package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Vehicle;

/**
 * 
 * @author Tunzis
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class VehicleDAO implements DAO<Vehicle> {

	private final String QUERY_ALL = "SELECT * FROM vehicle";
	private final String QUERY_CREATE = "INSERT INTO vehicle (nameVehicle, typeVehicle, speedVehicle, weightVehicle,longVehicle,latVehicle) VALUES (?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM vehicle WHERE idVehicle=?";
	private final String QUERY_UPDATE = "UPDATE vehicle SET nameVehicle=?, typeVehicle=?, speedVehicle=?, weightVehicle=?,  longVehicle=? ,latVehicle=? WHERE idVehicle=?";
	private final String QUERY_DELETE = "DELETE FROM vehicle WHERE idVehicle=?";

	public VehicleDAO() {

	}

	public List<Vehicle> getAll() {
		List<Vehicle> vehiclesList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Vehicle vehicle;
			while (resultSet.next()) {
				int idVehicle = resultSet.getInt("idVehicle");
				String nameVehicle = resultSet.getString("nameVehicle");
				String typeVehicle = resultSet.getString("typeVehicle");
				double speedVehicle = resultSet.getDouble("speedVehicle");
				double weightVehicle = resultSet.getDouble("weightVehicle");
				
				double longVehicle = resultSet.getDouble("longVehicle");
				double latVehicle = resultSet.getDouble("latVehicle");
				
				vehicle = new Vehicle(nameVehicle, typeVehicle, speedVehicle, weightVehicle,  longVehicle ,latVehicle);
				vehicle.setIdVehicle(idVehicle);
				vehiclesList.add(vehicle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehiclesList;
	}

	public boolean insert(Vehicle vehicleToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, vehicleToInsert.getNameVehicle());
			preparedStatement.setString(3, vehicleToInsert.getTypeVehicle());
			preparedStatement.setDouble(4, vehicleToInsert.getSpeedVehicle());
			preparedStatement.setDouble(5, vehicleToInsert.getWeightVehicle());	
			preparedStatement.setDouble(6, vehicleToInsert.getLongVehicle());
			preparedStatement.setDouble(7, vehicleToInsert.getLatVehicle());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
                            //vehicleId sostituito a vehicleId
	public Vehicle read(int vehicleId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, vehicleId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String nameVehicle, typeVehicle;
			double speedVehicle, weightVehicle, latVehicle, longVehicle;

			nameVehicle = resultSet.getString("nameVehicle");
			typeVehicle = resultSet.getString("typeVehicle");
			speedVehicle = resultSet.getDouble("speedVehicle");
			weightVehicle = resultSet.getDouble("weightVehicle");
			latVehicle = resultSet.getDouble("latVehicle");
			longVehicle = resultSet.getDouble("longVehicle");
			Vehicle vehicle = new Vehicle(nameVehicle, typeVehicle, speedVehicle, weightVehicle, latVehicle, longVehicle);
			vehicle.setIdVehicle(resultSet.getInt("idVehicle"));

			return vehicle;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Vehicle vehicleToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (vehicleToUpdate.getIdVehicle() == 0)
			return false;
		Vehicle vehicleRead = read(vehicleToUpdate.getIdVehicle());
		if (!vehicleRead.equals(vehicleToUpdate)) {
			try {
				// Fill the vehicleToUpdate object
				if (vehicleToUpdate.getNameVehicle() == null || vehicleToUpdate.getNameVehicle().equals("")) {
					vehicleToUpdate.setNameVehicle(vehicleRead.getNameVehicle());
				}

				if (vehicleToUpdate.getTypeVehicle() == null || vehicleToUpdate.getTypeVehicle().equals("")) {
					vehicleToUpdate.setTypeVehicle(vehicleRead.getTypeVehicle());
				}

				// Update the vehicle
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				
				preparedStatement.setInt(6, vehicleToUpdate.getIdVehicle());
				preparedStatement.setString(1, vehicleToUpdate.getNameVehicle());
				preparedStatement.setString(3, vehicleToUpdate.getTypeVehicle());
				preparedStatement.setDouble(4, vehicleToUpdate.getSpeedVehicle());
				preparedStatement.setDouble(5, vehicleToUpdate.getWeightVehicle());
				preparedStatement.setDouble(5, vehicleToUpdate.getLatVehicle());
				preparedStatement.setDouble(5, vehicleToUpdate.getLongVehicle());
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

	public boolean delete(int idVehicle) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idVehicle);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}
