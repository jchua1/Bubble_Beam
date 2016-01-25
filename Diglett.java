import cs1.Keyboard;

public class Diglett extends Pokemon {

    public Diglett(){
	_hp = 10;
	_atk = 55;
	_spatk = 35;
	_def = 25;
	_spdef = 45;
	_spd = 95;
	acc = 100;
	_type = "ground";
	type = "ground";
	_type2 = "";
	name = "Diglett";
	updateStats();
	heal();
	allMoves = new String[] {"Scratch","Growl","Dig","Sand-Attack","Slash", "Earthquake"};
	levelLearn = new int[] {1,15,19,24,35,47};
    }

    public Diglett(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 26) {
	    name = "Dugtrio";
	    _hp = 35;
	    _atk = 80;
	    _spatk = 50;
	    _def = 50;
	    _spdef = 70;
	    _spd = 120;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 26) {
	    System.out.println("Your Diglett has evolved into a Dugtrio!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Dugtrio";
	    _hp = 35;
	    _atk = 80;
	    _spatk = 50;
	    _def = 50;
	    _spdef = 70;
	    _spd = 120;
	}
    }

    public void moves(int pick, Pokemon enemy){
	String move = moveSet[pick - 1];
	if (move.equals("Scratch")){
	    normal = true;
	    setType("normal");
	    power = 40;
	    acc = 100;
	}
	if (move.equals("Growl")){
	    debuff = true;
	    debuffStat = "atk";
	    debuffNum = -1;
	    acc = 100;
	}
	if (move.equals("Dig")){
	    special = true;
	    setType("ground");
	    power = 100;
	    acc = 50;
	}
	if (move.equals("Sand-Attack")){
	    debuff = true;
	    debuffStat = "acc";
	    debuffNum = -1;
	    acc = 100;
	}
	if (move.equals("Slash")){
	    normal = true;
	    setType("normal");
	    power = 70;
	    acc = 100;
	}
	if (move.equals("Earthquake")){
	    special = true;
	    setType("ground");
	    power = 100;
	    acc = 100;
	}
    }
}
