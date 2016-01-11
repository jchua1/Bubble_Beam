public abstract Pokemon {
    
    protected int hp, atk, spatk, def, spdef, spd, lvl, xp;
    protected String element, name;
    protected String[] moveSet, allMoves;

    public abstract Pokemon();

    public abstract Pokemon(String name, int level);

    //~~~~~~~~~~ACCESSOR METHODS~~~~~~~~~~
    public int getAttack() {
	return atk;
    }

    public int getSpAttack() {
	return spatk;
    }

    public int getDefense() {
	return def;
    }
    
    public int getSpDefense() {
	return spdef;
    }
    
    public int getHp() {
	if (hp < 0) {
	    return 0;
	}
	return hp;
    }

    public int getSpeed() {
	return spd;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~MUTATOR METHODS~~~~~~~~~~
    public void setAttack(int x) {
	atk = x;
    }

    public void setSpAttack(int x) {
	spatk = x;
    }

    public void setDefense(int x) {
	def = x;
    }
    
    public void setSpDefense(int x) {
	spdef = x;
    }

    public void setHp(int x) {
	hp = x;
    }

    public void setSpeed(int x) {
	spd = x;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public void lowerHp(int x) {
	hp -= x;
    }

    public void attack(Pokemon enemy) {
	
