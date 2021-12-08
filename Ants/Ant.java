package com.dottormarmitta.JPMCodePreparation.Ants;

/**
 * Class representing an Ant. 
 * 
 * @author Guglielmo Del Sarto
 */
public class Ant implements Animal {

	private static final int SPEED = 10;

	private int currentX;
	private int currentY;
	private int previousX;
	private int previousY;
	private CartesianPlane plane;
	private boolean diagonal = false;
	private boolean previous = true;
	
	/**
	 * Constructor for Ant objects
	 * 
	 * @param plane an implementation of {@link CartesianPlane}
	 */
	public Ant(CartesianPlane plane) {

		this.plane = plane;

		// Default position is in the origin
		this.currentX = plane.getOriginOfThePlane()[0];
		this.previousX = this.currentX;

		this.currentY = plane.getOriginOfThePlane()[1];
		this.previousY = this.currentY;
	}

	@Override
	public void setPosition(int x, int y) {

		this.currentX = x;
		this.currentY = y;

		this.previousX = this.currentX;
		this.previousY = this.currentY;
	}

	@Override
	public int[] getCurrentPosition() {
		return new int[] {currentX, currentY};
	}

	@Override
	public int[] getPreviousPosition() {
		return new int[] {previousX, previousY};
	}

	@Override
	public void move() {
		int newX = Integer.MIN_VALUE;
		int newY = Integer.MIN_VALUE;
		
		while (!plane.isPositionLegit(newX, newY)) {
			
			if (!diagonal) {
				double directionSelector = Math.random();
				if (directionSelector < 0.25) {
					// Move UP
					newX = currentX;
					newY = currentY + 1;
				} else if (directionSelector < 0.50) {
					// Move DOWN
					newX = currentX;
					newY = currentY - 1;
				} else if (directionSelector < 0.75) {
					// Move LEFT
					newX = currentX - 1;
					newY = currentY;
				} else {
					// Move RIGHT
					newX = currentX + 1;
					newY = currentY;
				}

			} else {
				double directionSelector = 0;
				directionSelector = 2.0*Math.random();
				if (directionSelector < 0.25) {
					// Move UP
					newX = currentX;
					newY = currentY + 1;
				} else if (directionSelector < 0.50) {
					// Move DOWN
					newX = currentX;
					newY = currentY - 1;
				} else if (directionSelector < 0.75) {
					// Move LEFT
					newX = currentX - 1;
					newY = currentY;
				} else if (directionSelector < 1.00){
					// Move RIGHT
					newX = currentX + 1;
					newY = currentY;
				} else if (directionSelector < 1.25){
					// Move NORTH-EAST
					newX = currentX + 1;
					newY = currentY + 1;
				}  else if (directionSelector < 1.50){
					// Move SOUTH-EAST
					newX = currentX + 1;
					newY = currentY - 1;
				} else if (directionSelector < 1.75){
					// Move SOUTH-WEST
					newX = currentX - 1;
					newY = currentY + 1;
				} else {
					// Move NORTH-WEST
					newX = currentX - 1;
					newY = currentY + 1;
				}
			}
			
			if(!previous) {
				if (newX == previousX && newY == previousY) {
					newX = Integer.MIN_VALUE;
					newY = Integer.MIN_VALUE;
				}
			}
		}

		previousX = currentX;
		previousY = currentY;
		currentX  = newX;
		currentY  = newY;
	}

	@Override
	public void allowDiagonal() {
		diagonal = true;
	}

	@Override
	public void forbidDiagonal() {
		diagonal = false;
	}

	@Override
	public void allowPreviousCell() {
		previous = true;
	}

	@Override
	public void forbidPreviousCell() {
		previous = false;
	}

	@Override
	public void printAllowedMovements() {
		System.out.println();
		System.out.println("The ant current movements are: ");
		System.out.println("Diagonal movement allowed? " + diagonal);
		System.out.println("Return previous cell allowed? " + previous);
		System.out.println();
	}

	@Override
	public int getSpeed() {
		return SPEED;
	}

}
