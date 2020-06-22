import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AssignCharacters{
	private ArrayList<Role> roles;
	private Play play;
	
	public AssignCharacters(String loc, int numRoles) throws FileNotFoundException{
		play = new Play(loc);
		roles = new ArrayList<Role>(numRoles);
		for(int i = 0; i < numRoles; i++) {
			roles.add(new Role("r" + i));
		}
	}
	public AssignCharacters(String loc, ArrayList<String> names) throws FileNotFoundException{
		play = new Play(loc);
		roles = new ArrayList<Role>(names.size());
		for(int i = 0; i < names.size(); i++) {
			roles.add(new Role(names.get(i)));
		}
	}
	public AssignCharacters(Play p, int numRoles) {
		play = p;
		roles = new ArrayList<Role>(numRoles);
		for(int i = 0; i < numRoles; i++) {
			roles.add(new Role("r" + i));
		}
	}	
	public AssignCharacters(Play p, ArrayList<String> names) {
		play = p;
		roles = new ArrayList<Role>(names.size());
		for(int i = 0; i < names.size(); i++) {
			roles.add(new Role(names.get(i)));
		}
	}
	
	private static ArrayList<Character> orderCharacters(ArrayList<Character> arr, boolean fineSort){
		int n = arr.size(); 
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr.get(j).getNumTalkedTo() < arr.get(j+1).getNumTalkedTo()){ 
                    // swap arr[j+1] and arr[i] 
                    Character temp = arr.get(j); 
                    arr.set(j, arr.get(j+1)); 
                    arr.set(j+1, temp); 
                } 
                if (arr.get(j).getNumTalkedTo() == arr.get(j+1).getNumTalkedTo() && fineSort) {
                	if (arr.get(j).getLineNum() > arr.get(j+1).getLineNum()){ 
                        // swap arr[j+1] and arr[i] 
                        Character temp = arr.get(j); 
                        arr.set(j, arr.get(j+1)); 
                        arr.set(j+1, temp); 
                    }
                }
            }
        }
        return arr;
	}
	private ArrayList<Role> rolesNotTalksTo(Character character) {
		ArrayList<Role> ntt = new ArrayList<Role>(5);
		// System.out.println(character.getName() + " " + character.getTalksTo());
		for(Role r : roles) {
			boolean flag = true;
			for(Character c : r.getCharacters()) {
				if(character.getTalksTo().contains(c)) {
					flag = false;
				}
			}
			if(flag == true) {
				ntt.add(r);
			}
		}
		return ntt;
	}
	
	public ArrayList<Role> assignRoles(boolean fineSort) {
//		ArrayList<Role> roles = new ArrayList<Role>(numRoles);
//		for(int i = 0; i < numRoles; i++) {
//			roles.add(new Role("r" + i));
//		}
		
		ArrayList<Character> untaken = new ArrayList<Character>(80);
		for(Character c: play.getCharacters()) {
			untaken.add(c);
		}
		
		for(int i = 0; i < untaken.size()-1; i++) {
			if(untaken.get(i).getName().equals("ACT")) {
				untaken.remove(i);
				i--;
			}
		}
		untaken = orderCharacters(untaken, fineSort);
		System.out.println(untaken);
		
		
		System.out.println("Each person should get about " + Stats.linesPerPerson(play, 5) + " lines \n");
		
		
		while(untaken.size() > 0) {
			String currChar = untaken.get(0).getName();
			ArrayList<Role> notTalksTo = rolesNotTalksTo(play.getCharacter(currChar));
			if(notTalksTo.size() == 0) {
				System.out.println();
				System.out.println("IMPOSSIBLE NUMBER OF ROLES (at least with this algorithm)! PLEASE HAVE AT LEAST ONE MORE PERSON");
				System.out.println();
				break;
			}
			//System.out.println(notTalksTo);
			
			Role leastLines = notTalksTo.get(0);
			
			for(Role r: notTalksTo) {
				if(r.countLines() < leastLines.countLines()) {
					leastLines = r;
				}
			}
			
			leastLines.addChar(play.getCharacter(currChar));
			untaken.remove(0);
		}
		
		
		
		//Prints out the Role assignments
		System.out.println("Reading Role Assignments: ");
		
		return roles;
	}
	
	public ArrayList<Role> getAssignments(){
		return roles;
	}
}