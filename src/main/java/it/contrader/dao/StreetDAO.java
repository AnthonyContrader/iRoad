package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Street;


public  class StreetDAO implements DAO<Street> {
	
	private final String QUERY_ALL = "SELECT * FROM street";
	private final String QUERY_CREATE = "INSERT INTO street (streetname, streettype) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM street WHERE idstreet=?";
	private final String QUERY_UPDATE = "UPDATE street SET streetname=?, streettype=? WHERE idstreet=?";
	private final String QUERY_DELETE = "DELETE FROM street WHERE idstreet=?";
	
	
	
	public StreetDAO() {
		
	}
	
	

	
	
	
	
	public List<Street> getAll() {
		List<Street> streetsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Street street;
			while (resultSet.next()) {
				int idstreet = resultSet.getInt("idstreet");
				String streetname = resultSet.getString("streetname");
				String streettype = resultSet.getString("streettype");
				
				street = new Street(streetname, streettype);
				street.setIdstreet(idstreet);
				streetsList.add(street);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return streetsList;
	}

	public boolean insert(Street streetToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, streetToInsert.getSreetname());
			preparedStatement.setString(2, streetToInsert.getSreettype());
			
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Street read(int streetId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, streetId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String streetname, streettype;
		

			streetname = resultSet.getString("streetname");
			streettype = resultSet.getString("streettype");
			
			Street street = new Street(streetname, streettype);
			street.setIdstreet(resultSet.getInt("idstreet"));

			return street;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Street streetToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (streetToUpdate.getIdstreet() == 0)
			return false;

		Street streetRead = read(streetToUpdate.getIdstreet());
		if (!streetRead.equals(streetToUpdate)) {
			try {
				// Fill the streetToUpdate object
				if (streetToUpdate.getSreetname() == null || streetToUpdate.getSreetname().equals("")) {
					streetToUpdate.setStreetname(streetRead.getSreetname());
				}


				if (streetToUpdate.getSreettype() == null || streetToUpdate.getSreettype().equals("")) {
					streetToUpdate.setStreettype(streetRead.getSreettype());
				}

				// Update the street
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				
				preparedStatement.setString(1, streetToUpdate.getSreetname());
			
				preparedStatement.setString(2, streetToUpdate.getSreettype());
	
				preparedStatement.setInt(3, streetToUpdate.getIdstreet());
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

	public boolean delete(int idstreet) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idstreet);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}
