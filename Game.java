import cs1.Keyboard;

public class Game {

    protected Trainer a;
    protected Pokemon x;
    
    public void play() throws InterruptedException{
        int inputI = 0;
	String inputS = "";
	System.out.println("Welcome to the world of Pokemon!");
	Thread.sleep(1000);
	System.out.println("What's your name?");
	Thread.sleep(1000);
	System.out.print("Enter your name: ");
	inputS = Keyboard.readString();
	System.out.println("Your name's " + inputS + "? Excellent!");
	Thread.sleep(1000);
	while ((inputI > 3 ) || (inputI < 1)) {
	    System.out.println("Now pick a Pokemon!");
	    System.out.println("\t1. Bulbasaur\n\t2. Charmander\n\t3. Squirtle");
	    inputI = Keyboard.readInt();
	    if ((inputI > 3) || (inputI < 1)) {
		System.out.println("Invalid choice!");
	    }
	}
	if (inputI == 1) {
	    x = new Bulbasaur(3);
	}
	else if (inputI == 2) {
	    x = new Charmander(3);
	}
	else if (inputI == 3) {
	    x = new Squirtle(3);
	}
	Pokemon[] starter = {x,new Squirtle(5)};
	a = new Trainer(inputS, starter);
	Thread.sleep(1000);
        System.out.println("You now have a " + x.getName() + " that is level 3!");
	Thread.sleep(1000);
	System.out.println("You're on your way to becoming the Pokemon league champion!");
	
	Pokemon[] brockPoke = {new Bulbasaur(5), new Squirtle(5), new Charmander(5)};
	Pokemon[] pewterPoke = {new Bulbasaur(5), new Squirtle(5), new Charmander(5)};
	Trainer brock = new Trainer("Brock", brockPoke);
	City pewter = new City("Pewter City",a, brock, pewterPoke);

	pewter.path();
    }	    			       
        public static void main(String[] args) throws InterruptedException{
        Game x = new Game();
        x.play();
    }
}
