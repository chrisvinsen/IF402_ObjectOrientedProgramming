package week05.christianto.ac.id.umn;

public class Triangle extends Shape {
	
	private double height;
	private double base;
	
	public Triangle() { }
	
	public Triangle(double height, double base, String color) {
		super(color);
		this.height = height;
		this.base = base;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getBase() {
		return base;
	}
	
	public double getArea() {
		return (height*base)/2;
	}
	
	public double getPerimeter() {
		return base + height + Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
	}
	
	

}
