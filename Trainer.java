import java.util.ArrayList;
import cs1.Keyboard;

public class Trainer {
    
    private String name;
    private ArrayList<Pokemon> party, storage;
    private int current, pokeballs;

    public Trainer(String x, Pokemon[] y) {
	name = x;
	party = new ArrayList<Pokemon>();
	for (Pokemon poke: y){
	    party.add(poke);
	}
	current = 0;
	pokeballs = 2;
	storage = new ArrayList<Pokemon>();
    }

    public String getName() {
	return name;
    }

    public Pokemon getPokemon(int partySlot) {
	return party.get(partySlot);
    }

    public Pokemon getCurrent() {
	return party.get(current);
    }

    public int getPokeballs() {
	return pokeballs;
    }

    public void switchPokemon(int x) {
	current = x;
    }

    public void addPokeballs(int x) {
	pokeballs += x;
    }

    public boolean catchPokemon(Pokemon enemy) {
	int catchChance = (int)(Math.random()*enemy.getMaxHp());
	if (catchChance > enemy.getHp()*2) {
	    if (party.size() == 6){
	    	enemy.heal();
	    	storage.add(enemy);
	    }
	    else {
	    	party.add(enemy);
	    }
	    return true;
	}
	return false;
    }
    
    public void printStorage(){
    	int counter = 1;
    	for (Pokemon a:storage){
	    System.out.println("\t" + counter + ". " + a.getName() + "\n");
	    counter += 1;
    	}
    }
    
    public void printParty(){
    	int counter = 1;
    	for (Pokemon a:party){
	    System.out.println("\t" + counter + ". " + a.getName() + "\n");
	    counter += 1;
    	}
    }
    
    public boolean checkRange(int input, int min, int max){
    	return input >= min && input <= max;
    }
    
    public void editParty() throws InterruptedException{
    	boolean done = false;
    	String introMessage = "What would you like to do?\n" 
	    + "\t1. Release Pokemon from storage\n"
	    + "\t2. Edit Party\n" 
	    + "\t3. Leave the Pokemon Center\n"
	    + "---------------------------------------------";
    	System.out.println(introMessage);
    	int input = Keyboard.readInt();
    	int input2 = 0;
    	while (!checkRange(input,1,3)){
	    System.out.println("Invalid Input!");
	    Thread.sleep(1000);
	    System.out.println(introMessage);
	    input = Keyboard.readInt(); 
    	}
	if (input == 3){
	    System.out.println("Leaving the Pokemon center...");
	    done = true;
    	}
    	else if (storage.size() == 0){
	    System.out.println("Sorry! You have no Pokemon in your storage!\n"
			       + "---------------------------------------------");
	    Thread.sleep(1000);	    
    	}
    	else if (input == 1){
	    printStorage();
	    Thread.sleep(1000);
	    System.out.println("Who would you like to release?\n"
			       + "---------------------------------------------");
	    input = Keyboard.readInt();  
	    while (!checkRange(input,1,storage.size())){
		System.out.println("Invalid Input!");
		printStorage();
		Thread.sleep(1000);
		System.out.println("Who would you like to release?\n"
				   + "---------------------------------------------");
		input = Keyboard.readInt(); 
	    }
	    if (checkRange(input,0,storage.size())){
		storage.remove(input - 1);
		System.out.print("You have released " + storage.get(input - 1).getName());
	    } 
    	}
    	else if (input == 2){
	    System.out.println("Choice 2!");
	    printParty();
	    Thread.sleep(1000);
	    System.out.println("Who would you like to switch out?\n"
			       + "---------------------------------------------");
	    input = Keyboard.readInt();
	    while (!checkRange(input,1,party.size())){
		System.out.println("Invalid Input!");
		printParty();
		Thread.sleep(1000);
		System.out.println("Who would you like to switch out?\n"
				   + "---------------------------------------------");
		input = Keyboard.readInt(); 
	    }
	    if (checkRange(input,1,party.size())){
		printStorage();
		Thread.sleep(1000);
		System.out.println("Who would you like to switch with?\n"
				   + "---------------------------------------------");
		input2 = Keyboard.readInt();  
		while (!checkRange(input2,1,storage.size())){
		    System.out.println("Invalid Input!");
		    printStorage();
		    Thread.sleep(1000);
		    System.out.println("Who would you like to switch with?\n"
				       + "---------------------------------------------");
		    input2 = Keyboard.readInt(); 
		}
		if (checkRange(input2,1,storage.size())){
		    System.out.println(party.get(input - 1) + " has been switched with " + storage.get(input2 - 1));
		    party.set(input - 1, storage.set(input2 - 1, party.get(input - 1)));
		    Thread.sleep(1000); 
		}
	    }
    	}
    	if (!done){
	    editParty();
    	}
    }
    
