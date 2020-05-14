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
}