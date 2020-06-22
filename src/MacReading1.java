import java.io.FileNotFoundException;

public class MacReading1{
	public static void main(String[] args) throws FileNotFoundException{
		Play p = new Play("Macbeth Part 2", "C:\\Users\\summe\\eclipse-workspace\\Shakespeare\\src\\txt\\macbeth1.txt");
		
		AssignCharacters ac = new AssignCharacters(p, 5);
		ac.assignRoles(true);
		for(Role r: ac.getAssignments()) {
			System.out.println();
			System.out.println(r.getName() + " has " + r.countLines() + " lines");
			System.out.println(r.contradicts());
			System.out.println(r);
		}
		System.out.println(Stats.stanDevRoles(p, ac.getAssignments()));
	}
}