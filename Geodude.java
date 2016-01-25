import cs1.Keyboard;

public class Geodude extends Pokemon {

    public Geodude(){
        _hp = 40;
	_atk = 80;
	_spatk = 30;
	_def = 100;
	_spdef = 30;
	_spd = 20;
	acc = 100;
	_type = "rock";
	type = "rock";
	_type2 = "ground";
	name = "Geodude";
	updateStats();
	heal();
	allMoves = new String[] {"Tackle","Defense Curl","Rock Throw","Harden","Earthquake"};
	levelLearn = new int[] {1,11,16,29,36};
    }

    public Geodude(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 40) {
	    name = "Golem";
	    _hp = 80;
	    _atk = 110;
	    _spatk = 55;
	    _def = 130;
	    _spdef = 65;
	    _spd = 45;
	}
	else if (level >= 25) {
	    name = "Graveler";
	    _hp = 55;
	    _atk = 95;
	    _spatk = 45;
	    _def = 115;
	    _spdef = 45;
	    _spd = 35;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 25) {
	    System.out.println("Your Geodude evolved into Graveler!");
	    System.out.println("---------------------------------------------");
	    name = "Graveler";
	    _hp = 55;
	    _atk = 95;
	    _spatk = 45;
	    _def = 115;
	    _spdef = 45;
	    _spd = 35;
	}
	if (level == 40) {
	    System.out.println("Your Graveler evolved into Golem!");
	    System.out.println("---------------------------------------------");
	    name = "Golem";
	    _hp = 80;
	    _atk = 110;
	    _spatk = 55;
	    _def = 130;
	    _spdef = 65;
	    _spd = 45;
	}
    }

    public void moves(int pick, Pokemon enemy) {
	String move = moveSet[pick - 1];
	if (move.equals("Tackle")){
	    normal = true;
	    setType("normal");
	    power = 20;
	    acc = 85;
	}
	if (move.equals("Defense Curl")){
	    buff = true;
	    buffStat = "def";
	    buffNum = 1;
	    acc = 100;
	}
	if (move.equals("Rock Throw")){
	    normal = true;
	    setType("rock");
	    power = 50;
	    acc = 90;
	}
	if (move.equals("Harden")) {
	    buff = true;
	    buffStat = "def";
	    buffNum = 1;
	    acc = 100;
	}
	if (move.equals("Earthquake")) {
	    normal = true;
	    setType("ground");
	    power = 100;
	    acc = 100;
	}
    }
}
