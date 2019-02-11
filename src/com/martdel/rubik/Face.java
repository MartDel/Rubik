package com.martdel.rubik;

/**
 * @author MartDel
 *
 */
public class Face {
	
	private Color colorCenter;
	
	// Schematization of a face in the "schema" file
	// Colors in face
	
	private Color one;
	private Color two;
	private Color three;
	private Color four;
	private Color five;
	private Color six;
	private Color seven;
	private Color eight;
	
	// Adjacents faces
	
	private Face top;
	private Face right;
	private Face bottom;
	private Face left;
	
	// Construct
	
	public Face(Color colorCenter, Color one, Color two, Color three, Color four, Color five, Color six, Color seven, Color eight) {
		setColorcenter(colorCenter);
		setOne(one);
		setTwo(two);
		setThree(three);
		setFour(four);
		setFive(five);
		setSix(six);
		setSeven(seven);
		setEight(eight);
	}
	
	// Getters and setters

	public Color getEight() {
		return eight;
	}
	public void setEight(Color eight) {
		this.eight = eight;
	}
	public Color getSeven() {
		return seven;
	}
	public void setSeven(Color seven) {
		this.seven = seven;
	}
	public Color getSix() {
		return six;
	}
	public void setSix(Color six) {
		this.six = six;
	}
	public Color getFive() {
		return five;
	}
	public void setFive(Color five) {
		this.five = five;
	}
	public Color getFour() {
		return four;
	}
	public void setFour(Color four) {
		this.four = four;
	}
	public Color getThree() {
		return three;
	}
	public void setThree(Color three) {
		this.three = three;
	}
	public Color getTwo() {
		return two;
	}
	public void setTwo(Color two) {
		this.two = two;
	}
	public Color getColorCenter() {
		return colorCenter;
	}
	public void setColorcenter(Color colorCenter) {
		this.colorCenter = colorCenter;
	}
	public Color getOne() {
		return one;
	}
	public void setOne(Color one) {
		this.one = one;
	}
	public Face getTop() {
		return top;
	}
	public void setTop(Face top) {
		this.top = top;
	}
	public Face getRight() {
		return right;
	}
	public void setRight(Face right) {
		this.right = right;
	}
	public Face getBottom() {
		return bottom;
	}
	public void setBottom(Face bottom) {
		this.bottom = bottom;
	}
	public Face getLeft() {
		return left;
	}
	public void setLeft(Face left) {
		this.left = left;
	}
}