import cs1.Keyboard;

public class City {
    
    private String name;
    private Trainer gymLeader, self;
    private Pokemon[] wilderness;
    
    public City(String x, Trainer a, Trainer y, Pokemon[] z) {
        name = x;
        self = a;
        gymLeader = y;
        wilderness = z;
    }
    
    public void path() throws InterruptedException {
        int input = 0;
        System.out.println("You're in " + name + "!");
        Thread.sleep(1000);
        while (input <= 0 || input > 3) {
            System.out.println("What would you like to do?");
            System.out.println("\t1. Battle the gym leader.");
            System.out.println("\t2. Train in the wilderness.");
            System.out.println("\t3. Go to the Pokemon center.");
            input = Keyboard.readInt();
            if (input < 0 || input > 3) {
                System.out.println("Invalid choice!");
            }
        }
        if (input == 1) {
            self.battle(gymLeader);
        }
        if (input == 2) {
	    Pokemon wild = spawn();
            self.battle(wild,"A wild " + wild + " has appeared!");
        }
        if (input == 3) {
            self.editParty();
        }
        
    }

                
    public Pokemon spawn() {
        int x = (int)(Math.random()*wilderness.length);
        return wilderness[x];
    }
}
