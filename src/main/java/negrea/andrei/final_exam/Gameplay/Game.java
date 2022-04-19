package negrea.andrei.final_exam.Gameplay;

import negrea.andrei.final_exam.Hero.Hero;
import negrea.andrei.final_exam.Score.Highscore;
import negrea.andrei.final_exam.obstacles.Bug;
import negrea.andrei.final_exam.obstacles.Guardian;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        int option = -1;
        Scanner scanner = new Scanner(System.in);
        Highscore highscore = new Highscore();
        while (option != 0) {
            System.out.println("\n\t\tWelcome to Azure Castle!\n");
            System.out.println("\n\t\t1.Start New Game\n\t\t2.Highscore\n\t\t0.Exit\n");
            option = scanner.nextInt();
            switch (option) {
                case 1: {
                    highscore.setScore(0);
                    String name = "";
                    System.out.println("Welcome adventurer! Your journey awaits you!\n");
                    Thread.sleep(3000);
                    System.out.println("What name do you go by?");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    System.out.println(name + "? Alright, got it! I'll be your narrator, " + name + ", and you don't get a saying in this.\n");
                    Thread.sleep(3000);
                    Hero hero = new Hero(name);
                    Locations location = new Locations();
                    Guardian guard = new Guardian();
                    location.townGate(guard, hero);
                    if(hero.getHp()<=0){
                        break;
                    }
                    highscore.earnPoint();
                    location.crossroad();
                    highscore.earnPoint();
                    switch (location.getOption()) {
                        case 1: {
                            Bug bug = new Bug();
                            location.north(hero, bug);
                            if (hero.getHp() <= 0) {
                                break;
                            }
                            highscore.earnPoint();
                            location.forest(hero, bug, highscore);
                            break;
                        }
                        case 2: {
                            location.east(hero, highscore);
                            if (hero.getHp() <= 0) {
                                break;
                            }
                            highscore.earnPoint();
                            location.thiefEncounter(hero, highscore);
                            break;
                        }
                        case 3: {
                            location.west(hero, highscore);
                            if (hero.getHp() <= 0) {
                                break;
                            }
                            highscore.earnPoint();
                            location.lakeGoblinEncounter(hero, highscore);
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    highscore.readFile();
                    System.out.println("Highscore:\n\t\t" + highscore.getHighscore() + "\n");
                    break;
                }
                case 0: {
                    System.out.println("Hope you liked the game!\n");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Unavailable option. Please Select one of the given ones.\n");
                    break;
                }
            }
        }
    }
}
