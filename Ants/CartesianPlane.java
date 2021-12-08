package com.dottormarmitta.JPMCodePreparation.Ants;

/**
 * This interface is an abstraction for a NxN Cartesian plane.
 * <br>
 * Following usual mathematics rules, a point P in the plane
 * is represented by two coordinates, x and y:
 * <br>
 * P = (x, y)
 * <br>
 * where both x and y are integers.
 * 
 * @author Guglielmo Del Sarto
 * @since Version 1.0
 */
public interface CartesianPlane {
	
	/**
	 * This method returns the origin of the plane.
	 * <br>
	 * By definition, the origin of the plane is the bottom left corner.
	 * 
	 * @return coordinateArray containing as first element the x and second element
	 * the y
	 */
	public int[] getOriginOfThePlane();
	
	/**
	 * Given a point P = (x, y), his method returns true if the point
	 * belongs to the Cartesian plane. False elsewhere.
	 * 
	 * @param x the abscissa
	 * @param y the ordinate
	 * @return isThePointLegit a boolean flagging whether the point is in the plane
	 */
	public boolean isPositionLegit(int x, int y);

}
