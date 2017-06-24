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
	
	public LaunchDBQuery(int level){
		LaunchDBQuery.level = level;
	}
	
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
	
	public char[][] getTab() {
		return tab;
	}
	
	public int getFinalDiamonds() {
		return finalDiamonds;
	}
}
