package model;

public interface IDAOTest {
	
	/**
	 * It's about connecting to DB
	 */
	public void connection();
	
	/**
	 * It's about executing the query which corresponds to the choice
	 * @param choice
	 */
	public void executeQuery(int choice);
	
	/**
	 * Fill the result of the query in character table
	 */
	public void setQueryIntoTable();
	
	/**
	 * Getter of tab[][]
	 * @return tab[][]
	 */
	public char[][] getTab();
	
	/**
	 * Getter of finalDiamonds
	 * @return finalDiamonds
	 */
	public int getFinalDiamonds();
	
	/**
	 * Getter of choice
	 * @return choice
	 */
	public int getChoice();
	
}
