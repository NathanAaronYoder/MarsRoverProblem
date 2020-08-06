# MarsRoverProblem

Solution written in Java, main class is MarsRoverMain.java.

To compile, type "javac MarsRoverMain.java" in terminal or command line.
To run, type "java MarsRoverMain" in terminal or command line.

Design Steps
---------------
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
