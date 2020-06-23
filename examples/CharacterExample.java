import java.io.FileNotFoundException;
import classes.Play;
import classes.Character;

public class CharacterExample{
	public static void main(String[] args) throws FileNotFoundException{
		Play play = new Play("Hamlet", "C:\\Users\\summe\\eclipse-workspace\\EquitableLineDistribution\\plays\\hamlet.txt");
		Character hamlet = play.getCharacter("HAMLET");
		
		//Prints out all of Hamlet's lines:
		System.out.println("HAMLET's LINES: \n" + play.getCharacterLines("HAMLET"));
		
		//Deals with how often a character speaks, length of lines, number of words, etc.
		System.out.println("Hamlet speaks a total of " + hamlet.getNumWords() + " words.");
		System.out.println("Hamlet has " + hamlet.getLineNum() + " total speeches.");
		System.out.println("Each speech Hamlet has is aabout " + (int)hamlet.getAvgLineLength() + " words long");
		
		//Shows who Hamlet talks to
		System.out.println("Hamlet talks to  " + hamlet.getNumTalkedTo() + " people total");
		System.out.println("Hamlet talks to: " + hamlet.getTalksTo());
		System.out.println("Hamlet doesn't talk to: " + hamlet.getNotTalksTo());
		
	}
}