public class Squirtle extends Pokemon {

    public Squirtle(){
	hp = 100;
	atk = 30;
	spatk = 30;
	def = 20;
	spdef = 25;
	spd = 30;
	acc = 100;
	lvl = 1;
        type = "water";
	_hp = hp;
	_atk = atk;
	_spatk = spatk;
	_def = def;
	_spdef = spdef;
	_spd = spd;
	_acc = acc;
	_type = "water";
	name = "Squirtle";
	moveSet = new String[] {"Tackle","Tail Whip","Water Gun","Bubble"};
	allMoves = new String[] {};//add moves later
    }

    public Squirtle(int level){
	this();
	lvl = level;
	if (level >= 36) {
	    name = "Blastoise";
	}
	else if (level >= 16) {
	    name = "Wartortle";
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
