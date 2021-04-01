import java.util.ArrayList;

/**
 * 
 * @author gottlijd
 * 
 *         Purpose: <br>
 *         Create 2D cellular automata capable of changing based on given initial state
 *         Restriction: <br>
 *         Prints text; no interaction or GUI to create initial state or select rules
 *         For example: <br>
 *         CellularAutomata2D ca2 = new CellularAutomata2D();
 *
 */

public class CellularAutomata2D {

	public ArrayList<ArrayList<Integer>> state = new ArrayList<ArrayList<Integer>>();
	private int width = 20;
	public String ruleSet = "";
	
	/**
	 * ensures: initializes initial state of automata
	 * @param, initialArray
	 */

	public CellularAutomata2D(ArrayList<ArrayList<Integer>> initialArray) {
		initialize(initialArray);
	}
	
	/**
	 * ensures: sets an initial state based on a given 2D binary array
	 * @param initialArray
	 */
	
	public void initialize(ArrayList<ArrayList<Integer>> initialArray) {
		for (int i = 0; i < initialArray.size(); i++) {
			ArrayList<Integer> tempArr = new ArrayList<Integer>();
			for (int j = 0; j < initialArray.get(0).size(); j++) {
				tempArr.add(initialArray.get(i).get(j));
			}
			this.state.add(tempArr);
		}
	}
	
	/**
	 * ensures: calls an update on the eight local cells
	 */

	public void update() {
		int previousX = 0;
		int previousY = 0;
		int currentX = 0;
		int currentY = 0;
		int nextX = 0;
		int nextY = 0;
		int diagonal1LX = 0;
		int diagonal1LY = 0;
		int diagonal1RX = 0;
		int diagonal1RY = 0;
		int diagonal2LX = 0;
		int diagonal2LY = 0;
		int diagonal2RX = 0;
		int diagonal2RY = 0;
		ArrayList<ArrayList<Integer>> newState = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < state.size(); i++) {
			ArrayList<Integer> tempArr = new ArrayList<Integer>();
			for (int j = 0; j < state.get(0).size(); j++) {
				currentX = j;
				currentY = i;
				if (j - 1 < 0) {
					previousX = state.get(0).size() - 1;
				} else {
					previousX = j - 1;
				}
				if (j + 1 > state.get(0).size() - 1) {
					nextX = 0;
				} else {
					nextX = j + 1;
				}
				if (i - 1 < 0) {
					previousY = state.size() - 1;
				} else {
					previousY = i - 1;
				}
				if (i + 1 > state.size() - 1) {
					nextY = 0;
				} else {
					nextY = i + 1;
				}

				if (j - 1 < 0 && i - 1 < 0) {
					diagonal1LX = state.get(0).size() - 1;
					diagonal1LY = state.size() - 1;
				} else if (j - 1 < 0 && i - 1 >= 0) {
					diagonal1LX = state.get(0).size() - 1;
					diagonal1LY = i - 1;
				} else if (i - 1 < 0 && j - 1 >= 0) {
					diagonal1LX = j - 1;
					diagonal1LY = state.size() - 1;
				} else {
					diagonal1LX = j - 1;
					diagonal1LY = i - 1;
				}

				if (j + 1 > state.get(0).size() - 1 && i + 1 > state.size() - 1) {
					diagonal1RX = 0;
					diagonal1RY = 0;
				} else if (j + 1 > state.get(0).size() - 1 && i + 1 <= state.size() - 1) {
					diagonal1RX = 0;
					diagonal1RY = i + 1;
				} else if (j + 1 <= state.get(0).size() - 1 && i + 1 > state.size() - 1) {
					diagonal1RX = j + 1;
					diagonal1RY = 0;
				} else {
					diagonal1RX = j + 1;
					diagonal1RY = i + 1;
				}

				if (j - 1 < 0 && i + 1 > state.size() - 1) {
					diagonal2LX = state.get(0).size() - 1;
					diagonal2LY = 0;
				} else if (j - 1 < 0 && i + 1 <= state.size() - 1) {
					diagonal2LX = state.get(0).size() - 1;
					diagonal2LY = i + 1;
				} else if (j - 1 >= 0 && i + 1 > state.size() - 1) {
					diagonal2LX = j - 1;
					diagonal2LY = 0;
				} else {
					diagonal2LX = j - 1;
					diagonal2LY = i + 1;
				}

				if (j + 1 > state.get(0).size() - 1 && i - 1 < 0) {
					diagonal2RX = 0;
					diagonal2RY = state.size() - 1;
				} else if (j + 1 > state.get(0).size() - 1 && i - 1 >= 0) {
					diagonal2RX = 0;
					diagonal2RY = i - 1;
				} else if (j + 1 <= state.get(0).size() - 1 && i - 1 < 0) {
					diagonal2RX = j + 1;
					diagonal2RY = state.size() - 1;
				} else {
					diagonal2RX = j + 1;
					diagonal2RY = i - 1;
				}

				tempArr.add(update(state.get(currentY).get(currentX), state.get(currentY).get(previousX),
						state.get(currentY).get(nextX), state.get(previousY).get(currentX),
						state.get(nextY).get(currentX), state.get(diagonal1LY).get(diagonal1LX),
						state.get(diagonal1RY).get(diagonal1RX), state.get(diagonal2LY).get(diagonal2LX),
						state.get(diagonal2RY).get(diagonal2RX)));
			}
			newState.add(tempArr);
		}
		state.clear();
		for (int i = 0; i < newState.size(); i++) {
			ArrayList<Integer> tempArr = new ArrayList<Integer>();
			for (int j = 0; j < newState.get(0).size(); j++) {
				tempArr.add(newState.get(i).get(j));
			}
			state.add(tempArr);
		}
	}
	
	/**
	 * ensures: uses current and eight surrounding states to determine how to build
	 * the next state
	 * 
	 * @param current, previousH, nextH, previousV, nextV, previousD1L, nextD1R, previousD2L, nextD2R
	 */

	public int update(int current, int previousH, int nextH, int previousV, int nextV, int previousD1L, int nextD1R, int previousD2L, int nextD2R) {
		int livingCells = previousH + nextH + previousV + nextV + previousD1L + nextD1R + previousD2L + nextD2R;
		if(current == 1 && livingCells < 2) {
			return 0;
		} else if(current == 1 && livingCells == 2 || livingCells == 3) {
			return 1;
		} else if(current == 1 && livingCells >= 3) {
			return 0;
		} else if(current == 0 && livingCells == 3) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	 * ensures: prints a representation of the current state
	 */

	public void printState() {
		for (int i = 0; i < this.state.size(); i++) {
			for (int j = 0; j < this.state.get(0).size(); j++) {
				if(this.state.get(i).get(j) == 0) {
					System.out.print('.');
				} else {
					System.out.print('O');
				}
			}
			System.out.println("");
		}
	}
}
