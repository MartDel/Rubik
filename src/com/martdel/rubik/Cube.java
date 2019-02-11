package com.martdel.rubik;

/**
 * @author MartDel
 *
 */
public class Cube {
	private Face whiteFace;
	private Face blueFace;
	private Face redFace;
	private Face greenFace;
	private Face orangeFace;
	private Face yellowFace;
	
	// Methods

	public void turnFaceRight(Face f, int t) {
		// Turn a face to the right
		for(int i = 0; i < t; i++) {
			f.setOne(f.getSix());
			f.setTwo(f.getFour());
			f.setThree(f.getOne());
			f.setFour(f.getSeven());
			f.setFive(f.getTwo());
			f.setSix(f.getEight());
			f.setSeven(f.getFive());
			f.setEight(f.getThree());
			updateAdjacentsFace
		}
	}
	
	public void turnFaceLeft(int t) {
		// Turn a face to the left
	}
	
	// Getters and setters
	
	public Cube() {
		// TODO Auto-generated constructor stubs
	}
	public Face getWhiteFace() {
		return whiteFace;
	}
	public void setWhiteFace(Face whiteFace) {
		this.whiteFace = whiteFace;
	}
	public Face getBlueFace() {
		return blueFace;
	}
	public void setBlueFace(Face blueFace) {
		this.blueFace = blueFace;
	}
	public Face getRedFace() {
		return redFace;
	}
	public void setRedFace(Face redFace) {
		this.redFace = redFace;
	}
	public Face getGreenFace() {
		return greenFace;
	}
	public void setGreenFace(Face greenFace) {
		this.greenFace = greenFace;
	}
	public Face getOrangeFace() {
		return orangeFace;
	}
	public void setOrangeFace(Face orangeFace) {
		this.orangeFace = orangeFace;
	}
	public Face getYellowFace() {
		return yellowFace;
	}
	public void setYellowFace(Face yellowFace) {
		this.yellowFace = yellowFace;
	}
	
}
