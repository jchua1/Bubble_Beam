public class Charmander extends Pokemon {

    public Charmander(){
	_hp = 39;
	_atk = 52;
	_spatk = 60;
	_def = 43;
	_spdef = 50;
	_spd = 65;
	acc = 100;
	_type = "fire";
	type = "fire";
	_type2 = "";
	updateStats();
	name = "Charmander";
	moveSet = new String[] {"Scratch","Growl","Ember","Leer"};
	allMoves = new String[] {"Scratch","Growl","Ember","Leer","Rage","Slash","Flamethrower","Fire Spin"};
    }

    public Charmander(int level){
	this();
	lvl = level;
	updateStats();
	if (level >= 36) {
	    name = "Charizard";
	    _hp = 78;
	    _atk = 84;
	    _spatk = 109;
	    _def = 78;
	    _spdef = 85;
	    _spd = 100;
	}
	else if (level >= 16) {
	    name = "Charmeleon";
	    _hp = 58;
	    _atk = 64;
	    _spatk = 80;
	    _def = 58;
	    _spdef = 65;
	    _spd = 80;
	}
    }

    public void name(int level) throws InterruptedException {
	if (level == 36) {
	    System.out.println("Your Charmeleon has evolved into a Charizard!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);	   
	    name = "Charizard";
	    _hp = 78;
	    _atk = 84;
	    _spatk = 109;
	    _def = 78;
	    _spdef = 85;
	    _spd = 100;
	}
	if (level == 16) {
	    System.out.println("Your Charmander has evolved into a Charmeleon!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);	   
	    name = "Charmeleon";
	    _hp = 58;
	    _atk = 64;
	    _spatk = 80;
	    _def = 58;
	    _spdef = 65;
	    _spd = 80;
	}
    }

    public void moves(int pick, Pokemon enemy){
	String move = moveSet[pick - 1];
	if (move.equals("Growl")){
	    enemy.setAtkStage(-1);
	    acc = 100; 
	    System.out.println(enemy.getName() + "'s attack fell!");
	    //NOTE TO SELF: FIX INTERACTION BETWEEN ACC AND STAGE ALTERATION
	}
	if (move.equals("Scratch")){
	    normal = true;
	    setType("normal");
	    power = 40;
	    acc = 100;
	}
	if (move.equals("Ember")){
	    special = true;
	    setType("fire");
	    power = 40;
	    acc = 100;
	}
	if (move.equals("Leer")){
	    enemy.setDefStage(-1);
	    System.out.println(enemy.getName() + "'s defense fell!");
	}
    }

}
