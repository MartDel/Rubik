package com.martdel.rubik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	private static Cube cube;

	public static void main(String[] args) {
		cube = new Cube();
		// askColor();
		init();
		cube.turnFace(cube.getAttribut(Color.BLUE), true, 1);
		System.out.println(cube.getAttribut(Color.BLUE).getColorCenter());
		//cube.turnFace(cube.getAttribut(Color.BLUE), true, 1);
		System.out.println("--------------------");
		test();
	}
	
	public static void init() {
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
			System.out.println("Rentrer les couleurs des étiquettes du cube");
			System.out.println("w pour white, r pour red, b pour blue, etc...");
			System.out.println("Remplicez les informations pour chaque phrase une par une :");
			System.out.println("! Si le programme se relance cela signifie que les données remplie ne sont pas valides !");
			for(Color faceColor : Color.values()) {
				String faceOrientation = faceColor.getFaceOrientation();
				String faceName = faceColor.getFrench();
				Map<Integer, Color> array = new HashMap<>();
				System.out.println("------------------------------------");
				System.out.println("Face " + faceName + " : ");
				System.out.println("Orientez la face " + faceName + " vers la face " + faceOrientation);
				System.out.println("(face " + faceName + " face à vous et face " + faceOrientation + " derrière)");
				array.put(1, input("Coin en haut à gauche :"));
				array.put(2, input("Arête en haut au centre :"));
				array.put(3, input("Coin en haut à droite :"));
				array.put(4, input("Arête au milieu à gauche :"));
				array.put(5, input("Arête au milieu à droite :"));
				array.put(6, input("Coin en bas à gauche :"));
				array.put(7, input("Arrête en bas au centre :"));
				array.put(8, input("Coin en bas à droite :"));
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
