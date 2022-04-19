package negrea.andrei.final_exam.obstacles;

import negrea.andrei.final_exam.Hero.Hero;

public class Goblin implements Obstacle {

    private int hp = 8;
    private int attack = 2;
    private String name = "Goblin";

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public String getName() {
        return name;
    }


    @Override
    public void firstEncounter() {
        System.out.println("*goblin noises*");
    }

    @Override
    public void fight(Hero hero) throws InterruptedException {
        hero.setHp(hero.getHp() - (getAttack()-(hero.getDefense()*0.2)));
        System.out.println("The " + getName() + " slashed you. You took " + getAttack() + " damage.\n");
        Thread.sleep(2000);
        setHp(getHp() - hero.getAttack());
        System.out.println("You've attacked the " + getName() + " with" + hero.getWeapon_name() + " and dealt " + hero.getAttack() + " damage.\n");
        Thread.sleep(2000);
        System.out.println("Your hp: " + hero.getHp() + "\n");
        System.out.println(getName() + " hp: " + getHp() + "\n");
        Thread.sleep(2000);
    }

    @Override
    public void death() {
        System.out.println("The " + getName() + " has been defeated");
    }
}
