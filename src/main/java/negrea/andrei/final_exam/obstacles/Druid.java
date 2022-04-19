package negrea.andrei.final_exam.obstacles;

import negrea.andrei.final_exam.Hero.Hero;

public class Druid implements Obstacle {
    private int hp = 12;
    private int attack = 4;
    private String name;

    public Druid(String name) {
        this.name = name;
    }

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
        System.out.println("You are the enemy of nature!");
    }

    @Override
    public void fight(Hero hero) throws InterruptedException {
        hero.setHp(hero.getHp() - (getAttack()-(hero.getDefense()*0.2)));
        System.out.println("The " + getName() + " slashed you. You took " + getAttack() + " damage.\n");
        Thread.sleep(2000);
        setHp(getHp() - hero.getAttack());
        System.out.println("You've attacked the " + getName() + " and dealt " + hero.getAttack() + " damage\n");
        Thread.sleep(2000);
        System.out.println("Your hp: " + hero.getHp() + "\n");
        System.out.println(getName() + " hp: " + getHp() + "\n");
        Thread.sleep(2000);
    }

    @Override
    public void death() {
        System.out.println(getName() + " has been defeated\n");
    }
}
