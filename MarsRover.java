public class MarsRover {

	private int column;
	private int row;
	private int degreeFacing;
	private int columnBounds;
	private int rowBounds;
	private String instructions;
	private boolean roverWentOutOfBounds;

	//Constructor
	public MarsRover(int column, int row, String direction, String instructions, int columnBounds, int rowBounds) {
		this.columnBounds = columnBounds;
		this.rowBounds = rowBounds;
		this.column = column;
		this.row = row;
		this.degreeFacing = setDegreeFacing(direction);
		this.instructions = instructions;
		this.roverWentOutOfBounds = false;
	}		

	//Converts direction to degrees which is easier to calculate movement
	public int setDegreeFacing(String direction)
	{
		switch(direction)
		{
			case "N":
				return 90;
			case "E":
				return 0;
			case "W":
				return 180;
			case "S":
				return 270;
		}
		return 0;
	}

	public void moveEast()
	{
		this.column += 1;
	}

	public void moveNorth()
	{
		this.row += 1;
	}

	public void moveWest()
	{
		this.column -= 1;
	}
	
	public void moveSouth()
	{
		this.row -= 1;
	}

	public void turnLeft()
	{
		this.degreeFacing += 90;
		this.degreeFacing %= 360;
	}

	public void turnRight()
	{
		this.degreeFacing -= 90;
		if (this.degreeFacing < 0)
		{
			this.degreeFacing += 360;
		}
	}

	public void moveForward()
	{
		switch(this.degreeFacing)
		{
			case 0:
				moveEast();
				break;
			case 90:
				moveNorth();
				break;
			case 180:
				moveWest();
				break;
			case 270:
				moveSouth();
				break;
		}
	}

	//Rover goes through instructions given and follows them
	public void followInstructions()
	{
		char instruction;
		for (int i = 0; i < this.instructions.length(); i++)
		{
			instruction = this.instructions.charAt(i);
			switch(instruction)
			{
				case 'M':
					moveForward();
					break;
				case 'R':
					turnRight();
					break;
				case 'L':
					turnLeft();
					break;
			}
			if (roverIsOutOfBounds())
			{
				this.roverWentOutOfBounds = true;
			}
		}
	}

	//Used by roverIsOutOfBounds()
	public boolean numberIsBetween(int numBetween, int num1, int num2)
	{
		if (num1 > num2)
		{
			return (numBetween <= num1 && numBetween >= num2);
		}
		else
		{
			return (numBetween <= num2 && numBetween >= num1);
		}
	}

	//Checks if position of rover is within boundaries on a linear plane
	public boolean roverIsOutOfBounds()
	{
		if (numberIsBetween(this.column, 0, this.columnBounds) && numberIsBetween(this.row, 0, this.rowBounds))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	//Converts final heading back to directions for the user interface
	public String getDirection()
	{
		switch(this.degreeFacing)
		{
			case 0:
				return "E";
			case 90:
				return "N";
			case 180:
				return "W";
			case 270:
				return "S";
		}
		return "S";
	}

	//If the rover stayed within its bounds, prints its final position and heading
	public String toString()
	{
		String direction = getDirection();
		if (roverIsOutOfBounds() || this.roverWentOutOfBounds)
		{
			return "\n     The Rover is out of Bounds";
		}
		else
		{
			return " final position and heading: " + this.column + " " + this.row + " " + direction;
		}
	}
}