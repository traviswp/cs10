/**
 * This class defines expressions that are constants.
 * You must use Constant.make to create an object of this class.
 * 
 * @author Scot Drysdale
 */
public class Constant implements Expression
{		
	private double myValue;	  // The value of the constant
	
	/**
	 * Constructor
	 * @param value the value of this Constant
	 */
	private Constant(double value)
	{
		myValue = value;
	}
	
	/**
	 * Creates a constant, but simplifies if possible
	 * @param value the value of the constant
	 * @return the simplified constant
	 */
	public static Expression make(double value) {
		return new Constant(value);
	}
	
	/**
	 * Evaluates this constant
	 * @return the value of this constant
	 */
	public double eval()
	{
		return myValue;
	}
	
	/**
	 * Converts this constant to a string
	 * @return the string representation of this constant
	 */
	public String toString()
	{
		return "" + myValue;	// A sneaky way to convert a double to a String
	}
	
	/**
	 * Take the derivative of this constant
	 * @param v the variable with respect to which the derivative is taken (irrelevant)
	 * @return the derivative of this constant - 0.0
	 */
	public Expression deriv(String v)
	{
		return new Constant(0.0);	// Derivative of a constant is 0
	}
}