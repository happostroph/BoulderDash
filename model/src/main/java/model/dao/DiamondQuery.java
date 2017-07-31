package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.IDiamondQuery;

public class DiamondQuery extends LaunchDBQuery implements IDiamondQuery{
	
	/**
	 * Constructor of DiamondQuery
	 * 
	 * @param level
	 */
	public DiamondQuery(int level, String name) {
		super(level, name);
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see model.IDiamondQuery#executeDiamondQuery(java.sql.ResultSet, java.sql.Statement)
	 */
	public ResultSet executeDiamondQuery(ResultSet result, Statement statement) throws SQLException {
		switch (level) {
		case 1:
			result = statement.executeQuery("call `GetDiamonds_1`()");
			break;
		case 2:
			result = statement.executeQuery("call `GetDiamonds_2`()");
			break;
		case 3:
			result = statement.executeQuery("call `GetDiamonds_3`()");
			break;
		case 4:
			result = statement.executeQuery("call `GetDiamonds_4`()");
			break;
		case 5:
			result = statement.executeQuery("call `GetDiamonds_5`()");
			break;
		default:
			System.out.print("System error");
			break;
		}
		return result;
	}
	
	/**
	 * Put the request in a attribute
	 */
	public void setQueryDiamondsInToInteger(ResultSet result){
		try {
			result.next();
			finalDiamonds = result.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
