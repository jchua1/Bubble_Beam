import cs1.Keyboard;

public class Bulbasaur extends Pokemon {

    public Bulbasaur(){
        _hp = 45;
	_atk = 49;
	_spatk = 65;
	_def = 49;
	_spdef = 65;
	_spd = 45;
	acc = 100;
	_type = "grass";
	type = "grass";
	_type2 = "poison";
	name = "Bulbasaur";
	updateStats();
	heal();
	moveSet = new String[] {"Tackle","Growl","Leech Seed","Vine Whip"};
	allMoves = new String[] {"Tackle","Growl","Leech Seed","Vine Whip","Poison Powder","Razor Leaf","Growth","Sleep Powder","Solar Beam"};
    }

    public Bulbasaur(int level){
	this();
	lvl = level;
	updateStats();
	heal();
	if (level >= 32) {
	    name = "Venusaur";
	}
	else if (level >= 16) {
	    name = "Ivysaur";
	}
    }

    public void name(int level) throws InterruptedException{
	if (level == 36) {
	    System.out.println("Your Ivysaur has evolved into a Venusaur!");
	    System.out.println("---------------------------------------------");
	    name = "Venusaur";
	    _hp = 80;
	    _atk = 82;
	    _spatk = 100;
	    _def = 83;
	    _spdef = 100;
	    _spd = 80;
	}
	if (level == 16) {
	    System.out.println("Your Bulbasuar has evolved into a Venusaur!");
	    System.out.println("---------------------------------------------");
	    name = "Ivysuar";
	    _hp = 60;
	    _atk = 62;
	    _spatk = 80;
	    _def = 80;
	    _spdef = 80;
	    _spd = 60;
	}
    }

    public void moves(int pick, Pokemon enemy) {
	String move = moveSet[pick - 1];
	if (move.equals("Growl")){
	    debuff = true;
	    buffStat = "atk";
	    buffNum = -1;
	    acc = 100;
	}
	if (move.equals("Tackle")){
	    normal = true;
	    setType("normal");
	    power = 35;
	    acc = 95;
	}
	if (move.equals("Vine Whip")){
	    special = true;
	    setType("grass");
	    power = 35;
	    acc = 100;
	}
	if (move.equals("Leech Seed")){
	    buff = true;
	    buffStat = "leech";
	    acc = 90;
	}
	if (move.equals("Poison Powder")) {
	    debuff = true;
	    buffStat = "poisoned";
	    acc = 75;
	}
	if (move.equals("Razor Leaf")) {
	    special = true;
	    setType("grass");
	    power = 55;
	    acc = 95;
	}
	if (move.equals("Growth")) {
	    buff = true;
	    buffStat = "spatk";
	    buffNum = 1;
	    acc = 100;
	}
	if (move.equals("Sleep Powder")) {
	    debuff = true;
	    buffStat = "sleep";
	    acc = 75;
	}
	if (move.equals("Solar Beam")) {
	    special = true;
	    setType("grass");
	    power = 120;
	    acc = 100; //charge up time??
	}
    }

    public void learn(int level) throws InterruptedException {
	if (level == 7) {
	    moveSet[2] = "Leech Seed";
	    System.out.println(name + " learned Leech Seed!");
	}
	if (level == 13) {
	    moveSet[3] = "Vine Whip";
	    System.out.println(name + " learned Vine Whip!");
	}
	if (level == 22) {
	    learnMessage("Poison Powder");
	}
	if (level == 30) {
	    learnMessage("Razor Leaf");
	}
	if (level == 43) {
	    learnMessage("Growth");
	}
	if (level == 55) {
	    learnMessage("Sleep Powder");
	}
	if (level == 65) {
	    learnMessage("Solar Beam");
	}
    }
		
    public static void main(String[] args) throws InterruptedException {
	Pokemon x = new Bulbasaur(20);
	x.levelUp(1000);
    }

}
