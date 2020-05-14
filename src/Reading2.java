import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Reading2{
	public static void main(String[] args) throws FileNotFoundException{
		//C:\Users\summe\eclipse-workspace\Shakespeare\src\txt
		Play p = new Play("Hamlet", "C:\\Users\\summe\\eclipse-workspace\\Shakespeare\\src\\txt\\Ham2-3.txt");
		//System.out.println(p.getCharacters());
		
		Role cc = new Role("Clotten's Clothes");
		cc.addChar(p.getCharacter("KING"));
		cc.addChar(p.getCharacter("PLAYER_KING"));
		cc.addChar(p.getCharacter("GHOST"));
		cc.addChar(p.getCharacter("REYNALDO"));
		
		Role mk = new Role("Mercutio/Kip");
		mk.addChar(p.getCharacter("OPHELIA"));
		mk.addChar(p.getCharacter("GUILDENSTERN"));
		mk.addChar(p.getCharacter("FIRST_PLAYER"));
		mk.addChar(p.getCharacter("QUEEN"));
		
		Role ho = new Role("HermioneOwl");
		ho.addChar(p.getCharacter("HAMLET"));
		ho.addChar(p.getCharacter("VOLTEMAND"));
		//ho.addChar(p.getCharacter("VOLTIMAND"));
		
		Role hr = new Role("Hoe-Ratio");
		hr.addChar(p.getCharacter("HORATIO"));
		hr.addChar(p.getCharacter("POLONIUS"));
		hr.addChar(p.getCharacter("ROSENCRANTZ"));
		hr.addChar(p.getCharacter("PLAYER_QUEEN"));
		
		System.out.println("CC Line Num: " + cc.countLines() + "  Contradicts: " + cc.contradicts());
		System.out.println("MK Line Num: " + mk.countLines() + "  Contradicts: " + mk.contradicts());
		System.out.println("HO Line Num: " + ho.countLines() + "  Contradicts: " + ho.contradicts());
		System.out.println("HR Line Num: " + hr.countLines() + "  Contradicts: " + hr.contradicts());
		
		
	}
}