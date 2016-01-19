import cs1.Keyboard;

public class Game {
    
    public void checkPoint(){
	System.out.println("Type f.");
        while (!(Keyboard.readString().equals("f"))){
            System.out.println("Please type f.");
	}
    }
    
    public void play() throws InterruptedException{
        Pokemon x = new Bulbasaur(1);
	Trainer a = new Trainer("John Doe", x);
        boolean finished = false;
        int inputI = 0;
	String inputS = "";
        while (!finished) {
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
	    a = new Trainer(inputS, x);
	    Thread.sleep(1000);
            System.out.println("You now have a " + x.getName() + " that is level 3!");
	    Thread.sleep(1000);
	    System.out.println("You're on your way to becoming the Pokemon league champion!");
            Pokemon y = new Charmander(5);
	    Thread.sleep(1000);
            System.out.println("Oh no! A wild Charmander appeared!");
            while ((x.getHp() > 0) && (y.getHp() > 0)) {
                int move = 0;
                int enemyMove = 0;
		Thread.sleep(1000);
                System.out.println("What move will you use?");
                System.out.println("\t1. " + x.moveSet[0]
				   + "\n\t2. " + x.moveSet[1]
				   + "\n\t3. " + x.moveSet[2]
				   + "\n\t4. " + x.moveSet[3]);
                move = Keyboard.readInt();
                x.attack(move,y);
                System.out.println("Enemy's Turn:");
                enemyMove = (int)(Math.random()*4 + 1);
                y.attack(enemyMove,x);
                System.out.println("Your HP: " + x.getHp() + " Enemy HP: " + y.getHp());
            }
            if (x.getHp() == 0) {
                System.out.println("Oh no! Your " + x.getName() + " fainted! There go your hopes and dreams of becoming a Pokemon master. :(");
            }
            else {
		x.levelUp(y.getLevel() * (int)(Math.sqrt(y.getLevel())));
		System.out.println(x.getName() + " earned " + y.getLevel() * (int)(Math.sqrt(y.getLevel())) + " experience!");
                System.out.println("You defeated the Charmander! Congratulations! Thanks for playing!");
            }
            finished = true;
        }
    }
    
    public static void main(String[] args) throws InterruptedException{
        Game x = new Game();
        x.play();
    }
}
