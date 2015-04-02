package maman11;

public class Circle {

	private double _diameter;
	
	private Circle(){}
	
	/**
	 * Static initializer, initializes {@link Circle} with radius as input.
	 * @param radius
	 * @return instance of {@link Circle}
	 */
	public static Circle initWithRadius(double radius){
		Circle c = new Circle();
		c.set_diameter(radius * 2);
		return c;
	}
	/**
	 * Static initializer, initializes {@link Circle} with diameter as input.
	 * @param diameter
	 * @return instance of {@link Circle}
	 */
	public static Circle initWithDiameter(double diameter){
		Circle c = new Circle();
		c.set_diameter(diameter);
		return c;
	}
	public double get_diameter() {
		return _diameter;
	}

	public void set_diameter(double _diameter) {
		if(_diameter < 0){
			System.err.println("Diameter most be positive integer!");
			return;
		}
		this._diameter = _diameter;
	}
	
	private double clalculateRadius(){
		return (double)this._diameter / 2;
	}
	
	private double calculateArea(){
		return Math.PI * Math.pow(this.clalculateRadius(),2);
	}
	
	private double calculatePerimeter(){
		return Math.PI * this.clalculateRadius() * 2;
	}

	@Override
	public String toString() {
		return "radius = " + this.clalculateRadius() + ", aera = " + this.calculateArea() + ", perimeter = " + this.calculatePerimeter();
	}
}
