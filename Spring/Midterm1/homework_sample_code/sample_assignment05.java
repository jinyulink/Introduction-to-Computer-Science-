package homework_sample_code;
import java.util.*;

public class sample_assignment05 {

	static ArrayList<int[]> all_team_count = new ArrayList<>();
	static int[] temp_count;
	static int temp_m = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Character> All_Team = new ArrayList<>();
		int n, m;
		String character, name;
		n = input.nextInt();
		for(int i = 0; i < n; i++){
			m = input.nextInt();
			temp_m = m;
			temp_count = new int[]{0, 0, 0, 0, 0};
			ArrayList<Character> team = new ArrayList<>(); //
			for(int j = 0; j < m; j++){
				character = input.next();
				name = input.next();
				if(character.equals("Warrior")){
					team.add(new Warrior(name));
					temp_count[0]++;
				}
				else if(character.equals("Bowmen")){
					team.add(new Bowmen(name));
					temp_count[1]++;
				}
				else if(character.equals("Magician")){
					team.add(new Magician(name));
					temp_count[2]++;
				}
				else if(character.equals("Thief")){
					team.add(new Thief(name));
					temp_count[3]++;
				}
				else if(character.equals("Pirate")){
					team.add(new Pirate(name));
					temp_count[4]++;
				}
			}
			Collections.sort(team, new Comparator<Character>() {
	            public int compare(Character c1, Character c2) {
	                int result = c1.getData()[0].compareTo(c2.getData()[0]);
	                if (result == 0) {
	                    result = c1.getData()[1].compareTo(c2.getData()[1]);
	                }
	                return result;
	            }
	        });
	        if(team.size() == 1){
	        	All_Team.add(team.get(0));
	        }
	        else{
		        Team final_team = new Team(team.get(m - 2), team.get(m - 1), 2);
		        for(int j = m - 3; j >= 0; j--){
		        	final_team = new Team(team.get(j), final_team, m - j);
		        }
		        All_Team.add(final_team);
		    }
		}
		Collections.sort(All_Team, new Comparator<Character>() {
    		public int compare(Character c1, Character c2) {
        		if (c1.attack() > c2.attack()) return -1;
        		else if (c1.attack() < c2.attack()) return 1;
        		else return 0;
        	}
		});
		PrintRank(All_Team);
	}

	public static void PrintRank(ArrayList<Character> arr)
	{
		for(int i = 0; i < arr.size(); i++){
			System.out.println("Tier " + (i + 1) +  " team:");
			System.out.println(arr.get(i).teammate());
			System.out.print("Team BUFF : ");
			System.out.println(arr.get(i).attack());
			System.out.println();
		}
	}

	public static abstract class Character {
		// return a String Array include class name and player name
		public String[] getData(){
			return new String[]{"Begineer", "Candy"};
		}

		// return player's or team's attack
		public abstract int attack();

		// return all team mate in String type
		public abstract String teammate();
	}

	public static class Warrior extends Character {
		private String name;
		public Warrior(String _name){
			name = _name;
		}
		public String[] getData(){
			return new String[]{"Warrior", name};
		}
		public int attack(){
			return 40;
		}
		public String teammate(){
			return "Warrior : " + name;
		}
	}

	public static class Bowmen extends Character {
		private String name;
		public Bowmen(String _name){
			name = _name;
		}
		public String[] getData(){
			return new String[]{"Bowmen", name};
		}
		public int attack(){
			return 25;
		}
		public String teammate(){
			return "Bowmen : " + name;
		}
	}

	public static class Magician extends Character {
		private String name;
		public Magician(String _name){
			name = _name;
		}
		public String[] getData(){
			return new String[]{"Magician", name};
		}
		public int attack(){
			return 30;
		}
		public String teammate(){
			return "Magician : " + name;
		}
	}

	public static class Thief extends Character {
		private String name;
		public Thief(String _name){
			name = _name;
		}
		public String[] getData(){
			return new String[]{"Thief", name};
		}
		public int attack(){
			return 50;
		}
		public String teammate(){
			return "Thief : " + name;
		}
	}

	public static class Pirate extends Character {
		private String name;
		public Pirate(String _name){
			name = _name;
		}
		public String[] getData(){
			return new String[]{"Pirate", name};
		}
		public int attack(){
			return 34;
		}
		public String teammate(){
			return "Pirate : " + name;
		}
	}

	public static class Team extends Character {
		private Character c1, c2;
		private int[] class_count = new int[5];
		private int[] class_attack = new int[]{40, 25, 30, 50, 34};
		private int total_num, member_count;
		public Team(Character a1, Character a2, int count){
			c1 = a1;
			c2 = a2;
			total_num = temp_m;
			member_count = count;
			for(int i = 0; i < 5; i++){
				class_count[i] = temp_count[i];
			}
		}
		public int attack(){
			int base_attack = c1.attack() + c2.attack();
			int total_attack = base_attack;
			if(member_count == total_num){
				for(int i = 0; i < 5; i++){
					if(class_count[i] >= 2){
						total_attack += class_attack[i] * (class_count[i] - 1);
					}
				}
			}
			return total_attack;
		}
		public String teammate(){
			return c1.teammate() + "\n" + c2.teammate();
		}
	}
}