package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface IDiamondQuery {
	

	/**
	 * It's about executing the query in order
	 * to get corresponding amount of diamonds needed in the chosen map
	 * @param result
	 * @param statement
	 * @return result
	 * @throws SQLException
	 */
	public ResultSet executeDiamondQuery(ResultSet result, Statement statement) throws SQLException;
	
	/**
	 * Put the request in a attribute
	 * @param result
	 */
	public void setQueryDiamondsInToInteger(ResultSet result);

}
