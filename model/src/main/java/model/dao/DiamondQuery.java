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
	 * @param result
	 * @param statement
	 */
	public DiamondQuery(int level) {
		super(level);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Take in BD the number of diamonds corresponding to the map
	 * @param choice
	 * @throws SQLException
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
	 * @throws SQLException
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
