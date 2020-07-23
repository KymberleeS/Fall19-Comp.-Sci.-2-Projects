import java.util.Scanner;

public class MyCircle 
{
	public static void main(String[] args) 
	{
		//variable initialization
			double radius;
			double diameter;
			double pi = 3.14159;
			double circumference;
			double area;
			
		//statements
			Scanner input = new Scanner (System.in);
			
			System.out.printf("Enter radius value: ");
			radius = input.nextDouble();
			
			diameter = radius * 2;
			circumference = diameter * pi;
			area = pi * radius * radius;
			
			System.out.printf("Radius: %17.2f\n", radius);
			System.out.printf("Circumference: %10.2f\n", circumference);
			System.out.printf("Area: %19.2f\n", area);
			
			input.close();
	}
}
