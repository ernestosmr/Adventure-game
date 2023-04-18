package User;

public abstract class User {
    private int attack;
    private int health;
    private int defense;
    private int knowledge;
    private double dodgeChance = 0;

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }

    public double getDodgeChance() {
        return dodgeChance;
    }

    public void setDodgeChance(double dodgeChance) {
        if(dodgeChance > 0.7){
            System.out.println("Max dodge chance");
            System.out.println("+100 Health");
            this.health += 100;
        } else{
            this.dodgeChance = dodgeChance;
        }
    }
    public void showStats(){
        System.out.println("attack: " + getAttack());
        System.out.println("health: " + getHealth());
        System.out.println("knowledge: + " + getKnowledge());
        System.out.println("dodge chance: " + getDodgeChance());
    }
}
