// Relational operators < <= > >= == <>
public class NodeRelop extends Node {

	private String relop;

	public NodeRelop(int pos, String relop) {
		this.pos = pos;
		this.relop = relop;
	}

	// Compares two values, returning true/false (1.0/0.0).
	// Valid comparisons for each relational operator.
	public double op(double o1, double o2) {
		boolean r; // Our boolean comparison return value

		switch (relop) {
			case "<":
				r = o1 < o2;
				break;
			case "<=":
				r = o1 <= o2;
				break;
			case ">":
				r = o1 > o2;
				break;
			case ">=":
				r = o1 >= o2;
				break;
			case "<>":
				r = o1 != o2;
				break;
			default:
				r = o1 == o2;
				break;
		}

		// If r is true, return 1, otherwise 0
		return r ? 1.0 : 0.0;
	}

	// Return the operator relop unless it is <>, which will 
	// get converted to != in C.
	public String code() {
		return relop.equals("<>") ? "!=" : relop;
	}

}
