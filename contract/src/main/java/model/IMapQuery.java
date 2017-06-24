package model;

import java.sql.ResultSet;
import java.sql.Statement;

public interface IMapQuery {

	/**
	 * It's about executing the query in order to get the chosen map
	 * 
	 * @param result
	 * @param statement
	 */
	public ResultSet executeMapQuery(ResultSet result, Statement statement);
	
	/**
	 * Fill the result of the query in character table
	 * 
	 * @param result
	 * @param tab
	 */
	public void setMapQueryIntoTable(ResultSet result, char[][] tab);	
}
