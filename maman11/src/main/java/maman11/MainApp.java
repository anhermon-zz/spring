package maman11;

import java.util.Scanner;

public class MainApp {
	private static final Scanner s = new Scanner(System.in);
	public static void main(String[] args){
		Position topLeft = initPoint("top left");
		Position bottomRight = initPoint("bottom right");
		Rectangle rec = new Rectangle(topLeft, bottomRight);
		rec.displayCircleAttributes();
	}
	private static Position initPoint(String name) {
		int x = 0;
		int y = 0;
		System.out.println("please insert x coordinate for rectangle " + name + " corner:");
		x = s.nextInt();
		System.out.println("please insert y coordinate for rectangle " + name + " corner:");
		y = s.nextInt();
		return new Position(x, y);
	}
}