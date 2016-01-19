public class Trainer {
    
    private String name;
    private Pokemon[] party;
    private int current, pokeballs;

    public Trainer(String x, Pokemon y) {
	name = x;
	party = new Pokemon[6];
	party[0] = y;
	current = 0;
	pokeballs = 0;
    }

    public Pokemon getPokemon(int partySlot) {
	return party[partySlot];
    }

    public Pokemon getCurrent() {
	return party[current];
    }

    public int getPokeballs() {
	return pokeballs;
    }

    public void setPokemon(int partySlot, Pokemon x) {
	party[partySlot] = x;
    }

    public void switchPokemon(int x) {
	current = x;
    }

    public void addPokeballs(int x) {
	pokeballs += x;
    }

    public static void main(String[] args) {
	Pokemon charmander = new Charmander(16);
	Pokemon bulbasaur = new Bulbasaur(16);
	Pokemon squirtle = new Squirtle(16);
	Trainer x = new Trainer("Ash",charmander);
	System.out.println(x.getPokemon(0));
	System.out.println(x.getCurrent());
	x.setPokemon(1,bulbasaur);
	x.setPokemon(2,squirtle);
	System.out.println(x.getPokemon(1));
	System.out.println(x.getPokemon(2));
	x.switchPokemon(1);
	System.out.println(x.getCurrent());
	x.switchPokemon(2);
	System.out.println(x.getCurrent());
	System.out.println(x.getPokeballs());
	x.addPokeballs(5);
	System.out.println(x.getPokeballs());
    }

}

    
