import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Test{
	
	
	public static void main(String[] args) throws FileNotFoundException{
		//C:\Users\summe\eclipse-workspace\Shakespeare\src\txt
		Play p = new Play("Hamlet", "C:\\Users\\summe\\eclipse-workspace\\Shakespeare\\src\\txt\\Ham4-5.txt");
		ArrayList<Character> characters = p.getCharacters();
		ArrayList<Character> minorCharacters = Stats.getMinorCharacters(p);
		ArrayList<Character> majorCharacters = Stats.getMajorCharacters(p);
		
		
		characters.remove(Utils.indexOf(characters, "HAMLET"));
		System.out.println(Stats.linesPerPerson(characters, 6));
		
//		
//		
//		Role role1 = new Role("Horatio");
//		System.out.println(p.getCharacter("HORATIO").getTalksTo());
//		role1.addChar(p.getCharacter("HORATIO"));
//		role1.addChar(p.getCharacter("LORD"));
//		role1.addChar(p.getCharacter("OPHELIA"));
//		role1.addChar(p.getCharacter("DOCTOR"));
//		System.out.println(role1.contradicts());
//		System.out.println(role1.countLines());
		
		
	}
}