import cs1.Keyboard;

public class Snorlax extends Pokemon {

    public Snorlax(){
        _hp = 160;
	_atk = 110;
	_spatk = 65;
	_def = 65;
	_spdef = 110;
	_spd = 30;
	acc = 100;
	_type = "normal";
	type = "normal";
	_type2 = "";
	name = "Snorlax";
	updateStats();
	heal();
	allMoves = new String[] {"Headbutt","Amnesia","Body Slam","Harden","Double-Edge","Hyper Beam"};
	levelLearn = new int[] {1,1,35,41,48,56};
    }

    public Snorlax(int level){
	this();
	lvl = level;
	updateStats();
	heal();
	giveMoves(level);
    }

    public void name(int level) throws InterruptedException {
    
    }

    public void moves(int pick, Pokemon enemy) {
	String move = moveSet[pick - 1];
	if (move.equals("Headbutt")){
	    normal = true;
	    setType("normal");
	    power = 70;
	    acc = 100;
	}
	if (move.equals("Amnesia")){
	    buff = true;
	    buffStat = "spdef";
	    buffNum = 2;
	    acc = 100;
	}
	if (move.equals("Body Slam")){
	    normal = true;
	    setType("normal");
	    power = 85;
	    acc = 100;
	    if (Math.random()*101 <= 30) {
		status = true;
		statusName = "paralysis";
	    }
	}
	if (move.equals("Harden")) {
	    buff = true;
	    buffStat = "def";
	    buffNum = 1;
	    acc = 100;
	}
	if (move.equals("Double-Edge")) {
	    normal = true;
	    setType("normal");
	    power = 100;
	    acc = 100;
	    lowerHp(10);
	    System.out.println(name + " has taken 10 damage from recoil!");
	}
	if (move.equals("Hyper Beam")) {
	    special = true;
	    setType("normal");
	    power = 150;
	    acc = 50;
	}
    }
}
