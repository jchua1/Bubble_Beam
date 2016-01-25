import cs1.Keyboard;

public class Oddish extends Pokemon {

    public Oddish(){
	_hp = 45;
	_atk = 50;
	_spatk = 75;
	_def = 55;
	_spdef = 65;
	_spd = 30;
	acc = 100;
	_type = "grass";
	type = "grass";
	_type2 = "poison";
	name = "Oddish";
	updateStats();
	heal();
	allMoves = new String[] {"Acid","Petal Dance","Posion Powder","Stun Spore","Sleep Powder"};
	levelLearn = new int[] {1,1,15,17,19};
    }

    public Oddish(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 40) {
	    name = "Vileplume";
	    _hp = 60;
	    _atk = 45;
	    _spatk = 80;
	    _def = 50;
	    _spdef = 80;
	    _spd = 70;
	}
	else if (level >= 21) {
	    name = "Gloom";
	    _hp = 60;
	    _atk = 65;
	    _spatk = 85;
	    _def = 70;
	    _spdef = 75;
	    _spd = 40;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 40) {
	    System.out.println("Your Gloom has evolved into a Vileplume!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Vileplume";
	    _hp = 75;
	    _atk = 80;
	    _spatk = 100;
	    _def = 85;
	    _spdef = 90;
	    _spd = 50;
	}
	if (level == 21) {
	    System.out.println("Your Oddish has evolved into a Gloom!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Gloom";
	    _hp = 60;
	    _atk = 65;
	    _spatk = 85;
	    _def = 70;
	    _spdef = 75;
	    _spd = 40;
	}
    }

    public void moves(int pick, Pokemon enemy){
	String move = moveSet[pick - 1];
	if (move.equals("Stun Spore")){
	    status = true;
	    statusName = "paralysis";
	    acc = 75;
	}
	if (move.equals("Sleep Powder")){
	    status = true;
	    statusName = "sleep";
	    acc = 75;
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
	if (move.equals("Petal Dance")){
	    special = true;
	    setType("grass");
	    power = 70 * (int)(Math.random() * 2 + 4);
	    acc = 100;
	    confused = 4;
	    System.out.println(name + " has been confused!");
	}
	if (move.equals("Poison Powder")) {
	    status = true;
	    statusName = "poison";
	    acc = 75;
	}
    }
}
