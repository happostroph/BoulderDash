package model;

public interface ILauncherDBQueries {
	/**
	 * Launch all the queries necessary
	 */
	public void launchQueries();
	
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
}
