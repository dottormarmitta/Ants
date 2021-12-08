package com.dottormarmitta.JPMCodePreparation.Ants;

import java.util.Arrays;

/**
 * Runnable class solving Game1.
 * 
 * @author Guglielmo Del Sarto
 */
public class Problem1 {

	public static void main(String[] args) {
		
		CartesianPlane chessBoard = new ChessBoard();
		
		Animal antA = new Ant(chessBoard);
		Animal antB = new Ant(chessBoard);
		int numberOfSimulations = 1000000;
		long timer = 0;
		double[] timerArray = new double[numberOfSimulations];
		
		System.out.println("Problem 1.\n"
				+ "Ants cannot move diagonally.\n"
				+ "They can return on immediate previous cell.");
		System.out.println();
		
		/*
		 * Here we look at when the two ants land on same cell.
		 */
		for (int i = 0; i < numberOfSimulations; i++) {
			antA.setPosition(1, 1);
			antB.setPosition(8, 8);
			while(!Arrays.equals(antA.getCurrentPosition(), antB.getCurrentPosition())) {
				antA.move();
				antB.move();
				timer += antA.getSpeed();
				timerArray[i] +=  10.0;
			}
		}
		System.out.println("Land on same cell.");
		System.out.println("Average time....: " + Arrays.stream(timerArray).parallel()
				.average().getAsDouble());
		final double mean = (double) timer/numberOfSimulations;
		System.out.println("Standard error..: " + Math.sqrt(Arrays.stream(timerArray).parallel()
				.map(x -> (x - mean)*(x - mean)).average().getAsDouble())/
				Math.sqrt(numberOfSimulations));
		System.out.println();
		/*
		Here we look at when the two ants exchange cell.
		This is antA goes from J to K and antB from K to J.
		It is commented because it results in an infinite loop.

		timer = 0;
		for (int i = 0; i < numberOfSimulations; i++) {
			antA.setPosition(1, 1);
			antB.setPosition(8, 8);
			while(!Arrays.equals(antA.getCurrentPosition(), antB.getPreviousPosition()) &&
					!Arrays.equals(antB.getCurrentPosition(), antA.getPreviousPosition())) {
				antA.move();
				antB.move();
				timer += antA.getSpeed();
			}
		}
		*/
		System.out.println("Exchange cell.");
		System.out.println("Average time....: " + (double) (1.0/0.0) + " seconds");
	}

}