    public void battle(Pokemon x, String y) throws InterruptedException{
        int input = 0;
	int input2 = 0;
        int move = 0;
        int enemyMove = 0;
        System.out.println(y);
        Thread.sleep(1000);
	int maxMoves = 0;
	for (String i: getCurrent().moveSet){
	    if (!i.equals("")){
		maxMoves += 1;
	    }
	}
        while (getCurrent().getHp() != 0 && x.getHp() != 0) {
            move = 0;
            while ((!checkRange(move,1,maxMoves) && !checkRange(move,5,7)) || (move == 7 && !(y.substring(0,1).equals("A"))) || (move == 6 && pokeballs == 0)) {
                System.out.println("What will " + getCurrent() + " do?");
                System.out.println("\t1." + getCurrent().moveSet[0]);
                System.out.println("\t2." + getCurrent().moveSet[1]);
                System.out.println("\t3." + getCurrent().moveSet[2]);
                System.out.println("\t4." + getCurrent().moveSet[3]);
		System.out.println("\t5.Switch Pokemon");
		System.out.println("\t6.Catch");
		System.out.println("\t7.Run");
                move = Keyboard.readInt();
                if (!checkRange(move,1,maxMoves) && !checkRange(move,5,7)) {
		    Thread.sleep(1000);
                    System.out.println("Invalid choice!");
                }
		if (move == 6 && pokeballs == 0) {
		    System.out.println("You don't have any Poke Balls!");
		}
		else if (move == 5) {
		    while (!checkRange(input2,1,party.size()) || party.get(input2-1).getHp() == 0 || input2-1 == current) {
			System.out.println("Choose a Pokemon.");
			for (int i = 0; i < party.size(); i++) {
			    System.out.println("\t" + (i+1) + ". " +  party.get(i) + " HP: " + party.get(i).getHp());
			}
			input2 = Keyboard.readInt();
			if (!checkRange(input2,1,party.size())) {
			    System.out.println("Invalid choice!");
			}
			else if (party.get(input2-1).getHp() == 0) {
			    System.out.println(party.get(input-1) + " has no energy left to battle!");
			}
			else if (input2-1 == current) {
			    System.out.println(getCurrent() + " is already in battle!");
			}
		    }  
		}
		else if (move == 7 && (y.substring(0,1).equals("A"))) {
		    int chance = (int)(Math.random()*101);
		    if (chance < 98) {
			System.out.println("You got away safely!");
			return;
		    }
		    else {
			System.out.println("Unable to escape!");
		    }
		}
		else if (move == 7 && !(y.substring(0,1).equals("A"))) {
		    System.out.println("No! There's no running from a Trainer battle!");
		}
	    }
	    if (move == 5) {
		switchPokemon(input2-1);
		System.out.println("Go! " + getCurrent() + "!");
	    }
	    else if (move == 6) {
		if (!(y.substring(0,1).equals("A"))) {
		    System.out.println(name + " used a Poke Ball.");
		    System.out.println("The Trainer blocked your Poke Ball!");
		    System.out.println("Don't be a thief!");
		}
		else {
		    System.out.println(name + " used a Poke Ball.");
		    pokeballs -= 1;
		    if (catchPokemon(x)) {
			System.out.println("Gotcha!");
			System.out.println("The wild " + x + " was caught!");
			return;
		    }
		    else {
			System.out.println("Oh no! The wild " + x + " broke free!");
		    }
		}
	    }
	    else if (checkRange(move,1, maxMoves)) {
		if (getCurrent().getSpeed() >= x.getSpeed()){		    
		    getCurrent().attack(move,x);
		    if (x.checkDeath()) {
			Thread.sleep(1000);
			System.out.println(x + " fainted!");
			return;
		    }
		    enemyMove = (int)(Math.random()*4 + 1);
		    x.attack(enemyMove,getCurrent());
		    if (getCurrent().checkDeath()) {
			Thread.sleep(1000);
			System.out.println(getCurrent() + " fainted!");
			if (checkParty()) {
			    switchValid(input);
			}
			else {
			    System.out.println("All your Pokemon have fainted!");
			    return;
			}
		    }
		}
		else{
		    enemyMove = (int)(Math.random()*4 + 1);
		    x.attack(enemyMove,getCurrent());
		    if (getCurrent().checkDeath()) {
			Thread.sleep(1000);
			System.out.println(getCurrent() + " fainted!");
			if (checkParty()) {
			    switchValid(input);
			}
			else {
			    System.out.println("All your Pokemon have fainted!");
			    return;
			}
		    }
		    getCurrent().attack(move,x);
		    if (x.checkDeath()) {
			Thread.sleep(1000);
			System.out.println(x + " fainted!");
			return;
		    }
		}
	    }
	}
    }

