import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AssignCharactersMe{
	ArrayList<Role> roles;
	Play play;
	
	public AssignCharactersMe(String loc, int numRoles) throws FileNotFoundException{
		play = new Play(loc);
		roles = new ArrayList<Role>(numRoles);
		for(int i = 0; i < numRoles; i++) {
			roles.add(new Role("r" + i));
		}
	}
	public AssignCharactersMe(String loc, ArrayList<String> names) throws FileNotFoundException{
		play = new Play(loc);
		roles = new ArrayList<Role>(names.size());
		for(int i = 0; i < names.size(); i++) {
			roles.add(new Role(names.get(i)));
		}
	}
	public AssignCharactersMe(Play p, int numRoles) {
		play = p;
		roles = new ArrayList<Role>(numRoles);
		for(int i = 0; i < numRoles; i++) {
			roles.add(new Role("r" + i));
		}
	}	
	public AssignCharactersMe(Play p, ArrayList<String> names) {
		play = p;
		roles = new ArrayList<Role>(names.size());
		for(int i = 0; i < names.size(); i++) {
			roles.add(new Role(names.get(i)));
		}
	}
	
	
	public ArrayList<Role> assignRoles() {
		ArrayList<Character> untaken = play.getCharacters();
		untaken.remove(0);
		untaken = orderCharacters(untaken);
		System.out.println(untaken);
		ArrayList<Role> temp = new ArrayList<Role>(roles.size()-1);
		
		for(int i = 0; i < roles.size()-1; i++) {
			temp.add(roles.get(i));
		}
		
		
		while(untaken.size() > 0) {
			//int ci = nextCharacter(untaken);
			Character c = untaken.get(0);
			
			Role r = roles.get(whichAssignTo(temp, temp, c));
			r.addChar(play.getCharacter(c.getName()));
			untaken.remove(0);
		}
		
		boolean noContra = false;
		while(!noContra) {
			 noContra = true;
			 for(Role r: roles) {
				 if(r.contradicts()) {
					 noContra = false;
				 }
			 }
			 if(!noContra) {
				 int charRemoveI = roles.get(mostContradictoryRole()).mostContradictory();
				 Character charRemove = roles.get(mostContradictoryRole()).getCharacters().get(roles.get(mostContradictoryRole()).mostContradictory());
				 if(roles.get(roles.size() - 1).canAdd(charRemove)) {
					 System.out.println(roles.get(mostContradictoryRole()));
					 System.out.println(roles.get(mostContradictoryRole()).contradictions());
					 System.out.println(charRemove);
					 roles.get(roles.size() - 1).addChar(charRemove);
					 roles.get(mostContradictoryRole()).removeChar(charRemoveI);
				 } else {
					 break;
//					 for(int i = 0; i < roles.size(); i++) {
//						 System.out.println(roles.get(mostContradictoryRole()));
//						 System.out.println(roles.get(mostContradictoryRole()).contradictions());
//						 System.out.println(charRemove);
//						 roles.get(i).addChar(charRemove);
//						 roles.get(mostContradictoryRole()).removeChar(charRemove);
//					 }
				 }
				 
			 }
			 noContra = true;
			 for(Role r: roles) {
				 if(r.contradicts()) {
					 noContra = false;
				 }
			 }
			
		}
		
		
		for(Role r: roles) {
			System.out.println(r.getName() + " Line Num: " + r.countLines() + " Contradicts: " + r.contradictions());
			System.out.println(r);
			System.out.println();
		}
		System.out.println(temp);
		System.out.println(roles);
		System.out.println("!!!!!!" + untaken);
		return roles;
	}
	
	//Returns the index of the role with the least lines
	public static int hasLeastLines(ArrayList<Role> roles) {
		int least = Integer.MAX_VALUE;
		int ind = 0;
		for(int i = 0; i < roles.size(); i++) {
			if(roles.get(i).countLines() < least) {
				least = roles.get(i).countLines();
				ind = i;
			}
		}
		return ind;
	}
	//Returns the index of the role with the least contradictions
	public static int hasLeastContradictions(ArrayList<Role> roles) {
		int least = Integer.MAX_VALUE;
		int leastInd = 0;
		for(int i = 0; i < roles.size(); i++) {
			if(roles.get(i).contradictions() < least) {
				leastInd = i;
				least = roles.get(i).contradictions();
			}
		}
		return leastInd;
	}
	public static int whichAssignTo(ArrayList<Role> origRoles, ArrayList<Role> roles, Character c) {
		
		if(roles.size() == 1) {
			//System.out.println(roles.get(hasLeastLines(origRoles)).getName() + " has the least lines");
			return hasLeastLines(origRoles);		
		}
		
		//int least = hasLeastLines(roles);
		int leastInd = hasLeastLines(roles);
		
		
		if(roles.get(leastInd).canAdd(c)) {
			//System.out.println("We can add " + c + " to " + roles.get(leastInd).getName());
			return leastInd;
		} else {
			ArrayList<Role> r2 = new ArrayList<Role>();
			for(int i = 0; i < roles.size(); i++) {
				r2.add(roles.get(i));
			}
			r2.remove(leastInd);
			return whichAssignTo(origRoles, r2, c);
		}
	}
	private int mostContradictoryRole() {
		int contra = Integer.MIN_VALUE;
		int contraInd = 0;
		for(int i = 0; i < roles.size(); i++) {
			if(roles.get(i).contradictions() > contra) {
				contra = roles.get(i).contradictions();
				contraInd = i;
			}
		}
		return contraInd;
	}
	
	//Orders characters from most people talked to to least
	//Uses MergeSort - thank you Java Methods Textbook for the code
	private ArrayList<Character> orderCharacters(ArrayList<Character> arr){
		int n = arr.size();
		return recursiveSort(arr, 0, n-1);
	}
	private ArrayList<Character> recursiveSort(ArrayList<Character> arr, int from, int to) {
		int tTalkedTo = arr.get(to).getNumTalkedTo();
		int fTalkedTo = arr.get(from).getNumTalkedTo();
		if(to - from < 2) {
			if(to > from && tTalkedTo > fTalkedTo) {
				// swap them
				Character temp = arr.get(to);
				arr.set(to, arr.get(from));
				arr.set(from, temp);
			}
			return arr;
		} else {
			int middle = (from + to)/2;
			recursiveSort(arr, from, middle);
			recursiveSort(arr, middle, to);
			return mergeOC(arr, from, middle, to);
		}
	}
	private ArrayList<Character> mergeOC(ArrayList<Character> arr, int from, int middle, int to){
		int i = from, j = middle + 1, k = from;
		ArrayList<Character> temp = new ArrayList<Character>(arr.size());
		for(int z = 0; z < arr.size(); z++) {
			temp.add(arr.get(i));
		}
		
		//While both arrays have elements left unprocessed:
		while(i <= middle && j <= to) {
			if(arr.get(i).getNumTalkedTo() > arr.get(j).getNumTalkedTo()) {
				temp.set(k, arr.get(i));
				i++;
			} else {
				temp.set(k, arr.get(j));
				j++;
			}
			k++;
		}
		while(i <= middle) {
			temp.set(k, arr.get(i));
			i++;
			k++;
		}
		while(j <= to) {
			temp.set(k, arr.get(j));
			j++;
			k++;
		}
		for(k = from; k <= to; k++) {
			arr.set(k, temp.get(k));
		}
	return arr;
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		//C:\Users\summe\eclipse-workspace\Shakespeare\src\txt
		//C:\\Users\\summe\\eclipse-workspace\\Shakespeare\\src\\txt\\Ham4-5.txt
		AssignCharactersMe r = new AssignCharactersMe("C:\\Users\\summe\\eclipse-workspace\\Shakespeare\\src\\txt\\Ham4-5.txt", 5);
		
		r.assignRoles();	
	}
}