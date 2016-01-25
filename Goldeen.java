import cs1.Keyboard;

public class Goldeen extends Pokemon {

    public Goldeen(){
        _hp = 20;
	_atk = 10;
	_spatk = 15;
	_def = 55;
	_spdef = 20;
	_spd = 80;
	acc = 100;
	_type = "water";
	type = "water";
	_type2 = "";
	name = "Goldeen";
	updateStats();
	heal();
	allMoves = new String[] {"Tackle","Bite","Dragon Rage","Leer","Hydro Pump","Hyper Beam"};
	levelLearn = new int[] {1,20,25,32,41,52};
    }

    public Goldeen(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 33) {
	    name = "Seaking";
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 20) {
	    System.out.println("Your Magikarp has evolved into Gyarados!");
	    System.out.println("---------------------------------------------");
	    name = "Gyarados";
	    _hp = 95;
	    _atk = 125;
	    _spatk = 60;
	    _def = 79;
	    _spdef = 100;
	    _spd = 81;
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
	if (move.equals("Leer")){
	    debuff = true;
	    buffStat = "def";
	    debuffNum = -1;
	    acc = 100;
	}
	if (move.equals("Bite")){
	    normal = true;
	    setType("normal");
	    power = 60;
	    acc = 100;
	    if (Math.random()*101 <= 10) {
		status = true;
		statusName = "flinch";
	    }
	}
	if (move.equals("Hydro Pump")) {
	    special = true;
	    setType("water");
	    power = 110;
	    acc = 80;
	}
	if (move.equals("Dragon Rage")) {
	    enemy.lowerHp(40);
	    System.out.println(name + " did 40 damage to " + enemy.getName());
	}
	if (move.equals("Hyper Beam")) {
	    special = true;
	    setType("normal");
	    power = 150;
	    acc = 50;
	}
    }
}
