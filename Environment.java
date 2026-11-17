import java.util.*;

public class Environment {
 	// Map variables in our env to double values
	private Map<String, Double> map = new HashMap<String, Double>();
	// Contains every declared variable at parse time for C code generation
	private static Set<String> declared = new HashSet<>();

	// Inserts a key value pair into the map hashmap, with the variable 
	// name as the key and double `val` as the value.
	// Arguments:
	//     var = variable name
	//     val = double value to be stored, associated with var
	// Members:
	//     map = HashMap containing the environment's variables
	// Returns:
	//     the value stored
	public double put(String var, double val) {
		map.put(var, val);
		return val;
	}

	// Returns a variable's value, throwing an exception if 
	// no such variable exists.
	// Arguments:
	//     pos = current position of program
	//     var = variable name, key in hashmap
	// Members:
	//     map = HashMap containing the environment's variables
	// Returns:
	//     double value associated with key `var`.
	// Throws:
	//     EvalException when key `var` is not in map.
	public double get(int pos, String var) throws EvalException {
		if (!map.containsKey(var))
			throw new EvalException(pos, var);
		return map.get(var);
	}

	// Adds a variable name to the declared set so that it will be declared
	// in toC() for code generation.
	public static void declare(String var) {
		declared.add(var);
	}

	// This method generates a C program declaring the variables 
	// in the environment, all of which are doubles.
	// Members:
	//     declared = HashSet containing ALL variables declared in the environment.
	// Returns:
	//     A C source containing each variable in our environment.
	public String toC() {
		String declare = "double";
		String sep = " ";
		String init = "";

		for (String v : declared) {
			declare += sep + v;
			sep = ",";
			init += v + "=0;";
		}

		return declared.isEmpty() ? "" : declare + ";\n" + init + "\n";
	}

}
