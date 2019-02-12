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
	
	public void copyTo(Cube newCube) {
		Color[] listOfAttributs = {Color.WHITE, Color.BLUE, Color.RED, Color.GREEN, Color.ORANGE, Color.YELLOW};
		for(Color attribut : listOfAttributs) {
			newCube.setAttribut(attribut, getAttribut(attribut));
		}
	}

	public Cube turnFaceRight(Cube newCube, Face f, int t) {
		// Turn a face to the right
		Face newF = newCube.getAttribut(f.getColorCenter());
		Integer[] idOfTheNewColor = {6, 4, 1, 7, 2, 8, 5, 3}; // Creating an array which contain the order of the id of the stickers which will become the new stickers
		for(int j = 0; j < 8; j++) {
			f.setAttribut(j, newF.getAttribut(idOfTheNewColor[j]));
		}
		//updateAdjacentsFaces(f);
		return newCube;
	}
	
	public void updateAdjacentsFaces(Face f) {
		switch(f.getColorCenter()) {
		case WHITE :
			blueFace.setOne(orangeFace.getThree());
			blueFace.setTwo(orangeFace.getTwo());
			blueFace.setThree(orangeFace.getOne());
			redFace.setThree(blueFace.getOne());
			redFace.setTwo(blueFace.getTwo());
			redFace.setOne(blueFace.getThree());
			greenFace.setThree(redFace.getThree());
			greenFace.setTwo(redFace.getTwo());
			greenFace.setOne(redFace.getOne());
			orangeFace.setThree(greenFace.getThree());
			orangeFace.setTwo(greenFace.getTwo());
			orangeFace.setOne(greenFace.getOne());
			break;
		case BLUE:
			whiteFace.setOne(orangeFace.getSix());
			whiteFace.setTwo(orangeFace.getFour());
			whiteFace.setThree(orangeFace.getOne());
			redFace.setThree(whiteFace.getOne());
			redFace.setFive(whiteFace.getTwo());
			redFace.setEight(whiteFace.getThree());
			yellowFace.setThree(redFace.getThree());
			yellowFace.setTwo(redFace.getFive());
			yellowFace.setOne(redFace.getEight());
			orangeFace.setSix(yellowFace.getThree());
			orangeFace.setFour(yellowFace.getTwo());
			orangeFace.setOne(yellowFace.getOne());
			break;
		case RED:
			whiteFace.setThree(greenFace.getEight());
			whiteFace.setFive(greenFace.getFive());
			whiteFace.setEight(greenFace.getThree());
			blueFace.setThree(whiteFace.getThree());
			blueFace.setFive(whiteFace.getFive());
			blueFace.setEight(whiteFace.getEight());
			yellowFace.setOne(blueFace.getThree());
			yellowFace.setFour(blueFace.getFive());
			yellowFace.setSix(blueFace.getEight());
			greenFace.setEight(yellowFace.getOne());
			greenFace.setFive(yellowFace.getFour());
			greenFace.setThree(yellowFace.getSix());
			break;
		case GREEN:
			whiteFace.setSix(orangeFace.getEight());
			whiteFace.setSeven(orangeFace.getFive());
			whiteFace.setEight(orangeFace.getThree());
			redFace.setOne(whiteFace.getSix());
			redFace.setFour(whiteFace.getSeven());
			redFace.setSix(whiteFace.getEight());
			yellowFace.setSix(redFace.getOne());
			yellowFace.setSeven(redFace.getFour());
			yellowFace.setEight(redFace.getSix());
			orangeFace.setEight(yellowFace.getSix());
			orangeFace.setFive(yellowFace.getSeven());
			orangeFace.setThree(yellowFace.getEight());
			break;
		case ORANGE:
			whiteFace.setOne(blueFace.getSix());
			whiteFace.setFour(blueFace.getFour());
			whiteFace.setSix(blueFace.getOne());
			greenFace.setOne(whiteFace.getOne());
			greenFace.setFour(whiteFace.getFour());
			greenFace.setSix(whiteFace.getSix());
			yellowFace.setEight(greenFace.getOne());
			yellowFace.setFive(greenFace.getFour());
			yellowFace.setThree(greenFace.getSix());
			blueFace.setSix(yellowFace.getEight());
			blueFace.setFour(yellowFace.getFive());
			blueFace.setOne(yellowFace.getThree());
			break;
		case YELLOW:
			blueFace.setSix(redFace.getSix());
			blueFace.setSeven(redFace.getSeven());
			blueFace.setEight(redFace.getEight());
			orangeFace.setSix(blueFace.getSix());
			orangeFace.setSeven(blueFace.getSeven());
			orangeFace.setEight(blueFace.getEight());
			greenFace.setSix(orangeFace.getSix());
			greenFace.setSeven(orangeFace.getSeven());
			greenFace.setEight(orangeFace.getEight());
			redFace.setSix(greenFace.getSix());
			redFace.setSeven(greenFace.getSeven());
			redFace.setEight(greenFace.getEight());
			break;
		}
	}

	public void turnFaceLeft(int t) {
		// Turn a face to the left
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
