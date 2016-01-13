public class Charmander extends Pokemon {

    public Charmander(){
	hp = 100;
	atk = 30;
	spatk = 30;
	def = 20;
	spdef = 25;
	spd = 30;
	acc = 100;
	lvl = 1;
	element = "fire";
	name = "Charmander";
	moveSet = new String[] {"Growl","Scratch","Ember","Smokescreen"};
	allMoves = new String[] {"Growl","Scratch","Ember","Smokescreen","Dragon Rage","Scary Face","Fire Fang","Slash","Flamethrower"};
    }

    public Charmander(int level){
	this();
	lvl = level;
	if (level >= 36) {
	    name = "Charizard";
	}
	else if (level >= 16) {
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
	}
	if (move.equals("Ember")){
	    atk = 0;
	}
	if (move.equals("Smokescreeen")){
	    atk = 0;
	    spatk = 0;
	    enemy.setAccuracy(enemy.getAccuracy() - 10.0);
	}
    }
    
    public void normalize(){
    	atk = 30;
    	spatk = 30;
    }

    public static void main(String[] args) {
    	Pokemon x = new Charmander(2);
    	Pokemon y = new Charmander(5);
	System.out.println(x.getName());
	System.out.println(x.getHp());
    	System.out.println(x.getXp());
    	System.out.println(x.getLevel());
    	x.levelUp(15);
    	System.out.println(x.getLevel());
    	System.out.println(x.getXp());
    	x.attack(2,y);
    	y.attack(3,x);
    	System.out.println(x.getHp());
    	System.out.println(y.getHp());
    }
}
