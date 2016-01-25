import cs1.Keyboard;

public class NidoranF extends Pokemon {

    public NidoranF(){
	_hp = 55;
	_atk = 47;
	_spatk = 40;
	_def = 52;
	_spdef = 40;
	_spd = 41;
	acc = 100;
	_type = "poison";
	type = "poison";
	_type2 = "";
	name = "NidoranF";
	updateStats();
	heal();
	allMoves = new String[] {"Tackle","Tail Whip","Scratch","Double Kick","Poison Sting","Body Slam"};
	levelLearn = new int[] {1,1,8,12,14,23};
    }

    public NidoranF(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 32) {
	    name = "Nidoqueen";
	    _type2 = "ground";
	    _hp = 60;
	    _atk = 45;
	    _spatk = 80;
	    _def = 50;
	    _spdef = 80;
	    _spd = 70;
	}
	else if (level >= 16) {
	    name = "Nidorina";
	    _hp = 70;
	    _atk = 62;
	    _spatk = 55;
	    _def = 67;
	    _spdef = 55;
	    _spd = 56;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 32) {
	    System.out.println("Your Nidorina has evolved into a Nidoqueen!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Nidoqueen";
	    _type2 = "ground";
	    _hp = 90;
	    _atk = 82;
	    _spatk = 75;
	    _def = 87;
	    _spdef = 85;
	    _spd = 76;
	}
	if (level == 16) {
	    System.out.println("Your NidoranF has evolved into a Nidorina!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Nidorina";
	    _hp = 70;
	    _atk = 62;
	    _spatk = 55;
	    _def = 67;
	    _spdef = 55;
	    _spd = 56;
	}
    }

    public void moves(int pick, Pokemon enemy){
	String move = moveSet[pick - 1];
	if (move.equals("Tackle")){
	    normal = true;
	    setType("normal");
	    power = 35;
	    acc = 95;
	}
	if (move.equals("Tail Whip")){
	    debuff = true;
	    debuffStat = "def";
	    debuffNum = -1;
	    acc = 100;
	}
	if (move.equals("Scratch")){
	    normal = true;
	    setType("normal");
	    power = 40;
	    acc = 100;
	}
	if (move.equals("Double Kick")){
	    special = true;
	    setType("fighting");
	    power = 60;
	    acc = 100;
	}
	if (move.equals("Poison Sting")) {
	    special = true;
	    setType("poison");
	    power = 15;
	    acc = 100;
	    if (Math.random() * 10 < 3){
		status = true;
		statusName = "poisoned";
	    }
	}
	if (move.equals("Body Slam")) {
	    normal = true;
	    setType("normal");
	    power = 85;
	    acc = 100;
	    if (Math.random() * 10 < 3){
		status = true;
		statusName = "paralysis";
	    }
	}
    }
}
