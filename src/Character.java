import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Character{
	String name;
	ArrayList<String> lines;
	int lineNum;
	ArrayList<Character> talksTo = new ArrayList<Character>();
	ArrayList<Character> notTalksTo = new ArrayList<Character>();
	
	public Character(String name) {
		this.name = name;
		lineNum = 0;
		lines = new ArrayList<String>();
	}
	public Character(String name, String play) {
		this.name = name;
		lines = new ArrayList<String>();
		setLineNum(play);
		setLines(play);
		
	}
	public Character(String name, Play play) {
		this.name = name;
		lines = new ArrayList<String>();
		setLineNum(play.getScript());
		setLines(play.getScript());
	}
	
	//Helper functions
	private void setLineNum(String play) {
		int i = 0;
	    while(i < play.length()) {
	    	if(Utils.isUpper(play.charAt(i)) && Utils.isUpper(play.charAt(i+1)) && Utils.isUpper(play.charAt(i+2))) {
	    		int j = i;
	    		while(Utils.isUpper(play.charAt(j))) {
	    			j++;
	    		}
	    		if(play.substring(i, j).trim().equals(name)) {
	    			lineNum++;
	    		}
	    		i = j;
	    	} else {
	    		i++;
	    	}
	    }
	}
	private void setLines(String play) {
		int i = 0;
		while(i < play.length() - name.length()) {
			if(play.substring(i, i + name.length()).equals(name.toUpperCase())){
				String line = "";
				i += name.length();
				while(!(Utils.isUpper(play.charAt(i)) && Utils.isUpper(play.charAt(i+1))) && i < play.length() - name.length()) {
					line += play.charAt(i);
					i++;
				}
				lines.add(line);
			} else {
				i++;
			}
		}
	}
	public void setTalksTo(Play play) {
		/*
		if(play.characters.get(0).getName().equals(name)) {
			talksTo.add(play.characters.get(play.getCharacterIndex(name)));
		}
		*/
		for(int i = 1; i < play.lineOrder.size() - 1; i++) {
			if(play.lineOrder.get(i).equals(name)) {
				talksTo.add(play.getCharacter(play.lineOrder.get(i-1)));
				talksTo.add(play.getCharacter(play.lineOrder.get(i+1)));
				
				int a = 0;
				while(a < talksTo.size() - 1) {
					int b = a + 1;
					while(b < talksTo.size()) {
						if(talksTo.get(a).equalsC(talksTo.get(b))) {
							talksTo.remove(b);
						} else {
							b++;
						}
					}
					a++;
				}
			}
		}
	}
	public void setNotTalksTo(Play play) {
		for(int i = 0; i < play.characters.size(); i++) {
			boolean flag = false;
			for(int j = 0; j < talksTo.size(); j++) {
				if(play.characters.get(i).equalsC(talksTo.get(j))) {
					flag = true;
				}
			}
			if(flag == false) {
				notTalksTo.add(play.characters.get(i));
			}
		}
	}
	
	public String toString() {
		return name + ": " + lineNum;
	}
	public String getName() {
		return name;
	}
	public int getLineNum() {
		return lineNum;
	}
	public ArrayList<String> getLines() {
		return lines;
	}
	public ArrayList<Character> getTalksTo(){
		return talksTo;
	}
	public ArrayList<Character> getNotTalksTo(){
		return notTalksTo;
	}
	
	public boolean equalsC(Character other) {
		return other.getName().equals(this.getName());
	}
	
	public boolean talksTo(Character other) {
		if(other.getTalksTo().contains(this)) {
			return true;
		}
		if(this.getTalksTo().contains(other)) {
			return true;
		}
		
		return false;
	}
	public int getNumTalkedTo() {
		return talksTo.size();
	}
}