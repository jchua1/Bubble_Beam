import cs1.Keyboard;

public class Porygon extends Pokemon {

    public Porygon(){
        _hp = 65;
	_atk = 60;
	_spatk = 85;
	_def = 70;
	_spdef = 75;
	_spd = 40;
	acc = 100;
	_type = "normal";
	type = "normal";
	_type2 = "";
	name = "Porygon";
	updateStats();
	heal();
	allMoves = new String[] {"Tackle","Sharpen","Psybeam","Agility","Tri Attack"};
	levelLearn = new int[] {1,1,23,35,42};
    }

    public Porygon(int level){
	this();
	lvl = level;
	updateStats();
	heal();
	giveMoves(level);
    }

    public void name(int level) throws InterruptedException{

    }

    public void moves(int pick, Pokemon enemy) {
	String move = moveSet[pick - 1];
	if (move.equals("Tackle")){
	    normal = true;
	    setType("normal");
	    power = 35;
	    acc = 95;
	}
	if (move.equals("Sharpen")){
	    buff = true;
	    buffStat = "atk";
	    buffNum = 1;
	    acc = 100;
	}
	if (move.equals("Psybeam")) {
	    special = true;
	    setType("psychic");
	    power = 65;
	    acc = 100;
	    if (Math.random()*101 < 11) {
		status = true;
		statusName = "confused";
	    }
	}
	if (move.equals("Agility")) {
	    buff = true;
	    buffStat = "spd";
	    buffNum = 2;
	    acc = 100;
	}
	if (move.equals("Tri Attack")) {
	    special = true;
	    setType("normal");
	    power = 80;
	    acc = 100;
	}
    }
}
