import cs1.Keyboard;

public class Mrmime extends Pokemon {

    public Mrmime(){
        _hp = 40;
	_atk = 45;
	_spatk = 100;
	_def = 65;
	_spdef = 120;
	_spd = 90;
	acc = 100;
	_type = "psychic";
	type = "psychic";
	_type2 = "";
	name = "Mr. Mime";
	updateStats();
	heal();
	allMoves = new String[] {"Confusion","Double Slap","Meditate"};
	levelLearn = new int[] {15,31,39};
    }

    public Mrmime(int level){
	this();
	lvl = level;
	giveMoves(level);
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{

    }

    public void moves(int pick, Pokemon enemy) {
	String move = moveSet[pick - 1];
	if (move.equals("Confusion")){
	    special = true;
	    setType("psychic");
	    power = 50;
	    acc = 100;
	    if (Math.random()*101 <= 10) {
		status = true;
		statusName = "confused";
	    }
	}
	if (move.equals("Double Slap")){
	    normal = true;
	    setType("normal");
	    power = 15 * (int)(Math.random()*4+2);
	    acc = 85;
	}
	if (move.equals("Meditate")) {
	    buff = true;
	    buffStat = "atk";
	    buffNum = 1;
	}
    }
}
