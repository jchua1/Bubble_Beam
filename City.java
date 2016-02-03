import cs1.Keyboard;

public class City {
    
    private String name;
    private Trainer gymLeader, self;
    private Pokemon[] wilderness;
    
    public City(String x, Trainer a, Trainer y, Pokemon[] z) {
        name = x;
        self = a;
        gymLeader = y;
        wilderness = z;
    }
    
    public void path() throws InterruptedException {
	while (!self.getBeatLeader()) {
	    int input = 0;
	    System.out.println("You're in " + name + "!");
	    while (input <= 0 || input > 3) {
		System.out.println("What would you like to do?");
		System.out.println("\t1. Battle the gym leader.");
		System.out.println("\t2. Train in the wilderness.");
		System.out.println("\t3. Go to the Pokemon center.");
		input = Keyboard.readInt();
		if (input < 0 || input > 3) {
		    System.out.println("Invalid choice!");
		}
	    }
	    if (input == 1) {
		self.battle(gymLeader);
		
	    }
	    if (input == 2) {
		Pokemon wild = spawn();
		self.battle(wild,"A wild " + wild + " has appeared!");
	    }
	    if (input == 3) {
		self.editParty();
	    }
	}
	return;
    }

    public Pokemon spawn() {
        int x = (int)(Math.random()*wilderness.length);
        return copy(wilderness[x].getName(),wilderness[x].getLevel());
    }

    public Pokemon copy(String x, int level){
	Pokemon a;
	if (x.equals("Bellsprout") || x.equals("Weepinbel") || x.equals("Victreebel") ){
	    a = new Bellsprout(level);
	}
	else if (x.equals("Bulbasaur") || x.equals("Ivysaur") || x.equals("Venusaur") ){
	    a = new Bulbasaur(level);
	}
	else if (x.equals("Caterpie") || x.equals("Metapod") || x.equals("Butterfree") ){
	    a = new Caterpie(level);
	}
	else if (x.equals("Charmander") || x.equals("Charmeleon") || x.equals("Charizard") ){
	    a = new Charmander(level);
	}
	else if (x.equals("Diglett") || x.equals("Dugtrio") ){
	    a = new Diglett(level);
	}
	else if (x.equals("Dratini") || x.equals("Dragonair") || x.equals("Dragonite") ){
	    a = new Dratini(level);
	}
	else if (x.equals("Drowzee") || x.equals("Hypno") ){
	    a = new Drowzee(level);
	}
	else if (x.equals("Ekans") || x.equals("Arbok") ){
	    a = new Ekans(level);
	}
	else if (x.equals("Geodude") || x.equals("Graveler") || x.equals("Golem") ){
	    a = new Geodude(level);
	}
	else if (x.equals("Grimer") || x.equals("Muk") ){
	    a = new Grimer(level);
	}
	else if (x.equals("Growlithe") || x.equals("Arcanine") ){
	    a = new Growlithe(level);
	}
	else if (x.equals("Kadabra") || x.equals("Abra") ){
	    a = new Kadabra(level);
	}
	else if (x.equals("Koffing") || x.equals("Weezing") ){
	    a = new Koffing(level);
	}
	else if (x.equals("Magicarp") || x.equals("Gyarados") ){
	    a = new Magikarp(level);
	}
	else if (x.equals("Mrmime")){
	    a = new Mrmime(level);
	}
	else if (x.equals("NidoranF") || x.equals("Nidorina") || x.equals("Nidoqueen") ){
	    a = new NidoranF(level);
	}
	else if (x.equals("NidoranM") || x.equals("Nidorino") || x.equals("Nidoking") ){
	    a = new NidoranM(level);
	}
	else if (x.equals("Oddish") || x.equals("Gloom") || x.equals("Vileplume") ){
	    a = new Oddish(level);
	}
	else if (x.equals("Onix") || x.equals("Steelix") ){
	    a = new Onix(level);
	}
	else if (x.equals("Pidgey") || x.equals("Pidgeotto") || x.equals("Pidgeot") ){
	    a = new Pidgey(level);
	}
	else if (x.equals("Pikachu") || x.equals("Raichu") ){
	    a = new Pikachu(level);
	}
	else if (x.equals("Ponyta") || x.equals("Rapidash") ){
	    a = new Ponyta(level);
	}
	else if (x.equals("Porygon")){
	    a = new Porygon(level);
	}
	else if (x.equals("Rattata") || x.equals("Raticate") ){
	    a = new Rattata(level);
	}
	else if (x.equals("Rhyhorn") || x.equals("Rhydon") ){
	    a = new Rhyhorn(level);
	}
	else if (x.equals("Snorlax")){
	    a = new Snorlax(level);
	}
	else if (x.equals("Spearow") || x.equals("Spearow") ){
	    a = new Spearow(level);
	}
	else if (x.equals("Squirtle") || x.equals("Wartortle") || x.equals("Blastoise") ){
	    a = new Squirtle(level);
	}
	else if (x.equals("Staryu") || x.equals("Starmie") ){
	    a = new Staryu(level);
	}
	else if (x.equals("Tangela")){
	    a = new Tangela(level);
	}
	else if (x.equals("Venonat") || x.equals("Venomoth") ){
	    a = new Venonat(level);
	}
	else if (x.equals("Voltorb") || x.equals("Electrode") ){
	    a = new Voltorb(level);
	}
	else if (x.equals("Weedle") || x.equals("Kakuna") || x.equals("Beedrill") ){
	    a = new Weedle(level);
	}
	else{
	    a = new Caterpie(level);
	}	
	return a;
    }
}
