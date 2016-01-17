public class Squirtle extends Pokemon {

    public Squirtle(){
        _hp = 44;
	_atk = 48;
	_spatk = 50;
	_def = 65;
	_spdef = 64;
	_spd = 43;
	_acc = 100;
	_type = "water";
	type = "water";
	updateStats();
	name = "Squirtle";
	moveSet = new String[] {"Tackle","Tail Whip","Water Gun","Bubble"};
	allMoves = new String[] {};//add moves later
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

    public void name(int level){
	if (level == 36) {
	    System.out.println("Your Wartortle has evolved into a Blastoise!");
	    checkPoint();
	    name = "Blastoise";
	}
	if (level == 16) {
	    System.out.println("Your Squirtle has evolved into a Wartortle!");
	    checkPoint();
	    name = "Wortortle";
	}
    }

    public void moves(int pick, Pokemon enemy){
	String move = moveSet[pick - 1];
	if (move.equals("Tail Whip")){
	    atk = 0;
	    spatk = 0;
	    enemy.setDefense(enemy.getDefense() - 5.0);
	}
	if (move.equals("Tackle")){
	    spatk = 0; 
	    setType("normal");
	}
	if (move.equals("Water Gun")){
	    atk = 0;
	    setType("water");
	}
	if (move.equals("Bubble")){
	    atk = 0;
	    setType("water");
	}
    }

}
