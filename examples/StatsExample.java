import java.io.FileNotFoundException;
import classes.Play;
import classes.Stats;

public class StatsExample{
	public static void main(String args[]) throws FileNotFoundException{
		Play play = new Play("Hamlet", "C:\\Users\\summe\\eclipse-workspace\\EquitableLineDistribution\\plays\\hamlet.txt");
		
		System.out.println("The average character speaks " + Stats.avgLines(play) + " lines total, with a standard deviation of " +
							Stats.stanDev(play));
		System.out.println("There are " + Stats.totalLines(play) + " in the play");
		System.out.println("There are " + Stats.numCharacters(play) + " characters\n");
		
		System.out.println("There are " + Stats.numMajorCharacters(play) + " major characters. " + 
							"They are: " +  Stats.getMajorCharacters(play));
		System.out.println("There are " + Stats.numMinorCharacters(play) + " minor characters. " + 
							"They are: " +  Stats.getMinorCharacters(play));
		
	}
}