/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: ESPGame: This java program is a simple guessing game. A list of colors will be
 * provided as a text file "colors.txt". The program will select a random color and the user 
 * must try to guess the color. After the game is over the user will input some information and
 * their score will be saved to a file.
 * Due: 02/11/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Adam J Ido
 */


import java.io.*;

import java.util.*;

public class ESPGame {
	
	public static void main(String [] args) throws IOException, FileNotFoundException {
		System.out.println("Welcome to my ESPGame!");
		System.out.println("This game will test your ESP (Extrasensory perception)!");
		
		FileWriter fw = new FileWriter("EspGameResults.txt", true);
		PrintWriter outFile = new PrintWriter(fw);
		Scanner keyboard = new Scanner(System.in);
		
		final int rounds = 3;
		int choice = 0; //Users input selection for the menu in the main loop
		while(choice != 4) {
			
			choice = 0;
			while(choice < 1 || choice > 4) {
			System.out.println("Please select from the following choices: ");
			System.out.println(" 1. Guess a random color from 16 colors (3 rounds)"
								+ "\n 2. Guess a random color from 10 colors (3 rounds)"
								+ "\n 3. Guess a random color from 5 colors (3 rounds)"
								+ "\n 4. Exit game");
			if(keyboard.hasNextInt()) choice = keyboard.nextInt();
			else {
				System.out.println("Invalid input!");
				keyboard.nextLine();
			}
			}
			
			int numColors = 16;
			if(choice == 1) numColors = 16;
			else if(choice == 2) numColors = 10;
			else if(choice == 3) numColors = 5;
			else continue;
			
			
			keyboard.nextLine(); //Getting the newline character out of the buffer.
			
			System.out.println("Enter the filename for \'colors.txt\': ");
			String fileName = keyboard.nextLine();
			File inputFile = new File(fileName);
			Scanner input = new Scanner(inputFile);
			//lines 62-106 handle the file input
			String COLOR_1 = null, COLOR_2 = null, COLOR_3 = null, COLOR_4 = null,
				   COLOR_5 = null, COLOR_6 = null, COLOR_7 = null, COLOR_8 = null,
				   COLOR_9 = null, COLOR_10 = null, COLOR_11 = null, COLOR_12 = null,
				   COLOR_13 = null, COLOR_14 = null, COLOR_15 = null, COLOR_16 = null;
			
			System.out.println("Colors available from " + fileName + ": ");
			
			for(int i = 0; i < numColors && input.hasNext(); i++) {
				String line = input.nextLine();
				System.out.println(line);
				switch(i) {
				case 0: COLOR_1 = new String(line);
					break;
				case 1: COLOR_2 = new String(line);
					break;
				case 2: COLOR_3 = new String(line);		
					break;
				case 3: COLOR_4 = new String(line);
					break;
				case 4: COLOR_5 = new String(line);
					break;
				case 5: COLOR_6 = new String(line);
					break;
				case 6: COLOR_7 = new String(line);
					break;
				case 7: COLOR_8 = new String(line);
					break;
				case 8: COLOR_9 = new String(line);
					break;
				case 9: COLOR_10 = new String(line);
					break;
				case 10: COLOR_11 = new String(line);
					break;
				case 11: COLOR_12 = new String(line);
					break;
				case 12: COLOR_13 = new String(line);
					break;
				case 13: COLOR_14= new String(line);
					break;
				case 14: COLOR_15 = new String(line);
					break;
				case 15: COLOR_16 = new String(line);
					break;
				}
			}
			
			//lines 112-147 generate the computer's secret color.
			Random rand = new Random(); 
			String guess, secretColor = null;
			int wins = 0, colorSwitch; 
			for(int i = 0; i < rounds; i++) {
				colorSwitch = rand.nextInt(numColors);
				switch(colorSwitch) {
				case 0: secretColor = new String(COLOR_1);
					break;
				case 1: secretColor = new String(COLOR_2);
					break;
				case 2: secretColor = new String(COLOR_3);	
					break;
				case 3: secretColor = new String(COLOR_4);
					break;
				case 4: secretColor = new String(COLOR_5);
					break;
				case 5: secretColor = new String(COLOR_6);
					break;
				case 6: secretColor = new String(COLOR_7);
					break;
				case 7: secretColor = new String(COLOR_8);
					break;
				case 8: secretColor = new String(COLOR_9);
					break;
				case 9: secretColor = new String(COLOR_10);
					break;
				case 10: secretColor = new String(COLOR_11);
					break;
				case 11: secretColor = new String(COLOR_12);
					break;
				case 12: secretColor = new String(COLOR_13);
					break;
				case 13: secretColor = new String(COLOR_14);
					break;
				case 14: secretColor = new String(COLOR_15);
					break;
				case 15: secretColor = new String(COLOR_16);
					break;
				}
				System.out.println("=========================");
				System.out.println("Round " + (i+1) + "\n");
				System.out.println("I'm thinking of a color....");
				System.out.println("Take a guess! ");
				guess = keyboard.nextLine();
				
				System.out.println("I was thinking of " + secretColor +". You guessed " + guess + ".\n");
				
				if(guess.equalsIgnoreCase(secretColor)) {
					System.out.println("Nice job!");
					wins++;
				}
				
			}
			
			System.out.println("You guessed " + wins + " out of " + rounds + " correctly.\n");
			input.close();
		}
		keyboard.close();
		System.exit(0);
		outFile.close();
			
	}
}