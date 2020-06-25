import java.io.FileNotFoundException;

import classes.AssignCharacters;
import classes.Play;
import classes.Role;

import java.util.ArrayList;

public class RolesExample{
	public static void main(String args[]) throws FileNotFoundException{
		String title = "Hamlet";
		String loc = "C:\\Users\\summe\\eclipse-workspace\\EquitableLineDistribution\\play\\hamlet.txt";
		int readers = 7;
		String assignBy = "words"; // Words or lines
		
		Play play = new Play(title, loc);
		
		
		AssignCharacters characterAssignments = new AssignCharacters(play, readers);
		characterAssignments.assignRoles(false, assignBy);
		ArrayList<Role> roles = characterAssignments.getAssignments();
		Role role = roles.get(0);
		
		System.out.println(role.getName() + " reads for: " + role.getCharacters());
		System.out.println("Their main character is: " + role.getPrincipalCharacter());
		System.out.println("They speak " + role.countLines() + " lines and " + role.countWords() + " words.");
		if(role.contradicts()) {
			System.out.println("They do talk to themselves once");
		} else {
			System.out.println("They don't talk to themself");
		}
	}
}