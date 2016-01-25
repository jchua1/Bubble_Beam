import cs1.Keyboard;

public class Ekans extends Pokemon {

    public Ekans(){
	_hp = 35;
	_atk = 60;
	_spatk = 40;
	_def = 44;
	_spdef = 54;
	_spd = 55;
	acc = 100;
	_type = "poison";
	type = "poison";
	_type2 = "";
	name = "Ekans";
	updateStats();
	heal();
	allMoves = new String[] {"Wrap","Leer","Poison Sting","Bite","Glare", "Screech","Acid"};
	levelLearn = new int[] {1,1,10,17,27,36,47};
    }

    public Ekans(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 22) {
	    name = "Arbok";
	    _hp = 60;
	    _atk = 85;
	    _spatk = 65;
	    _def = 69;
	    _spdef = 79;
	    _spd = 80;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 22) {
	    System.out.println("Your Ekans has evolved into a Arbok!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Arbok";
	    _hp = 60;
	    _atk = 85;
	    _spatk = 65;
	    _def = 69;
	    _spdef = 79;
	    _spd = 80;
	}
    }

    public void moves(int pick, Pokemon enemy){
	String move = moveSet[pick - 1];
	if (move.equals("Wrap")){
	    normal = true;
	    setType("normal");
	    power = 15;
	    acc = 85;
	}
	if (move.equals("Poison Sting")){
	    special = true;
	    setType("poison");
	    power = 15;
	    acc = 100;
	    if (Math.random() * 10 < 3){
		status = true;
		statusName = "poisoned";
	    }
	}
	if (move.equals("Leer")){
	    debuff = true;
	    debuffStat = "def";
	    debuffNum = -1;
	    acc = 100;
	}
	if (move.equals("Bite")){
	    normal = true;
	    setType("normal");
	    power = 60;
	    acc = 100;
	    if (Math.random() * 10 < 3){
		status = true;
		statusName = "flinch";
	    }
	}
	if (move.equals("Glare")){
	    status = true;
	    statusName = "paralysis";
	    acc = 75;
	}
	if (move.equals("Screech")){
	    debuff = true;
	    debuffStat = "def";
	    debuffNum = -2;
	    acc = 85;
	}
	if (move.equals("Acid")){
	    special = true;
	    setType("poison");
	    power = 40;
	    acc = 100;
	    if (Math.random() * 10 < 1){
	        debuff = true;
		debuffStat = "def";
		debuffNum = -1;
	    }
	}
    }
}
