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
	
	public Face copyFaceFrom(Face origin) {
		Face returnFace = new Face(origin.getColorCenter(), origin.getOne(), origin.getTwo(), origin.getThree(), origin.getFour(), origin.getFive(), origin.getSix(), origin.getSeven(), origin.getEight());
		return returnFace;
	}

	public void turnFaceRight(Face f, int t) {
		// Turn a face to the right
		Face newF = new Face(null, null, null, null, null, null, null, null, null);
		Integer[] idOfTheNewColor = {6, 4, 1, 7, 2, 8, 5, 3}; // Creating an array which contain the order of the id of the stickers which will become the new stickers
		for(int j = 1; j <= 8; j++) {
			newF.setAttribut(j, f.getAttribut(idOfTheNewColor[j - 1]));
		}
		setAttribut(f.getColorCenter(), newF);
		updateAdjacentsFaces(f);
	}
	
	public void updateAdjacentsFaces(Face f) {
		switch(f.getColorCenter()) {
		case WHITE :
			Face newFirstF = copyFaceFrom(getBlueFace());
			Face newSecondF = copyFaceFrom(getRedFace());
			Face newThirdF = copyFaceFrom(getGreenFace());
			Face newFourthF = copyFaceFrom(getOrangeFace());
			newFirstF.setThree(orangeFace.getThree());
			newFirstF.setTwo(orangeFace.getTwo());
			newFirstF.setOne(orangeFace.getOne());
			newSecondF.setThree(blueFace.getOne());
			newSecondF.setTwo(blueFace.getTwo());
			newSecondF.setOne(blueFace.getThree());
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
			newSecondF1.setOne(whiteFace.getOne());
			newSecondF1.setFour(whiteFace.getTwo());
			newSecondF1.setSix(whiteFace.getThree());
			newThirdF1.setOne(orangeFace.getOne());
			newThirdF1.setTwo(orangeFace.getFour());
			newThirdF1.setThree(orangeFace.getSix());
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
			newFirstF2.setThree(greenFace.getEight());
			newFirstF2.setFive(greenFace.getFive());
			newFirstF2.setEight(greenFace.getThree());
			newSecondF2.setOne(whiteFace.getThree());
			newSecondF2.setFour(whiteFace.getFive());
			newSecondF2.setSix(whiteFace.getEight());
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
			newFirstF5.setEight(redFace.getSix());
			newFirstF5.setSeven(redFace.getSeven());
			newFirstF5.setSix(redFace.getEight());
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

	public Cube turnFaceLeft(Cube newCube, Face f, int t) {
		// Turn a face to the left
		return newCube;
	}
	
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
