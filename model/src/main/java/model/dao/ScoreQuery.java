package model.dao;

import java.sql.SQLException;
import java.sql.Statement;

public class ScoreQuery extends LaunchDBQuery{
	public ScoreQuery(int level, String name) {
		super(level, name);
		// TODO Auto-generated constructor stub
	}

	public void SetScoreIntoDatabase(Statement statement, int score, int level, String name) throws SQLException {
		statement.executeUpdate("insert into Scores values (null, '" + name + "', '" + level + "','" + score + "')");
	}
}