    public void switchValid(int input){
	while (!checkRange(input,1,party.size()) || party.get(input-1).getHp() == 0) {
	    System.out.println("Battle using which Pokemon?");
	    for (int i = 0; i < party.size(); i++) {
		System.out.println("\t" + (i+1) + ". " +  party.get(i) + " HP: " + party.get(i).getHp());
	    }
	    input = Keyboard.readInt();
	    if (!checkRange(input,1,party.size())) {
		System.out.println("Invalid choice!");
	    }
	    else if (party.get(input-1).getHp() == 0) {
		System.out.println(party.get(input-1) + " has no energy left to battle!");
	    }
	}		
	switchPokemon(input-1);
	System.out.println("Go! " + getCurrent() + "!");
    }

    public boolean checkParty() {
	for (int i = 0; i < party.size(); i++) {
	    if (party.get(i).getHp() != 0) {
		return true;
	    }
	}
	return false;
    }

    public void battle(Trainer x) throws InterruptedException {
	int leaderPokemon = 0;
	while (x.checkParty()) {
	    battle(x.getPokemon(leaderPokemon),x.getName() + " sent out " + x.getCurrent() + "!");
	    leaderPokemon += 1;
	    x.switchPokemon(leaderPokemon);
	}
	System.out.println("You have defeated " + x.getName() + "!");
    }
	    

    public static void main(String[] args) throws InterruptedException {
	Pokemon[] a = new Pokemon[1];
	Pokemon bulbasaur = new Bulbasaur(16);
	a[0] = bulbasaur;
	Pokemon bulbasaur2 = new Bulbasaur(15);
	Pokemon bulbasaur3 = new Bulbasaur(36);
	Pokemon squirtle = new Squirtle(3);
	Pokemon charmander = new Charmander(3);
	Pokemon bulbasaur4 = new Bulbasaur(3);
	Trainer x = new Trainer("Ash",a);
        Trainer y = new Trainer("Bob",a);
	y.party.add(charmander);
	y.party.add(bulbasaur4);
	x.party.add(bulbasaur2);
	x.party.add(bulbasaur3);
	x.party.add(bulbasaur4);
	x.party.add(bulbasaur);
	x.party.add(bulbasaur);
	squirtle.setHp(1);
	x.battle(y);
	x.printParty();
	x.printStorage();
    }

}
