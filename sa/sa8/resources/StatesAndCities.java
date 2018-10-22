import java.util.*;

/**
 * Demonstrates the use of a Map to associate states with sets of cities 
 * in each state.
 * 
 * Inspired by an example in the CS AP "acorn" book.
 * 
 * This version has method bodies removed as part of a short assignment.
 * 
 * @author Scot Drysdale
 */
public class StatesAndCities {
	// Maps state names to sets of cities.
	private Map<String, Set<String>> stateCityMap;  

	/**
	 * Constructs empty map
	 */
	public StatesAndCities() {
	    // TODO: Your Code Here
	}

	/**
	 * Adds a state/city pair to the atlas.
	 * @param state the state to add to
	 * @param city the city to add
	 */
	public void addPair(String state, String city) {
	    // TODO: Your Code Here
	}

	/**
	 * Is the city is associated with the state in the map
	 * @param state the state to look for
	 * @param city the city to look for
	 * @return true if city is in state
	 */
	public boolean isCityInState(String state, String city) {
	    // TODO: Your Code Here
	}

	/**
	 * Returns a string describing the entire map
	 */
	public String toString() {
	    // TODO: Your Code Here
	}


	/**
	 * For testing purposes
	 */
	public static void main(String args[]) {
		StatesAndCities atlas = new StatesAndCities();  // Hold the state/city data
		char command = ' ';                             // a command
		String state;                                   // a state name
		String city;					      	        // a city name
		Scanner input = new Scanner(System.in);

		while (command != 'q') {
			System.out.print("Command (q, a, i, P, ?): ");
			command = input.nextLine().charAt(0);

			switch (command) {
			case 'q':                   // Quit
				System.out.println("Bye");
				break;

			case 'a':                   // add a city/state pair
				System.out.print("Enter state: ");
				state = input.nextLine();
				System.out.print("Enter city in the state: ");
				city = input.nextLine();
				atlas.addPair(state, city);
				break;

			case 'i':                   // isCityInState
				System.out.print("Enter state: ");
				state = input.nextLine();
				System.out.print("Enter city that might be in the state: ");
				city = input.nextLine();

				if(atlas.isCityInState(state, city))
					System.out.println(city + " is in  " + state);
				else
					System.out.println(city + " is not listed as being in " + state);
				break;


			case 'P':                   // print
				System.out.println(atlas);
				break;

			case '?':                   // Print all the commands
				System.out.println("Commands are\n  q: quit\n  a: addPair\n  i: isCityInState\n  " +
				"P: print\n  ");
				break;

			default:
				System.out.println("Huh?");
			}
		}
	}
}
