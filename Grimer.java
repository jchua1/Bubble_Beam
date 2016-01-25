import cs1.Keyboard;

public class Grimer extends Pokemon {

    public Grimer(){
        _hp = 80;
	_atk = 80;
	_spatk = 40;
	_def = 50;
	_spdef = 50;
	_spd = 25;
	acc = 100;
	_type = "poison";
	type = "poison";
	_type2 = "";
	name = "Grimer";
	updateStats();
	heal();
	allMoves = new String[] {"Pound","Poison Gas","Sludge","Harden","Screech","Acid Armor"};
	levelLearn = new int[] {1,30,37,45,53,60};
    }

    public Grimer(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 38) {
	    name = "Muk";
	    _hp = 105;
	    _atk = 105;
	    _spatk = 65;
	    _def = 75;
	    _spdef = 100;
	    _spd = 50;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 38) {
	    System.out.println("Your Grimer evolved into Muk!");
	    System.out.println("---------------------------------------------");
	    name = "Muk";
	    _hp = 105;
	    _atk = 105;
	    _spatk = 65;
	    _def = 75;
	    _spdef = 100;
	    _spd = 50;
	}
    }

    public void moves(int pick, Pokemon enemy) {
	String move = moveSet[pick - 1];
	if (move.equals("Pound")){
	    normal = true;
	    setType("normal");
	    power = 40;
	    acc = 100;
	}
	if (move.equals("Poison Gas")){
	    status = true;
	    statusName = "poisoned";
	    acc = 55;
	}
	if (move.equals("Sludge")){
	    special = true;
	    setType("poison");
	    power = 65;
	    acc = 100;
	    if (Math.random()*101 <= 30) {
		status = true;
		statusName = "poisoned";
	    }
	}
	if (move.equals("Harden")) {
	    buff = true;
	    buffStat = "def";
	    buffNum = 1;
	}
	if (move.equals("Screech")) {
	    debuff = true;
	    buffStat = "def";
	    buffNum = -2;
	}
	if (move.equals("Acid Armor")) {
	    buff = true;
	    buffStat = "def";
	    buffNum = 2;
	}
    }
}
