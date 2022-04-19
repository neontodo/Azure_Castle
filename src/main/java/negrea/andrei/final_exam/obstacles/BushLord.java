package negrea.andrei.final_exam.obstacles;

import negrea.andrei.final_exam.Hero.Hero;

public class BushLord implements Obstacle {
    private static BushLord bush_lord;
    private int hp = 150;
    private int attack = 17;
    private String name = "Bush lord";

    private BushLord() {

    }

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

    public static BushLord getBushLord() {
        if (bush_lord == null) {
            bush_lord = new BushLord();
        }
        return bush_lord;
    }

    @Override
    public void firstEncounter() {
        System.out.println("Why is a mortal disturbing my sleep. You shall pay for what you've done!\n");
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
        System.out.println("The bush lord goes back to his long sleep.\n");
    }
}
