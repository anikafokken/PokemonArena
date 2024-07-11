package PokemonArena;

public class Battle {
    public static void doOneTurn(Pokemon one, Pokemon two) {
        Pokemon player;
        Pokemon opponent;
        Skill move;
        if (one.getNextTurnTime() < two.getNextTurnTime() || one.getNextTurnTime() == two.getNextTurnTime()) {
            player = one;
            opponent = two;
        }
        else {
            player = two;
            opponent = one;
        }
        move = one.takeTurn(one, one);
        //System.out.println(one.getEffectiveness(one, two));
        int damage = move.getHealthLoss(one, two);

        System.out.println(player + " HP, "+opponent + " HP\n");
        move.useSkill(one, two);
        System.out.println(one.toString() + " uses " + move.toString() + " on " + two.toString() + " for " + damage + " damage.");
        move.printEffectivenessStatements(two, one);


        if (two.isAlive()) {
            move = two.takeTurn(two, one);
            damage = move.getHealthLoss(two, one);

            System.out.println(two.toString() + " uses " + move.toString() + " on " + one.toString() + " for " + damage + " damage.");
            move.useSkill(two, one);
            //System.out.println("done");

        }
    }

    public static Pokemon battle(Pokemon one, Pokemon two) {
        one.prepForBattle();
        two.prepForBattle();
        System.out.println(one.toString() + " HP vs " + two.toString() + " HP");
        if (one.getType2()!=null) {
            System.out.print(one.getType1() + "/" + one.getType2());
        }
        else if (one.getType2()==null) {
            System.out.print(one.getType1());
        }
        if (two.getType2()!=null) {
            System.out.print(" vs. " + two.getType1()+"/" + two.getType2() + "\n");
        }
        else if (two.getType2()==null) {
            System.out.println(" vs. " + two.getType1() + "\n");
        }

        while (true) {
            doOneTurn(one, two);
            if (!one.isAlive() || !two.isAlive()) {
                if (!one.isAlive()) {
                    System.out.println(two.toString() + " wins!");
                    return two;
                }
                else {
                    System.out.println(one.toString() + " wins!");
                    return one;
                }
            }
            if (!one.isAlive() && !two.isAlive()) {
                System.out.println("It's a draw!");
            }
        }
    }


}
