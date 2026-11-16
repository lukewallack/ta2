public class NodeWhile extends Node {

	// while boolexpr do stmt
	private NodeBoolexpr condition;
	private Node body;	// Refer to the grammar. The stmt can be a block etc.

	public NodeWhile(NodeBoolexpr condition, Node body) {
		this.condition = condition;
		this.body = body;
	}

	public double eval(Environment env) throws EvalException {
		double d = 0.0;

		while (condition.eval(env) != 0.0) {
			d = body.eval(env);
		}

		return d;
	}

	public String code() {
		return "while" + condition.code() + "{\n" + body.code() + "}\n";
	}

}
