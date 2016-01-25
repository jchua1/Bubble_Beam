import cs1.Keyboard;

public class Dratini extends Pokemon {

    public Dratini(){
        _hp = 41;
	_atk = 64;
	_spatk = 50;
	_def = 45;
	_spdef = 50;
	_spd = 50;
	acc = 100;
	_type = "dragon";
	type = "dragon";
	_type2 = "";
	name = "Dratini";
	updateStats();
	heal();
	allMoves = new String[] {"Wrap","Leer","Thunder Wave","Agility","Slam","Dragon Rage","Hyper Beam"};
	levelLearn = new int[] {1,1,10,20,35,45,60};
    }

    public Dratini(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 55) {
	    name = "Dragonite";
	    _hp = 91;
	    _atk = 134;
	    _spatk = 100;
	    _def = 95;
	    _spdef = 100;
	    _spd = 80;
	    _type2 = "flying";
	}
	else if (level >= 30) {
	    name = "Dragonair";
	    _hp = 61;
	    _atk = 84;
	    _spatk = 70;
	    _def = 65;
	    _spdef = 70;
	    _spd = 70;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 55) {
	    System.out.println("Your Dragonair has evolved into a Dragonite!");
	    System.out.println("---------------------------------------------");
	    name = "Dragonite";
	    _hp = 91;
	    _atk = 134;
	    _spatk = 100;
	    _def = 95;
	    _spdef = 100;
	    _spd = 80;
	    _type2 = "flying";
	}
	if (level == 30) {
	    System.out.println("Your Dratini has evolved into a Dragonair!");
	    System.out.println("---------------------------------------------");
	    name = "Dragonair";
	    _hp = 61;
	    _atk = 84;
	    _spatk = 70;
	    _def = 65;
	    _spdef = 70;
	    _spd = 70;
	}
    }

    public void moves(int pick, Pokemon enemy) {
	String move = moveSet[pick - 1];
	if (move.equals("Wrap")){
	    normal = true;
	    power = 20;
	    acc = 85;
	}
	if (move.equals("Leer")){
	    debuff = true;
	    buffStat = "def";
	    debuffNum = -1;
	    acc = 100;
	}
	if (move.equals("Thunder Wave")){
	    status = true;
	    statusName = "paralysis";
	    acc = 100;
	}
	if (move.equals("Agility")){
	    buff = true;
	    buffStat = "spd";
	    buffNum = 2;
	    acc = 100;
	}
	if (move.equals("Slam")) {
	    normal = true;
	    setType("normal");
	    power = 80;
	    acc = 75;
	}
	if (move.equals("Dragon Rage")) {
	    enemy.lowerHp(40);
	    System.out.println(name + " did 40 damage to " + enemy.getName());
	}
	if (move.equals("Hyper Beam")) {
	    special = true;
	    setType("normal");
	    power = 150;
	    acc = 50;
	}
    }
}
