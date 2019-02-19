package com.martdel.rubik;

public enum Color {
	WHITE("blanche", "bleue"),
	BLUE("bleue", "blanche"),
	RED("rouge","blanche"),
	GREEN("verte", "blanche"),
	ORANGE("orange", "blanche"),
	YELLOW("jaune", "bleue");
	
	// Traduction of the color to print it in a sentence
	private String french;
	// Look at the file "shcema.png"
	private String faceOrientation;
	
	Color(String french, String faceOrientation){
		this.french = french;
		this.faceOrientation = faceOrientation;
	}
	
	public String getFrench() {
		return french;
	}
	
	public String getFaceOrientation() {
		return faceOrientation;
	}
}
