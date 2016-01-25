import cs1.Keyboard;

public class Staryu extends Pokemon {

    public Staryu(){
        _hp = 30;
	_atk = 45;
	_spatk = 70;
	_def = 55;
	_spdef = 55;
	_spd = 85;
	acc = 100;
	_type = "water";
	type = "water";
	_type2 = "";
	name = "Staryu";
	updateStats();
	heal();
	allMoves = new String[] {"Tackle","Water Gun","Bubble Beam","Harden","Swift","Hydro Pump"};
	levelLearn = new int[] {1,17,20,22,32,47};
    }

    public Staryu(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 20) {
	    name = "Starmie";
	    _type2 = "psychic";
	    _hp = 60;
	    _atk = 75;
	    _spatk = 100;
	    _def = 85;
	    _spdef = 85;
	    _spd = 115;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 20) {
	    System.out.println("Your Staryu evolved into Starmie!");
	    System.out.println("---------------------------------------------");
	    name = "Starmie";
	    _hp = 60;
	    _atk = 75;
	    _spatk = 100;
	    _def = 85;
	    _spdef = 85;
	    _spd = 115;
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
	if (move.equals("Water Gun")){
	    special = true;
	    setType("water");
	    power = 40;
	    acc = 100;
	}
	if (move.equals("Bubble Beam")){
	    special = true;
	    setType("water");
	    power = 65;
	    acc = 100;
	    if (Math.random()*101 <= 10) {
		debuff = true;
		buffStat = "spd";
		buffNum = -1;
	    }
	}
	if (move.equals("Harden")) {
	    buff = true;
	    buffStat = "def";
	    buffNum = 1;
	}
	if (move.equals("Swift")) {
	    special = true;
	    setType("water");
	    power = 60;
	    acc = 1000;
	}
	if (move.equals("Hydro Pump")) {
	    special = true;
	    setType("water");
	    power = 120;
	    acc = 80;
	}
    }
}
