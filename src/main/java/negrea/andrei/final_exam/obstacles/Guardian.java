package negrea.andrei.final_exam.obstacles;

import negrea.andrei.final_exam.Hero.Hero;

public class Guardian implements Obstacle {
    private int hp = 20;
    private int attack = 7;
    private String name = "Guardian";

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public String getName() {
        return name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public void firstEncounter() {
        System.out.println("Hello there, adventurer!\n");
    }

    @Override
    public void fight(Hero hero) throws InterruptedException {
        hero.setHp(hero.getHp() - (getAttack()-(hero.getDefense()*0.2)));
        System.out.println("The " + getName() + " slashed you with a sword. You took " + getAttack() + " damage.\n");
        Thread.sleep(2000);
        setHp(getHp() - hero.getAttack());
        System.out.println("You've attacked the" + getName() + " and dealt " + hero.getAttack() + " damage\n");
        Thread.sleep(2000);
        System.out.println("Your hp: " + hero.getHp() + "\n");
        System.out.println(getName() + " hp: " + getHp() + "\n");
        Thread.sleep(2000);
    }

    @Override
    public void death() {
        System.out.println("The guardian has been defeated!\n");
    }

    public void chat() {
        System.out.println("You may enter. Be careful, there are rumored thieves creeping around lately.\n");
    }
}
