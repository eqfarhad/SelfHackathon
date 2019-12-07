package ir.eqtech.selfhack;


public class Fight {
    private PlayerData myself;
    private PlayerData enemy;
    private int round;

    public Fight(PlayerData myself, PlayerData enemy) {
        this.myself = myself;
        this.enemy = enemy;
        this.round = 0;
    }

    private float characterFight(Character myCharacter, Character enemyCharacter) {
        return myCharacter.getFightValue() - enemyCharacter.getFightValue();
    }

    public String nextFight(){
        Character myFighter;
        Character enemyFighter;
        System.out.println("Current round "+round);
        if(round == 0){
            myFighter = myself.getCharacter();
            enemyFighter = enemy.getCharacter();
        }
        else if(round <= myself.getFighterAmount() && round <= enemy.getFighterAmount()) {
            myFighter = myself.getFighterAt(round -1);
            enemyFighter = enemy.getFighterAt(round -1);
        }
        else {
            return "";
        }

        double fightResult = characterFight(myFighter, enemyFighter);

        round++;
        if(fightResult < 0){
            return myFighter.toString() + " loses against " + enemyFighter.toString();
        }
        else if(fightResult == 0){
            return myFighter.toString() + " ties against " + enemyFighter.toString();
        }
        else {
            return myFighter.toString() + " wins against " + enemyFighter.toString();
        }
    }
}
