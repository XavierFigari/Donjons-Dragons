package main.java.dd.persons;

import main.java.dd.Colors;
import main.java.dd.UserInterface;
import main.java.dd.tools.DefensiveTool;
import main.java.dd.tools.OffensiveTool;

public abstract class Person {

    // Attributes
    // --------------------------------------------------------------------------
    protected String name;
    // available to children (protected) :
    protected int life;
    protected int strength;

    protected DefensiveTool defensiveTool; // shield (warrior) or philtre (wizard)
    protected OffensiveTool offensiveTool; // sword, hammer (warrior) or fireball, lightning (wizard)

    protected int position;

    // Constructors
    // --------------------------------------------------------------------------
    public Person(String name) {
        this.name = name;
        this.position = 0;
    }

    // Methods
    // --------------------------------------------------------------------------

    public void reset() {
        this.position = 0;
    }


    //    public abstract String pickOffensiveTool(OffensiveTool offensiveTool);
    public String pickTool(OffensiveTool newOffensiveTool) {
        String message;
        if (this.offensiveTool.getClass() == newOffensiveTool.getClass()) {
            message = "Tu as déjà cette arme : " + this.offensiveTool;
        } else if (this.offensiveTool.getAttackLevel() > newOffensiveTool.getAttackLevel()) {
            message = "Tu as déjà une meilleure arme : " + this.offensiveTool;
        } else {
            message = "Tu as déjà " + this.offensiveTool + " mais cette arme est meilleure. Prends-là !\n";
            this.setOffensiveTool(newOffensiveTool);
            message += "Avec cette arme, ta force sera augmentée de "
                    + newOffensiveTool.getAttackLevel() +
                    " points, tu auras donc une force totale de "
                    + this.getTotalStrength() + " points.";
        }
        return message;
    }

    public void fight(Enemy enemy, UserInterface ui) throws PersonIsDeadException {

        int fleeMove = 0;

        // Inform the player about the fight

        ui.display("- Ta force \uD83D\uDCAA = " + this.getStrength() + " points. Ta vie ❤️ = " + this.getLife() + " points.");
        ui.display("- Tu attaques " + enemy.getName() + " (\uD83D\uDCAA " + enemy.getStrength() + " ❤️ " + enemy.getLife() + ").");
        if (this.offensiveTool != null) {
            ui.display("- Tu utilises " + this.offensiveTool + ", ce qui te donne une force totale de " + this.getTotalStrength() + " points.");
        }

        // Ok, we're ready to fight !

        // Tant que le joueur n'a pas fui :
        while ((fleeMove = ui.getFleeMove()) == 0) {

            // 1. The player attacks the enemy
            // -------------------------------

            // Lower the enemy's life : subtract from enemy's life the total strength of the player
            int newEnemyLife = enemy.getLife() - this.getTotalStrength();
            if (newEnemyLife <= 0) {
                ui.display("Tu as vaincu " + enemy.getName() + " ! Il s'effondre à terre, mort.\n" +
                        "Hourra ! Tu as gagné le combat !");
            }
            enemy.setLife(newEnemyLife); // throws exception if life <= 0

            // 2. He's not dead, he's fighting back !
            // --------------------------------------

            ui.display("Tu as infligé " + this.getTotalStrength() + " points de dégâts à " + enemy.getName() + ".\n" +
                    enemy.getName() + " a encore " + enemy.getLife() + " points de vie ❤️.");
            ui.displayRed(enemy.getName() + " riposte ! Il a une force \uD83D\uDCAA de " + enemy.getStrength() + " points.");

            int newLife = this.getLife() - Math.min(enemy.getStrength(), this.getLife());

            ui.display("Tu as perdu " + Math.min(enemy.getStrength(), this.getLife()) + " points de vie.\n" +
                    (newLife > 0 ? "Il te reste " + newLife + " points de vie ❤️." : "\n\uD83D\uDC80 Tu es mort.\n"));

            this.setLife(newLife); // throws exception if life <= 0
        }

        // Le joueur a fui
        fleeMove = Math.min(this.getPosition(), fleeMove);
        ui.display("Tu as fui le combat ! Tu recules de " + fleeMove + " cases.");
        this.setPosition(this.getPosition() - fleeMove);
        ui.display("Tu es maintenant sur la case " + this.getPosition() + ".");
    }

//    public void simpleFight(Enemy enemy, UserInterface ui) throws PersonIsDeadException {
//        // Inform the player about the fight
//        ui.display("- Ta force \uD83D\uDCAA = " + this.getStrength() + " points. Ta vie ❤️ = " + this.getLife() + " points.");
//        ui.display("- Tu attaques " + enemy.getName() + " (\uD83D\uDCAA " + enemy.getStrength() + " ❤️ " + enemy.getLife() + ").");
//
//        // Inform the player about the offensive tool
//        if (this.offensiveTool != null) {
//            ui.display("- Tu utilises " + this.offensiveTool + ", ce qui te donne une force totale de " + this.getTotalStrength() + " points.");
//        }
//
//        // Lower the enemy's life : subtract from enemy's life the total strength of the player
//        enemy.setLife(enemy.getLife() - this.getTotalStrength());
//
//        // Test if the enemy is dead
//        if (enemy.getLife() <= 0) {
//            ui.display("Tu as vaincu " + enemy.getName() + " ! Il s'effondre à terre, mort.");
//        } else {
//            // He's not dead, he's fighting back !
//            ui.display("Tu as infligé " + this.getTotalStrength() + " points de dégâts à " + enemy.getName() + ".\n" +
//                    enemy.getName() + " a encore " + enemy.getLife() + " points de vie ❤️.");
//            ui.displayRed(enemy.getName() + " riposte ! Il a une force \uD83D\uDCAA de " + enemy.getStrength() + " points.");
//            int newLife = this.getLife() - Math.min(enemy.getStrength(), this.getLife());
//            ui.display("Tu as perdu " + Math.min(enemy.getStrength(), this.getLife()) + " points de vie.\n" +
//                    (newLife > 0 ? "Il te reste " + newLife + " points de vie ❤️." : "\n\uD83D\uDC80 Tu es mort.\n"));
//            this.setLife(newLife); // throw exception if life <= 0
//        }
//    }

    @Override
    public String toString() {
        return
                "         Nom    = " + Colors.colstr(Colors.ANSI_GREEN, getName()) + '\n' +
                        "         Type   = " + getTypeString() + '\n' +
                        "         ❤️     = " + getLife() + '\n' +
                        "         \uD83D\uDCAA     = " + getStrength() + '\n';
    }

    // Getters
    // --------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public int getStrength() {
        return strength;
    }

    public int getTotalStrength() {
        return strength + offensiveTool.getAttackLevel();
    }

    public int getPosition() {
        return position;
    }

    public OffensiveTool getOffensiveTool() {
        return offensiveTool;
    }

    public DefensiveTool getDefensiveTool() {
        return defensiveTool;
    }

    // Abstract methods
    public abstract String getTypeString();

    // Setters
    // --------------------------------------------------------------------------
    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setLife(int life) throws PersonIsDeadException {
        this.life = life;
        if (life <= 0) throw new PersonIsDeadException(this);
    }

    public void setDefensiveTool(DefensiveTool defensiveTool) {
        this.defensiveTool = defensiveTool;
    }

    public void setOffensiveTool(OffensiveTool offensiveTool) {
        this.offensiveTool = offensiveTool;
    }

}
