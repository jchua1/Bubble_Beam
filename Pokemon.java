import cs1.Keyboard;

public abstract class Pokemon {
    
    protected double _hp, _atk, _spatk, _def , _spdef, _spd, _acc;
    protected double hp, atk, spatk, def, spdef, spd, acc, power;
    protected int lvl, xp;
    protected String element, name;
    protected String[] moveSet, allMoves;

    //~~~~~~~~~~ACCESSOR METHODS~~~~~~~~~~
    public String getName() {
	return name;
    }

    public double getAttack() {
	return atk;
    }  

    public double getSpAttack() {
	return spatk;
    }

    public double getDefense() {
	return def;
    }
    
    public double getSpDefense() {
	return spdef;
    }
    
    public double getHp() {
	if (hp < 0) {
	    return 0;
	}
	return hp;
    }

    public double getSpeed() {
	return spd;
    }

    public double getAccuracy(){
	return acc;
    }

    public String getElement(){
	return element;
    }

    public int getLevel() {
	return lvl;
    }
    
    public int getXp() {
        return xp;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~MUTATOR METHODS~~~~~~~~~~
    public double setAttack(double x) {
	double ret = atk;
	atk = x;
	return ret;
    }

    public void setSpAttack(double x) {
	spatk = x;
    }

    public void setDefense(double x) {
	def = x;
    }
    
    public void setSpDefense(double x) {
	spdef = x;
    }

    public void setHp(double x) {
	hp = x;
    }

    public void setSpeed(double x) {
	spd = x;
    }

    public void setAccuracy(double x){
	acc = x;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public abstract void moves(int pick, Pokemon enemy);
    
    public void checkPoint(){
	System.out.println("Type f.");
        while (!(Keyboard.readString().equals("f"))){
            System.out.println("Please type f.");
	}
    }
    
    public void lowerHp(double x) {
	hp -= x;
    }

    public void levelUp(int xpget) {
        xp += xpget;
	while (xp >= (lvl*lvl)) {
	    xp -= (lvl * lvl);
	    lvl += 1;
	    System.out.println("Congratulations! " + name + " is now level " + lvl + "!");
	}
    }
	
    public void normalize() {
	atk = _atk;
	spatk = _spatk;
	def = _def;
	spdef = _spdef;
	spd = _spd;
	acc = _acc;
	power = 0;
    }

    public double attack(int move, Pokemon enemy) {
        double damage = 0;
	if (Math.random()*100 < acc){
	    moves(move, enemy);
	    //Buffs and Debuffs
	    if (spatk == 0 && atk == 0){
		damage = 0; 
	    }
	    //Normal Attacks
	    else if (spatk == 0){
		if ((atk - enemy.getDefense()) * advantage(element,enemy.getElement()) < 0) {
		    damage = 1;
		}
		else {
		    damage = (atk - enemy.getDefense()) * advantage(element,enemy.getElement());
		}
	    }
	    //Special Attacks
	    else if (atk == 0){
		if ((spatk - enemy.getSpDefense()) * advantage(element,enemy.getElement()) < 0){
		    damage = 1;
		}
		else {
		    damage = (spatk - enemy.getSpDefense()) * advantage(element,enemy.getElement());
		}
	    }
        }
	System.out.println(name + " used " + moveSet[move-1] + "!");
        enemy.lowerHp(damage);
        normalize();
        enemy.normalize();
    	System.out.println(name + " did " + damage + " damage to " + enemy.getName() + "!");
	checkPoint();
        return damage;
    }
    

    public double advantage(String ele1, String ele2){
	if (ele1.equals("normal")) {
	    if ((ele2.equals("rock"))) {
		return .5;
	    }
	    else if ((ele2.equals("ghost"))) {
		return 0;
	    }
	}
	else if (ele1.equals("fire")){
	    if ((ele2.equals("fire"))
		|| (ele2.equals("water"))
		|| (ele2.equals("rock"))
		|| (ele2.equals("dragon"))) {
		return .5;
	    }
	    else if ((ele2.equals("grass"))
		     || (ele2.equals("ice"))
		     || (ele2.equals("bug"))) {
		return 2;
	    }
	}
	else if (ele1.equals("water")) {
	    if ((ele2.equals("water"))
		|| (ele2.equals("grass"))
		|| (ele2.equals("dragon"))) {
		return .5;
	    }
	    else if ((ele2.equals("fire"))
		     || (ele2.equals("ground"))
		     || (ele2.equals("rock"))) {
		return 2;
	    }
	}		 
	return 1;
    }

    public static void main(String[] args) {
	Pokemon x = new Charmander(3);
	Pokemon y = new Charmander(3);
	x.getAttack();
    }
}
