package PokemonArena;

import java.util.Random;
import java.util.Scanner;

public class Pokemon {
    public String Name;
    public int Strength;
    public int MaxHP;
    public int CurrHP;
    public Skill[] Moves;
    public int MoveIndex;
    public double SpeedScore;
    public double NextTurnTime;
    public String Type1;
    public String Type2;
    public int choice;
    public String MoveType;

    Random generator = new Random();
    Scanner attackChoiceInput = new Scanner(System.in);

    public static String[] nameList = {"Bulbasaur", "Charmander", "Squirtle", "Pikachu", "Pidgey", "Rattata", "Onix",
            "Horsea", "Snivy", "Ho-Oh", "Articuno", "Mewtwo", "Meowth", "Garbodor", "Zororark", "Ivysaur", "Charizard",
            "Ekans", "Arbok", "Vulpix", "Butterfree", "Caterpie", "Kakuna", "Jolteon", "Eevee", "Voltorb", "Haunter",
            "Gastly", "Gengar", "Wartortle"};


    public static String[] types = {"Grass", "Fire", "Water", "Electric", "Psychic", "Poison", "Fighting", "Rock",
            "Ground", "Ice", "Dark", "Fairy", "Bug", "Steel", "Dragon", "Normal", "Flying"};

    public Pokemon() {
        this.Name = nameList[Main.generator.nextInt(nameList.length)];
    }

    public Pokemon(String name, int maxHP, double speedScore, String type1, String type2, Skill[] moves) {
        this();
        this.MaxHP = maxHP;
        this.CurrHP = maxHP;
        this.SpeedScore = speedScore;
        this.Name = name;
        this.Moves = moves;
        this.Type1 = type1;
        this.Type2 = type2;
    }

    public Pokemon(Pokemon pokemon) {

    }

    public int getStrength() {
        return Strength;
    }

    public double getNextTurnTime() {
        return NextTurnTime;
    }

    public int getMaxHP() {
        return MaxHP;
    }

    public double getSpeedScore() {
        return SpeedScore;
    }

    public String getName() {
        return Name;
    }

    public int getHP() {
        return CurrHP;
    }

    public String getType1() {
        return this.Type1;
    }

    public String getType2() {
        return this.Type2;
    }

    public Skill[] getMoves() {
        return Moves;
    }

    public String getMoveType() {
        return MoveType;
    }

    public void prepForBattle() {
        this.CurrHP = getMaxHP();
        this.NextTurnTime = getSpeedScore();
        this.MoveIndex = -1;
        for (int i = 0; i < Moves.length; i++) {
            Moves[i].refresh();
        }
    }

    public void setNextTurnTime(double nextTurnTime) {
        this.NextTurnTime = nextTurnTime;
    }

    public Skill takeTurn(Pokemon attacker, Pokemon player) {
        setNextTurnTime(this.SpeedScore + getNextTurnTime());
        if (MoveIndex >= Moves.length - 1) {
            MoveIndex = -1;
        }
        if (attacker.equals(player)) {
            //System.out.println(attacker);
            System.out.println("\nChoose an attack: \n" +
                    "1. " + this.getMoves()[0] + " (Power: " + getMoves()[0].getStrength() + ")" + " \n2. "
                    + this.getMoves()[1] + " (Power: " + getMoves()[1].getStrength() + ")  \n3. "
                    + this.getMoves()[2] + " (Power: " + getMoves()[2].getStrength() + ") \n4. "
                    + this.getMoves()[3] + " (Power: " + getMoves()[3].getStrength() + ")");
            choice = Integer.valueOf(attackChoiceInput.nextLine());
            return Moves[choice - 1];
        } else {
            return Moves[generator.nextInt(4)];
        }
    }


    public void adjustHealth(int amount) {
        this.CurrHP += amount;
        if (this.CurrHP > getMaxHP()) {
            this.CurrHP = MaxHP;
        }
        if (this.CurrHP <= 0) {
            this.CurrHP = 0;
        }
    }

    public String toString() {
        String returnString = getName() + " " + getHP() + "/" + getMaxHP();
        return returnString;
    }

    public boolean isAlive() {
        return this.CurrHP > 0;
    }

