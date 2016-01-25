import cs1.Keyboard;

public class Squirtle extends Pokemon {

    public Squirtle(){
	_hp = 44;
	_atk = 48;
	_spatk = 50;
	_def = 65;
	_spdef = 64;
	_spd = 43;
	acc = 100;
	_type = "water";
	type = "water";
	_type2 = "";
	name = "Squirtle";
	updateStats();
	heal();
	allMoves = new String[] {"Tackle","Tail Whip","Bubble","Water Gun","Bite","Withdraw","Skull Bash","Hydro Pump"};
	levelLearn = new int[] {1,1,8,15,24,31,42,52};
    }

    public Squirtle(int level){
	this();
	lvl = level;
	updateStats();
	heal();
	giveMoves(level);
	if (level >= 36) {
	    name = "Blastoise";
	    _hp = 79;
	    _atk = 83;
	    _spatk = 85;
	    _def = 100;
	    _spdef = 105;
	    _spd = 78;
	}
	else if (level >= 16) {
	    name = "Wartortle";
	    _hp = 59;
	    _atk = 63;
	    _spatk = 65;
	    _def = 80;
	    _spdef = 80;
	    _spd = 58;
	}
    }

    public void name(int level) throws InterruptedException{
	if (level == 36) {
	    System.out.println("Your Wartortle has evolved into a Blastoise!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Blastoise";
	    _hp = 79;
	    _atk = 83;
	    _spatk = 85;
	    _def = 100;
	    _spdef = 105;
	    _spd = 78;
	}
	if (level == 16) {
	    System.out.println("Your Squirtle has evolved into a Wartortle!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Wartortle";
	    _hp = 59;
	    _atk = 63;
	    _spatk = 65;
	    _def = 80;
	    _spdef = 80;
	    _spd = 58;
	}
    }

    public void moves(int pick, Pokemon enemy){
	String move = moveSet[pick - 1];
	if (move.equals("Tail Whip")){
	    debuff = true;
	    debuffStat = "def";
	    debuffNum = -1;
	}
	if (move.equals("Tackle")){
	    normal = true;
	    setType("normal");
	    power = 35;
	    acc = 95;
	}
	if (move.equals("Water Gun")){
	    special = true;
	    setType("water");
	    power = 40;
	    acc = 100;
	}
	if (move.equals("Bubble")){
	    special = true;
	    setType("water");
	    power = 20;
	    acc = 100;
	}
	if (move.equals("Bite")) {
	    normal = true;
	    setType("normal");
	    power = 60;
	    acc = 100;
	}
	if (move.equals("Withdraw")) {
	    buff = true;
	    buffStat = "def";
	    buffNum = 1;
	    acc = 100;
	}
	if (move.equals("Skull Bash")) {
	    normal = true;
	    setType("normal");
	    power = 100;
	    acc = 100;
	}
	if (move.equals("Hydro Pump")) {
	    special = true;
	    setType("water");
	    power = 120;
	    acc = 80;
	}		
    }
}
