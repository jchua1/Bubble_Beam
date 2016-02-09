import cs1.Keyboard;

public class Weedle extends Pokemon {

    public Weedle(){
	_hp = 40;
	_atk = 35;
	_spatk = 20;
	_def = 30;
	_spdef = 20;
	_spd = 50;
	acc = 100;
	_type = "bug";
	type = "bug";
	_type2 = "poison";
	name = "Weedle";
	updateStats();
	heal();
	allMoves = new String[] {"Poison Sting","String Shot","Fury Attack","Twineedle","Rage","Pin Missile","Agility"};
	levelLearn = new int[] {1,1,12,20,25,30,35};
    }

    public Weedle(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 10) {
	    name = "Beedrill";
	    _hp = 65;
	    _atk = 80;
	    _spatk = 45;
	    _def = 40;
	    _spdef = 80;
	    _spd = 75;
	}
	else if (level >= 7) {
	    name = "Kakuna";
	    _hp = 45;
	    _atk = 25;
	    _spatk = 25;
	    _def = 50;
	    _spdef = 25;
	    _spd = 35;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 10) {
	    System.out.println("Your Kakuna has evolved into a Beedrill!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Beedrill";
	    _hp = 65;
	    _atk = 80;
	    _spatk = 45;
	    _def = 40;
	    _spdef = 80;
	    _spd = 75;
	}
	if (level == 7) {
	    System.out.println("Your Weedle has evolved into a Kakuna!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Kakuna";
	    _hp = 45;
	    _atk = 25;
	    _spatk = 25;
	    _def = 50;
	    _spdef = 25;
	    _spd = 35;
	}
    }

    public void moves(int pick, Pokemon enemy){
	String move = moveSet[pick - 1];
	if (move.equals("Poision Sting")){
	    special = true;
	    setType("poison");
	    power = 15;
	    acc = 100;
	    if (Math.random() * 10 < 3){
		status = true;
		statusName = "posion";
	    }
	}
	if (move.equals("String Shot")){
	    debuff = true;
	    debuffStat = "spd";
	    debuffNum = -1;
	    acc = 95;
	}
	if (move.equals("Fury Attack")){
	    normal = true;
	    setType("normal");
	    power = 15 * ((int)Math.random() * 4 + 2);
	    acc = 85;
	}
	if (move.equals("Twineedle")){
	    special = true;
	    setType("bug");
	    power = 50;
	    acc = 100;
	    if (Math.random() * 10 < 2){
		status = true;
		statusName = "poison";
	    }
	    if (Math.random() * 10 < 2){
		status = true;
		statusName = "poison";
	    }
	}
	if (move.equals("Rage")) {
	    normal = true;
	    setType("normal");
	    power = 20;
	    acc = 100;
	    buff = true;
	    buffStat = "atk";
	    buffNum = 1;
	}
	if (move.equals("Pin Missile")) {
	    special = true;
	    setType("bug");
	    power = 14 * ((int)Math.random() * 4 + 2);
	    acc = 85;
	}
	if (move.equals("Agility")) {
	    buff = true;
	    buffStat = "spd";
	    buffNum = 2;
	    acc = 100;
	}
    }
}
