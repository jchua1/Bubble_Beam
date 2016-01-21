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
	updateStats();
	name = "Bulbasaur";
	moveSet = new String[] {"Tackle","Growl","Leech Seed","Vine Whip"};
	allMoves = new String[] {"Tackle","Growl","Leech Seed","Vine Whip","Poison Powder","Razor Leaf","Growth","Sleep Powder","Solar Beam"};
    }

    public Bulbasaur(int level){
	this();
	lvl = level;
	updateStats();
	if (level >= 32) {
	    name = "Venusaur";
	}
	else if (level >= 16) {
	    name = "Ivysaur";
	}
    }

    public void name(int level){
	if (level == 36) {
	    System.out.println("Your Ivysaur has evolved into a Venusaur!");
	    name = "Venusaur";
	}
	if (level == 16) {
	    System.out.println("Your Bulbasuar has evolved into a Venusaur!");
	    name = "Ivysuar";
	}
    }

    public void moves(int pick, Pokemon enemy){
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
	    debuff = true;
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
	}
    }

}
