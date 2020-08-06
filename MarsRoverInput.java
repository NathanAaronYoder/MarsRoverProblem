import java.util.Scanner; 

/*
The point of this Class is to certain validate input: Rover Position, Rover Heading,
and Rover Instructions
*/
public class MarsRoverInput {
	private Scanner scanner;
	private int columnBounds;
	private int rowBounds;

	//Use the columnBounds and rowBounds variables to validate rover position input
	public MarsRoverInput(int columnBounds, int rowBounds)
	{
		scanner = new Scanner(System.in);
		this.columnBounds = columnBounds;
		this.rowBounds = rowBounds;
	}

	//Checks if a position is between two other positions on a linear axis
	//Helpful in case of negative boundaries
	public boolean numberIsBetween(int numBetween, int num1, int num2)
	{
		if (num1 > num2)
		{
			if (numBetween <= num1 && numBetween >= num2)
			{
				return true;
			}
			else
			{
				System.out.println("Starting point is not within the declared bounds.");
				return false;
			}
		}
		else
		{
			if (numBetween <= num2 && numBetween >= num1)
			{
				return true;
			}
			else
			{
				System.out.println("Starting point is not within the declared bounds.");
				return false;
			}
		}
	}

	//Get Starting column position of Rover
	public int getColumn()
	{
		int column;
		do {
			System.out.print("Enter the rover's starting column: ");
			column = scanner.nextInt();
		}
		while (!(numberIsBetween(column, this.columnBounds, 0)));
		return column;
	}

	//Get Starting row position of Rover
	public int getRow()
	{
		int row;
		do {
			System.out.print("Enter the rover's starting row: ");
			row = scanner.nextInt();
		}
		while (!(numberIsBetween(row, this.rowBounds, 0)));
		return row;
	}

	//Validates the direction input of rover
	public boolean checkDirection(String direction)
	{
		switch(direction)
		{
			case "N":
				return true;
			case "E":
				return true;
			case "S":
				return true;
			case "W":
				return true;
		}
		System.out.println("The direction is invalid.");
		return false;
	}

	//Gets direction input of rover
	public String getDirectionInput()
	{
		String bugFix = scanner.nextLine();
		String direction;
		do {
			System.out.print("Enter the direction the rover is facing ('N', 'E', 'W', or 'S'): ");
			direction = scanner.nextLine();
		}
		while (!checkDirection(direction));
		return direction;
	}

	//Gets instruction input of rover
	public String getInstructions()
	{
		System.out.print("Enter the Rover's Instructions: ");
		String instructions = scanner.nextLine();
		return instructions;
	}
}