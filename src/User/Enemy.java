package User;

public class Enemy extends User{
    public Enemy(int difficulty) {
        this.setAttack(100 * difficulty);
        this.setHealth(200 * difficulty);
        this.setDefense(20 * difficulty);
        this.setKnowledge(10 * difficulty);
        this.setDodgeChance(getDodgeChance() + (0.05 * difficulty));
    }
}
