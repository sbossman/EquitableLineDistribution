import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.RandomAccessFile;

public class Play{
	private ArrayList<String> cast = new ArrayList<String>();
	public ArrayList<String> lineOrder = new ArrayList<String>();
	public ArrayList<Character> characters = new ArrayList<Character>();
	private String play;
	private String title;
	
	public Play(String title, String location) throws FileNotFoundException{
		this.title = title;
		
		//Sets play to the script
		File p = new File(location);
		Scanner sc = new Scanner(p); 
	    while (sc.hasNextLine()) {
	    	play += sc.nextLine() + "\n";
	    }
	    sc.close();
	    
	    
	    setLineOrder();
	    setCast();
	    setCharacters();
	    for(int i = 0; i < characters.size(); i++) {
	    	characters.get(i).setTalksTo(this);
	    	characters.get(i).setNotTalksTo(this);
	    }
	}
	
	private void setLineOrder() {
		int i = 0;
	    while(i < play.length()) {
	    	if(Utils.isUpper(play.charAt(i)) && Utils.isUpper(play.charAt(i+1)) && Utils.isUpper(play.charAt(i+2))) {
	    		int j = i;
	    		while(Utils.isUpper(play.charAt(j))) {
	    			j++;
	    		}
	    		String full = play.substring(i, j);
	    		lineOrder.add(full.trim());
	    		i = j;
	    	} else {
	    		i++;
	    	}
	    }
	}
	private void setCast() {
		for(int i = 0; i < lineOrder.size(); i++) {
			boolean dupFound = false;
			for(String c: cast) {
				if(lineOrder.get(i).equals(c)) {
					dupFound = true;
				}
			}
			if(!dupFound) {
				cast.add(lineOrder.get(i));
			}
		}
	}
	private void setCharacters() {
		for(String name: cast) {
			characters.add(new Character(name, this));
		}
	}
	
	//The accessor methods
	public String toString() {
		return title;
	}
	public String getScript() {
		return play;
	}
	public ArrayList<String> getLineOrder(){
		return lineOrder;
	}
	public ArrayList<String> getCast(){
		return cast;
	}
	public String getTitle() {
		return title;
	}
	public ArrayList<Character> getCharacters() {
		return characters;
	}
	public Character getCharacter(String name) {
		for(int i = 0; i < characters.size(); i++) {
			if(characters.get(i).getName().equals(name))
				return characters.get(i);
		}
		return null;
	}
	public int getCharacterIndex(String name) {
		for(int i = 0; i < characters.size(); i++) {
			if(characters.get(i).getName().equals(name))
				return i;
		}
		return -1;
	}
	public ArrayList<String> getCharacterLines(String character){
		character = character.toUpperCase();
		for(int i = 0; i < characters.size(); i++) {
			if(characters.get(i).getName().equals(character)) {
				System.out.println("Character found!");
				System.out.println(characters.get(i));
				return characters.get(i).getLines();
			}
		}
		return new ArrayList<String>();
	}
}