import cs1.Keyboard;

public class Game {
    
    public void checkPoint(){
	System.out.println("Type f");
        while (!(Keyboard.readString().equals("f"))){
            System.out.println("Please type f");
	}
    }
    
    public void play() {
        Pokemon x;
        boolean battle = false;
        int input = 0;
        while (!battle) {
            System.out.println("Pick a Pokemon!");
            System.out.println("\t1. Charmander");
            input = Keyboard.readInt();
            if (input == 1) {
                x = new Charmander(3);
            }
            else {
                System.out.println("We only have 1 Pokemon so far! Sorry! XD");
                return;
            }
            System.out.println("You now have a Charmander that is level 3!\nYou're on your way to becoming the Pokemon league champion!");
            Pokemon y = new Charmander(5);
            System.out.println("Oh no! A wild Charmander popped out of the grass!");
            while ((x.getHp() > 0) && (y.getHp() > 0)) {
                int move = 0;
                int enemyMove = 0;
                System.out.println("What move will you use?");
                System.out.println("\t1. Growl\n\t2. Scratch\n\t3. Ember\n\t4. Smokescreen");
                move = Keyboard.readInt();
                x.attack(move,y);
                System.out.println("Enemy's Turn:");
                enemyMove = (int)(Math.random()*4 + 1);
                y.attack(enemyMove,x);
                System.out.println("Your HP: " + x.getHp() + " Enemy HP: " + y.getHp());
            }
            if (x.getHp() == 0) {
                System.out.println("Oh no! Your Charmander fainted! There go your hopes and dreams of becoming a Pokemon master. :(");
            }
            else {
		x.levelUp(y.getLevel() * (int)(Math.sqrt(y.getLevel())));
		System.out.println("Charmander earned " + y.getLevel() * (int)(Math.sqrt(y.getLevel())) + " experience!");
                System.out.println("You defeated the Charmander! Congratulations! Thanks for playing!");
            }
            battle = true;
        }
    }
    
    public static void main(String[] args) {
        Game x = new Game();
        x.play();
    }
}
