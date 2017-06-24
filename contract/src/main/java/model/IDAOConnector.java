package model;

import java.sql.ResultSet;
import java.sql.Statement;

public interface IDAOConnector {
	
	/**
	 * It's about connecting to DB
	 */
	public void connection();
	
	/**
	 * Getter of choice
	 * @return choice
	 */
	public int getChoice();
	
	/**
	 * Getters of statement
	 * @return statement
	 */
	public Statement getStatement();

	/**
	 * Getters of result
	 * @return result
	 */
	public ResultSet getResult();
}
