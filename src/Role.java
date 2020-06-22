import java.util.ArrayList;

public class Role{
	private ArrayList<Character> characters;
	private String name;
	private int lines;
	private int principalCharacter;
	
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
	

	public void addChar(Character c) {
		characters.add(c);
		countLines();
		setPrincipalChar();
	}
	public void removeChar(int i) {
		characters.remove(i);
		countLines();
	}
	public void removeChar(Character c) {
		for(int i = 0; i < characters.size(); i++) {
			if(c.equalsC(characters.get(i))) {
				characters.remove(i);
				countLines();
				return;
			}
		}
	}
	public int countLines() {
		int ln = 0;
		for(int i = 0; i < characters.size(); i++) {
			ln += characters.get(i).getLineNum();
		}
		lines = ln;
		return ln;
	}
	public void setPrincipalChar() {
		int m = 0;
		int mLines = characters.get(0).getLineNum();
		for(int i = 0; i < characters.size(); i++) {
			if(characters.get(i).getLineNum() > mLines) {
				m = i;
				mLines = characters.get(i).getLineNum();
			}
		}
		principalCharacter = m;
	}
	
	public boolean contradicts() {
		if(contradictions() == 0) {
			return false;
		} else {
			return true;
		}
	}
	public int contradictions() {
		int i = 0;
		for(Character c: characters) {
			for(Character d: characters) {
				if(c.talksTo(d)) {
					i++;
				}
			}
		}
		return i;
	}
	public boolean canAdd(Character newChar) {
		ArrayList<Character> list = new ArrayList<Character>();
		for(Character c: characters) {
			list.add(c);
		}
		list.add(newChar);		
		int i = 0;
		for(Character c: list) {
			for(Character d: list) {
				if(c.talksTo(d)) {
					return false;
				}
			}
		}
		return true;
	}
	public int mostContradictory() {
		if(!contradicts()) {
			return -1;
		}
		int[] numContradictions = new int[characters.size()];
		int i = 0;
		for(Character c: characters) {
			for(Character d: characters) {
				if(c.talksTo(d)) {
					numContradictions[i]++;
				}
			}
			i++;
		}
		
		int mostContra = Integer.MIN_VALUE;
		int mostContraInd = 0;
		for(int j = 0; j < numContradictions.length; j++) {
			if(numContradictions[j] > mostContra && j != principalCharacter) {
				mostContraInd = j;
				mostContra = numContradictions[j];
			}
		}
		
		
		return mostContraInd;
	}
	
	public String toString() {
		return name + characters;
	}
	public ArrayList<Character> getCharacters(){
		return characters;
	}
	public String getName() {
		return name;
	}
	public int getPrincipalCharacter() {
		return principalCharacter;
	}
	public int getPrincipalCharacterInd() {
		return characters.indexOf(principalCharacter);
	}
}