import cs1.Keyboard;

public class Charmander extends Pokemon {

    public Charmander(){
	_hp = 39;
	_atk = 52;
	_spatk = 60;
	_def = 43;
	_spdef = 50;
	_spd = 65;
	acc = 100;
	_type = "fire";
	type = "fire";
	_type2 = "";
	name = "Charmander";
	updateStats();
	heal();
	allMoves = new String[] {"Scratch","Growl","Ember","Leer","Rage","Slash","Flamethrower","Fire Spin"};
	levelLearn = new int[] {1,1,9,15,24,36,46,55};
    }

    public Charmander(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 36) {
	    name = "Charizard";
	    _hp = 78;
	    _atk = 84;
	    _spatk = 109;
	    _def = 78;
	    _spdef = 85;
	    _spd = 100;
	}
	else if (level >= 16) {
	    name = "Charmeleon";
	    _hp = 58;
	    _atk = 64;
	    _spatk = 80;
	    _def = 58;
	    _spdef = 65;
	    _spd = 80;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException {
	if (level == 36) {
	    System.out.println("Your Charmeleon has evolved into a Charizard!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);	   
	    name = "Charizard";
	    _hp = 78;
	    _atk = 84;
	    _spatk = 109;
	    _def = 78;
	    _spdef = 85;
	    _spd = 100;
	}
	if (level == 16) {
	    System.out.println("Your Charmander has evolved into a Charmeleon!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);	   
	    name = "Charmeleon";
	    _hp = 58;
	    _atk = 64;
	    _spatk = 80;
	    _def = 58;
	    _spdef = 65;
	    _spd = 80;
	}
    }

    public void moves(int pick, Pokemon enemy){
	String move = moveSet[pick - 1];
	if (move.equals("Growl")){
	    debuff = true;
	    debuffStat = "atk";
	    debuffNum = -1;
	}
	if (move.equals("Scratch")){
	    normal = true;
	    setType("normal");
	    power = 40;
	    acc = 100;
	}
	if (move.equals("Ember")){
	    special = true;
	    setType("fire");
	    power = 40;
	    acc = 100;
	}
	if (move.equals("Leer")){
	    debuff = true;
	    debuffStat = "def";
	    debuffNum = -1;
	    acc = 100;
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
	if (move.equals("Slash")) {
	    normal = true;
	    setType("normal");
	    power = 70;
	    acc = 100;
	}
	if (move.equals("Flamethrower")) {
	    special = true;
	    setType("fire");
	    power = 95;
	    acc = 100;
	}
	if (move.equals("Fire Spin")) {
	    special = true;
	    setType("fire");
	    power = 15;
	    acc = 70;
	    status = true;
	    statusName = "fireTrap";
	}
    }
}
