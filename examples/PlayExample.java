import java.io.FileNotFoundException;
import classes.Play;

public class PlayExample{
	public static void main(String args[]) throws FileNotFoundException{
		Play play = new Play("Hamlet", "C:\\Users\\summe\\eclipse-workspace\\EquitableLineDistribution\\plays\\hamlet.txt");
		
		System.out.println("The play " + play.getTitle() + "'s cast is: " + play.getCast());
		System.out.println("The play's script is: " + play.getScript());
		System.out.println("Here is the character HAMLET: " + play.getCharacterIndex("HAMLET"));
	}
}