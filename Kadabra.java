import cs1.Keyboard;

public class Kadabra extends Pokemon {

    public Kadabra(){
        _hp = 40;
	_atk = 35;
	_spatk = 120;
	_def = 30;
	_spdef = 70;
	_spd = 105;
	acc = 100;
	_type = "psychic";
	type = "psychic";
	_type2 = "";
	name = "Kadabra";
	updateStats();
	heal();
	allMoves = new String[] {"Kinesis","Confusion","Psybeam","Psychic"};
	levelLearn = new int[] {1,16,27,38};
    }

    public Kadabra(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 42) {
	    name = "Alakazam";
	    _hp = 55;
	    _atk = 50;
	    _spatk = 135;
	    _def = 45;
	    _spdef = 85;
	    _spd = 120;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 32) {
	    System.out.println("Your Kadabra evolved into Alakazam!");
	    System.out.println("---------------------------------------------");
	    name = "Alakazam";
	    _hp = 55;
	    _atk = 50;
	    _spatk = 135;
	    _def = 45;
	    _spdef = 85;
	    _spd = 120;
	}
    }

    public void moves(int pick, Pokemon enemy) {
	String move = moveSet[pick - 1];
	if (move.equals("Kinesis")){
	    debuff = true;
	    buffStat = "acc";
	    buffNum = -1;
	}
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
	if (move.equals("Psybeam")){
	    special = true;
	    setType("psychic");
	    power = 65;
	    acc = 100;
	    if (Math.random()*101 <= 10) {
		status = true;
		statusName = "confused";
	    }
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