    public int calculateDamage(Pokemon attacker) {
        return (attacker.getStrength() / 4);
    }

    public int getEffectiveness(Pokemon one, Pokemon two) {
        int effectiveness = -44;
        if (((one.takeTurn(one, two).getMoveType() == "Fire") && ((two.getType1() == "Grass") || two.getType2() == "Grass"))) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Fire") && ((two.getType1() == "Ice") || two.getType2() == "Ice"))) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Fire") && ((two.getType1() == "Bug") || two.getType2() == "Bug"))) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Fire") && ((two.getType1() == "Steel") || two.getType2() == "Steel"))) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Water")) && ((two.getType1() == "Fire") || two.getType2() == "Fire")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Water")) && ((two.getType1() == "Ground") || two.getType2() == "Ground")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Water")) && ((two.getType1() == "Rock") || two.getType2() == "Rock")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Electric")) && ((two.getType1() == "Water") || two.getType2() == "Water")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Electric")) && ((two.getType1() == "Flying") || two.getType2() == "Flying")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Grass")) && ((two.getType1() == "Water") || two.getType2() == "Water")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Grass")) && ((two.getType1() == "Ground") || two.getType2() == "Ground")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Grass")) && ((two.getType1() == "Rock") || two.getType2() == "Rock")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Ice")) && ((two.getType1() == "Grass") || two.getType2() == "Grass")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Ice")) && ((two.getType1() == "Ground") || two.getType2() == "Ground")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Ice")) && ((two.getType1() == "Flying") || two.getType2() == "Flying")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Ice")) && ((two.getType1() == "Dragon") || two.getType2() == "Dragon")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Fighting")) && ((two.getType1() == "Normal") || two.getType2() == "Normal")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Fighting")) && ((two.getType1() == "Ice") || two.getType2() == "Ice")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Fighting")) && ((two.getType1() == "Rock") || two.getType2() == "Rock")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Fighting")) && ((two.getType1() == "Dark") || two.getType2() == "Dark")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Fighting")) && ((two.getType1() == "Steel") || two.getType2() == "Steel")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Poison")) && ((two.getType1() == "Grass") || two.getType2() == "Grass")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Poison")) && ((two.getType1() == "Fairy") || two.getType2() == "Fairy")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Ground")) && ((two.getType1() == "Fire") || two.getType2() == "Fire")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Ground")) && ((two.getType1() == "Electric") || two.getType2() == "Electric")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Ground")) && ((two.getType1() == "Poison") || two.getType2() == "Poison")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Ground")) && ((two.getType1() == "Rock") || two.getType2() == "Rock")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Ground")) && ((two.getType1() == "Steel") || two.getType2() == "Steel")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Flying")) && ((two.getType1() == "Grass") || two.getType2() == "Grass")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Flying")) && ((two.getType1() == "Fighting") || two.getType2() == "Fighting")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Flying")) && ((two.getType1() == "Bug") || two.getType2() == "Bug")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Psychic")) && ((two.getType1() == "Fighting") || two.getType2() == "Fighting")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Psychic")) && ((two.getType1() == "Poison") || two.getType2() == "Poison")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Bug")) && ((two.getType1() == "Grass") || two.getType2() == "Grass")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Bug")) && ((two.getType1() == "Psychic") || two.getType2() == "Psychic")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Bug")) && ((two.getType1() == "Fighting") || two.getType2() == "Fighting")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Rock")) && ((two.getType1() == "Fire") || two.getType2() == "Fire")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Rock")) && ((two.getType1() == "Ice") || two.getType2() == "Ice")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Rock")) && ((two.getType1() == "Flying") || two.getType2() == "Flying")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Rock")) && ((two.getType1() == "Bug") || two.getType2() == "Bug")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Ghost")) && ((two.getType1() == "Psychic") || two.getType2() == "Psychic")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Ghost")) && ((two.getType1() == "Ghost") || two.getType2() == "Ghost")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Dragon")) && ((two.getType1() == "Dragon") || two.getType2() == "Dragon")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Dark")) && ((two.getType1() == "Psychic") || two.getType2() == "Psychic")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Dark")) && ((two.getType1() == "Ghost") || two.getType2() == "Ghost")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Steel")) && ((two.getType1() == "Ice") || two.getType2() == "Ice")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Steel")) && ((two.getType1() == "Rock") || two.getType2() == "Rock")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Steel")) && ((two.getType1() == "Fairy") || two.getType2() == "Fairy")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Fairy")) && ((two.getType1() == "Dragon") || two.getType2() == "Dragon")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Fairy")) && ((two.getType1() == "Fighting") || two.getType2() == "Fighting")) {
            effectiveness = 1;
        } else if (((one.takeTurn(one, two).getMoveType() == "Fairy")) && ((two.getType1() == "Dark") || (two.getType2() == "Dark"))) {
            effectiveness = 1;
        }
        // *** Not very effective... ***
        else if ((one.takeTurn(one, two).getMoveType() == "Normal")) {
            if ((two.getType1() == "Rock") || (two.getType2() == "Rock")) {
                effectiveness = -1;
            } else if ((two.getType1() == "Steel") || two.getType2() == "Steel") {
                effectiveness = -1;
            }
        } else if ((one.takeTurn(one, two).getMoveType() == "Fire")) {
            if ((two.getType1() == "Fire") || (two.getType2() == "Fire")) {
                effectiveness = -1;
            } else if ((two.getType1() == "Water") || (two.getType2() == "Water")) {
                effectiveness = -1;
            } else if ((two.getType1() == "Rock") || (two.getType2() == "Rock")) {
                effectiveness = -1;
            } else if ((two.getType1() == "Dragon") || (two.getType2() == "Dragon")) {
                effectiveness = -1;
            }
        } else if ((one.takeTurn(one, two).getMoveType() == "Water")) {
            if ((two.getType1() == "Water") || (two.getType2() == "Water")) {
                effectiveness = -1;
            } else if ((two.getType1() == "Grass") || (two.getType2() == "Grass")) {
                effectiveness = -1;
            } else if ((two.getType1() == "Dragon") || (two.getType2() == "Dragon")) {
                effectiveness = -1;
            }
        } else if ((one.takeTurn(one, two).getMoveType() == "Electric")) {
            if ((two.getType1() == "Electric") || (two.getType2() == "Electric")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Grass") || (two.getType2() == "Grass")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Dragon") || (two.getType2() == "Dragon")) {
                    effectiveness = -1;
                }
        } else if ((one.takeTurn(one, two).getMoveType() == "Grass")) {
                if ((two.getType1() == "Fire") || (two.getType2() == "Fire")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Grass") || (two.getType2() == "Grass")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Poison") || (two.getType2() == "Poison")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Flying") || (two.getType2() == "Flying")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Bug") || (two.getType2() == "Bug")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Dragon") || (two.getType2() == "Dragon")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Steel") || (two.getType2() == "Steel")) {
                    effectiveness = -1;
                }
        } else if ((one.takeTurn(one, two).getMoveType() == "Ice")) {
                if ((two.getType1() == "Fire") || (two.getType2() == "Fire")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Water") || (two.getType2() == "Water")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Ice") || (two.getType2() == "Ice")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Steel") || (two.getType2() == "Steel")) {
                    effectiveness = -1;
                }
        } else if ((one.takeTurn(one, two).getMoveType() == "Fighting")) {
                if ((two.getType1() == "Poison") || (two.getType2() == "Poison")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Flying") || (two.getType2() == "Flying")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Psychic") || (two.getType2() == "Psychic")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Bug") || (two.getType2() == "Bug")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Fairy") || (two.getType2() == "Fairy")) {
                    effectiveness = -1;
                }
        } else if ((one.takeTurn(one, two).getMoveType() == "Poison")) {
                if ((two.getType1() == "Poison") || (two.getType2() == "Poison")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Ground") || (two.getType2() == "Ground")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Rock") || (two.getType2() == "Rock")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Dragon") || (two.getType2() == "Dragon")) {
                    effectiveness = -1;
                }
        } else if ((one.takeTurn(one, two).getMoveType() == "Ground")) {
                if ((two.getType1() == "Grass") || (two.getType2() == "Grass")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Bug") || (two.getType2() == "Bug")) {
                    effectiveness = -1;
                }
        } else if ((one.takeTurn(one, two).getMoveType() == "Flying")) {
                if ((two.getType1() == "Electric") || (two.getType2() == "Electric")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Rock") || (two.getType2() == "Rock")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Steel") || (two.getType2() == "Steel")) {
                    effectiveness = -1;
                }
        } else if ((one.takeTurn(one, two).getMoveType() == "Psychic")) {
                if ((two.getType1() == "Psychic") || (two.getType2() == "Psychc")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Steel") || (two.getType2() == "Steel")) {
                    effectiveness = -1;
                }
        } else if ((one.takeTurn(one, two).getMoveType() == "Bug")) {
                if ((two.getType1() == "Flying") || (two.getType2() == "Flying")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Grass") || (two.getType2() == "Grass")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Fighting") || (two.getType2() == "Fighting")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Poison") || (two.getType2() == "Poison")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Ghost") || (two.getType2() == "Ghost")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Steel") || (two.getType2() == "Steel")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Fairy") || (two.getType2() == "Fairy")) {
                    effectiveness = -1;
                }
        } else if ((one.takeTurn(one, two).getMoveType() == "Rock")) {
                if ((two.getType1() == "Fighting") || (two.getType2() == "Fighting")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Ground") || (two.getType2() == "Ground")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Steel") || (two.getType2() == "Steel")) {
                    effectiveness = -1;
                }
        } else if ((one.takeTurn(one, two).getMoveType() == "Ghost")) {
                if ((two.getType1() == "Dark") || (two.getType2() == "Dark")) {
                    effectiveness = -1;
                }
        } else if ((one.takeTurn(one, two).getMoveType() == "Dark")) {
                if ((two.getType1() == "Fighting") || (two.getType2() == "Fighting")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Dark") || (two.getType2() == "Dark")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Fairy") || (two.getType2() == "Fairy")) {
                    effectiveness = -1;
                }
        } else if ((one.takeTurn(one, two).getMoveType() == "Steel")) {
                if ((two.getType1() == "Fire") || (two.getType2() == "Fire")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Water") || (two.getType2() == "Water")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Electric") || (two.getType2() == "Electric")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Steel") || (two.getType2() == "Steel")) {
                    effectiveness = -1;
                }
        } else if ((one.takeTurn(one, two).getMoveType() == "Fairy")) {
                if ((two.getType1() == "Fire") || (two.getType2() == "Fire")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Poison") || (two.getType2() == "Poison")) {
                    effectiveness = -1;
                } else if ((two.getType1() == "Steel") || (two.getType2() == "Steel")) {
                    effectiveness = -1;
                }
            }

        // *** No effect ***
            else if (((one.takeTurn(one, two).getMoveType() == "Normal")) && ((two.getType1() == "Ghost") || (two.getType2() == "Ghost"))) {
                    effectiveness = -2;
            } else if (((one.takeTurn(one, two).getMoveType() == "Electric")) && ((two.getType1() == "Ground") || (two.getType2() == "Ghost"))) {
                effectiveness = -2;
            } else if (((one.takeTurn(one, two).getMoveType() == "Fighting")) && ((two.getType1() == "Ghost") || (two.getType2() == "Ghost"))) {
                effectiveness = -2;
            } else if (((one.takeTurn(one, two).getMoveType() == "Poison")) && ((two.getType1() == "Steel") || (two.getType2() == "Steel"))) {
                effectiveness = -2;
            } else if (((one.takeTurn(one, two).getMoveType() == "Ground")) && ((two.getType1() == "Flying") || (two.getType2() == "Flying"))) {
                effectiveness = -2;
            } else if (((one.takeTurn(one, two).getMoveType() == "Psychic")) && ((two.getType1() == "Dark") || (two.getType2() == "Dark"))) {
                effectiveness = -2;
            } else if (((one.takeTurn(one, two).getMoveType() == "Ghost")) && ((two.getType1() == "Normal") || (two.getType2() == "Normal"))) {
                effectiveness = -2;
            } else if (((one.takeTurn(one, two).getMoveType() == "Dragon")) && ((two.getType1() == "Fairy") || (two.getType2() == "Fairy"))) {
                effectiveness = -2;
            } else {
                effectiveness = 0;
        }
                return effectiveness;
        }
    }

