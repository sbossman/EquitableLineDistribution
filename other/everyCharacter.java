import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;

import classes.Play;
import classes.Stats;
import classes.Character;


public class everyCharacter {
	public static void main(String args[]) throws Exception{
//      //Instantiating the CSVWriter class
      FileWriter writer = new FileWriter("C:\\Users\\summe\\eclipse-workspace\\EquitableLineDistribution\\other\\characters.csv");
      String PLAY_LOCATION = "C:\\Users\\summe\\eclipse-workspace\\EquitableLineDistribution\\play\\";
      File[] files = new File(PLAY_LOCATION).listFiles();
      
      
      String header = "id, name, play, number of lines, num words, num talked to, avg line length\n";
      writer.write(header);
      
      int id = 0;
      for (File file : files) {
	        if (file.isDirectory() || file.getName().equals(".gitkeep")) {
	            System.out.println("Directory: " + file.getName());
	        } else {
	            System.out.println("File: " + file.getName());
	            String title = file.getName().substring(0, file.getName().length()-4);
	            Play play = new Play(title, PLAY_LOCATION + file.getName());
	            for(Character c: play.getCharacters()) {
	            	String name = c.getName();
	            	int lines = c.getLineNum();
	            	int words = c.getNumWords();
	            	int talkedTo = c.getNumTalkedTo();
	            	int avgLineLength = (int)(c.getAvgLineLength()+0.5);
	            	
	            	
	            	String row = id + ", " + name + ", " + title + ", " + lines + ", " + words + ", " + talkedTo + ", " + avgLineLength + "\n";
		            writer.write(row);
		            id++;
	            }	            
	            
	        }
	    }

      writer.flush();
      System.out.println("Data entered");
      writer.close();
   }
}