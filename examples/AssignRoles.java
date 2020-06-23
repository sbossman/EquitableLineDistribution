import java.io.FileNotFoundException;
import java.util.Scanner;

import classes.AssignCharacters;
import classes.Play;
import classes.Role;

import java.util.ArrayList;

public class AssignRoles{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Title of play: ");
		String title = keyboard.nextLine();
		System.out.println("Location of play: ");
		String loc = keyboard.nextLine();
		System.out.println("\nNumber of readers: ");
		int readers = keyboard.nextInt();
		System.out.println("\nAssign by (words or lines): ");
		String assignBy = keyboard.nextLine();
		
		Play play = new Play(title, loc);
		
		
		AssignCharacters characterAssignments = new AssignCharacters(play, readers);
		characterAssignments.assignRoles(false, assignBy);
		ArrayList<Role> roles = characterAssignments.getAssignments();
		
		
		System.out.println("Lines: ");
		for(Role r: roles) {
			System.out.println(r);
		}
		
		keyboard.close();
	}
}