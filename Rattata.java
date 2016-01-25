import cs1.Keyboard;

public class Rattata extends Pokemon {

    public Rattata(){
	_hp = 30;
	_atk = 56;
	_spatk = 25;
	_def = 35;
	_spdef = 35;
	_spd = 72;
	acc = 100;
	_type = "normal";
	type = "normal";
	_type2 = "";
	name = "Rattata";
	updateStats();
	heal();
	allMoves = new String[] {"Tackle","Tail Whip","Hyper Fang","Super Fang"};
	levelLearn = new int[] {1,1,14,41};
    }

    public Rattata(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 20) {
	    name = "Raticate";
	    _hp = 55;
	    _atk = 81;
	    _spatk = 50;
	    _def = 60;
	    _spdef = 70;
	    _spd = 97;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 20) {
	    System.out.println("Your Rattata has evolved into a Raticate!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Raticate";
	    _hp = 55;
	    _atk = 81;
	    _spatk = 50;
	    _def = 60;
	    _spdef = 70;
	    _spd = 97;
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
	if (move.equals("Tail Whip")){
	    debuff = true;
	    debuffStat = "def";
	    debuffNum = -1;
	    acc = 100;
	}
	if (move.equals("Hyper Fang")){
	    normal = true;
	    setType("normal");
	    power = 80;
	    acc = 90;
	    if (Math.random()*10 < 1){
		status = true;
		statusName = "flinch";
	    }
	}
	if (move.equals("Super Fang")){
	    enemy.setHp(enemy.getHp() / 2);
	    System.out.println(name + " did " + (enemy.getHp() / 2) + " damage to " + enemy);
	}
    }
}
