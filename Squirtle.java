public class Squirtle extends Pokemon {

    public Squirtle(){
        _hp = 44;
	_atk = 48;
	_spatk = 50;
	_def = 65;
	_spdef = 64;
	_spd = 43;
	acc = 100;
	_type = "water";
	type = "water";
	_type2 = "";
	updateStats();
	name = "Squirtle";
	moveSet = new String[] {"Tackle","Tail Whip","Bubble","Water Gun"};
	allMoves = new String[] {"Tackle","Tail Whip","Bubble","Water Gun","Bite","Withdraw","Skull Bash","Hydro Pump"};
    }

    public Squirtle(int level){
	this();
	lvl = level;
	updateStats();
	if (level >= 36) {
	    name = "Blastoise";
	}
	else if (level >= 16) {
	    name = "Wartortle";
	}
    }

    public void name(int level) throws InterruptedException{
	if (level == 36) {
	    System.out.println("Your Wartortle has evolved into a Blastoise!");
	    Thread.sleep(1000);
	    name = "Blastoise";
	}
	if (level == 16) {
	    System.out.println("Your Squirtle has evolved into a Wartortle!");
	    Thread.sleep(1000);
	    name = "Wartortle";
	}
    }

    public void moves(int pick, Pokemon enemy){
	String move = moveSet[pick - 1];
	if (move.equals("Tail Whip")){
	    enemy.setDefStage(-1);
	    acc = 100;
	    System.out.println(enemy.getName() + "'s defense fell!");
	}
	if (move.equals("Tackle")){
	    normal = true;
	    setType("normal");
	    power = 35;
	    acc = 95;
	}
	if (move.equals("Water Gun")){
	    special = true;
	    setType("water");
	    power = 40;
	    acc = 100;
	}
	if (move.equals("Bubble")){
	    special = true;
	    setType("water");
	    power = 20;
	    acc = 100;
	}
    }

}
