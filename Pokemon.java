public abstract class Pokemon {
    
    protected double hp, atk, spatk, def, spdef, spd, acc;
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
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~MUTATOR METHODS~~~~~~~~~~
    public void setAttack(double x) {
	atk = x;
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

    public abstract void moves(int pick, Pokemon ememy);

    public void lowerHp(double x) {
	hp -= x;
    }

    public void levelUp(int xpget) {
	while (xpget >= 0) {
	    xpget = xpget

    public void attack(Pokemon enemy) {
	if (Math.random()*100 < acc){
	    if (spatk == 0){
		enemy.lowerHp(atk - enemy.getDefense());
	    }
	    else if (atk == 0){
		enemy.lowerHp((spatk - enemy.getSpDefense()) * advantage(element,enemy.getElement()));
	    }
	}
    }

    public double advantage(String ele1, String ele2){
	if (ele1.equals("fire")){
	    if (ele2.equals("water")){
		return .5;
	    }
	    if (ele2.equals("grass")){
		return 2;
	    }
	}
	return 1;
    }	    
}
