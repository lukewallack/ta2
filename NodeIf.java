public class NodeIf extends Node {

	private NodeBoolexpr condition;
	private Node thenStmt;
	private Node elseStmt;	// possibly null

	public NodeIf(NodeBoolexpr condition, Node thenStmt, Node elseStmt) {
		this.condition = condition;
		this.thenStmt = thenStmt;
		this.elseStmt = elseStmt;
	}

	public double eval(Environment env) throws EvalException {
		if (condition.eval(env) != 0.0)
			return thenStmt.eval(env);
		
		if (elseStmt != null)
			return elseStmt.eval(env);
			
		return 0.0;
	}

	public String code() {
		String s = "if" + condition.code() + "{\n" + thenStmt.code() + "}\n";
		if (elseStmt != null)
			s += "else {\n" + elseStmt.code() + "}\n";

		return s;
	}

}
