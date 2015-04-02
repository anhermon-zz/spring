package maman11;

public class Rectangle {

	private Position _topLeft;
	private Position _bottomRight;
	
	public Rectangle(Position topLeft, Position bottomRight){
		this._topLeft = topLeft;
		this._bottomRight = bottomRight;
	}
	
	private int getInnerDiameter(){
		return Math.min(this.height(), this.width());
	}
	
	private int getOuterDiameter(){
		return Math.max(this.height(), this.width());
	}
	
	private int height(){
		return this._bottomRight.get_y() - this._topLeft.get_y();
	}
	
	private int width(){
		return this._topLeft.get_x() - this._bottomRight.get_x();
	}
	
	public void displayCircleAttributes(){
		Circle incircle = Circle.initWithDiameter(getInnerDiameter());
		Circle excircle = Circle.initWithDiameter(getOuterDiameter());
		
		System.out.println("Incircle:" + incircle);
		System.out.println("Excircle"  + excircle);
	}
}
