import cs1.Keyboard;

public class Ponyta extends Pokemon {

    public Ponyta(){
        _hp = 50;
	_atk = 85;
	_spatk = 65;
	_def = 55;
	_spdef = 65;
	_spd = 90;
	acc = 100;
	_type = "fire";
	type = "fire";
	_type2 = "";
	name = "Ponyta";
	updateStats();
	heal();
	allMoves = new String[] {"Ember","Tail Whip","Stomp","Growl","Fire Spin","Take Down","Agility"};
	levelLearn = new int[] {1,30,32,35,39,47,55};
    }

    public Ponyta(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 40) {
	    name = "Rapidash";
	    _hp = 65;
	    _atk = 100;
	    _spatk = 80;
	    _def = 70;
	    _spdef = 80;
	    _spd = 105;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 42) {
	    System.out.println("Your Ponyta evolved into Rapidash!");
	    System.out.println("---------------------------------------------");
	    name = "Rapidash";
	    _hp = 65;
	    _atk = 100;
	    _spatk = 80;
	    _def = 70;
	    _spdef = 80;
	    _spd = 105;
	}
    }

    public void moves(int pick, Pokemon enemy) {
	String move = moveSet[pick - 1];
	if (move.equals("Ember")) {
	    special = true;
	    setType("fire");
	    power = 40;
	    acc = 100;
	    if (Math.random()*101 <= 10) {
		status = true;
		statusName = "burned";
	    }
	}
	if (move.equals("Tail Whip")) {
	    debuff = true;
	    buffStat = "def";
	    buffNum = -1;
	}
	if (move.equals("Stomp")) {
	    normal = true;
	    setType("normal");
	    power = 65;
	    acc = 100;
	    if (Math.random()*101 <= 30) {
		status = true;
		statusName = "flinch";
	    }
	}
	if (move.equals("Growl")) {
	    debuff = true;
	    buffStat = "atk";
	    buffNum = -1;
	}
	if (move.equals("Fire Spin")) {
	    special = true;
	    setType("fire");
	    power = 15;
	    acc = 70;
	    status = true;
	    statusName = "fireTrap";
	}
	if (move.equals("Take Down")) {
	    normal = true;
	    setType("normal");
	    power = 90;
	    acc = 85;
	    lowerHp(10);
	    System.out.println(name + " has taken 10 damage from recoil!");
	}
	if (move.equals("Agility")) {
	    buff = true;
	    buffStat = "spd";
	    buffNum = 2;
	}
    }
}
