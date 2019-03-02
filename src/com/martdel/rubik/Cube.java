package com.martdel.rubik;

import java.util.HashMap;
import java.util.Map;

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
			Map<String, Integer[]> adj = new HashMap<>();
			Integer[] p1 = {3, 2, 1};
			Integer[] p2 = {1, 4, 6};
			Integer[] p3 = {8, 5, 3};
			Integer[] p4 = {6, 7, 8};		
			switch(f.getColorCenter()) {
			case WHITE:
				adj = setAdj(adj, p1, p1, p1, p1);
				break;
			case BLUE:
				adj = setAdj(adj, p1, p2, p1, p3);
				break;
			case GREEN:
				adj = setAdj(adj, p4, p2, p4, p3);
				break;
			case ORANGE:
				adj = setAdj(adj, p2, p2, p3, p3);
				break;
			case RED:
				adj = setAdj(adj, p3, p2, p2, p3);
				break;
			case YELLOW:
				adj = setAdj(adj, p4, p4, p4, p4);
				break;
			}
			// Duplicate the adjacents faces of the turning face in others variables
			Face newFirstF = copyFaceFrom(getAttribut(Main.getColorFromFr(f.getColorCenter().getTop())));
			Face newSecondF = copyFaceFrom(getAttribut(Main.getColorFromFr(f.getColorCenter().getRight())));
			Face newThirdF = copyFaceFrom(getAttribut(Main.getColorFromFr(f.getColorCenter().getBottom())));
			Face newFourthF = copyFaceFrom(getAttribut(Main.getColorFromFr(f.getColorCenter().getLeft())));
			Face[] newAdjFaces = {newFirstF, newSecondF, newThirdF, newFourthF};
			Face[] newAdjF = {null, null, null, null};
			if(o) {
				idOfTheNewColor = idOfTheNewColorR;
				newAdjF = updateAdjFacesRight(f, newAdjFaces, adj);
			} else {
				idOfTheNewColor = idOfTheNewColorL;
				newAdjF = updateAdjFacesLeft(f, newAdjFaces, adj);
			}
			for(int j = 1; j <= 8; j++) {
				newF.setAttribut(j, f.getAttribut(idOfTheNewColor[j - 1]));
			}
			setAttribut(f.getColorCenter(), newF);
			// Set adjacents faces
			setAttribut(Main.getColorFromFr(f.getColorCenter().getTop()), newAdjF[0]);
			setAttribut(Main.getColorFromFr(f.getColorCenter().getRight()), newAdjF[1]);
			setAttribut(Main.getColorFromFr(f.getColorCenter().getBottom()), newAdjF[2]);
			setAttribut(Main.getColorFromFr(f.getColorCenter().getLeft()), newAdjF[3]);
		}
	}
	
	public Map<String, Integer[]> setAdj(Map<String, Integer[]> adj, Integer[] p1, Integer[] p2, Integer[] p3, Integer[] p4) {
		Map<String, Integer[]> array = adj;
		array.put("top", p1);
		array.put("right", p2);
		array.put("bottom", p3);
		array.put("left", p4);
		return array;
	}
	
	public Face[] updateAdjFacesRight(Face f, Face[] adjFaces, Map<String, Integer[]> adj) {
		Face[] adjF = adjFaces;
		for(int i = 0; i < adj.get("top").length; i++) {
			adjF[0].setAttribut(adj.get("top")[i], getAttribut(Main.getColorFromFr(f.getColorCenter().getLeft())).getAttribut(adj.get("left")[i]));		
		}
		for(int i = 0; i < adj.get("right").length; i++) {
			adjF[1].setAttribut(adj.get("right")[i], getAttribut(Main.getColorFromFr(f.getColorCenter().getTop())).getAttribut(adj.get("top")[i]));
		}
		for(int i = 0; i < adj.get("bottom").length; i++) {		
			adjF[2].setAttribut(adj.get("bottom")[i], getAttribut(Main.getColorFromFr(f.getColorCenter().getRight())).getAttribut(adj.get("right")[i]));
		}
		for(int i = 0; i < adj.get("left").length; i++) {		
			adjF[3].setAttribut(adj.get("left")[i], getAttribut(Main.getColorFromFr(f.getColorCenter().getBottom())).getAttribut(adj.get("bottom")[i]));
		}
		return adjF;
	}
	
	public Face[] updateAdjFacesLeft(Face f, Face[] adjFaces, Map<String, Integer[]> adj) {
		Face[] adjF = adjFaces;
		for(int i = 0; i < adj.get("top").length; i++) {
			adjF[0].setAttribut(adj.get("top")[i], getAttribut(Main.getColorFromFr(f.getColorCenter().getLeft())).getAttribut(adj.get("right")[i]));		
		}
		for(int i = 0; i < adj.get("right").length; i++) {
			adjF[1].setAttribut(adj.get("right")[i], getAttribut(Main.getColorFromFr(f.getColorCenter().getTop())).getAttribut(adj.get("bottom")[i]));
		}
		for(int i = 0; i < adj.get("bottom").length; i++) {		
			adjF[2].setAttribut(adj.get("bottom")[i], getAttribut(Main.getColorFromFr(f.getColorCenter().getRight())).getAttribut(adj.get("left")[i]));
		}
		for(int i = 0; i < adj.get("left").length; i++) {		
			adjF[3].setAttribut(adj.get("left")[i], getAttribut(Main.getColorFromFr(f.getColorCenter().getBottom())).getAttribut(adj.get("top")[i]));
		}
		return adjF;
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
