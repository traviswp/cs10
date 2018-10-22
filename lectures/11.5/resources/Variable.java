import java.util.HashMap;

/**
 * Represents expressions that are variables
 * You must use Variable.make to create an object of this class.
 * 
 * @author Scot Drysdale
 */
public class Variable implements Expression {	
	private String myVariable;  // the name of this variable
	
	private static HashMap<String, Double> symbolTable = new HashMap<String, Double>();
	
	/**
	 * Constructs this variable
	 * @param name the name of the variable
	 */
	private Variable(String name) {
		myVariable = name;
	}
	
	/**
	 * Creates a variable, but simplifies if possible
	 * @param name the name of the variable
	 * @return the simplified constant
	 */
	public static Expression make(String name) {
		return new Variable(name);
	}
	
	
  /**
   * Converts variable to a string
   * @return the variable name
   */
	public String toString() {
		return myVariable;
	}

	/**
	 * Assign the variable the given value.
	 * If previously assigned, replaces the old value.
	 * @param variable the name of the variable
	 * @param value the value to assign to it.
	 */
	public static void assignVariable(String variable, double value) {
		symbolTable.put(variable, value);
	}
	
	/**
	 * Evaluates this variable using the value saved in symbolTable
	 * @return the value of this variable
	 */
	public double eval() {
	  Double value = symbolTable.get(myVariable);
 
	  if (value == null)
	  	throw(new UnassignedVariableException("Evaluated unassigned variable " + myVariable));
	  else
	  	return value;  // Uses unboxing
	}
	
	/**
	 * Take the derivative of this variable.
	 * @param v the variable with respect to which the derivative is taken
	 * @return the derivative or this variable with respect to the variable v
	 */
	public Expression deriv(String v) {
		String myVar = toString();		// Get the name of this variable
		
		if(v.equals(myVar))
			return Constant.make(1.0);
		else
			return Constant.make(0.0);
	}
	
}