package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LaunchDBQuery {
	protected static int level = 0, finalDiamonds = 0;
	protected static char tab[][] = new char[22][40];
	protected static DAOConnector connectionBDD;
	protected static MapQuery mapQuery;
	protected static DiamondQuery diamondQuery;
	protected static Statement statement = null;
	protected static ResultSet result;
	
	/**
	 * Constructor of LaunchDBQuery
	 * 
	 * @param level
	 */
	public LaunchDBQuery(int level){
		LaunchDBQuery.level = level;
	}
	
	/**
	 * Contains all the query we need to execute
	 */
	public void launchQueries(){
		connectionBDD = new DAOConnector(level);
		connectionBDD.connection();
		
		mapQuery = new MapQuery(level);
		result = mapQuery.executeMapQuery(result, statement);
		mapQuery.setMapQueryIntoTable(result, tab);

		diamondQuery = new DiamondQuery(level);
		try {
			result = diamondQuery.executeDiamondQuery(result, statement);
			diamondQuery.setQueryDiamondsInToInteger(result);
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
