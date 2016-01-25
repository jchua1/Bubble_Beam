import cs1.Keyboard;

public class Pidgey extends Pokemon {

    public Pidgey(){
	_hp = 40;
	_atk = 45;
	_spatk = 35;
	_def = 40;
	_spdef = 35;
	_spd = 56;
	acc = 100;
	_type = "normal";
	type = "normal";
	_type2 = "flying";
	name = "Pidgey";
	updateStats();
	heal();
	allMoves = new String[] {"Gust","Sand-Attack","Wing Attack","Agility"};
	levelLearn = new int[] {1,5,31,44};
    }

    public Pidgey(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 36) {
	    name = "Pidgeot";
	    _hp = 83;
	    _atk = 80;
	    _spatk = 70;
	    _def = 75;
	    _spdef = 70;
	    _spd = 91;
	}
	else if (level >= 18) {
	    name = "Pidgeotto";
	    _hp = 63;
	    _atk = 60;
	    _spatk = 50;
	    _def = 55;
	    _spdef = 50;
	    _spd = 71;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 36) {
	    System.out.println("Your Pidgeotto has evolved into a Pidgeot!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Pidgeot";
	    _hp = 83;
	    _atk = 80;
	    _spatk = 70;
	    _def = 75;
	    _spdef = 70;
	    _spd = 91;
	}
	if (level == 18) {
	    System.out.println("Your Pidgey has evolved into a Pidgeotto!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Pidgeotto";
	    _hp = 63;
	    _atk = 60;
	    _spatk = 50;
	    _def = 55;
	    _spdef = 50;
	    _spd = 71;
	}
    }

    public void moves(int pick, Pokemon enemy){
	String move = moveSet[pick - 1];
	if (move.equals("Gust")){
	    normal = true;
	    setType("normal");
	    power = 40;
	    acc = 100;
	}
	if (move.equals("Sand-Attack")){
	    debuff = true;
	    debuffStat = "acc";
	    debuffNum = -1;
	    acc = 100;
	}
	if (move.equals("Wing Attack")){
	    special = true;
	    setType("flying");
	    power = 35;
	    acc = 100;
	}
	if (move.equals("Agility")){
	    buff = true;
	    buffStat = "spd";
	    buffNum = 2;
	    acc = 100;
	}
    }
}
