package com.martdel.rubik;

public enum Color {
	WHITE("blanche", "bleue", "rouge", "verte", "orange"),
	BLUE("bleue", "blanche", "orange", "jaune", "rouge"),
	RED("rouge","blanche", "bleue", "jaune", "verte"),
	GREEN("verte", "blanche", "rouge", "jaune", "orange"),
	ORANGE("orange", "blanche", "verte", "jaune", "bleue"),
	YELLOW("jaune", "bleue", "orange", "verte", "rouge");
	
	// Traduction of the color to print it in a sentence
	private String french;
	// Look at the file "schema.png"
	private String top;
	private String right;
	private String bottom;
	private String left;
	
	Color(String french, String top, String right, String bottom, String left){
		this.french = french;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.left = left;
	}
	
	public String getFrench() {
		return french;
	}
	
	public String getTop() {
		return top;
	}

	public String getRight() {
		return right;
	}
	public String getBottom() {
		return bottom;
	}
	public String getLeft() {
		return left;
	}
}
