import cs1.Keyboard;

public class Bellsprout extends Pokemon {

    public Bellsprout(){
	_hp = 50;
	_atk = 75;
	_spatk = 70;
	_def = 35;
	_spdef = 30;
	_spd = 40;
	acc = 100;
	_type = "grass";
	type = "grass";
	_type2 = "poison";
	name = "Bellsprout";
	updateStats();
	heal();
	allMoves = new String[] {"Stun Spore","Acid","Razor Leaf","Wrap","Posion Powder","Sleep Powder"};
	levelLearn = new int[] {1,1,1,13,15,18};
    }

    public Bellsprout(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 40) {
	    name = "Victreebel";
	    _hp = 80;
	    _atk = 105;
	    _spatk = 100;
	    _def = 65;
	    _spdef = 60;
	    _spd = 70;
	}
	else if (level >= 21) {
	    name = "Weepinbell";
	    _hp = 65;
	    _atk = 90;
	    _spatk = 85;
	    _def = 50;
	    _spdef = 45;
	    _spd = 55;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 40) {
	    System.out.println("Your Weepinbell has evolved into a Victreebel!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Victreebel";
	    _hp = 80;
	    _atk = 105;
	    _spatk = 100;
	    _def = 65;
	    _spdef = 60;
	    _spd = 70;
	}
	if (level == 21) {
	    System.out.println("Your Bellsprout has evolved into a Weepinbell!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Weepinbell";
	    _hp = 65;
	    _atk = 90;
	    _spatk = 85;
	    _def = 50;
	    _spdef = 45;
	    _spd = 55;
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
	if (move.equals("Razor Leaf")){
	    special = true;
	    setType("grass");
	    power = 55;
	    acc = 95;
	}
	if (move.equals("Poison Powder")) {
	    status = true;
	    statusName = "poison";
	    acc = 75;
	}
	if (move.equals("Wrap")) {
	    normal = true;
	    setType("normal");
	    power = 15;
	    acc = 85;
	}
    }
}
