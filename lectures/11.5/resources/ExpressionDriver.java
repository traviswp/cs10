/**
 * A driver program to illustrate the use of the Expression interface.
 * A parser that would read expressions and parse them would be nicer, but
 *   the complications would hide the point of this example
 * 
 * @author Scot Drysdale
 */
public class ExpressionDriver
{  
	public static void main(String[] args)
	{  
		Expression first, second, third;		// Hold the expressions
		
		Variable.assignVariable("x", 2.0);
		Variable.assignVariable("y", 6.0);
		
		System.out.println("Variable assignments x = 2.0, y = 6.0");
		
		first = Sum.make(Constant.make(17.5), Quotient.make(Constant.make(5.0), 
			 Variable.make("x")));
				
		System.out.println("The value of the expression:");
		System.out.println(first + " = " + first.eval());  
		
		System.out.println();
		
		second = Difference.make(Variable.make("y"), Constant.make(4.0)); 
		System.out.println("The value of the expression:");
		System.out.println(second + "  = " + second.eval()); 
		
		System.out.println();
		
		third = Product.make(first, second); 
		System.out.println("The value of their product:");
		System.out.println(third + "  = " + third.eval());  
		
		System.out.println();
		
		Variable.assignVariable("x", -1.25);
		Variable.assignVariable("y", 14.0);
		
		System.out.println("Variable assignments x = -1.25, y = 14.0");
		
		System.out.println("The value of their product:");
		System.out.println(third + "  = " + third.eval());  
		
		System.out.println();
		
		System.out.println("The derivative with respect to y of:");
		System.out.println(second);  
		System.out.println("equals " + second.deriv("y")); 

		System.out.println();
				
		System.out.println("The derivative with respect to x of:");
		System.out.println(first);  
		System.out.println("equals " + first.deriv("x")); 
		
		System.out.println();
				
		System.out.println("The derivative with respect to x of:");
		System.out.println(third);  
		System.out.println("equals " + third.deriv("x")); 
		
		System.out.println();
		
		// Example of a try-catch
		try {
		  System.out.println((Variable.make("z")).eval());
		}
		catch(UnassignedVariableException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		System.out.println();
		
		System.out.println("The second derivative with respect to x of:");
		System.out.println(third);  
		System.out.println("equals " + (third.deriv("x")).deriv("x")); 
	}
}

