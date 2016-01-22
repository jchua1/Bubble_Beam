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
	updateStats();
	name = "Squirtle";
	moveSet = new String[] {"Tackle","Tail Whip","Bubble","Water Gun"};
	allMoves = new String[] {"Tackle","Tail Whip","Bubble","Water Gun","Bite","Withdraw","Skull Bash","Hydro Pump"};
    }

    public Squirtle(int level){
	this();
	lvl = level;
	updateStats();
	if (level >= 36) {
	    name = "Blastoise";
	}
	else if (level >= 16) {
	    name = "Wartortle";
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
	    buffStat = "def";
	    buffNum = -1;
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

    public void learn(int level) throws InterruptedException {
	if (level == 8) {
	    moveSet[2] = "Bubble";
	    System.out.println(name + " learned Bubble!");
	}
	if (level == 15) {
	    moveSet[3] = "Water Gun";
	    System.out.println(name + " learned Water Gun!");
	}
	if (level == 24) {
	    learnMessage("Bite");
	}
	if (level == 31) {
	    learnMessage("Withdraw");
	}
	if (level == 42) {
	    learnMessage("Skull Bash");
	}
	if (level == 52) {
	    learnMessage("Hydro Pump");
	}
    }

}
