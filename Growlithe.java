import cs1.Keyboard;

public class Growlithe extends Pokemon {

    public Growlithe(){
	_hp = 55;
	_atk = 70;
	_spatk = 70;
	_def = 45;
	_spdef = 50;
	_spd = 60;
	acc = 100;
	_type = "fire";
	type = "fire";
	_type2 = "";
	name = "Growlithe";
	updateStats();
	heal();
	allMoves = new String[] {"Bite","Ember","Leer","Take Down","Agility", "Flamethrower"};
	levelLearn = new int[] {1,18,23,30,39,50};
    }

    public Growlithe(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 45) {
	    name = "Arcanine";
	    _hp = 90;
	    _atk = 110;
	    _spatk = 100;
	    _def = 80;
	    _spdef = 80;
	    _spd = 95;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 45) {
	    System.out.println("Your Growlithe has evolved into a Arcanine!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Arcanine";
	    _hp = 90;
	    _atk = 110;
	    _spatk = 100;
	    _def = 80;
	    _spdef = 80;
	    _spd = 95;
	}
    }

    public void moves(int pick, Pokemon enemy){
	String move = moveSet[pick - 1];
	if (move.equals("Bite")){
	    normal = true;
	    setType("normal");
	    power = 60;
	    acc = 100;
	    if (Math.random() * 10 < 1){
		status = true;
		statusName = "flinch";
	    }
	}
	if (move.equals("Ember")){
	    special = true;
	    setType("fire");
	    power = 40;
	    acc = 100;
	    if (Math.random()*10 < 1){
		status = true;
		statusName = "burned";
	    }
	}
	if (move.equals("Leer")){
	    debuff = true;
	    debuffStat = "def";
	    debuffNum = -1;
	    acc = 100;
	}
	if (move.equals("Take Down")){
	    normal = true;
	    setType("normal");
	    power = 90;
	    acc = 85;
	    lowerHp(10);
	    System.out.println(name + " has taken 10 damage from recoil!");
	}
	if (move.equals("Agility")){
	    buff = true;
	    buffStat = "spd";
	    buffNum = 2;
	    acc = 100;
	}
	if (move.equals("Flamethrower")){
	    special = true;
	    setType("fire");
	    power = 95;
	    acc = 100;
	    if (Math.random() * 10 < 1){
	        status = true;
		statusName = "burned";
	    }
	}
    }
}
