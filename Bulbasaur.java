public class Bulbasaur extends Pokemon {

    public Bulbasaur(){
        _hp = 45;
	_atk = 49;
	_spatk = 65;
	_def = 49;
	_spdef = 65;
	_spd = 45;
	_acc = 100;
	_type = "grass";
	type = "grass";
	type2 = "ice";
	nurseJoy();
	name = "Bulbasaur";
	moveSet = new String[] {"Tackle","Growl","Vine Whip","Take Down"};
	allMoves = new String[] {"Tackle","Growl","Vine Whip","Take Down","Razor Leaf","Double-Edge"};//add all moves later
    }

    public Bulbasaur(int level){
	this();
	lvl = level;
	nurseJoy();
	if (level >= 32) {
	    name = "Venusaur";
	}
	else if (level >= 16) {
	    name = "Ivysaur";
	}
    }

    public void name(int level){
	if (level == 36) {
	    System.out.println("Your Ivysaur has evolved into a Venusaur!");
	    checkPoint();
	    name = "Venusaur";
	}
	if (level == 16) {
	    System.out.println("Your Bulbasuar has evolved into a Venusaur!");
	    checkPoint();
	    name = "Ivysuar";
	}
    }

    public void moves(int pick, Pokemon enemy){
	String move = moveSet[pick - 1];
	if (move.equals("Growl")){
	    atk = 0;
	    spatk = 0;
	    enemy.setAttack(enemy.getAttack() - 5.0);
	}
	if (move.equals("Tackle")){
	    spatk = 0; 
	    setType("normal");
	}
	if (move.equals("Vine Whip")){
	    spatk = 0;
	    setType("grass");
	}
	if (move.equals("Take Down")){
	    spatk = 0;
	    setType("normal");
	}
    }

}
