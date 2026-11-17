public class NodeAssn extends Node {

	private String id;
	private NodeExpr expr;

	public NodeAssn(String id, NodeExpr expr) {
		this.id = id;
		this.expr = expr;
		Environment.declare(id);
	}

	public double eval(Environment env) throws EvalException {
		return env.put(id, new NodeWr(expr).eval(env));
	}

	// We need to add the printf to the assignment's 
	// code generation to prevent bugs in compilation.
	// Using NodeWr does not work and causes re-evaluation
	// of variables.
	public String code() {
		return id + "=" + expr.code() + ";"
			+ "printf(\"%g\\n\",(double)(" + id + "));";
	}

}
