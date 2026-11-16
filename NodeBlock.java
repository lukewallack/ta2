public class NodeBlock extends Node {

	private NodeStmt stmt;		// left, first statement in grammar
	private NodeBlock block;	// remaining block

	public NodeBlock(NodeStmt stmt, NodeBlock block) {
		this.stmt = stmt;
		this.block = block;
	}

	public double eval(Environment env) throws EvalException {
		double blockValue = stmt.eval(env); // Evaluate the statement
		if (block != null) {
			blockValue = block.eval(env); // If we have a block, evaluate the block
		}
		return blockValue;
	}

	// We always have a statement, so return at least the 
	// statement's code. If we have a block as well, then 
	// evaluate that afterwards.
	public String code() {
		return stmt.code() + (block == null ? "" : block.code());
	}

}
