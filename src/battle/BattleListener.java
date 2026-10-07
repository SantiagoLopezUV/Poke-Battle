package battle;

public interface BattleListener
{
    void onTurn(String attacker, String defender, int damage, boolean critical, double modifier);
    void onHpChanged(String pokemon, int hpActual);
    void onBattleEnded(String winner);
}
