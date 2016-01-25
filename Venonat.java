import cs1.Keyboard;

public class Venonat extends Pokemon {

    public Venonat(){
        _hp = 60;
	_atk = 55;
	_spatk = 40;
	_def = 50;
	_spdef = 55;
	_spd = 45;
	acc = 100;
	_type = "bug";
	type = "bug";
	_type2 = "poison";
	name = "Venonat";
	updateStats();
	heal();
	allMoves = new String[] {"Tackle","Confusion","Poison Powder","Stun Spore","Psybeam","Sleep Powder","Psychic"};
	levelLearn = new int[] {1,1,24,30,38,43,50};
    }

    public Venonat(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 31) {
	    name = "Venomoth";
	    _hp = 70;
	    _atk = 65;
	    _spatk = 90;
	    _def = 60;
	    _spdef = 75;
	    _spd = 90;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 31) {
	    System.out.println("Your Venonat evolved into Venomoth!");
	    System.out.println("---------------------------------------------");
	    name = "Venomoth";
	    _hp = 70;
	    _atk = 65;
	    _spatk = 90;
	    _def = 60;
	    _spdef = 75;
	    _spd = 90;
	}
    }

    public void moves(int pick, Pokemon enemy) {
	String move = moveSet[pick - 1];
	if (move.equals("Tackle")) {
	    normal = true;
	    setType("normal");
	    power = 35;
	    acc = 95;    
	}
	if (move.equals("Confusion")) {
	    special = true;
	    setType("psychic");
	    power = 50;
	    acc = 100;
	    if (Math.random()*101 <= 10) {
		status = true;
		statusName = "confused";
	    }
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
	if (move.equals("Psybeam")) {
	    special = true;
	    setType("psychic");
	    power = 65;
	    acc = 100;
	    if (Math.random()*101 <= 10) {
		status = true;
		statusName = "confused";
	    }
	}
	if (move.equals("Sleep Powder")) {
	    status = true;
	    statusName = "sleep";
	    acc = 75;
	}
	if (move.equals("Psychic")) {
	    special = true;
	    setType("psychic");
	    power = 90;
	    acc = 100;
	    if (Math.random()*101 <= 33.2) {
		debuff = true;
		buffStat = "spdef";
		buffNum = -1;
	    }
	}
    }
}
