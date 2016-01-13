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
	element = "grass";
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
	}
	if (move.equals("Vine Whip")){
	    spatk = 0;
	}
	if (move.equals("Take Down")){
	    spatk = 0;
	}
    }
    
    public void normalize(){
    	atk = 30;
    	spatk = 30;
    }

    public static void main(String[] args) {
	Pokemon x = new Charmander(3);
	Pokemon y = new Charmander(3);
	Pokemon z = new Bulbasaur(3);
	x.attack(3,y);
	System.out.println(y.getHp());
	x.attack(3,z);
	System.out.println(z.getHp());
    }
}
