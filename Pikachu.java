import cs1.Keyboard;

public class Pikachu extends Pokemon {

    public Pikachu(){
        _hp = 35;
	_atk = 55;
	_spatk = 50;
	_def = 40;
	_spdef = 50;
	_spd = 90;
	acc = 100;
	_type = "electric";
	type = "electric";
	_type2 = "";
	name = "Pikachu";
	updateStats();
	heal();
	allMoves = new String[] {"Thunder Shock","Growl","Tail Whip","Thunder Wave","Slam","Swift","Thunderbolt","Agility","Thunder"};
	levelLearn = new int[] {1,1,6,9,20,26,26,33,41};
    }

    public Pikachu(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 42) {
	    name = "Raichu";
	    _hp = 60;
	    _atk = 90;
	    _spatk = 90;
	    _def = 55;
	    _spdef = 80;
	    _spd = 100;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 42) {
	    System.out.println("Your Pikachu evolved into Raichu!");
	    System.out.println("---------------------------------------------");
	    name = "Raichu";
	    _hp = 60;
	    _atk = 90;
	    _spatk = 90;
	    _def = 55;
	    _spdef = 80;
	    _spd = 100;
	}
    }

    public void moves(int pick, Pokemon enemy) {
	String move = moveSet[pick - 1];
	if (move.equals("Thunder Shock")){
	    special = true;
	    setType("electric");
	    power = 40;
	    acc = 100;
	    if (Math.random()*101 <= 10) {
		status = true;
		statusName = "paralysis";
	    }
	}
	if (move.equals("Growl")){
	    debuff = true;
	    buffStat = "atk";
	    buffNum = -1;
	    acc = 100;
	}
	if (move.equals("Tail Whip")){
	    debuff = true;
	    buffStat = "def";
	    buffNum = -1;
	    acc = 100;
	}
	if (move.equals("Thunder Wave")) {
	    status = true;
	    statusName = "paralysis";
	    acc = 100;
	}
	if (move.equals("Slam")) {
	    normal = true;
	    setType("normal");
	    power = 80;
	    acc = 75;
	}
	if (move.equals("Swift")) {
	    special = true;
	    setType("normal");
	    power = 60;
	    acc = 1000;
	}
	if (move.equals("Thunderbolt")) {
	    special = true;
	    setType("electric");
	    power = 90;
	    acc = 100;
	    if (Math.random()*101 <= 10) {
		status = true;
		statusName = "paralysis";
	    }
	}
	if (move.equals("Agility")) {
	    buff = true;
	    buffStat = "spd";
	    buffNum = 2;
	}
	if (move.equals("Thunder")) {
	    special = true;
	    setType("electric");
	    power = 110;
	    acc = 70;
	    if (Math.random()*101 <= 10) {
		status = true;
		statusName = "paralysis";
	    }
	}
    }
}
