package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LaunchDBQuery {
	protected static int level = 0, finalDiamonds = 0;
	protected static char tab[][] = new char[22][40];
	protected static String name = "";
	protected static DAOConnector connectionBDD;
	protected static MapQuery mapQuery;
	protected static DiamondQuery diamondQuery;
	protected static ScoreQuery ScoreQuery;
	protected static Statement statement = null;
	protected static ResultSet result;
	
	/**
	 * Constructor of LaunchDBQuery
	 * 
	 * @param level
	 */
	public LaunchDBQuery(int level, String name){
		LaunchDBQuery.level = level;
		LaunchDBQuery.name = name;
	}
	
	/**
	 * Contains all the query we need to execute
	 */
	public void launchQueries(){
		connectionBDD = new DAOConnector(level, name);
		connectionBDD.connection();
		
		mapQuery = new MapQuery(level, name);
		result = mapQuery.executeMapQuery(result, statement);
		mapQuery.setMapQueryIntoTable(result, tab);

		diamondQuery = new DiamondQuery(level, name);
		try {
			result = diamondQuery.executeDiamondQuery(result, statement);
			diamondQuery.setQueryDiamondsInToInteger(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void launchScoreQuery(int score){
		connectionBDD = new DAOConnector(level, name);
		connectionBDD.connection();
		
		ScoreQuery = new ScoreQuery(level, name);
		try {
			ScoreQuery.SetScoreIntoDatabase(statement, score, level, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Getters of tab
	 * 
	 * @return tab
	 */
	public char[][] getTab() {
		return tab;
	}
	
	/**
	 * Getters of finalDiamonds
	 * 
	 * @return finalDiamonds
	 */
	public int getFinalDiamonds() {
		return finalDiamonds;
	}
}
