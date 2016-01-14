public class Charmander extends Pokemon {

    public Charmander(){
	_hp = 39;
	_atk = 52;
	_spatk = 60;
	_def = 43;
	_spdef = 50;
	_spd = 65;
	_acc = 100;
	_type = "fire";
	type = "fire";
	nurseJoy();
	name = "Charmander";
	moveSet = new String[] {"Growl","Scratch","Ember","Smokescreen"};
	allMoves = new String[] {"Growl","Scratch","Ember","Smokescreen","Dragon Rage","Scary Face","Fire Fang","Slash","Flamethrower"};
    }

    public Charmander(int level){
	this();
	lvl = level;
	nurseJoy();
	if (level >= 36) {
	    name = "Charizard";
	}
	else if (level >= 16) {
	    name = "Charmeleon";
	}
    }

   public void name(int level){
	if (level == 36) {
	    System.out.println("Your Charmeleon has evolved into a Charizard!");
	    checkPoint();
	    name = "Charizard";
	}
	if (level == 16) {
	    System.out.println("Your Charmander has evolved into a Charmeleon!");
	    checkPoint();
	    name = "Charmeleon";
	}
    }

    public void moves(int pick, Pokemon enemy){
	String move = moveSet[pick - 1];
	if (move.equals("Growl")){
	    atk = 0;
	    spatk = 0;
	    enemy.setAttack(enemy.getAttack() - 5.0);
	}
	if (move.equals("Scratch")){
	    spatk = 0; 
	    setType("normal");
	}
	if (move.equals("Ember")){
	    atk = 0;
	    setType("fire");
	}
	if (move.equals("Smokescreeen")){
	    atk = 0;
	    spatk = 0;
	    enemy.setAccuracy(enemy.getAccuracy() - 10.0);
	}
    }

}
