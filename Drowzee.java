import cs1.Keyboard;

public class Drowzee extends Pokemon {

    public Drowzee(){
	_hp = 60;
	_atk = 48;
	_spatk = 43;
	_def = 45;
	_spdef = 90;
	_spd = 42;
	acc = 100;
	_type = "psychic";
	type = "psychic";
	_type2 = "";
	name = "Drowzee";
	updateStats();
	heal();
	allMoves = new String[] {"Pound","Hypnosis","Confusion","Headbutt","Poison Gas", "Psychic","Meditate"};
	levelLearn = new int[] {1,1,17,24,33,37,43};
    }

    public Drowzee(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 26) {
	    name = "Hypno";
	    _hp = 85;
	    _atk = 73;
	    _spatk = 73;
	    _def = 70;
	    _spdef = 115;
	    _spd = 67;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 26) {
	    System.out.println("Your Drowzee has evolved into a Hypno!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Hypno";
	    _hp = 85;
	    _atk = 73;
	    _spatk = 73;
	    _def = 70;
	    _spdef = 115;
	    _spd = 67;
	}
    }

    public void moves(int pick, Pokemon enemy){
	String move = moveSet[pick - 1];
	if (move.equals("Pound")){
	    normal = true;
	    setType("normal");
	    power = 40;
	    acc = 100;
	}
	if (move.equals("Hypnosis")){
	    status = true;
	    statusName = "sleep";
	    acc = 60;
	}
	if (move.equals("Confusion")){
	    special = true;
	    setType("psychic");
	    power = 50;
	    acc = 100;
	    if (Math.random() * 10 < 1){
		status = true;
		statusName = "confused";
	    }
	}
	if (move.equals("Headbutt")){
	    normal = true;
	    setType("normal");
	    power = 70;
	    acc = 100;
	    if (Math.random() * 10 < 3){
		status = true;
		statusName = "flinch";
	    }
	}
	if (move.equals("Poison Gas")){
	    status = true;
	    statusName = "poison";
	    acc = 55;
	}
	if (move.equals("Psychic")){
	    special = true;
	    setType("psychic");
	    power = 90;
	    acc = 100;
	    if (Math.random() * 10 < 3.33){
		debuff = true;
		debuffStat = "spatk";
		debuffNum = -1;
	    }
	}
	if (move.equals("Meditate")){
	    buff = true;
	    buffStat = "atk";
	    buffNum = 1;
	    acc = 100;
	}
    }
}
