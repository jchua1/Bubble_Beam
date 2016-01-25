import cs1.Keyboard;

public class Caterpie extends Pokemon {

    public Caterpie(){
	_hp = 45;
	_atk = 30;
	_spatk = 20;
	_def = 35;
	_spdef = 20;
	_spd = 45;
	acc = 100;
	_type = "bug";
	type = "bug";
	_type2 = "";
	name = "Caterpie";
	updateStats();
	heal();
	allMoves = new String[] {"Tackle","String Shot","Confusion","Posion Powder","Stun Spore","Sleep Powder","Supersonic","Gust","Psybeam"};
	levelLearn = new int[] {1,1,12,15,16,17,21,28,32};
    }

    public Caterpie(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 10) {
	    name = "Butterfree";
	    _type2 = "flying";
	    _hp = 60;
	    _atk = 45;
	    _spatk = 80;
	    _def = 50;
	    _spdef = 80;
	    _spd = 70;
	}
	else if (level >= 7) {
	    name = "Metapod";
	    _hp = 50;
	    _atk = 20;
	    _spatk = 25;
	    _def = 55;
	    _spdef = 25;
	    _spd = 30;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 10) {
	    System.out.println("Your Metapod has evolved into a Butterfree!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Butterfree";
	    _type2 = "flying";
	    _hp = 60;
	    _atk = 45;
	    _spatk = 80;
	    _def = 50;
	    _spdef = 80;
	    _spd = 70;
	}
	if (level == 7) {
	    System.out.println("Your Caterpie has evolved into a Metapod!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Metapod";
	    _hp = 50;
	    _atk = 20;
	    _spatk = 25;
	    _def = 55;
	    _spdef = 25;
	    _spd = 30;
	}
    }

    public void moves(int pick, Pokemon enemy){
	String move = moveSet[pick - 1];
	if (move.equals("Tackle")){
	    normal = true;
	    setType("normal");
	    power = 35;
	    acc = 95;
	}
	if (move.equals("String Shot")){
	    debuff = true;
	    debuffStat = "spd";
	    debuffNum = -1;
	    acc = 95;
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
	if (move.equals("Poison Powder")){
	    status = true;
	    statusName = "poisoned";
	    acc = 75;
	}
	if (move.equals("Stun Spore")) {
	    status = true;
	    statusName = "paralysis";
	    acc = 75;
	}
	if (move.equals("Sleep Powder")) {
	    status = true;
	    statusName = "sleep";
	    acc = 75;
	}
	if (move.equals("Supersonic")) {
	    status = true;
	    statusName = "confused";
	    acc = 55;
	}
	if (move.equals("Gust")) {
	    normal = true;
	    setType("normal");
	    power = 40;
	    acc = 100;
	}
	if (move.equals("Psybeam")) {
	    normal = true;
	    setType("psychic");
	    power = 65;
	    acc = 100;
	    if (Math.random() * 10 < 1){
		status = true;
		statusName = "confused";
	    }
	}
    }
}
