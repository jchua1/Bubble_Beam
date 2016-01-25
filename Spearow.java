import cs1.Keyboard;

public class Spearow extends Pokemon {

    public Spearow(){
	_hp = 40;
	_atk = 60;
	_spatk = 31;
	_def = 30;
	_spdef = 31;
	_spd = 70;
	acc = 100;
	_type = "normal";
	type = "normal";
	_type2 = "flying";
	name = "Spearow";
	updateStats();
	heal();
	allMoves = new String[] {"Peck","Growl","Leer","Fury Attack","Drill Peck", "Agility"};
	levelLearn = new int[] {1,1,9,15,34,43};
    }

    public Spearow(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 20) {
	    name = "Fearow";
	    _hp = 65;
	    _atk = 90;
	    _spatk = 61;
	    _def = 65;
	    _spdef = 61;
	    _spd = 100;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 20) {
	    System.out.println("Your Spearow has evolved into a Fearow!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Fearow";
	    _hp = 65;
	    _atk = 90;
	    _spatk = 61;
	    _def = 65;
	    _spdef = 61;
	    _spd = 100;
	}
    }

    public void moves(int pick, Pokemon enemy){
	String move = moveSet[pick - 1];
	if (move.equals("Peck")){
	    special = true;
	    setType("flying");
	    power = 35;
	    acc = 100;
	}
	if (move.equals("Growl")){
	    debuff = true;
	    debuffStat = "atk";
	    debuffNum = -1;
	    acc = 100;
	}
	if (move.equals("Leer")){
	    debuff = true;
	    debuffStat = "def";
	    debuffNum = -1;
	    acc = 100;
	}
	if (move.equals("Fury Attack")){
	    normal = true;
	    setType("normal");
	    power = 15 * (int)(Math.random() * 4 + 2);
	    acc = 85;
	}
	if (move.equals("Drill Peck")){
	    special = true;
	    setType("flying");
	    power = 80;
	    acc = 100;
	}
	if (move.equals("Agility")){
	    buff = true;
	    buffStat = "spd";
	    buffNum = 2;
	    acc = 100;
	}
    }
}
