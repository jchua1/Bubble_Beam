import cs1.Keyboard;

public class Tangela extends Pokemon {

    public Tangela(){
        _hp = 65;
	_atk = 55;
	_spatk = 100;
	_def = 115;
	_spdef = 40;
	_spd = 60;
	acc = 100;
	_type = "grass";
	type = "grass";
	_type2 = "";
	name = "Tangela";
	updateStats();
	heal();
	allMoves = new String[] {"Constrict","Vine Whip","Poison Powder","Stun Spore","Sleep Powder","Slam","Growth"};
	levelLearn = new int[] {1,29,32,36,39,45,48};
    }

    public Tangela(int level){
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
	if (move.equals("Constrict")){
	    normal = true;
	    setType("normal");
	    power = 10;
	    acc = 100;
	    if (Math.random()*101 <= 10) {
		debuff = true;
		buffStat = "spd";
		buffNum = -1;
	    }
	}
	if (move.equals("Vine Whip")) {
	    special = true;
	    setType("grass");
	    power = 35;
	    acc = 100;
	}
	if (move.equals("Poison Powder")) {
	    status = true;
	    statusName = "poisoned";
	    acc = 75;
	}
	if (move.equals("Stun Spore")) {
	    status = true;
	    statusName = "paralysis";
	    acc = 75;
	}
	if (move.equals("Sleep Powder")) {
	    status = true;
	    statusName = "sleep";
	    acc = 75;
	}
	if (move.equals("Slam")) {
	    normal = true;
	    setType("normal");
	    power = 80;
	    acc = 75;
	}
	if (move.equals("Growth")) {
	    buff = true;
	    buffStat = "spatk";
	    buffNum = 1;
	    acc = 100;
	}
    }
}
