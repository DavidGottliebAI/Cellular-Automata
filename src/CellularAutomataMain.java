import java.util.ArrayList;

import java.util.Collections;
import java.util.Random;

/**
 * 
 * @author gottlijd
 * 
 *         Purpose: <br>
 *         Runs 1D and 2D cellular automata, as well as transient test
 *         Restriction: <br>
 *         Must hard code in create of specific automata
 *
 */

public class CellularAutomataMain {
	
	public static void main(String[] args) {
		/*
		 * The following runs average transient test;
		 * Uncomment other two sections to run 1D and 2D automata
		 */
//		ArrayList<Integer> transientLengths = new ArrayList<Integer>();
//		for(int j = 0; j < 256; j++) {
//			System.out.println("Rule: " + j);
//			String binaryStr = Integer.toBinaryString(j);
//			String eightBinaryStr = String.format("%8s", binaryStr).replaceAll(" ", "0");
//			// Create initial state
//			Random random = new Random();
//			double sum = 0;
//			for(int k = 0; k < 100; k++) {
//				ArrayList<Integer> initial1 = new ArrayList<Integer>();
//				for(int i = 0; i < 20; i++) {
//					if(random.nextBoolean()) {
//						initial1.add(0);
//					} else {
//						initial1.add(1);
//					}
//				}
//				// Create CA
//				CellularAutomata1D ca1 = new CellularAutomata1D(initial1, eightBinaryStr);
//				int stateNum = 0;
//				ArrayList<CellularAutomata1D> previousStates = new ArrayList<CellularAutomata1D>();
//				// Loop through each CA
//				outerloop:
//				while(stateNum < 1000) {
//					CellularAutomata1D tempCA = ca1.deepCopy();
//					previousStates.add(tempCA);
//					ca1.update();
//					for(int i = 0; i < previousStates.size(); i++) {
//						if(ca1.calculateTransient(previousStates.get(i))){
//							transientLengths.add(stateNum);
//							break outerloop;
//						}
//					}
//					stateNum++;
//				}
//				sum += stateNum;
//			}
//			System.out.println(sum / 100);
//		}
		
//		// 1D Case:
//		Random random = new Random();
//		// Initialize first state
//		ArrayList<Integer> initial = new ArrayList<Integer>();
//		for(int i = 0; i < 20; i++) {
//			if(random.nextBoolean()) {
//				initial.add(0);
//			} else {
//				initial.add(1);
//			}
//		}
//		// Pass in a rule
//		String binaryStr = Integer.toBinaryString(126);
//		String eightBinaryStr = String.format("%8s", binaryStr).replaceAll(" ", "0");
//		// Create 1D automata and run simulation
//		CellularAutomata1D ca1 = new CellularAutomata1D(initial, eightBinaryStr);
//		ca1.printState();
//		for(int i = 0; i < 1000; i++) {
//			ca1.update();
//			ca1.printState();
//		}
		
//		// 2D Case:
//		Random random = new Random();
//		// Initialize first state
//		ArrayList<ArrayList<Integer>> initial = new ArrayList<ArrayList<Integer>>();
//		for (int i = 0; i < 40; i++) {
//			ArrayList<Integer> tempArr = new ArrayList<Integer>();
//			for (int j = 0; j < 80; j++) {
//				if(random.nextInt(4) >= 1) {
//					tempArr.add(0);
//				} else {
//					tempArr.add(1);
//				}
//			}
//			initial.add(tempArr);
//		}
//		// Create 1D automata
//		CellularAutomata2D ca2 = new CellularAutomata2D(initial);
//		for(int i = 0; i < 1000; i++) {
//			ca2.update();
//			ca2.printState();
//			System.out.println("");
//			System.out.println("");
//			System.out.println("");
//		}
	}
}
