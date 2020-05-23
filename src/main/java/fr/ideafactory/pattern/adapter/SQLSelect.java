package fr.ideafactory.pattern.adapter;

public class SQLSelect {

	public String likeClause(String likeValue) {
		return "LIKE '%" + likeValue + "%'";
	}

}
