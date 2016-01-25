import cs1.Keyboard;

public class Voltorb extends Pokemon {

    public Voltorb(){
        _hp = 40;
	_atk = 30;
	_spatk = 55;
	_def = 50;
	_spdef = 55;
	_spd = 100;
	acc = 100;
	_type = "electric";
	type = "electric";
	_type2 = "";
	name = "Voltorb";
	updateStats();
	heal();
	allMoves = new String[] {"Tackle","Screech","Sonic Boom","Swift"};
	levelLearn = new int[] {1,1,17,40};
    }

    public Voltorb(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 30) {
	    name = "Electrode";
	    _hp = 60;
	    _atk = 50;
	    _spatk = 80;
	    _def = 70;
	    _spdef = 80;
	    _spd = 140;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 30) {
	    System.out.println("Your Voltorb evolved into Electrode!");
	    System.out.println("---------------------------------------------");
	    name = "Graveler";
	    _hp = 60;
	    _atk = 50;
	    _spatk = 80;
	    _def = 70;
	    _spdef = 80;
	    _spd = 140;
	}
    }

    public void moves(int pick, Pokemon enemy) {
	String move = moveSet[pick - 1];
	if (move.equals("Tackle")){
	    normal = true;
	    setType("normal");
	    power = 20;
	    acc = 85;
	}
	if (move.equals("Screech")){
	    debuff = true;
	    buffStat = "def";
	    buffNum = -2;
	    acc = 85;
	}
	if (move.equals("Sonic Boom")){
	    enemy.lowerHp(20);
	    System.out.println(name + " did 20 damage to " + enemy.getName());
	}
	if (move.equals("Swift")) {
	    special = true;
	    setType("normal");
	    power = 60;
	    acc = 1000;
	}
    }
}
