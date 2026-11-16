// Boolean expression in the form expr relop expr.
// Evaluates to true/false (1.0/0.0 in double).
public class NodeBoolexpr extends Node {

	private NodeExpr left, right;
	private NodeRelop relop;

	public NodeBoolexpr(NodeExpr left, NodeRelop relop, NodeExpr right) {
		this.left = left;
		this.relop = relop;
		this.right = right;
	}

	public double eval(Environment env) throws EvalException {
		return relop.op(left.eval(env), right.eval(env));
	}

	public String code() {
		return "(" + left.code() + relop.code() + right.code() + ")";
	}

}
