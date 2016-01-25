import cs1.Keyboard;

public class Onix extends Pokemon {

    public Onix(){
        _hp = 35;
	_atk = 45;
	_spatk = 30;
	_def = 160;
	_spdef = 45;
	_spd = 70;
	acc = 100;
	_type = "rock";
	type = "rock";
	_type2 = "ground";
	name = "Onix";
	updateStats();
	heal();
	allMoves = new String[] {"Tackle","Screech","Bind","Rock Throw","Rage","Slam","Harden"};
	levelLearn = new int[] {1,1,15,19,25,33,43};
    }

    public Onix(int level){
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
	if (move.equals("Tackle")){
	    normal = true;
	    setType("normal");
	    power = 20;
	    acc = 85;
	}
	if (move.equals("Screech")){
	    debuff = true;
	    buffStat = "def";
	    buffNum = -2;
	    acc = 85;
	}
	if (move.equals("Bind")) {
	    normal = true;
	    setType("normal");
	    power = 15;
	    acc = 85;
	}
	if (move.equals("Rock Throw")) {
	    normal = true;
	    setType("rock");
	    power = 50;
	    acc = 90;
	}
	if (move.equals("Rage")) {
	    normal = true;
	    setType("normal");
	    power = 20;
	    acc = 100;
	    buff = true;
	    buffStat = "atk";
	    buffNum = 1;
	}
	if (move.equals("Slam")) {
	    normal = true;
	    setType("normal");
	    power = 80;
	    acc = 75;
	}
	if (move.equals("Harden")) {
	    buff = true;
	    buffStat = "def";
	    buffNum = 1;
	    acc = 100;
	}
    }
}
