import java.util.ArrayList;

/**
 * 
 * @author gottlijd
 * 
 *         Purpose: <br>
 *         Create 1D cellular automata capable of changing based on given rules
 *         and a given initial state Restriction: <br>
 *         Prints text; no interaction or GUI to create initial state or select
 *         rules For example: <br>
 *         CellularAutomata1D ca1 = new CellularAutomata1D();
 *
 */

public class CellularAutomata1D {

	public ArrayList<Integer> state = new ArrayList<Integer>();
	private int width = 20;
	public String ruleSet = "";

	/**
	 * ensures: initializes initial state and ruleset of automata @param,
	 * initialArray, ruleset
	 */

	public CellularAutomata1D(ArrayList<Integer> initialArray, String ruleSet) {
		initialize(initialArray);
		setRuleSet(ruleSet);
	}

	/**
	 * ensures: sets the rules based on a given binary string
	 */

	public void setRuleSet(String ruleSet) {
		this.ruleSet = ruleSet;
	}

	/**
	 * ensures: sets an initial state based on a given binary array
	 * 
	 * @param initialArray
	 */

	public void initialize(ArrayList<Integer> initialArray) {
		for (int i = 0; i < initialArray.size(); i++) {
			this.state.add(initialArray.get(i));
		}
	}

	/**
	 * ensures: calls an update on the two local cells
	 */

	public void update() {
		int previous = 0;
		int current = 0;
		int next = 0;
		ArrayList<Integer> newState = new ArrayList<Integer>();
		for (int i = 0; i < state.size(); i++) {
			current = i;
			if (i - 1 < 0) {
				previous = state.size() - 1;
			} else {
				previous = i - 1;
			}
			if (i + 1 > state.size() - 1) {
				next = 0;
			} else {
				next = i + 1;
			}
			newState.add(update(state.get(previous), state.get(current), state.get(next)));
		}
		state.clear();
		for (int i = 0; i < newState.size(); i++) {
			state.add(newState.get(i));
		}
	}

	/**
	 * ensures: returns false if a bit in the current state is not equal the bit of
	 * the given state, otherwise return true
	 * 
	 * @param otherCA (1D cellular automata)
	 */

	public boolean calculateTransient(CellularAutomata1D otherCA) {
		for (int i = 0; i < this.state.size(); i++) {
			if (this.state.get(i) != otherCA.state.get(i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * ensures: uses previous, current, and next states to determine how to build
	 * the next state
	 * 
	 * @param previous, current, next
	 */

	public int update(int previous, int current, int next) {
		if (previous == 1 && current == 1 && next == 1) {
			return ruleSet.charAt(0) - '0';
		} else if (previous == 1 && current == 1 && next == 0) {
			return ruleSet.charAt(1) - '0';
		} else if (previous == 1 && current == 0 && next == 1) {
			return ruleSet.charAt(2) - '0';
		} else if (previous == 1 && current == 0 && next == 0) {
			return ruleSet.charAt(3) - '0';
		} else if (previous == 0 && current == 1 && next == 1) {
			return ruleSet.charAt(4) - '0';
		} else if (previous == 0 && current == 1 && next == 0) {
			return ruleSet.charAt(5) - '0';
		} else if (previous == 0 && current == 0 && next == 1) {
			return ruleSet.charAt(6) - '0';
		} else {
			return ruleSet.charAt(7) - '0';
		}
	}

	/**
	 * ensures: prints a representation of the current state
	 */

	public void printState() {
		for (int i = 0; i < this.state.size(); i++) {
			if (this.state.get(i) == 0) {
				System.out.print('.');
			} else {
				System.out.print('O');
			}
		}
		System.out.println("");
	}

	/**
	 * ensures: creates an exact copy of the given 1D cellular automata
	 */

	public CellularAutomata1D deepCopy() {
		CellularAutomata1D newCA = new CellularAutomata1D(this.state, this.ruleSet);
		return newCA;
	}

}
