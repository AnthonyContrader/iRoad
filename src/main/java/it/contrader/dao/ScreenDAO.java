package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Screen;

//Vengono definiti gli attributi del CRUD
public class ScreenDAO implements DAO<Screen> {

	private final String QUERY_ALL = "SELECT * FROM screen";
	private final String QUERY_CREATE = "INSERT INTO screen (output) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM screen WHERE idScreen=?";
	private final String QUERY_UPDATE = "UPDATE screen SET output=? WHERE idScreen=?";
	private final String QUERY_DELETE = "DELETE FROM screen WHERE idScreen=?";

	public ScreenDAO() {

	}

	// si connette al database per mostrare la lista degli screen
	public List<Screen> getAll() {
		List<Screen> screensList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Screen screen;
			while (resultSet.next()) {
				int idScreen = resultSet.getInt("idScreen");
				String output = resultSet.getString("output");
				screen = new Screen(output);
				screen.setIdScreen(idScreen);
				screensList.add(screen);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return screensList;
	}

//si connette al database per la creazione dello screen
	public boolean insert(Screen screenToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, screenToInsert.getOutput());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Screen read(int screenIdScreen) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, screenIdScreen);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String output;

			output = resultSet.getString("output");
			Screen screen = new Screen(output);
			screen.setIdScreen(resultSet.getInt("idScreen"));

			return screen;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Screen screenToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		System.out.println("valore da inserire"+screenToUpdate.getOutput());
		// controlla se è presente un id
		if (screenToUpdate.getIdScreen() == 0)
			return false;

		Screen screenRead = read(screenToUpdate.getIdScreen());
		
		if (!screenRead.equals(screenToUpdate)) {
			try {
				// riempie l'oggetto ScreenToUpdate
				if (screenToUpdate.getOutput() == null || screenToUpdate.getOutput().equals("")) {
					screenToUpdate.setOutput(screenRead.getOutput());
				}
				System.out.println("ZZXXXXXXXXXe"+screenToUpdate.getOutput());
				// Si connette al database per l'Update dello screen
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);

				preparedStatement.setString(1, screenToUpdate.getOutput());
				preparedStatement.setInt(2, screenToUpdate.getIdScreen());
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

	// si connette al database per il Delete dello screen
	public boolean delete(int idScreen) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idScreen);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}

}
