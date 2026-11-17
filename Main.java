// This is the main class/method for the interpreter/compiler.
// An argument is a program which is scanned, parsed, and evaluated.
// All arguments share the same environment.

public class Main {

	public static void main(String[] args) {
		Parser parser=new Parser();
		Environment env=new Environment();
		String code="";
		for (String prog: args)
			try {
				Node node=parser.parse(prog);
				node.eval(env);
				code+=node.code();
			} catch (Exception e) {
				System.err.println(e);
			}
		new Code(code,env);
	}

}
