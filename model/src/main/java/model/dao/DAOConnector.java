package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.IDAOConnector;

public class DAOConnector extends LaunchDBQuery implements IDAOConnector {
	private final String URL = "jdbc:mysql://178.62.12.146:3306/boulderdash";
	private final String LOGIN = "boulderdash";
	private final String PASSWORD = "boulderdash";
	private Connection connection = null;
	private int choice = 0;
	
	/**
	 * Constructor of DAOConnector
	 * 
	 * @param level
	 */
	public DAOConnector(int level) {
		super(level);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Connection to the remote database
	 */
	public void connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			statement = connection.createStatement();
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see model.IDAOTest#getChoice()
	 */
	public int getChoice() {
		return choice;
	}

	/* (non-Javadoc)
	 * @see model.IDAOConnector#getStatement()
	 */
	public Statement getStatement() {
		return statement;
	}

	/* (non-Javadoc)
	 * @see model.IDAOConnector#getResult()
	 */
	public ResultSet getResult() {
		return result;
	}

}