package negrea.andrei.final_exam.obstacles;

import negrea.andrei.final_exam.Hero.Hero;

public class Bug {

    private int hp = 20;
    private int attack = 10;
    private String name;

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

    public void setName(String name) {
        this.name = name;
    }

    public void fight(Druid druid) throws InterruptedException {
        setHp(getHp() - druid.getAttack());
        System.out.println("The " + druid.getName() + " slashed " + getName() + ". " + getName() + " took " + druid.getAttack() + " damage.\n");
        Thread.sleep(2000);
        druid.setHp(druid.getHp() - getAttack());
        System.out.println(getName() + " attacked the " + druid.getName() + " and dealt " + getAttack() + " damage\n");
        Thread.sleep(2000);
        System.out.println(getName() + " hp: " + getHp() + "\n");
        System.out.println(druid.getName() + " hp: " + druid.getHp() + "\n");
        Thread.sleep(2000);
    }

    public void death() {
        System.out.println(getName() + " died! :[");
    }
}
