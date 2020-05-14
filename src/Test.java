import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.RandomAccessFile;

public class Test{
	
	
	public static void main(String[] args) throws FileNotFoundException{
		//C:\Users\summe\eclipse-workspace\Shakespeare\src\txt
		Play p = new Play("Hamlet", "C:\\Users\\summe\\eclipse-workspace\\Shakespeare\\src\\txt\\Ham4-5.txt");
		ArrayList<Character> characters = p.getCharacters();
		ArrayList<Character> minorCharacters = Stats.getMinorCharacters(p);
		
		
		
		Role role1 = new Role("Horatio");
		System.out.println(p.getCharacter("HORATIO").getTalksTo());
		role1.addChar(p.getCharacter("HORATIO"));
		role1.addChar(p.getCharacter("LORD"));
		role1.addChar(p.getCharacter("OPHELIA"));
		role1.addChar(p.getCharacter("DOCTOR"));
		System.out.println(role1.contradicts());
		System.out.println(role1.countLines());
		
		
//		for(Character c: characters) {
//			System.out.print(c + ": ");
//			System.out.println(c.getTalksTo());
//		}
//		System.out.println(p.getCharacter("LORD").getTalksTo());
//		System.out.println(p.getCharacter("GUILDENSTERN").getTalksTo());
//		System.out.println(p.getCharacter("LORD").talksTo(p.getCharacter("GUILDENSTERN")));
	}
}