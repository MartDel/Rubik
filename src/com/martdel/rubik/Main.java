package com.martdel.rubik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
	
	private static Cube cube;

	public static void main(String[] args) {
		cube = new Cube();
		init();
		// firstCross();
		findFirstCross(); // Not useful : to avoid having errors
	}
	
	/*public static void firstCross() {
		Color bestCross = findFirstCross(); // Find the best cross to start the cube solving
		Face f = cube.getAttribut(bestCross);
	}*/
	
	private static Color findFirstCross() {
		// Find the best cross in the cube and put the result in a HashMap
		Map<Color, Integer> bestCrossScore = new HashMap<>();
		for(Color faceColor : Color.values()) {
			Face f = cube.getAttribut(faceColor);
			Integer crossScore = 0;
			Integer[] ridges = {2, 4, 5, 7};
			switch(faceColor) {
			case WHITE :
				Color[] adjFaces = {Color.BLUE, Color.ORANGE, Color.RED, Color.GREEN};
				for(int i = 0; i < ridges.length; i++) {
					if(f.getAttribut(ridges[i]) == faceColor && cube.getAttribut(adjFaces[i]).getTwo() == adjFaces[i]) {
						crossScore++;
					}
				}
				break;
			case BLUE:
				Integer[] adjRidges = {2, 5, 4, 2};
				Color[] adjFaces1 = {Color.WHITE, Color.RED, Color.ORANGE, Color.YELLOW};
				for(int i = 0; i < ridges.length; i++) {
					if(f.getAttribut(ridges[i]) == faceColor && cube.getAttribut(adjFaces1[i]).getAttribut(adjRidges[i]) == adjFaces1[i]) {
						crossScore++;
					}
				}
				break;
			case GREEN:
				Integer[] adjRidges1 = {7, 5, 4, 7};
				Color[] adjFaces2 = {Color.WHITE, Color.ORANGE, Color.RED, Color.YELLOW};
				for(int i = 0; i < ridges.length; i++) {
					if(f.getAttribut(ridges[i]) == faceColor && cube.getAttribut(adjFaces2[i]).getAttribut(adjRidges1[i]) == adjFaces2[i]) {
						crossScore++;
					}
				}
				break;
			case ORANGE:
				Integer[] adjRidges2 = {4, 5, 4, 5};
				Color[] adjFaces3 = {Color.WHITE, Color.BLUE, Color.GREEN, Color.YELLOW};
				for(int i = 0; i < ridges.length; i++) {
					if(f.getAttribut(ridges[i]) == faceColor && cube.getAttribut(adjFaces3[i]).getAttribut(adjRidges2[i]) == adjFaces3[i]) {
						crossScore++;
					}
				}
				break;
			case RED:
				Integer[] adjRidges3 = {5, 5, 4, 4};
				Color[] adjFaces4 = {Color.WHITE, Color.GREEN, Color.BLUE, Color.YELLOW};
				for(int i = 0; i < ridges.length; i++) {
					if(f.getAttribut(ridges[i]) == faceColor && cube.getAttribut(adjFaces4[i]).getAttribut(adjRidges3[i]) == adjFaces4[i]) {
						crossScore++;
					}
				}
				break;
			case YELLOW:
				Color[] adjFaces5 = {Color.BLUE, Color.RED, Color.ORANGE, Color.GREEN};
				for(int i = 0; i < ridges.length; i++) {
					if(f.getAttribut(ridges[i]) == faceColor && cube.getAttribut(adjFaces5[i]).getSeven() == adjFaces5[i]) {
						crossScore++;
					}
				}
				break;
			}
			bestCrossScore.put(faceColor, crossScore);
		}
		// Find the best cross in the HashMap
		Color bestCross = Color.WHITE;
		Integer bestScore = -1;
		for(Entry<Color, Integer> score : bestCrossScore.entrySet()) {
		    if(score.getValue() > bestScore) {
		    	bestScore = score.getValue();
		    	bestCross = score.getKey();
		    }
		}
		return bestCross;
	}

	// function to init the cube attribut without ask the colors to the user (cube solved)
	public static void initSolved() {
		Color w = Color.WHITE;
		Color b = Color.BLUE;
		Color r = Color.RED;
		Color g = Color.GREEN;
		Color o = Color.ORANGE;
		Color y = Color.YELLOW;
		Face whiteFace = new Face(w, w, w, w, w, w, w, w, w);
		cube.setAttribut(w, whiteFace);
		Face blueFace = new Face(b, b, b, b, b, b, b, b, b);
		cube.setAttribut(b, blueFace);
		Face redFace = new Face(r, r, r, r, r, r, r, r, r);
		cube.setAttribut(r, redFace);
		Face greenFace = new Face(g, g, g, g, g, g, g, g, g);
		cube.setAttribut(g, greenFace);
		Face orangeFace = new Face(o, o, o, o, o, o, o, o, o);
		cube.setAttribut(o, orangeFace);
		Face yellowFace = new Face(y, y, y, y, y, y, y, y, y);
		cube.setAttribut(y, yellowFace);
	}

	// function to init the cube attribut without ask the colors to the user
	public static void init() {
		Color w = Color.WHITE;
		Color b = Color.BLUE;
		Color r = Color.RED;
		Color g = Color.GREEN;
		Color o = Color.ORANGE;
		Color y = Color.YELLOW;
		Face whiteFace = new Face(w, o, o, r, g, r, b, w, w);
		cube.setAttribut(w, whiteFace);
		Face blueFace = new Face(b, b, g, g, b, b, o, g, b);
		cube.setAttribut(b, blueFace);
		Face redFace = new Face(r, o, b, y, w, y, y, o, y);
		cube.setAttribut(r, redFace);
		Face greenFace = new Face(g, r, g, b, y, r, r, b, r);
		cube.setAttribut(g, greenFace);
		Face orangeFace = new Face(o, w, r, w, o, r, o, o, w);
		cube.setAttribut(o, orangeFace);
		Face yellowFace = new Face(y, g, y, y, y, w, g, w, g);
		cube.setAttribut(y, yellowFace);
	}
	
	// Print the colors of the cube to test methods
	public static void test() {
		// test method to test the turn method
		String[][] result = cube.toArray();
		String[] faces = {"blanche", "bleue", "rouge", "verte", "orange", "jaune"};
		for (int y = 0; y < result.length; ++y) {
			System.out.println("-- Face " + faces[y]);
	        for (int x = 0; x < result[y].length; ++x) {
	            System.out.print(result[y][x] + " , ");
	        }
	        System.out.println();
	    }
	}

	// function to get informations from the user about the cube (return a Color)
	public static Color input(String ask) {
		String s = "";
		Color r = null;
		BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
 		System.out.println(ask);
 		try {
			s = ob.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
 		switch(s) {
 		case "w" : r = Color.WHITE; break;
 		case "b" : r = Color.BLUE; break;
 		case "r" : r = Color.RED; break;
 		case "g" : r = Color.GREEN; break;
 		case "o" : r = Color.ORANGE; break;
 		case "y" : r = Color.YELLOW; break;
 		default:
 			System.out.println("La saisie est incorrecte!");
 			r = input(ask);
 			break;
 		}
		return r;
	}
	
	// Function who ask all of the colors in the cube
	public static void askColor() {
		Integer whiteCounter = 0;
		Integer blueCounter = 0;
		Integer redCounter = 0;
		Integer greenCounter = 0;
		Integer orangeCounter = 0;
		Integer yellowCounter = 0;
		do {
			whiteCounter = 0;
			blueCounter = 0;
			redCounter = 0;
			greenCounter = 0;
			orangeCounter = 0;
			yellowCounter = 0;
			System.out.println("Rentrer les couleurs des �tiquettes du cube");
			System.out.println("w pour white, r pour red, b pour blue, etc...");
			System.out.println("Remplicez les informations pour chaque phrase une par une :");
			System.out.println("! Si le programme se relance cela signifie que les donn�es remplie ne sont pas valides !");
			for(Color faceColor : Color.values()) {
				String faceOrientation = faceColor.getTop();
				String faceName = faceColor.getFrench();
				Map<Integer, Color> array = new HashMap<>();
				System.out.println("------------------------------------");
				System.out.println("Face " + faceName + " : ");
				System.out.println("Orientez la face " + faceName + " vers la face " + faceOrientation);
				System.out.println("(face " + faceName + " face � vous et face " + faceOrientation + " derri�re)");
				array.put(1, input("Coin en haut � gauche :"));
				array.put(2, input("Ar�te en haut au centre :"));
				array.put(3, input("Coin en haut � droite :"));
				array.put(4, input("Ar�te au milieu � gauche :"));
				array.put(5, input("Ar�te au milieu � droite :"));
				array.put(6, input("Coin en bas � gauche :"));
				array.put(7, input("Arr�te en bas au centre :"));
				array.put(8, input("Coin en bas � droite :"));
				Face face = new Face(faceColor, array.get(1), array.get(2), array.get(3), array.get(4), array.get(5), array.get(6), array.get(7), array.get(8));
				cube.setAttribut(faceColor, face);
				// Safety :
				for(int i = 1; i <= array.size(); i++) {
					switch(array.get(i)) {
					case WHITE: whiteCounter++; break;
					case BLUE: blueCounter++; break;
					case RED: redCounter++; break;
					case GREEN: greenCounter++; break;
					case ORANGE: orangeCounter++; break;
					case YELLOW: yellowCounter++; break;
					}
				}
			}
		} while(whiteCounter != 8 || blueCounter != 8 || redCounter != 8 || greenCounter != 8 || orangeCounter != 8 || yellowCounter != 8);
	}
}
