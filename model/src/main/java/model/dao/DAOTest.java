package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.IDAOTest;

public class DAOTest implements IDAOTest {
	private String URL = "jdbc:mysql://178.62.12.146:3306/boulderdash";
	private String LOGIN = "boulderdash";
	private String PASSWORD = "boulderdash";
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet result;
	private char tab[][] = new char[22][40];
	private int choice = 0;

//	public DAOTest(int choice){
//		this.choice = choice;
//	}
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

	/**
	 * Execute a static SQL request
	 * 
	 */

	public void executeQuery(int choice) {
		try {
			switch (choice) {
			case 1:
				result = statement.executeQuery("call `procédure_LV1`");
				break;
				
			case 2:
				result = statement.executeQuery("call `procédure_LV2`");
				break;
				
			case 3:
				//result = statement.executeQuery("call `procédure_LV3`");
				result = statement.executeQuery("call `test`");
				break;
				
			case 4:
				result = statement.executeQuery("call `procédure_LV4`");
				break;
				
			case 5:
				result = statement.executeQuery("call `procédure_LV5`");
				break;
				
			default:
				System.out.print("System error");
				break;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Take the data of the executed request and put character of the map in a
	 * character table
	 */

	public void setQueryIntoTable() {
		try {
			int ligne = 0;
			while (result.next()) {
				for (int colonne = 0; colonne < result.getObject(2).toString().length(); colonne++) {
					tab[ligne][colonne] = result.getObject(2).toString().charAt(colonne);
				}
				ligne++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * Show the map in the console in the form of characters
		 * 
		 */

//		 for (char sousTab[] : tab){
//		 for(char str : sousTab){
//		 System.out.print(str);
//		 }
//		 System.out.println("");
//		 }

	}

	/**
	 * @return tab the table which contains the result of the executed query
	 * 
	 */

	public char[][] getTab() {
		return tab;
	}
}