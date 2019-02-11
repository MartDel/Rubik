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
		askColor();
		System.out.println(cube.toString());
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
		System.out.println("Rentrer les couleurs des étiquettes du cube");
		System.out.println("w pour white, r pour red, b pour blue, etc...");
		System.out.println("Remplicez les informations pour chaque phrase une par une :");
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
			addFaceInCube(faceName, face);
			initAttributesOfFaces(faceName);
		}
	}

	private static void initAttributesOfFaces(String faceName) {
		switch(faceName) {
		case "blanche" :
			cube.getWhiteFace().setTop(cube.getBlueFace());
			cube.getWhiteFace().setRight(cube.getRedFace());
			cube.getWhiteFace().setBottom(cube.getGreenFace());
			cube.getWhiteFace().setLeft(cube.getOrangeFace());
		break;
		case "bleue" :
			cube.getBlueFace().setTop(cube.getWhiteFace());
			cube.getBlueFace().setRight(cube.getRedFace());
			cube.getBlueFace().setBottom(cube.getYellowFace());
			cube.getBlueFace().setLeft(cube.getOrangeFace());
		break;
		case "rouge" :
			cube.getRedFace().setTop(cube.getWhiteFace());
			cube.getRedFace().setRight(cube.getBlueFace());
			cube.getRedFace().setBottom(cube.getYellowFace());
			cube.getRedFace().setLeft(cube.getGreenFace());
		break;
		case "verte" :
			cube.getGreenFace().setTop(cube.getWhiteFace());
			cube.getGreenFace().setRight(cube.getRedFace());
			cube.getGreenFace().setBottom(cube.getYellowFace());
			cube.getGreenFace().setLeft(cube.getOrangeFace());
		break;
		case "orange" :
			cube.getOrangeFace().setTop(cube.getWhiteFace());
			cube.getOrangeFace().setRight(cube.getGreenFace());
			cube.getOrangeFace().setBottom(cube.getYellowFace());
			cube.getOrangeFace().setLeft(cube.getBlueFace());
		break;
		case "jaune" :
			cube.getYellowFace().setTop(cube.getBlueFace());
			cube.getYellowFace().setRight(cube.getRedFace());
			cube.getYellowFace().setBottom(cube.getGreenFace());
			cube.getYellowFace().setLeft(cube.getOrangeFace());
		break;
		}
	}

	private static void addFaceInCube(String faceName, Face face) {
		switch(faceName) {
		case "blanche" : cube.setWhiteFace(face); break;
		case "bleue" : cube.setBlueFace(face); break;
		case "rouge" : cube.setRedFace(face); break;
		case "verte" : cube.setGreenFace(face); break;
		case "orange" : cube.setOrangeFace(face); break;
		case "jaune" : cube.setYellowFace(face); break;
		}
	}

}
