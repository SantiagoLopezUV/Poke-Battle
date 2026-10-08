package battle;

import model.Pokemon;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battle
{
    //se crea con un limite alto para que no nos de 0 muchas veces
    private static final int MAX_TURNS = 200;

    private final Pokemon pokemon1;
    private final Pokemon pokemon2;
    private final List<BattleListener> listeners = new ArrayList<>();
    private final Random random = new Random();

    public Battle(Pokemon pokemon1, Pokemon pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    public void addBattleListener(BattleListener listener) {
        listeners.add(listener);
    }

    public void start(){

        Pokemon attacker = firstAttacker();
        Pokemon defender;
        if (attacker == pokemon1)
        {
            defender = pokemon2;
        } else
        {
            defender = pokemon1;
        }

        int turnos = 0;
        while (!pokemon1.isFatality() && !pokemon2.isFatality() && turnos < MAX_TURNS) {
            playTurn(attacker, defender);
            turnos++;

            if (defender.isFatality()) {
                break;
            }

            // se intercambian los roles para el siguiente turno
            Pokemon temp = attacker;
            attacker = defender;
            defender = temp;
        }

        Pokemon ganador;
        if (pokemon1.isFatality()) {
            ganador = pokemon2;
        } else {
            ganador = pokemon1;
        }
        notifyBattleEnded(ganador.getName());


    }

    //determinar quien tiene mayor speed
    private Pokemon firstAttacker() {
        if (pokemon1.getSpeed() > pokemon2.getSpeed()) {
            return pokemon1;
        }
        if (pokemon2.getSpeed() > pokemon1.getSpeed()) {
            return pokemon2;
        }
        return random.nextBoolean() ? pokemon1 : pokemon2;
    }

    private void playTurn(Pokemon attacker, Pokemon defender) {
        // damage = (ATK * random(0-1)) - (DEF * random(0-1))
        double attackRoll = attacker.getAttack() * random.nextDouble();
        double defenceRoll = defender.getDefense() * random.nextDouble();
        double baseDamage = attackRoll - defenceRoll;

        if (baseDamage < 0) { baseDamage = 0; }
        // daño critico * 1.5
        //si el ataque tiene un daño de 0 , no se reporta como critico
        boolean critical = false;
        if (baseDamage > 0 )
        {
            critical = random.nextDouble() < 0.10;
            if (critical) baseDamage *= 1.5;
        }

        // efectivdad, se escoge solo el primer tipo
        double modifier = effectiveness(attacker.getType(), defender.getType());
        baseDamage *= modifier;

        //daño final
        int finalDamage = (int) Math.round(baseDamage);

        // HP no puede ser negativo
        int nuevoHp = Math.max(0, defender.getCurrentHp() - finalDamage);
        defender.setCurrentHp(nuevoHp);

        notifyTurn(attacker.getName(), defender.getName(), finalDamage, critical, modifier);
        notifyHpChanged(defender.getName(), nuevoHp);
    }

    private double effectiveness(String typeAttacker, String typeDefender) {
        String attacker = typeAttacker.toLowerCase();
        String defender = typeDefender.toLowerCase();

        boolean stronger =
                (attacker.equals("water") && defender.equals("fire")) ||
                        (attacker.equals("fire") && defender.equals("grass")) ||
                        (attacker.equals("grass") && defender.equals("water"));

        boolean weaker =
                (attacker.equals("fire") && defender.equals("water")) ||
                        (attacker.equals("grass") && defender.equals("fire")) ||
                        (attacker.equals("water") && defender.equals("grass"));

        if (stronger) return 1.3;
        if (weaker) return 0.7;
        return 1.0;
    }

    private void notifyTurn(String attacker, String defender, int damage, boolean critical, double modifier) {
        for (BattleListener l : listeners) {
            l.onTurn(attacker, defender, damage, critical, modifier);
        }
    }

    private void notifyHpChanged(String pokemon, int hpActual) {
        for (BattleListener l : listeners) {
            l.onHpChanged(pokemon, hpActual);
        }
    }

    private void notifyBattleEnded(String winner) {
        for (BattleListener l : listeners) {
            l.onBattleEnded(winner);
        }
    }





}
