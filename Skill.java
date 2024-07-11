package PokemonArena;

import PokemonArena.Pokemon;
import org.w3c.dom.Text;

public class Skill {
    public String Name;
    public int Strength;
    public int Accuracy;
    public int UsageLimit;
    public int UsageLeft;
    public String Type;

    public Skill(String name, int strength, int usageLimit, int accuracy, String type) {
        this.Name = name;
        this.Strength = strength;
        this.UsageLimit = usageLimit;
        this.UsageLeft = usageLimit;
        this.Type = type;
    }

    public void refresh() {
        this.UsageLeft = UsageLimit;
    }

    public String getName() { return Name; }

    public int getStrength() { return Strength;}

    public int getUsageLimit() { return UsageLimit;}

    public int getUsageLeft() { return UsageLeft; }

    public int getAccuracy() { return Accuracy; }

    public String getMoveType() { return Type; }

    public void useSkill(Pokemon attacker, Pokemon receiver) {
        if (getUsageLeft() != 0) {
            applyChanges(attacker, receiver);
            this.UsageLeft -= 1;
            printEffectivenessStatements(attacker, receiver);
        }
    }

    public void applyChanges(Pokemon attacker, Pokemon receiver) {
        //System.out.println(attacker.getEffectiveness(attacker, receiver));
        int healthLoss = -getHealthLoss(attacker, receiver);
        receiver.adjustHealth(healthLoss);
    }

    public int getHealthLoss(Pokemon attacker, Pokemon receiver) {
        int healthLoss = (getStrength()/4);
        if (attacker.getEffectiveness(attacker, receiver) == -44) {
            while (attacker.getEffectiveness(attacker, receiver) == -44) {
                attacker.getEffectiveness(attacker, receiver);
            }

        if (attacker.getEffectiveness(attacker, receiver) == 1) {
            healthLoss *= 2;
        }
        else if (attacker.getEffectiveness(attacker, receiver) == -1) {
            healthLoss /= 2;
        }
        else if (attacker.getEffectiveness(attacker, receiver) == -2) {
            healthLoss = 0;
        }

        }
        else {
            healthLoss = (getStrength()/4);
        }
        return healthLoss;
    }

    public void printEffectivenessStatements(Pokemon attacker, Pokemon receiver) {
        if (attacker.getEffectiveness(attacker, receiver) == 1) {
            System.out.println("\u001B[31m" + "***  Super effective!  ***" + "\u001B[0m");
        } else if (attacker.getEffectiveness(attacker, receiver) == -1) {
            System.out.println("\u001B[33m***  Not very effective...  ***\u001B[0m");
        } else if (attacker.getEffectiveness(attacker, receiver) == -2) {
            System.out.println("\u001B[35m***  No effect  ***\u001B[0m");
        }
    }

    public String toString() {
        String returnString = getName() + " " + getUsageLeft() + "/" + getUsageLimit();
        return returnString;
    }



}




