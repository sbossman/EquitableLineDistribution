import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Reading3Ham{
	public static void main(String[] args) throws FileNotFoundException{
		//C:\Users\summe\eclipse-workspace\Shakespeare\src\txt
		Play p = new Play("Hamlet", "C:\\Users\\summe\\eclipse-workspace\\Shakespeare\\src\\txt\\Ham4-5.txt");
		ArrayList<Character> untakenCharacters = p.getCharacters();
		//System.out.println(p.getCharacters());
		
		Role r1 = new Role("R1");
		r1.addChar(p.getCharacter("HAMLET"));
		
		Role r2 = new Role("R2");
		r2.addChar(p.getCharacter("KING"));
		r2.addChar(p.getCharacter("CAPTAIN"));
		r2.addChar(p.getCharacter("AMBASSADOR"));
		r2.addChar(p.getCharacter("LORD"));
		r2.addChar(p.getCharacter("SAILOR"));
		
		Role r3 = new Role("R3");
		r3.addChar(p.getCharacter("HORATIO"));
		r3.addChar(p.getCharacter("ROSENCRANTZ"));
		r3.addChar(p.getCharacter("OPHELIA"));
		r3.addChar(p.getCharacter("GUILDENSTERN"));
		r3.addChar(p.getCharacter("DOCTOR"));
		r3.addChar(p.getCharacter("MESSENGER"));
		
		Role r4 = new Role("R4");
		r4.addChar(p.getCharacter("LAERTES"));
		r4.addChar(p.getCharacter("OTHER"));
		r4.addChar(p.getCharacter("FORTINBRAS"));
		r4.addChar(p.getCharacter("GENTLEMAN"));
		r4.addChar(p.getCharacter("GENTLEMEN"));
		
		Role r5 = new Role("R5");
		r5.addChar(p.getCharacter("QUEEN"));
		r5.addChar(p.getCharacter("GRAVEDIGGER"));
		r5.addChar(p.getCharacter("OSRIC"));
		
		
		ArrayList<Role> roles = new ArrayList<Role>(5);
		roles.add(r1);
		roles.add(r2);
		roles.add(r3);
		roles.add(r4);
		roles.add(r5);
		
		for(int r = 0; r < roles.size(); r++) {
			for(int c = 0; c < roles.get(r).getCharacters().size(); c++) {
				int i = 0;
				while(i < untakenCharacters.size()) {
					if(untakenCharacters.get(i).equalsC(roles.get(r).getCharacters().get(c))) {
						untakenCharacters.remove(i);
					} else {
						i++;
					}
				}
			}
		}
		System.out.println("!!!!!!" + untakenCharacters);
		
		
		
		System.out.println("R1 Line Num: " + r1.countLines() + "  Contradicts: " + r1.contradicts());
		System.out.println("R2 Line Num: " + r2.countLines() + "  Contradicts: " + r2.contradicts());
		System.out.println("R3 Line Num: " + r3.countLines() + "  Contradicts: " + r3.contradicts());
		System.out.println("R4 Line Num: " + r4.countLines() + "  Contradicts: " + r4.contradicts());
		System.out.println("R5 Line Num: " + r5.countLines() + "  Contradicts: " + r5.contradicts());
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
		System.out.println(r5);
		
		
	}
}