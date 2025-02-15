
public class TeraoTestSimpleRectangle {
	public static void main(String[] args) {
		// SimpleRectangle object
		SimpleRectangle rectangle1 = new SimpleRectangle();

		// SimpleRectangle object with defined dimensions
		SimpleRectangle rectangle2 = new SimpleRectangle(1.2, 2.2);
		SimpleRectangle rectangle3 = new SimpleRectangle(-2.0, -2.0);

		// System.out.println for each rectangle's area and perimeter
		System.out.println(
				"Rectangle 1: Area is: " + rectangle1.getArea() + ", The Perimeter is: " + rectangle1.getPerimeter());
		System.out.println(
				"Rectangle 2: Area is: " + rectangle2.getArea() + ", The Perimeter is: " + rectangle2.getPerimeter());
		System.out.println(
				"Rectangle 3: Area is: " + rectangle3.getArea() + ", The Perimeter is: " + rectangle3.getPerimeter());
	}
}

//class to store the values of each rectangle
class SimpleRectangle {
	private double length;
	private double width;

	// Default constructor
	public SimpleRectangle() {
		length = 1.0;
		width = 1.0;
	}

	// Constructor that sets custom dimensions and rejects non positive #'s
	public SimpleRectangle(double newLength, double newWidth) {
		if (newLength > 0) {
			length = newLength;
		} else {
			length = 1.0;
		}

		if (newWidth > 0) {
			width = newWidth;
		} else {
			width = 1.0;
		}
	}

	// Setters and Getters
	public void setLength(double newLength) {
		if (newLength > 0) {
			length = newLength;
		}

	}

	public void setWidth(double newWidth) {
		if (newWidth > 0) {
			width = newWidth;
		}

	}

	// Getters
	public double getArea() {
		return length * width;
	}

	public double getPerimeter() {
		return 2 * (length + width);
	}

}