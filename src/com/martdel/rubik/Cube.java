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
	
	public Cube() {
		// TODO Auto-generated constructor stubs
	}
	
	// Get an attribut with the color of the face
	public Face getAttribut(Color a) {
		Face f = null;
		switch(a) {
		case WHITE: f = getWhiteFace(); break;
		case BLUE: f = getBlueFace(); break;
		case RED: f = getRedFace(); break;
		case GREEN: f = getGreenFace(); break;
		case ORANGE: f = getOrangeFace(); break;
		case YELLOW: f = getYellowFace(); break;
		}
		return f;
	}
	
	// Set an attribut
	public void setAttribut(Color a, Face v) {
		switch(a) {
		case WHITE: setWhiteFace(v); break;
		case BLUE: setBlueFace(v); break;
		case RED: setRedFace(v); break;
		case GREEN: setGreenFace(v); break;
		case ORANGE: setOrangeFace(v); break;
		case YELLOW: setYellowFace(v); break;
		}
	}
	
	// Return all of the colors in the cube
	public String[][] toArray(){
		String[][] r = {
			whiteFace.toArray(),
			blueFace.toArray(),
			redFace.toArray(),
			greenFace.toArray(),
			orangeFace.toArray(),
			yellowFace.toArray()
		};
		return r;
	}
	
	// Duplicate a face
	public Face copyFaceFrom(Face origin) {
		Face returnFace = new Face(origin.getColorCenter(), origin.getOne(), origin.getTwo(), origin.getThree(), origin.getFour(), origin.getFive(), origin.getSix(), origin.getSeven(), origin.getEight());
		return returnFace;
	}

	// Turn a face "t" times and if "o" is true then the face will turn to the right else to the left
	public void turnFace(Face f, boolean o, int t) {
		// Turn a face to the right
		for(int i = 0; i < t; i++) {
			Face newF = new Face(f.getColorCenter(), null, null, null, null, null, null, null, null);
			Integer[] idOfTheNewColorR = {6, 4, 1, 7, 2, 8, 5, 3};
			Integer[] idOfTheNewColorL = {3, 5, 8, 2, 7, 1, 4, 6};
			Integer[] idOfTheNewColor; // Creating an array which contain the order of the id of the stickers which will become the new stickers
			if(o) {
				idOfTheNewColor = idOfTheNewColorR;
				updateAdjFacesRight(f);
			} else {
				idOfTheNewColor = idOfTheNewColorL;
				updateAdjFacesLeft(f);
			}
			for(int j = 1; j <= 8; j++) {
				newF.setAttribut(j, f.getAttribut(idOfTheNewColor[j - 1]));
			}
			setAttribut(f.getColorCenter(), newF);
		}
	}
	
	public void updateAdjFacesRight(Face f) {
		Integer[] top = {3, 2, 1};
		Integer[] right = {3, 2, 1};
		Integer[] bottom = {3, 2, 1};
		Integer[] left = {3, 2, 1};
		// Duplicate the adjacents faces of the turning face in others variables
		Face newFirstF = copyFaceFrom(getAttribut(Main.getColorFromFr(f.getColorCenter().getTop())));
		Face newSecondF = copyFaceFrom(getAttribut(Main.getColorFromFr(f.getColorCenter().getRight())));
		Face newThirdF = copyFaceFrom(getAttribut(Main.getColorFromFr(f.getColorCenter().getBottom())));
		Face newFourthF = copyFaceFrom(getAttribut(Main.getColorFromFr(f.getColorCenter().getLeft())));
		for(int i = 0; i < top.length; i++) {
			newFirstF.setAttribut(top[i], getAttribut(Main.getColorFromFr(f.getColorCenter().getLeft())).getAttribut(left[i]));		
		}
		newSecondF.setThree(getAttribut(Main.getColorFromFr(f.getColorCenter().getTop())).getThree());
		newSecondF.setTwo(getAttribut(Main.getColorFromFr(f.getColorCenter().getTop())).getTwo());
		newSecondF.setOne(getAttribut(Main.getColorFromFr(f.getColorCenter().getTop())).getOne());
		newThirdF.setThree(getAttribut(Main.getColorFromFr(f.getColorCenter().getRight())).getThree());
		newThirdF.setTwo(getAttribut(Main.getColorFromFr(f.getColorCenter().getRight())).getTwo());
		newThirdF.setOne(getAttribut(Main.getColorFromFr(f.getColorCenter().getRight())).getOne());
		newFourthF.setThree(getAttribut(Main.getColorFromFr(f.getColorCenter().getBottom())).getThree());
		newFourthF.setTwo(getAttribut(Main.getColorFromFr(f.getColorCenter().getBottom())).getTwo());
		newFourthF.setOne(getAttribut(Main.getColorFromFr(f.getColorCenter().getBottom())).getOne());
		setAttribut(Main.getColorFromFr(f.getColorCenter().getTop()), newFirstF);
		setAttribut(Main.getColorFromFr(f.getColorCenter().getLeft()), newSecondF);
		setAttribut(Main.getColorFromFr(f.getColorCenter().getBottom()), newThirdF);
		setAttribut(Main.getColorFromFr(f.getColorCenter().getLeft()), newFourthF);
		switch(f.getColorCenter()) {
		case WHITE :
			Face newFirstF = copyFaceFrom(getBlueFace());
			Face newSecondF = copyFaceFrom(getRedFace());
			Face newThirdF = copyFaceFrom(getGreenFace());
			Face newFourthF = copyFaceFrom(getOrangeFace());
			newFirstF.setThree(orangeFace.getThree());
			newFirstF.setTwo(orangeFace.getTwo());
			newFirstF.setOne(orangeFace.getOne());
			newSecondF.setThree(blueFace.getThree());
			newSecondF.setTwo(blueFace.getTwo());
			newSecondF.setOne(blueFace.getOne());
			newThirdF.setThree(redFace.getThree());
			newThirdF.setTwo(redFace.getTwo());
			newThirdF.setOne(redFace.getOne());
			newFourthF.setThree(greenFace.getThree());
			newFourthF.setTwo(greenFace.getTwo());
			newFourthF.setOne(greenFace.getOne());
			setAttribut(Color.BLUE, newFirstF);
			setAttribut(Color.RED, newSecondF);
			setAttribut(Color.GREEN, newThirdF);
			setAttribut(Color.ORANGE, newFourthF);
			break;
		case BLUE:
			Face newFirstF1 = copyFaceFrom(getWhiteFace());
			Face newSecondF1 = copyFaceFrom(getOrangeFace());
			Face newThirdF1 = copyFaceFrom(getYellowFace());
			Face newFourthF1 = copyFaceFrom(getRedFace());
			newFirstF1.setThree(redFace.getEight());
			newFirstF1.setTwo(redFace.getFive());
			newFirstF1.setOne(redFace.getThree());
			newSecondF1.setOne(whiteFace.getThree());
			newSecondF1.setFour(whiteFace.getTwo());
			newSecondF1.setSix(whiteFace.getOne());
			newThirdF1.setThree(orangeFace.getOne());
			newThirdF1.setTwo(orangeFace.getFour());
			newThirdF1.setOne(orangeFace.getSix());
			newFourthF1.setEight(yellowFace.getThree());
			newFourthF1.setFive(yellowFace.getTwo());
			newFourthF1.setThree(yellowFace.getOne());
			setAttribut(Color.WHITE, newFirstF1);
			setAttribut(Color.ORANGE, newSecondF1);
			setAttribut(Color.YELLOW, newThirdF1);
			setAttribut(Color.RED, newFourthF1);
			break;
		case RED:
			Face newFirstF2 = copyFaceFrom(getWhiteFace());
			Face newSecondF2 = copyFaceFrom(getBlueFace());
			Face newThirdF2 = copyFaceFrom(getYellowFace());
			Face newFourthF2 = copyFaceFrom(getGreenFace());
			newFirstF2.setEight(greenFace.getEight());
			newFirstF2.setFive(greenFace.getFive());
			newFirstF2.setThree(greenFace.getThree());
			newSecondF2.setOne(whiteFace.getEight());
			newSecondF2.setFour(whiteFace.getFive());
			newSecondF2.setSix(whiteFace.getThree());
			newThirdF2.setOne(blueFace.getOne());
			newThirdF2.setFour(blueFace.getFour());
			newThirdF2.setSix(blueFace.getSix());
			newFourthF2.setEight(yellowFace.getOne());
			newFourthF2.setFive(yellowFace.getFour());
			newFourthF2.setThree(yellowFace.getSix());
			setAttribut(Color.WHITE, newFirstF2);
			setAttribut(Color.BLUE, newSecondF2);
			setAttribut(Color.YELLOW, newThirdF2);
			setAttribut(Color.GREEN, newFourthF2);
			break;
		case GREEN:
			Face newFirstF3 = copyFaceFrom(getWhiteFace());
			Face newSecondF3 = copyFaceFrom(getRedFace());
			Face newThirdF3 = copyFaceFrom(getYellowFace());
			Face newFourthF3 = copyFaceFrom(getOrangeFace());
			newFirstF3.setSix(orangeFace.getEight());
			newFirstF3.setSeven(orangeFace.getFive());
			newFirstF3.setEight(orangeFace.getThree());
			newSecondF3.setOne(whiteFace.getSix());
			newSecondF3.setFour(whiteFace.getSeven());
			newSecondF3.setSix(whiteFace.getEight());
			newThirdF3.setSix(redFace.getOne());
			newThirdF3.setSeven(redFace.getFour());
			newThirdF3.setEight(redFace.getSix());
			newFourthF3.setEight(yellowFace.getSix());
			newFourthF3.setFive(yellowFace.getSeven());
			newFourthF3.setThree(yellowFace.getEight());
			setAttribut(Color.WHITE, newFirstF3);
			setAttribut(Color.RED, newSecondF3);
			setAttribut(Color.YELLOW, newThirdF3);
			setAttribut(Color.ORANGE, newFourthF3);
			break;
		case ORANGE:
			Face newFirstF4 = copyFaceFrom(getWhiteFace());
			Face newSecondF4 = copyFaceFrom(getGreenFace());
			Face newThirdF4 = copyFaceFrom(getYellowFace());
			Face newFourthF4 = copyFaceFrom(getBlueFace());
			newFirstF4.setOne(blueFace.getEight());
			newFirstF4.setFour(blueFace.getFive());
			newFirstF4.setSix(blueFace.getThree());
			newSecondF4.setOne(whiteFace.getOne());
			newSecondF4.setFour(whiteFace.getFour());
			newSecondF4.setSix(whiteFace.getSix());
			newThirdF4.setEight(greenFace.getOne());
			newThirdF4.setFive(greenFace.getFour());
			newThirdF4.setThree(greenFace.getSix());
			newFourthF4.setEight(yellowFace.getEight());
			newFourthF4.setFive(yellowFace.getFive());
			newFourthF4.setThree(yellowFace.getThree());
			setAttribut(Color.WHITE, newFirstF4);
			setAttribut(Color.GREEN, newSecondF4);
			setAttribut(Color.YELLOW, newThirdF4);
			setAttribut(Color.BLUE, newFourthF4);
			break;
		case YELLOW:
			Face newFirstF5 = copyFaceFrom(getBlueFace());
			Face newSecondF5 = copyFaceFrom(getOrangeFace());
			Face newThirdF5 = copyFaceFrom(getGreenFace());
			Face newFourthF5 = copyFaceFrom(getRedFace());
			newFirstF5.setSix(redFace.getSix());
			newFirstF5.setSeven(redFace.getSeven());
			newFirstF5.setEight(redFace.getEight());
			newSecondF5.setSix(blueFace.getSix());
			newSecondF5.setSeven(blueFace.getSeven());
			newSecondF5.setEight(blueFace.getEight());
			newThirdF5.setSix(orangeFace.getSix());
			newThirdF5.setSeven(orangeFace.getSeven());
			newThirdF5.setEight(orangeFace.getEight());
			newFourthF5.setSix(greenFace.getSix());
			newFourthF5.setSeven(greenFace.getSeven());
			newFourthF5.setEight(greenFace.getEight());
			setAttribut(Color.BLUE, newFirstF5);
			setAttribut(Color.ORANGE, newSecondF5);
			setAttribut(Color.GREEN, newThirdF5);
			setAttribut(Color.RED, newFourthF5);
			break;
		}
	}
	
	public void updateAdjFacesLeft(Face f) {
		switch(f.getColorCenter()) {
		case WHITE :
			Face newFirstF = copyFaceFrom(getBlueFace());
			Face newSecondF = copyFaceFrom(getRedFace());
			Face newThirdF = copyFaceFrom(getGreenFace());
			Face newFourthF = copyFaceFrom(getOrangeFace());
			newFirstF.setThree(redFace.getThree());
			newFirstF.setTwo(redFace.getTwo());
			newFirstF.setOne(redFace.getOne());
			newSecondF.setThree(greenFace.getThree());
			newSecondF.setTwo(greenFace.getTwo());
			newSecondF.setOne(greenFace.getOne());
			newThirdF.setThree(orangeFace.getThree());
			newThirdF.setTwo(orangeFace.getTwo());
			newThirdF.setOne(orangeFace.getOne());
			newFourthF.setThree(blueFace.getThree());
			newFourthF.setTwo(blueFace.getTwo());
			newFourthF.setOne(blueFace.getOne());
			setAttribut(Color.BLUE, newFirstF);
			setAttribut(Color.RED, newSecondF);
			setAttribut(Color.GREEN, newThirdF);
			setAttribut(Color.ORANGE, newFourthF);
			break;
		case BLUE:
			Face newFirstF1 = copyFaceFrom(getWhiteFace());
			Face newSecondF1 = copyFaceFrom(getOrangeFace());
			Face newThirdF1 = copyFaceFrom(getYellowFace());
			Face newFourthF1 = copyFaceFrom(getRedFace());
			newFirstF1.setThree(orangeFace.getOne());
			newFirstF1.setTwo(orangeFace.getFour());
			newFirstF1.setOne(orangeFace.getSix());
			newSecondF1.setOne(yellowFace.getThree());
			newSecondF1.setFour(yellowFace.getTwo());
			newSecondF1.setSix(yellowFace.getOne());
			newThirdF1.setThree(redFace.getEight());
			newThirdF1.setTwo(redFace.getFive());
			newThirdF1.setOne(redFace.getThree());
			newFourthF1.setEight(whiteFace.getThree());
			newFourthF1.setFive(whiteFace.getTwo());
			newFourthF1.setThree(whiteFace.getOne());
			setAttribut(Color.WHITE, newFirstF1);
			setAttribut(Color.ORANGE, newSecondF1);
			setAttribut(Color.YELLOW, newThirdF1);
			setAttribut(Color.RED, newFourthF1);
			break;
		case RED:
			Face newFirstF2 = copyFaceFrom(getWhiteFace());
			Face newSecondF2 = copyFaceFrom(getBlueFace());
			Face newThirdF2 = copyFaceFrom(getYellowFace());
			Face newFourthF2 = copyFaceFrom(getGreenFace());
			newFirstF2.setEight(blueFace.getOne());
			newFirstF2.setFive(blueFace.getFour());
			newFirstF2.setThree(blueFace.getSix());
			newSecondF2.setOne(yellowFace.getOne());
			newSecondF2.setFour(yellowFace.getFour());
			newSecondF2.setSix(yellowFace.getSix());
			newThirdF2.setOne(greenFace.getEight());
			newThirdF2.setFour(greenFace.getFive());
			newThirdF2.setSix(greenFace.getThree());
			newFourthF2.setEight(whiteFace.getEight());
			newFourthF2.setFive(whiteFace.getFive());
			newFourthF2.setThree(whiteFace.getThree());
			setAttribut(Color.WHITE, newFirstF2);
			setAttribut(Color.BLUE, newSecondF2);
			setAttribut(Color.YELLOW, newThirdF2);
			setAttribut(Color.GREEN, newFourthF2);
			break;
		case GREEN:
			Face newFirstF3 = copyFaceFrom(getWhiteFace());
			Face newSecondF3 = copyFaceFrom(getRedFace());
			Face newThirdF3 = copyFaceFrom(getYellowFace());
			Face newFourthF3 = copyFaceFrom(getOrangeFace());
			newFirstF3.setSix(redFace.getOne());
			newFirstF3.setSeven(redFace.getFour());
			newFirstF3.setEight(redFace.getSix());
			newSecondF3.setOne(yellowFace.getSix());
			newSecondF3.setFour(yellowFace.getSeven());
			newSecondF3.setSix(yellowFace.getEight());
			newThirdF3.setSix(orangeFace.getEight());
			newThirdF3.setSeven(orangeFace.getFive());
			newThirdF3.setEight(orangeFace.getThree());
			newFourthF3.setEight(whiteFace.getSix());
			newFourthF3.setFive(whiteFace.getSeven());
			newFourthF3.setThree(whiteFace.getEight());
			setAttribut(Color.WHITE, newFirstF3);
			setAttribut(Color.RED, newSecondF3);
			setAttribut(Color.YELLOW, newThirdF3);
			setAttribut(Color.ORANGE, newFourthF3);
			break;
		case ORANGE:
			Face newFirstF4 = copyFaceFrom(getWhiteFace());
			Face newSecondF4 = copyFaceFrom(getGreenFace());
			Face newThirdF4 = copyFaceFrom(getYellowFace());
			Face newFourthF4 = copyFaceFrom(getBlueFace());
			newFirstF4.setOne(greenFace.getOne());
			newFirstF4.setFour(greenFace.getFour());
			newFirstF4.setSix(greenFace.getSix());
			newSecondF4.setOne(yellowFace.getEight());
			newSecondF4.setFour(yellowFace.getFive());
			newSecondF4.setSix(yellowFace.getThree());
			newThirdF4.setEight(blueFace.getEight());
			newThirdF4.setFive(blueFace.getFive());
			newThirdF4.setThree(blueFace.getThree());
			newFourthF4.setEight(whiteFace.getOne());
			newFourthF4.setFive(whiteFace.getFour());
			newFourthF4.setThree(whiteFace.getSix());
			setAttribut(Color.WHITE, newFirstF4);
			setAttribut(Color.GREEN, newSecondF4);
			setAttribut(Color.YELLOW, newThirdF4);
			setAttribut(Color.BLUE, newFourthF4);
			break;
		case YELLOW:
			Face newFirstF5 = copyFaceFrom(getBlueFace());
			Face newSecondF5 = copyFaceFrom(getOrangeFace());
			Face newThirdF5 = copyFaceFrom(getGreenFace());
			Face newFourthF5 = copyFaceFrom(getRedFace());
			newFirstF5.setSix(orangeFace.getSix());
			newFirstF5.setSeven(orangeFace.getSeven());
			newFirstF5.setEight(orangeFace.getEight());
			newSecondF5.setSix(greenFace.getSix());
			newSecondF5.setSeven(greenFace.getSeven());
			newSecondF5.setEight(greenFace.getEight());
			newThirdF5.setSix(redFace.getSix());
			newThirdF5.setSeven(redFace.getSeven());
			newThirdF5.setEight(redFace.getEight());
			newFourthF5.setSix(blueFace.getSix());
			newFourthF5.setSeven(blueFace.getSeven());
			newFourthF5.setEight(blueFace.getEight());
			setAttribut(Color.BLUE, newFirstF5);
			setAttribut(Color.ORANGE, newSecondF5);
			setAttribut(Color.GREEN, newThirdF5);
			setAttribut(Color.RED, newFourthF5);
			break;
		}
	}
	
	// Getters and setters
	
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
