public class Bulbasaur extends Pokemon {

    public Bulbasaur(){
	hp = 100;
	atk = 30;
	spatk = 30;
	def = 20;
	spdef = 25;
	spd = 30;
	acc = 100;
	lvl = 1;
	type = "grass";
	_hp = hp;
	_atk = atk;
	_spatk = spatk;
	_def = def;
	_spdef = spdef;
	_spd = spd;
	_acc = acc;
	_type = "grass";
	name = "Bulbasaur";
	moveSet = new String[] {"Tackle","Growl","Vine Whip","Take Down"};
	allMoves = new String[] {"Tackle","Growl","Vine Whip","Take Down","Razor Leaf","Double-Edge"};//add all moves later
    }

    public Bulbasaur(int level){
	this();
	lvl = level;
	if (level >= 32) {
	    name = "Venusaur";
	}
	else if (level >= 16) {
	    name = "Ivysaur";
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
