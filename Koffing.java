import cs1.Keyboard;

public class Koffing extends Pokemon {

    public Koffing(){
        _hp = 40;
	_atk = 65;
	_spatk = 60;
	_def = 95;
	_spdef = 45;
	_spd = 35;
	acc = 100;
	_type = "poison";
	type = "poison";
	_type2 = "";
	name = "Koffing";
	updateStats();
	heal();
	allMoves = new String[] {"Tackle","Smog","Sludge","Smokescreen"};
	levelLearn = new int[] {1,1,32,39};
    }

    public Koffing(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 35) {
	    name = "Weezing";
	    _hp = 65;
	    _atk = 90;
	    _spatk = 85;
	    _def = 120;
	    _spdef = 70;
	    _spd = 60;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 35) {
	    System.out.println("Your Koffing evolved into Weezing!");
	    System.out.println("---------------------------------------------");
	    name = "Weezing";
	    _hp = 65;
	    _atk = 90;
	    _spatk = 85;
	    _def = 120;
	    _spdef = 70;
	    _spd = 60;
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
	if (move.equals("Smog")){
	    special = true;
	    setType("poison");
	    power = 30;
	    acc = 70;
	    if (Math.random()*101 <= 40) {
		status = true;
		statusName = "poisoned";
	    }
	}
	if (move.equals("Sludge")){
	    special = true;
	    setType("poison");
	    power = 65;
	    acc = 100;
	    if (Math.random()*101 <= 30) {
		status = true;
		statusName = "poisoned";
	    }
	}
	if (move.equals("Smokescreen")) {
	    debuff = true;
	    buffStat = "acc";
	    buffNum = -1;
	    acc = 100;
	}
    }
}
