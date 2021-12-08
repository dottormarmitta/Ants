package com.dottormarmitta.JPMCodePreparation.Ants;

/**
 * A class representing a chessboard. It implements 
 * {@link CartesianPlane}
 * 
 * @author Guglielmo Del Sarto
 */
public class ChessBoard implements CartesianPlane {
	
	private static final int SIZE = 8;
	private static final int[] ORIGIN    = {1, 1};
	
	@Override
	public int[] getOriginOfThePlane() {
		return ORIGIN;
	}

	@Override
	public boolean isPositionLegit(int x, int y) {
		return (x <= SIZE && x >= 1 && y <= SIZE && y >= 1);
	}

}
