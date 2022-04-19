package negrea.andrei.final_exam.obstacles;

import negrea.andrei.final_exam.Hero.Hero;

import java.util.Random;

public class Thief implements Obstacle {
    private int hp = 15;
    private int first_attack = 3;
    private int second_attack = 4;
    private String name = "Thief";

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getFirst_attack() {
        return first_attack;
    }

    public int getSecond_attack() {
        return second_attack;
    }

    public String getName() {
        return name;
    }

    @Override
    public void firstEncounter() {
        System.out.println("Give me everything you've got little guy, or you'll get the stabbies.");
    }

    @Override
    public void fight(Hero hero) throws InterruptedException {
        Random random = new Random();
        hero.setHp(hero.getHp() - (getFirst_attack() - (hero.getDefense() * 0.2)));
        System.out.println("The " + getName() + " slashed you. You took " + getFirst_attack() + " damage.\n");
        Thread.sleep(2000);
        if (random.nextInt(10) > 7) {
            hero.setHp(hero.getHp() - (getSecond_attack() - (hero.getDefense() * 0.2)));
            System.out.println("The " + getName() + " slashed you again. You took " + getSecond_attack() + " damage.\n");
            Thread.sleep(2000);
        }
        setHp(getHp() - hero.getAttack());
        System.out.println("You've attacked the " + getName() + " with " + hero.getWeapon_name() + " and dealt " + hero.getAttack() + " damage.\n");
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
