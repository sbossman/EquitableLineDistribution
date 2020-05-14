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
		for(Character c: characters) {
			System.out.print(c + ": ");
			System.out.println(c.getTalksTo());
		}
	}
}