import cs1.Keyboard;

public class Game {

    protected Trainer a;
    protected Pokemon x;
    
    public void play() throws InterruptedException{
        int inputI = 0;
	String inputS = "";
	System.out.println("Welcome to the world of Pokemon!");
	Thread.sleep(1000);
	System.out.println("What's your name?");
	Thread.sleep(1000);
	System.out.print("Enter your name: ");
	inputS = Keyboard.readString();
	System.out.println("Your name's " + inputS + "? Excellent!");
	Thread.sleep(1000);
	while ((inputI > 3 ) || (inputI < 1)) {
	    System.out.println("Now pick a Pokemon!");
	    System.out.println("\t1. Bulbasaur\n\t2. Charmander\n\t3. Squirtle");
	    inputI = Keyboard.readInt();
	    if ((inputI > 3) || (inputI < 1)) {
		System.out.println("Invalid choice!");
	    }
	}
	if (inputI == 1) {
	    x = new Bulbasaur(3);
	}
	else if (inputI == 2) {
	    x = new Charmander(3);
	}
	else if (inputI == 3) {
	    x = new Squirtle(3);
	}
	Pokemon[] starter = {x};
	a = new Trainer(inputS, starter);
	Thread.sleep(1000);
        System.out.println("You now have a level 3 " + x.getName() + "!");
	Thread.sleep(1000);
	System.out.println("You're on your way to becoming the Pokemon league champion!");

	Pokemon[] brockPoke = {new Geodude(12),new Onix(14)};
	Pokemon[] mistyPoke = {new Staryu(18),new Staryu(21)};
	Pokemon[] surgePoke = {new Voltorb(21),new Pikachu(18),new Pikachu(24)};
	Pokemon[] erikaPoke = {new Bellsprout(29),new Tangela(24),new Oddish(29)};
	Pokemon[] kogaPoke = {new Koffing(37),new Koffing(37),new Grimer(39),new Koffing(43)};
	Pokemon[] sabrinaPoke = {new Kadabra(38),new Mrmime(37),new Venonat(38),new Kadabra(43)};
	Pokemon[] blainePoke = {new Growlithe(42),new Ponyta(40),new Ponyta(42),new Growlithe(47)};
	Pokemon[] giovanniPoke = {new Rhyhorn(45),new Diglett(42),new NidoranF(44),new NidoranM(45),new Rhyhorn(50)};
	
	Pokemon[] pewterPoke = {new Caterpie(3), new Weedle(3), new Spearow(3), new Pidgey(3)};
	Pokemon[] ceruleanPoke = {new Magikarp(10), new Geodude(10), new Onix(10), new Staryu(10)};
	Pokemon[] vermilionPoke = {new Ekans(15), new Koffing(15), new Grimer(15), new Voltorb(15)};
	Pokemon[] celadonPoke = {new Oddish(20), new Bellsprout(20), new Tangela(20), new NidoranF(20)};
	Pokemon[] fuchsiaPoke = {new Drowzee(25), new Kadabra(25), new Venonat(25), new Porygon(25), new Mrmime(25)};
	Pokemon[] saffronPoke = {new Snorlax(30), new Diglett(30), new Ponyta(30), new Growlithe(30)};
	Pokemon[] cinnabarPoke = {new Pikachu(35), new NidoranM(35), new Mrmime(35), new Magikarp(35)};
	Pokemon[] viridianPoke = {new Dratini(40), new Rhyhorn(40), new Rattata(41), new Oddish(40)};

	Trainer brock = new Trainer("Brock", brockPoke);
	Trainer misty = new Trainer("Misty",mistyPoke);
	Trainer surge = new Trainer("Lt. Surge",surgePoke);
	Trainer erika = new Trainer("Erika",erikaPoke);
	Trainer koga = new Trainer("Koga",kogaPoke);
	Trainer sabrina = new Trainer("Sabrina",sabrinaPoke);
	Trainer blaine = new Trainer("Blaine",blainePoke);
	Trainer giovanni = new Trainer("Giovanni",giovanniPoke);

	City pewter = new City("Pewter City",a, brock,pewterPoke);
	City cerulean = new City("Cerulean City",a, misty,ceruleanPoke);
	City vermilion = new City("Vermilion City",a, surge,vermilionPoke);
	City celadon = new City("Celadon City",a, erika,celadonPoke);
	City fuchsia = new City("Fuchsia City",a, koga,fuchsiaPoke);
	City saffron = new City("Saffron City",a, sabrina,saffronPoke);
	City cinnabar = new City("Cinnabar Island",a, blaine,cinnabarPoke);
	City viridian = new City("Viridian City",a, giovanni,viridianPoke);

	pewter.path();
	a.setBeatLeader(false);
	cerulean.path();
	a.setBeatLeader(false);
	vermilion.path();
	a.setBeatLeader(false);
	celadon.path();
	a.setBeatLeader(false);
	fuchsia.path();
	a.setBeatLeader(false);
	saffron.path();
	a.setBeatLeader(false);
	cinnabar.path();
	a.setBeatLeader(false);
	viridian.path();
	System.out.print("Unfortunately, there is no Elite Four so that's it. Thanks for playing!");
    }
	
	
    public static void main(String[] args) throws InterruptedException{
        Game x = new Game();
        x.play();
    }
}
