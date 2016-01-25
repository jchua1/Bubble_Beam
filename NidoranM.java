import cs1.Keyboard;

public class NidoranM extends Pokemon {

    public NidoranM(){
	_hp = 46;
	_atk = 57;
	_spatk = 40;
	_def = 40;
	_spdef = 40;
	_spd = 50;
	acc = 100;
	_type = "poison";
	type = "poison";
	_type2 = "";
	name = "NidoranM";
	updateStats();
	heal();
	allMoves = new String[] {"Tackle","Horn Attack","Double Kick","Poison Sting","Thrash"};
	levelLearn = new int[] {1,8,12,14,23};
    }

    public NidoranM(int level){
	this();
	lvl = level;
	giveMoves(level);
	if (level >= 32) {
	    name = "Nidoking";
	    _type2 = "ground";
	    _hp = 81;
	    _atk = 92;
	    _spatk = 85;
	    _def = 77;
	    _spdef = 75;
	    _spd = 85;
	}
	else if (level >= 16) {
	    name = "Nidorino";
	    _hp = 61;
	    _atk = 72;
	    _spatk = 55;
	    _def = 57;
	    _spdef = 55;
	    _spd = 65;
	}
	updateStats();
	heal();
    }

    public void name(int level) throws InterruptedException{
	if (level == 32) {
	    System.out.println("Your Nidorino has evolved into a Nidoking!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Nidoking";
	    _type2 = "ground";
	    _hp = 81;
	    _atk = 92;
	    _spatk = 85;
	    _def = 77;
	    _spdef = 75;
	    _spd = 85;
	}
	if (level == 16) {
	    System.out.println("Your NidoranM has evolved into a Nidorino!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);
	    name = "Nidorino";
	    _hp = 61;
	    _atk = 72;
	    _spatk = 55;
	    _def = 57;
	    _spdef = 55;
	    _spd = 65;
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
	if (move.equals("Horn Attack")){
	    normal = true;
	    setType("normal");
	    power = 65;
	    acc = 100;
	}
	if (move.equals("Double Kick")){
	    special = true;
	    setType("fighting");
	    power = 60;
	    acc = 100;
	}
	if (move.equals("Poison Sting")) {
	    special = true;
	    setType("poison");
	    power = 15;
	    acc = 100;
	    if (Math.random() * 10 < 3){
		status = true;
		statusName = "poisoned";
	    }
	}
	if (move.equals("Thrash")){
	    normal = true;
	    setType("normal");
	    power = 90 * (int)(Math.random()*2 + 3);
	    acc = 100;
	    confused = 4;
	    System.out.println(name + " has been confused!");
	}
    }
}
