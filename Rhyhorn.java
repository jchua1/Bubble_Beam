import cs1.Keyboard;

public class Rhyhorn extends Pokemon {

    public Rhyhorn(){
	_hp = 80;
	_atk = 85;
	_spatk = 30;
	_def = 95;
	_spdef = 30;
	_spd = 25;
	acc = 100;
	_type = "ground";
	type = "ground";
	_type2 = "rock";
	name = "Rhyhorn";
	updateStats();
	heal();
	allMoves = new String[] {"Horn Attack","Stomp","Tail Whip","","Fury Attack", "Horn Drill","Leer","Take Down"};
	levelLearn = new int[] {1,30,35,40,48,55,64};
    }

    public Rhyhorn(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 42) {
	    name = "Rhydon";
	    _hp = 105;
	    _atk = 130;
	    _spatk = 45;
	    _def = 120;
	    _spdef = 45;
	    _spd = 40;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 42) {
	    System.out.println("Your Rhyhorn has evolved into a Rhydon!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Rhydon";
	    _hp = 105;
	    _atk = 130;
	    _spatk = 45;
	    _def = 120;
	    _spdef = 45;
	    _spd = 40;
	}
    }

    public void moves(int pick, Pokemon enemy){
	String move = moveSet[pick - 1];
	if (move.equals("Horn Attack")){
	    normal = true;
	    setType("normal");
	    power = 65;
	    acc = 100;
	}
	if (move.equals("Stomp")){
	    normal = true;
	    setType("normal");
	    power = 65;
	    acc = 100;
	    if (Math.random()* 10 < 3){
		status = true;
		statusName = "flinch";
	    }
	}
	if (move.equals("Tail Whip")){
	    debuff = true;
	    debuffStat = "def";
	    debuffNum = -1;
	    acc = 100;
	}
	if (move.equals("Fury Attack")){
	    normal = true;
	    setType("normal");
	    power = 15 * (int)(Math.random() * 4 + 2);
	    acc = 100;
	}
	if (move.equals("Horn Drill")){
	    normal = true;
	    setType("normal");
	    power = 300;
	    acc = 30;
	}
	if (move.equals("Take Down")){
	    normal = true;
	    setType("normal");
	    power = 90;
	    acc = 85;
	    lowerHp(10);
	    System.out.println(name + " has taken 10 damage from recoil!");
	}	
    }
}
