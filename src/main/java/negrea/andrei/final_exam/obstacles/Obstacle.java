package negrea.andrei.final_exam.obstacles;

import negrea.andrei.final_exam.Hero.Hero;

public interface Obstacle {

    void firstEncounter();

    void fight(Hero hero) throws InterruptedException;

    void death();
}
