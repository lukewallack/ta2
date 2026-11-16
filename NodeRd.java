public class NodeRd extends Node {

	// Rd uses java's Scanner to read from input stream. 'rd' id reads an identifier.
	private static java.util.Scanner in = new java.util.Scanner(System.in);
	private String id;

	public NodeRd(int pos, String id) {
		this.pos = pos;
		this.id = id;
		//Environment.declare(id);  // null init?
	}

	public double eval(Environment env) throws EvalException {
		try {
			return env.put(id, in.nextDouble());
		} catch (java.util.NoSuchElementException e) {
			throw new EvalException(pos, "rd: No double read");
		}
	}

	public String code() {
		return "scanf(\"%lf\",&" + id + ");\n";
	}

}
