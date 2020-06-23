package classes;
import java.util.ArrayList;

public class Stats{
	public static int totalLines(Play play) {
		int lineTotal = 0;
		for(int i = 0; i < play.getCharacters().size(); i++) {
			if(!play.getCharacters().get(i).getName().equals("ACT")) {
				lineTotal += play.getCharacters().get(i).getLineNum();
			}
		}
		return lineTotal;
	}
	public static int linesPerPerson(Play play, int readers) {
		return (int)((totalLines(play)/(double) readers) + 0.5);
	}
	public static double linesPerPerson(ArrayList<Character> characters, int readers) {
		int total = 0;
		for(Character c: characters) {
			total+= c.getLineNum();
		}
		return ((double)total)/readers;
	}
	public static double avgLines(Play play) {
		return totalLines(play)/((double)play.getCharacters().size()-1);
	}
	public static double stanDev(Play play) {
		double avg = avgLines(play);
		double devSum = 0;
		for(int i = 0; i < play.getCharacters().size(); i++) {
			if(!play.getCharacters().get(i).getName().equals("ACT")) {
				devSum += Math.abs(play.getCharacters().get(i).getLineNum()-avg);
			}
		}
		
		return devSum/((double)play.getCharacters().size());
	}
	
	public static double stanDevRoles(Play play, ArrayList<Role> roles) {
		double avg = linesPerPerson(play, roles.size());
		double devSum = 0;
		
		for(Role r: roles) {
			devSum += Math.abs(r.countLines()  - avg);
		}
		
		return devSum/((double)roles.size());
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

}