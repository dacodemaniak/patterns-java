package fr.ideafactory.pattern.adapter;

public class PGSQLSelect extends SQLSelect {
	private PGSQLAdapter adapter;
	
	public PGSQLSelect(PGSQLAdapter adapter) {
		this.adapter = adapter;
	}
	
	public String likeClause(String likeValue) {
		String clause = super.likeClause(likeValue);
		String regex = "LIKE";
		return clause.replaceFirst(regex, this.adapter.specificLikeOperator());
	}

}
