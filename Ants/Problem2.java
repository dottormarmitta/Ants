package com.dottormarmitta.JPMCodePreparation.Ants;

import java.util.Arrays;

/**
 * Runnable class solving Game2.
 * 
 * @author Guglielmo Del Sarto
 */
public class Problem2 {

	public static void main(String[] args) {

		CartesianPlane chessBoard = new ChessBoard();

		Animal antA = new Ant(chessBoard);
		antA.allowDiagonal();
		Animal antB = new Ant(chessBoard);
		antB.allowDiagonal();
		int numberOfSimulations = 1000000;
		long timer = 0;
		double[] timerArray = new double[numberOfSimulations];

		System.out.println("Problem 2.\n"
				+ "Ants can move diagonally.\n"
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
		 * Here we look at when the two ants exchange cell.
		 * This is antA goes from J to K and antB from K to J. 
		 */
		double[] timerArray2 = new double[numberOfSimulations];
		timer = 0;
		for (int i = 0; i < numberOfSimulations; i++) {
			antA.setPosition(1, 1);
			antB.setPosition(8, 8);
			while(!Arrays.equals(antA.getCurrentPosition(), antB.getPreviousPosition()) &&
					!Arrays.equals(antB.getCurrentPosition(), antA.getPreviousPosition())) {
				antA.move();
				antB.move();
				timer += antA.getSpeed();
				timerArray2[i] +=  10.0;
			}
		}
		System.out.println("Exchange cell.");
		System.out.println("Average time....: " + Arrays.stream(timerArray2).parallel()
				.average().getAsDouble());
		final double mean2 = (double) timer/numberOfSimulations;
		System.out.println("Standard error..: " + Math.sqrt(Arrays.stream(timerArray2).parallel()
				.map(x -> (x - mean2)*(x - mean2)).average().getAsDouble())/
				Math.sqrt(numberOfSimulations));
	}

}
