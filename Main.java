package PokemonArena;

import java.util.Random;

public class Main /*extends PApplet*/ {

    public static Random generator = new Random();
    public static void main(String[] args) {
        // TODO: figure out LinkageError
        //PApplet.main("PokemonArena.Main");
        Pokemon player;
        Pokemon opponent;

// **** Selection of moves ****
        // TODO: add more moves if time
        Skill sk1 = new Skill("VineWhip", 45, 25, 100, Pokemon.types[0]);
        Skill sk2 = new Skill("Leech Seed", 40 /*(1/8* player.getMaxHP())*/, 15, 90, Pokemon.types[0]);
        Skill sk3 = new Skill("Tackle", 40, 35, 100, Pokemon.types[15]);
        Skill sk4 = new Skill("Sleep Powder", 0, 15, 75, Pokemon.types[0]);
        Skill sk5 = new Skill("Ember", 40, 25, 100, Pokemon.types[1]);
        Skill sk6 = new Skill("Scratch", 40, 35, 100, Pokemon.types[15]);
        Skill sk7 = new Skill("Dragon Breath", 60, 20, 100, Pokemon.types[14]);
        Skill sk8 = new Skill("Slash", 70, 20, 100, Pokemon.types[15]);
        Skill sk9 = new Skill("Water Gun", 40, 25, 100, Pokemon.types[2]);
        Skill sk10 = new Skill("Bite", 60, 25, 100, Pokemon.types[10]);
        Skill sk11 = new Skill("Water Pulse", 60, 20, 100, Pokemon.types[2]);
        Skill sk12 = new Skill("Quick Attack", 40, 30, 100, Pokemon.types[15]);
        Skill sk13 = new Skill("Thunder Shock", 40, 30, 100, Pokemon.types[3]);
        Skill sk14 = new Skill("Feint", 30, 10, 100, Pokemon.types[10]);
        Skill sk15 = new Skill("Spark", 65, 20, 100, Pokemon.types[3]);
        Skill sk16 = new Skill("Wing Attack", 60, 35, 100, Pokemon.types[16]);
        Skill sk17 = new Skill("Twister", 40, 20, 100, Pokemon.types[14]);
        Skill sk18 = new Skill("Take Down", 90, 20, 85, Pokemon.types[15]);
        Skill sk19 = new Skill("Crunch", 80, 15, 100, Pokemon.types[10]);
        Skill sk20 = new Skill("Smack Down", 50, 15, 100, Pokemon.types[15]);
        Skill sk21 = new Skill("Rock Slide", 75, 10, 90, Pokemon.types[7]);
        Skill sk22 = new Skill("Bubble Beam", 65, 20, 100, Pokemon.types[2]);
        Skill sk23 = new Skill("Leaf Blade", 90, 15, 100, Pokemon.types[0]);
        Skill sk24 = new Skill("Ancient Power", 60, 5, 100, Pokemon.types[8]);
        Skill sk25 = new Skill("Fire Blast", 110, 5, 85, Pokemon.types[1]);
        Skill sk26 = new Skill("Extrasensory", 80, 20, 100, Pokemon.types[4]);
        Skill sk27 = new Skill("Sacred Fire", 100, 5, 95, Pokemon.types[1]);
        Skill sk28 = new Skill("Night Daze", 85, 10, 95, Pokemon.types[10]);
        Skill sk29 = new Skill("U Turn", 70, 20, 100, Pokemon.types[12]);
        Skill sk30 = new Skill("Knock Off", 65, 20, 100, Pokemon.types[10]);
        Skill sk31 = new Skill("Thunder Fang", 65, 15, 95, Pokemon.types[4]);
        Skill sk32 = new Skill("Thunder", 110, 10, 70, Pokemon.types[4]);


// **** Selection of Pokemon ****
        // TODO: add in levels and more Pokemon if time
        Pokemon pm1 = new Pokemon(Pokemon.nameList[0], 45, 45, Pokemon.types[0], null,new Skill[]{sk1, sk2, sk3, sk4});
        Pokemon pm2 = new Pokemon(Pokemon.nameList[1], 39, 65, Pokemon.types[1], null,new Skill[]{sk5, sk6, sk7, sk8});
        Pokemon pm3 = new Pokemon(Pokemon.nameList[2], 44, 43, Pokemon.types[2], null, new Skill[]{sk3, sk9, sk10, sk11});
        Pokemon pm4 = new Pokemon(Pokemon.nameList[3], 35, 50, Pokemon.types[3], null, new Skill[]{sk12, sk13, sk14, sk15});
        Pokemon pm5 = new Pokemon(Pokemon.nameList[4], 40, 56, Pokemon.types[15], Pokemon.types[16], new Skill[]{sk3, sk12, sk16, sk17});
        Pokemon pm6 = new Pokemon(Pokemon.nameList[5], 30, 72, Pokemon.types[15], null, new Skill[]{sk12, sk10, sk18, sk19});
        Pokemon pm7 = new Pokemon(Pokemon.nameList[6], 35, 70, Pokemon.types[8], Pokemon.types[9], new Skill[]{sk3, sk20, sk21, sk7});
        Pokemon pm8 = new Pokemon(Pokemon.nameList[7], 30, 60, Pokemon.types[2], null, new Skill[]{sk9, sk11, sk7, sk22});
        Pokemon pm9 = new Pokemon(Pokemon.nameList[8], 45, 63, Pokemon.types[0], null, new Skill[]{sk3, sk1, sk2, sk23});
        Pokemon pm10 = new Pokemon(Pokemon.nameList[9],  106, 90, Pokemon.types[1], Pokemon.types[16], new Skill[]{sk24, sk25, sk26, sk27});
        Pokemon pm11 = new Pokemon(Pokemon.nameList[14], 60, 105, Pokemon.types[10], null, new Skill[]{sk6, sk28, sk29, sk30});
        Pokemon pm12 = new Pokemon(Pokemon.nameList[24], 55, 55, Pokemon.types[15], null, new Skill[] {sk3, sk10, sk18, sk12});
        Pokemon pm13 = new Pokemon(Pokemon.nameList[23], 65, 130, Pokemon.types[4], null, new Skill[]{sk18, sk31});

        Pokemon[] pokemonSelection = new Pokemon[] {pm1, pm2, pm3, pm4, pm5, pm6, pm7, pm8, pm9, pm10, pm11, pm12};

// **** Set player's and opponent's Pokemon ****
        int selectedPokemonIndex = generator.nextInt(pokemonSelection.length);
        player = new Pokemon(pokemonSelection[selectedPokemonIndex].getName(),
                pokemonSelection[selectedPokemonIndex].getMaxHP(), pokemonSelection[selectedPokemonIndex].getSpeedScore(),
                pokemonSelection[selectedPokemonIndex].getType1(),
                pokemonSelection[selectedPokemonIndex].getType2(),
                pokemonSelection[selectedPokemonIndex].getMoves());
        selectedPokemonIndex = generator.nextInt(pokemonSelection.length);
        opponent = new Pokemon(pokemonSelection[selectedPokemonIndex].getName(),
                pokemonSelection[selectedPokemonIndex].getMaxHP(), pokemonSelection[selectedPokemonIndex].getSpeedScore(),
                pokemonSelection[selectedPokemonIndex].getType1(),
                pokemonSelection[selectedPokemonIndex].getType2(),
                pokemonSelection[selectedPokemonIndex].getMoves());



        System.out.println("A " + opponent.getName() + " approaches! You send out " + player.getName() + "!");
        while(player.isAlive() && opponent.isAlive()) {
            System.out.println(player.getHP() + " VS " + opponent.getHP() + "\n================\n");

            Battle.battle(player, opponent);
        }

    }

}
