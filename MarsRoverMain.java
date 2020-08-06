import java.util.Scanner; 
import java.util.ArrayList;

/*
Design Steps
	1. Get boundaries from user
	2. Get number of rovers from user (Cannot be negative)
	3. For each rover, ask user for its initial position (column and row which must be within the boundaries),
		heading (must be 'N', 'E', 'S', or 'W'), and instructions (allows other input but will only use 'M', 'L', and 'R')
	4. For each rover, follow the instructions it is given and print its results


Overrall Design
---------------
MarsRoverMain class is used to run the program and ask for some initial inputs
MarsRoverInput class is used to validate the necessary input for each rover
MarsRover class contains most of the logic necessary for each rover and each rover is instantiated a MarsRover object
	Each rover contains information about itself that changes depending on the instructions it has
*/

public class MarsRoverMain {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println();

		//Get X and Y positional boundaries for Rover
		System.out.print("Enter the Row Boundary: ");
		int rowBounds = scanner.nextInt();
		System.out.print("Enter the Column Boundary: ");
		int columnBounds = scanner.nextInt();

		//Gets the amount of rovers in problem
		int numberOfRovers;
		do {
			System.out.print("How many Rovers are there? ");
			numberOfRovers = scanner.nextInt();
		}
		while (numberOfRovers < 0);
		MarsRover[] rovers = new MarsRover[numberOfRovers];

		//Gets the input of starting position, heading, and instructions for each Rover
		MarsRoverInput roverInput = new MarsRoverInput(columnBounds, rowBounds);
		int column, row;
		String direction, instructions;
		for (int i = 0; i < numberOfRovers; i++)
		{
			System.out.println();
			System.out.println("Rover " + (i + 1) + ":");
			column = roverInput.getColumn();
			row = roverInput.getRow();
			direction = roverInput.getDirectionInput();
			instructions = roverInput.getInstructions();
			rovers[i] = new MarsRover(column, row, direction, instructions, columnBounds, rowBounds);
		}

		//Each Rover follows the instructions given to it and prints out end result
		for (int i = 0; i < numberOfRovers; i++)
		{
			System.out.println();
			rovers[i].followInstructions();
			System.out.println("Rover " + (i+1) + rovers[i]);
		}
	}
}