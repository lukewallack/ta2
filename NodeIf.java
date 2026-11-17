// NodeIf is a type of statement defined by if boolexpr then stmt
// or if boolexpr then stmt else stmt. So, else is either null, or 
// we have an else. The boolexpr is defined as a condition statement, 
// and we evaluate the corresponding statement depending on the condition 
// before returning it in eval.
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
