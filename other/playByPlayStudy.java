import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;

import classes.Play;
import classes.Stats;


public class playByPlayStudy {
	public static void main(String args[]) throws Exception{
//      //Instantiating the CSVWriter class
      FileWriter writer = new FileWriter("C:\\Users\\summe\\eclipse-workspace\\EquitableLineDistribution\\other\\plays.csv");
      String PLAY_LOCATION = "C:\\Users\\summe\\eclipse-workspace\\EquitableLineDistribution\\play\\";
      File[] files = new File(PLAY_LOCATION).listFiles();
      
      
      String header = "id, title, number of lines, number of characters, avg lines, stan dev of line num \n";
      writer.write(header);
      
      int id = 0;
      for (File file : files) {
	        if (file.isDirectory() || file.getName().equals(".gitkeep")) {
	            System.out.println("Directory: " + file.getName());
	        } else {
	            System.out.println("File: " + file.getName());
	            String title = file.getName().substring(0, file.getName().length()-4);
	            Play play = new Play(title, PLAY_LOCATION + file.getName());
	            int lineNum = Stats.totalLines(play);
	            int charNum = Stats.numCharacters(play);
	            int avgLines = (int) (Stats.avgLines(play) + 0.5);
	            double stanDev = Stats.stanDev(play);
	            
	            String row = id + ", " + title + ", " + lineNum + ", " + charNum + ", " + avgLines + ", " + stanDev + "\n";
	            writer.write(row);
	            id++;
	        }
	    }

      writer.flush();
      System.out.println("Data entered");
      writer.close();
   }
}