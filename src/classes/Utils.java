package classes;
import java.util.ArrayList;

public class Utils{
	public static boolean isUpperAndSpace(char c) {
		char[] a = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
		            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		for(char t: a) {
			if(t == c)
				return true;
		}
		return false;
	}
	public static boolean isUpper(char c) {
		char[] a = {'_', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
		            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		for(char t: a) {
			if(t == c)
				return true;
		}
		return false;
	}
	
	public static boolean contains(ArrayList<Character> arr, Character c) {
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).equalsC(c)) {
				return true;
			}
		}
		return false;
	}
	
	public static int indexOf(ArrayList<Character> arr, String s) {
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).getName().equals(s)) {
				return i;
			}
		}
		return -1;
	}
}