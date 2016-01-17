import cs1.Keyboard;

public abstract class Pokemon {
    
    protected double _hp, _atk, _spatk, _def , _spdef, _spd, _acc;
    protected double hp, atk, spatk, def, spdef, spd, acc, power, maxHp;
    protected boolean burned, poisoned, paralysis, leech, flinch, normal, special;
    protected int sleep, toxic, confused;
    protected int lvl, xp;
    protected String type, _type2, _type, name;
    protected String[] moveSet, allMoves;

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

    public double getAccuracy() {
	return acc;
    }

    public double getMaxHp() {
	return maxHp;
    }

    public String getType(){
	return _type;
    }

    public String getType2() {
	return _type2;
    }

    public String getAttackType(){
	return type;
    }
    
    public int getXp() {
        return xp;
    }

    public int getLevel() {
	return lvl;
    }

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

    public void setType(String x) {
	type = x;
    }

    public abstract void moves(int pick, Pokemon enemy);

    public abstract void name(int level) throws InterruptedException;
    
    public void checkPoint(){
	System.out.println("Type f.");
        while (!(Keyboard.readString().equals("f"))){
            System.out.println("Please type f.");
	}
    }
    
    public void lowerHp(double x) {
	hp -= x;
    }

    public void levelUp(int xpget)
	throws InterruptedException {
        xp += xpget;
	while (xp >= (lvl*lvl)) {
	    xp -= (lvl * lvl);
	    lvl += 1;
	    System.out.println("Congratulations! " + name + " is now level " + lvl + "!");
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);	   
	    name(lvl);
	    double a = hp; double b = atk; double c = spatk; double d = def; double e = spdef; double f = spd;
	    updateStats();
	    System.out.println("HP: " + a + " --> " + hp);
	    System.out.println("Atk: " + b + " --> " + atk);
	    System.out.println("Special Attack: " + c + " --> " + spatk);
	    System.out.println("Defense: " + d + " --> " + def);
	    System.out.println("Special Defense: " + e + " --> " + spdef);
	    System.out.println("Speed: " + f + " --> " + spd);
	    System.out.println("---------------------------------------------");
	    Thread.sleep(1000);	   
	}
    }

    public void normalize() {
        normal = false;
	special = false;
	spd = (int)((2 * _spd) * (lvl / 100.0) + 5);
	acc = 100;
    }
	
    public void updateStats() {
	atk = (int)((2 * _atk) * (lvl / 100.0) + 5);
	spatk = (int)((2 * _spatk) * (lvl / 100.0) + 5);
	def = (int)((2 * _def) * (lvl / 100.0) + 5);
	spdef = (int)((2 * _spdef) * (lvl / 100.0) + 5);
	spd = (int)((2 * _spd) * (lvl / 100.0) + 5);
	acc = _acc;
	type = _type;
	power = 0;
	hp = (int)((2 * _hp) * (lvl / 100.0) + lvl + 10);
	maxHp = hp;
    }

    public int attack(int move, Pokemon enemy) throws InterruptedException{
	double damage = 0;
	double defense = 0;
	double attack = 0;
	double modifier = ((Math.random()*16+85)/100) * advantage(_type,enemy.getType());
	if (!enemy.getType2().equals("")) {
	    modifier *= advantage(_type,enemy.getType2());
	}
	status(enemy);
	if (Math.random()*100 < acc){
	    moves(move, enemy);
	    System.out.println(name + " used " + moveSet[move-1] + "!");
	    Thread.sleep(1000);
	    //Buffs and Debuffs
	    if (!normal && !special){
		damage = 0; 
	    }
	    //Dmage-dealing Attacks
	    else {
		if (normal){
		    defense = enemy.getDefense();
		    attack = atk;
		}
		if (special){ 
		    defense = enemy.getSpDefense();
		    attack = spatk;
		}
		if (defense == 0) {
		    defense = 1;
		}
		damage = (((2 * lvl + 10)/250.0) * (attack/defense) * power + 2) * modifier;
		enemy.lowerHp((int)damage);
		System.out.println(name + " did " + (int)damage + " damage to " + enemy.getName() + "!");
	    }
        }
        normalize();
	System.out.println("---------------------------------------------");
	Thread.sleep(1000);
        return (int)damage;
    }

    public void status(Pokemon enemy)throws InterruptedException{
	if (poisoned){
	    lowerHp(maxHp / 8);
	    System.out.println(name + " has been posioned for " + (maxHp / 8) + " damage!");
	    Thread.sleep(1000);
	}
	if (paralysis){
	    //speed decreasing part will be in the enemy's move method
	    if (Math.random() * 4 < 1){
		acc = 0;
		System.out.println(name + " has been paralyzed!");
		Thread.sleep(1000);
	    }
	    paralysis = false;
	}		
	if (burned){
	    //attack decreasing part will be in the enemy's move method
	    lowerHp(maxHp / 8);
	    System.out.println(name + " has been burned for " + (maxHp / 8) + " damage!");
	    Thread.sleep(1000);
	}
	if (sleep > 0){
	    acc = 0;
	    System.out.println(name + " is asleep!");
	    Thread.sleep(1000);
	    sleep -= 1;
	}
	if (toxic > 0){
	    lowerHp(maxHp / 16 * toxic);
	    System.out.println(name + " has been posioned for " + (maxHp / 16 * toxic) + " damage!");
	    Thread.sleep(1000);
	}
	if (confused > 0){
	    if (Math.random() * 2 < 1){
		acc = 0;
		int selfHit = (int)(((2 * lvl + 10)/250.0) * (atk/def) * 40 + 2);
		System.out.println(name + " has attacked itself for " + selfHit + " damage!");
		Thread.sleep(1000);
	    }
	    confused -= 1;
	}
	if (flinch){
	    acc = 0;
	    flinch = false;
	}
	//Only positive effect
	if (leech){
	    lowerHp(0 - (enemy.getMaxHp() / 8));
	    enemy.lowerHp(enemy.getMaxHp() / 8);
	}
    }
    public double advantage(String ele1, String ele2){
	//normal type advantages
	if (ele1.equals("normal")) {
	    if (ele2.equals("ghost")) {
		return 0;
	    }
	    else if (ele2.equals("rock")) {
		return .5;
	    }
	}
	//fire type advantages
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
	//water type advantages
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
	//electric type advantages
	else if (ele1.equals("electric")) {
	    if (ele2.equals("ground")) {
		return 0;
	    }
	    else if ((ele2.equals("electric"))
		     || (ele2.equals("grass")) 
		     || (ele2.equals("dragon"))) {
		return .5;
	    }
	    else if ((ele2.equals("water"))
		     || (ele2.equals("flying"))) {
		return 2;
	    }
	}
	//grarss type advantages
	else if (ele1.equals("grass")) {
	    if ((ele2.equals("fire"))
		|| (ele2.equals("grass"))
		|| (ele2.equals("poison"))
		|| (ele2.equals("flying"))
		|| (ele2.equals("bug"))
		|| (ele2.equals("dragon"))) {
		return .5;
	    }
	    else if ((ele2.equals("water"))
		     || (ele2.equals("ground"))
		     || (ele2.equals("rock"))) {
		return 2;
	    }
	}
	//ice type advantages
	else if (ele1.equals("ice")) {
	    if ((ele2.equals("water"))
		|| (ele2.equals("ice"))) {
		return .5;
	    }
	    else if ((ele2.equals("grass"))
		     || (ele2.equals("ground"))
		     || (ele2.equals("flying"))
		     || (ele2.equals("dragon"))) {
		return 2;
	    }
	}
	//fighting type advantages
	else if (ele1.equals("fighting")) {
	    if (ele2.equals("ghost")) {
		return 0;
	    }
	    else if ((ele2.equals("poison"))
		     || (ele2.equals("flying"))
		     || (ele2.equals("psychic")) 
		     || (ele2.equals("bug"))) {
		return .5;
	    }
	    else if ((ele2.equals("normal"))
		     || (ele2.equals("ice"))
		     || (ele2.equals("rock"))) {
		return 2;
	    }
	}
	//poison type advantages
	else if (ele1.equals("poison")) {
	    if ((ele2.equals("poison"))
		|| (ele2.equals("ground"))
		|| (ele2.equals("rock"))
		|| (ele2.equals("ghost"))) {
		return .5;
	    }
	    else if ((ele2.equals("grass"))
		     || (ele2.equals("bug"))) {
		return 2;
	    }
	}
	//ground type advantages
	else if (ele1.equals("ground")) {
	    if (ele2.equals("flying")) {
		return 0;
	    }
	    else if ((ele2.equals("grass"))
		     || (ele2.equals("bug"))) {
		return .5;
	    }
	    else if ((ele2.equals("fire"))
		     || (ele2.equals("electric"))
		     || (ele2.equals("poison"))
		     || (ele2.equals("rock"))) {
		return 2;
	    }
	}
	//flying type advantages
	else if (ele1.equals("flying")) {
	    if ((ele2.equals("electric"))
		|| (ele2.equals("rock"))) {
		return .5;
	    }
	    else if ((ele2.equals("grass"))
		     || (ele2.equals("fighting"))
		     || (ele2.equals("bug"))) {
		return 2;
	    }
	}
	//psychic type advantages
	else if (ele1.equals("psychic")) {
	    if (ele2.equals("psychic")) {
		return .5;
	    }
	    else if ((ele2.equals("fighting"))
		     || (ele2.equals("poison"))) {
		return 2;
	    }
	}
	//bug type advantages
	else if (ele1.equals("bug")) {
	    if ((ele2.equals("fire"))
		|| (ele2.equals("fighting"))
		|| (ele2.equals("flying"))) {
		return .5;
	    }
	    else if ((ele2.equals("grass"))
		     || (ele2.equals("poison"))
		     || (ele2.equals("psychic"))) {
		return 2;
	    }
	}
	//rock type advantages
	else if (ele1.equals("rock")) {
	    if ((ele2.equals("fighting"))
		|| (ele2.equals("ground"))) {
		return .5;
	    }
	    else if ((ele2.equals("fire"))
		     || (ele2.equals("ice"))
		     || (ele2.equals("flying"))
		     || (ele2.equals("bug"))) {
		return 2;
	    }
	}
	//ghost type advantages
	else if (ele1.equals("ghost")) {
	    if ((ele2.equals("normal"))
		|| (ele2.equals("psychic"))) {
		return 0;
	    }
	    else if (ele2.equals("ghost")) {
		return 2;
	    }
	}
	//dragon type advantages
	else if (ele1.equals("dragon")) {
	    if (ele2.equals("dragon")) {
		return 2;
	    }
	}
	//returns 1 if no type advantage
	return 1;
    }

    public static void main(String[] args) throws InterruptedException {
	Pokemon x = new Charmander(14);
	//x.levelUp(100000);
	Pokemon y = new Bulbasaur(14);
	x.attack(3,y);
    }
}
