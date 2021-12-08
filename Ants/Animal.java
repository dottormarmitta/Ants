package com.dottormarmitta.JPMCodePreparation.Ants;

/**
 * This interface is an abstraction for an Animal on a Cartesian plane.
 * <br>
 * Each animal has:
 * 1. An initial position
 * 2. A speed (measured in seconds per 1 cell)
 * 
 * @author Guglielmo Del Sarto
 */
public interface Animal {
	
	/**
	 * This method set the position of the animal in the grid
	 * 
	 * @param x the abscissa
	 * @param y the ordinate
	 */
	public void setPosition(int x, int y);
	
	/**
	 * This methods recover the current position of the animal
	 * 
	 * @return positionArray where the first element is the abscissa and the second
	 * the ordinate
	 */
	public int[] getCurrentPosition();
	
	/**
	 * This methods recover the previous position occupied by the animal
	 * 
	 * @return positionArray where the first element is the abscissa and the second
	 * the ordinate
	 */
	public int[] getPreviousPosition();
	
	/**
	 * Once this method is called, the animal moves by one cell
	 * <br>
	 * The direction of the movements is determined by the current allowed movements
	 */
	public void move();
	
	/**
	 * Once this method is called, the animal can move diagonally
	 */
	public void allowDiagonal();
	
	/**
	 * Once this method is called, the animal cannot move diagonally
	 */
	public void forbidDiagonal();
	
	/**
	 * Once this method is called, the animal can return on previous cell
	 */
	public void allowPreviousCell();
	
	/**
	 * Once this method is called, the animal cannot return on previous cell
	 */
	public void forbidPreviousCell();
	
	/**
	 * This method is a recapitulation for the user on what is the
	 * current status of the allowed movements for the animal
	 */
	public void printAllowedMovements();
	
	/**
	 * This method returns the speed of the animal.
	 * <br>
	 * The speed unit of measure is seconds per 1 cell
	 * 
	 * @return speed the animal speed
	 */
	public int getSpeed();

}
