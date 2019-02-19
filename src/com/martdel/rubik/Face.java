package com.martdel.rubik;

/**
 * @author MartDel
 *
 */
public class Face {
	
	private Color colorCenter;
	
	// Schematization of a face in the "schema" file
	
	private Color one;
	private Color two;
	private Color three;
	private Color four;
	private Color five;
	private Color six;
	private Color seven;
	private Color eight;
	
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
	
	// Return all of the colors in this face
	public String[] toArray() {
		String[] r = {
			one.toString(),
			two.toString(),
			three.toString(),
			four.toString(),
			five.toString(),
			six.toString(),
			seven.toString(),
			eight.toString()
		};
		return r;
	}
	
	// Get an attribut
	public Color getAttribut(Integer a) {
		Color r = null;
		switch(a) {
		case 1: r = getOne(); break;
		case 2: r = getTwo(); break;
		case 3: r = getThree(); break;
		case 4: r = getFour(); break;
		case 5: r = getFive(); break;
		case 6: r = getSix(); break;
		case 7: r = getSeven(); break;
		case 8: r = getEight(); break;
		}
		return r;
	}
	
	// Set an attribut
	public void setAttribut(Integer a, Color v) {
		switch(a) {
		case 1: setOne(v); break;
		case 2: setTwo(v); break;
		case 3: setThree(v); break;
		case 4: setFour(v); break;
		case 5: setFive(v); break;
		case 6: setSix(v); break;
		case 7: setSeven(v); break;
		case 8: setEight(v); break;
		}
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
}