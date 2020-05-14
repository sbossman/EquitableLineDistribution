import java.util.List;
import java.util.ArrayList;

public class Role{
	private ArrayList<Character> characters;
	private String name;
	private int lines;
	
	public Role(ArrayList<Character> arr) {
		characters = arr;
		name = "Player1";
	}
	public Role(String name, ArrayList<Character> arr) {
		characters = arr;
		this.name = name;
	}
	public Role(String name) {
		characters = new ArrayList<Character>();
		this.name = name;
	}
	
	public boolean contradicts() {
		for(Character c: characters) {
			for(Character d: characters) {
				if(c.talksTo(d)) {
					return true;
				}
			}
		}
		return false;
	}
	public void addChar(Character c) {
		characters.add(c);
		countLines();
	}
	public int countLines() {
		int ln = 0;
		for(int i = 0; i < characters.size(); i++) {
			ln += characters.get(i).getLineNum();
		}
		lines = ln;
		return ln;
	}
	
	public String toString() {
		return name + characters;
	}
	public ArrayList<Character> getCharacters(){
		return characters;
	}
}