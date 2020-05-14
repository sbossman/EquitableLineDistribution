import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.RandomAccessFile;
import java.math.*;

public class Stats{
	public static double avgLines(Play play) {
		int lineTotal = 0;
		for(int i = 0; i < play.getCharacters().size(); i++) {
			if(!play.getCharacters().get(i).getName().equals("ACT")) {
				lineTotal += play.getCharacters().get(i).getLineNum();
			}
		}
		return lineTotal/((double)play.getCharacters().size()-1);
	}
	public static double stanDev(Play play) {
		double avg = avgLines(play);
		double devSum = 0;
		for(int i = 0; i < play.getCharacters().size(); i++) {
			if(!play.getCharacters().get(i).getName().equals("ACT")) {
				devSum += Math.abs(play.getCharacters().get(i).getLineNum()-avg);
			}
		}
		
		return devSum/((double)play.getCharacters().size()-1);
	}
	
	public static ArrayList<Character> getMajorCharacters(Play play){
		ArrayList<Character> arr = new ArrayList<Character>();
		for(int i = 0; i < play.getCharacters().size(); i++) {
			if(play.getCharacters().get(i).getLineNum() > avgLines(play)) {
				arr.add(play.getCharacters().get(i));
			}
		}
		return arr;
	}
	public static ArrayList<Character> getMinorCharacters(Play play){
		ArrayList<Character> arr = new ArrayList<Character>();
		for(int i = 0; i < play.getCharacters().size(); i++) {
			if(play.getCharacters().get(i).getLineNum() < avgLines(play)) {
				arr.add(play.getCharacters().get(i));
			}
		}
		return arr;
	}
	
	public static int numCharacters(Play play) {
		return play.getCharacters().size();
	}
	public static int numMinorCharacters(Play play) {
		return getMinorCharacters(play).size();
	}
	public static int numMajorCharacters(Play play) {
		return getMajorCharacters(play).size();
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		//C:\Users\summe\eclipse-workspace\Shakespeare\src\txt
		Play p = new Play("Hamlet", "C:\\Users\\summe\\eclipse-workspace\\Shakespeare\\src\\txt\\Ham4-5.txt");
		
		System.out.println("AVG LINES: " + avgLines(p));
		for(Character c: getMinorCharacters(p)) {
			System.out.println(c);
		}
	}
}