package negrea.andrei.final_exam.Gameplay;

import negrea.andrei.final_exam.Hero.Hero;
import negrea.andrei.final_exam.Score.Highscore;
import negrea.andrei.final_exam.obstacles.*;

import java.util.Scanner;

public class Locations {

    private int option;

    public Locations() {
    }

    public int getOption() {
        return this.option;
    }

    public void townGate(Guardian guard, Hero hero) throws InterruptedException {
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("You find yourself at the town gate\nYou encounter a guard there\n");
        Thread.sleep(1000);
        guard.firstEncounter();
        Thread.sleep(1000);
        System.out.println("What do you want to do?\n");
        System.out.println("\t1.Talk your way inside the gates\n");
        System.out.println("\t2.Fight the guard\n");
        System.out.println("\t3.Leave\n");
        Scanner scanner = new Scanner(System.in);
        this.option = scanner.nextInt();
        Thread.sleep(1000);
        switch (option) {
            case 1: {
                guard.chat();
                Thread.sleep(1000);
                break;
            }
            case 2: {
                while (hero.getHp() > 0 && guard.getHp() > 0) {
                    guard.fight(hero);
                    if (hero.getHp() <= 0) {
                        System.out.println("Game Over!");
                        break;
                    } else if (guard.getHp() <= 0) {
                        guard.death();
                        break;
                    }
                }
                break;
            }
            case 3: {
                System.out.println("END OF THE GAME! (WHY THO?)");
                System.exit(0);
                break;
            }
        }
    }

    public void crossroad() throws InterruptedException {
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("You get to a crossroad. ");
        System.out.println("Where do you want to go?\n");
        System.out.println("\t1.North\n");
        System.out.println("\t2.East\n");
        System.out.println("\t3.West\n");
        Scanner scanner = new Scanner(System.in);
        this.option = scanner.nextInt();
        Thread.sleep(1000);
        switch (option) {
            case 1: {
                System.out.println("You went to the north.");
                break;
            }
            case 2: {
                System.out.println("You went to the east");
                break;
            }
            case 3: {
                System.out.println("You went to the west");
                break;
            }
        }
    }

    public void north(Hero hero, Bug bug) throws InterruptedException {
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("A small bug lands on your sword.\n");
        System.out.println("What do you do with the bug?\n");
        System.out.println("\t1.Keep the bug\n");
        System.out.println("\t2.Kill the bug\n");
        System.out.println("\t3.Brush it off\n");
        Scanner scanner = new Scanner(System.in);
        this.option = scanner.nextInt();
        Thread.sleep(1000);
        switch (option) {
            case 1: {
                System.out.println("You kept the bug and seems you've got a life boost.\nYour maximum health has increased by 2.\nAren't you a great hero?\n");
                hero.setHp(hero.getHp() + 2);
                System.out.println("How about giving the bug a name?\n\nEnter name: ");
                scanner.nextLine();
                bug.setName(scanner.nextLine());
                break;
            }
            case 2: {
                System.out.println("You've killed the bug. What did he do to you? Whatever, meanie.\n");
                System.out.println("You've got 'Guilt': Decreases the hero's attack by 1\n");
                hero.setAttack(hero.getAttack() - 1);
                break;
            }
            case 3: {
                System.out.println("The bug is off.\n");
                break;
            }
        }
    }

    public void east(Hero hero, Highscore highscore) throws InterruptedException {
        String armor = "Rusty Iron Chestplate";
        int iron_chestplate_defense = 5;
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("You went to the blacksmith. He offers to upgrade one of your items for free.\n");
        System.out.println("Which one would you like to upgrade?\n");
        System.out.println("\t1.Upgrade the sword\n");
        System.out.println("\t2.Upgrade the armor\n");
        System.out.println("\t3.Fight the blacksmith\n");
        Scanner scanner = new Scanner(System.in);
        this.option = scanner.nextInt();
        Thread.sleep(1000);
        switch (option) {
            case 1: {
                System.out.println("The blacksmith has upgraded your sword. Sword upgrade: +2 attack\n");
                hero.setAttack(hero.getAttack() + 2);
                break;
            }
            case 2: {
                System.out.println("You give the blacksmith a leather tunic. He starts laughing.\n");
                System.out.println("Blacksmith: You really are a beginner, just as I thought. Here take this.\n");
                System.out.println("The blacksmith gives you an old but gold iron chestplate. \n");
                System.out.println("New item acquired: " + armor + ": 3 defense\n");
                hero.setDefense(iron_chestplate_defense);
                break;
            }
            case 3: {
                System.out.println("You've attacked the blacksmith and injured him. The guards caught you and put you behind the bars.\n");
                System.out.println("Game Over!");
                hero.setHp(0);
                highscore.readFile();
                highscore.saveHighscore(hero);
                break;
            }
        }
    }

    public void west(Hero hero, Highscore highscore) throws InterruptedException {
        String weapon = "Iron Dagger";
        int weapon_attack = 7;
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("You see a moving bush.\n");
        System.out.println("What do you want to do?\n");
        System.out.println("\t1.Search the bush\n");
        System.out.println("\t2.Leave the bush alone\n");
        System.out.println("\t3.Fight the bush\n");
        Scanner scanner = new Scanner(System.in);
        this.option = scanner.nextInt();
        Thread.sleep(1000);
        switch (option) {
            case 1: {
                System.out.println("You've searched the bush and found a squirrel with something in it's mouth. You grab the item. It's a high quality dagger.\n");
                System.out.println("You changed your rusty sword for a high quality dagger.\n");
                System.out.println("New item acquired: " + weapon + ": " + weapon_attack + "attack\n");
                hero.setAttack(weapon_attack);
                hero.setWeapon_name(weapon);
                break;
            }
            case 2: {
                System.out.println("You ignore the bush.\n");
                break;
            }
            case 3: {
                System.out.println("You have awoken the bush lord. Prepare for battle.\n");
                BushLord bush = BushLord.getBushLord();
                bush.firstEncounter();
                while (hero.getHp() > 0 && bush.getHp() > 0) {
                    bush.fight(hero);
                    if (hero.getHp() <= 0) {
                        System.out.println("Game Over!");
                        highscore.readFile();
                        highscore.saveHighscore(hero);
                    } else if (bush.getHp() <= 0) {
                        bush.death();
                        System.out.println("You have done it! Congratulation!\n Just kidding, you shouldn't be able to defeat him, meaning that you're hacking!\n Game Over!");
                        highscore.extraPoint();
                        highscore.readFile();
                        highscore.saveHighscore(hero);
                    }
                }
                break;
            }
        }
    }

    public void forest(Hero hero, Bug bug, Highscore highscore) throws InterruptedException {
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("You walk into a forest. A group of druids come towards you.\n");
        System.out.println("Druid: Give us the bug! He is a great threat to all species and must be eliminated \n");
        System.out.println("What do you do?\n");
        System.out.println("\t1.Offer them the bug\n");
        System.out.println("\t2.Fight the druids\n");
        System.out.println("\t3.Call them mad");
        Druid[] druids = new Druid[3];
        druids[0] = new Druid("Druid 1");
        druids[1] = new Druid("Druid 2");
        druids[2] = new Druid("Druid 3");
        int bug_death = 0;
        Scanner scanner = new Scanner(System.in);
        this.option = scanner.nextInt();
        Thread.sleep(1000);
        switch (option) {
            case 1: {
                System.out.println("The bug reveals its true identity and increases its size x10 times.\n He wishes to engage in a fight with the druids.\n");
                for (int i = 0; i <= 3; i++) {
                    while (bug.getHp() > 0 && druids[i].getHp() > 0) {
                        bug.fight(druids[i]);
                        if (bug.getHp() <= 0) {
                            bug.death();
                            System.out.println("You've witnessed your companion get killed. Well done, coward!\n");
                            System.out.println("Game Over!");
                            highscore.readFile();
                            highscore.saveHighscore(hero);
                        } else if (druids[i].getHp() <= 0) {
                            druids[i].death();
                        }
                    }
                }
                break;
            }
            case 2: {
                System.out.println("The bug reveals its true identity and increases its size x10 times.\n He wishes to engage in a fight along with you against the druids.\n");
                for (int i = 0; i < 3; i++) {
                    while (hero.getHp() > 0 && druids[i].getHp() > 0) {
                        druids[i].fight(hero);
                        if (bug_death == 0) {
                            bug.fight(druids[i]);
                        }
                        if (hero.getHp() <= 0) {
                            System.out.println("Game Over");
                            highscore.readFile();
                            highscore.saveHighscore(hero);
                        } else if (druids[i].getHp() <= 0) {
                            druids[i].death();
                        } else if (bug.getHp() <= 0 && bug_death == 0) {
                            bug.death();
                            bug_death = 1;
                        }
                    }
                    if (druids[2].getHp() <= 0) {
                        System.out.println("You've defeated the enemies! Congratulations!");
                        highscore.earnPoint();
                        highscore.readFile();
                        highscore.saveHighscore(hero);
                    }
                }
                break;
            }
            case 3: {
                for (int i = 0; i < 3; i++) {
                    while (hero.getHp() > 0 && druids[i].getHp() > 0) {
                        druids[i].fight(hero);
                    }
                    if (hero.getHp() <= 0) {
                        System.out.println("Game Over");
                        highscore.readFile();
                        highscore.saveHighscore(hero);
                    } else if (druids[i].getHp() <= 0) {
                        druids[i].death();
                    }
                    if (druids[2].getHp() <= 0) {
                        System.out.println("You've defeated the enemies! Congratulations!");
                        highscore.earnPoint();
                        highscore.readFile();
                        highscore.saveHighscore(hero);
                    }
                }
                break;
            }
        }
    }

    public void thiefEncounter(Hero hero, Highscore highscore) throws InterruptedException {
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("A stranger stops you from your path and drags you into an alley.\n");
        Thief thief = new Thief();
        thief.firstEncounter();
        System.out.println("What do you want to do?\n");
        System.out.println("\t1.Give him everything you've got\n");
        System.out.println("\t2.Fight the thief\n");
        Scanner scanner = new Scanner(System.in);
        this.option = scanner.nextInt();
        Thread.sleep(1000);
        switch (option) {
            case 1: {
                hero.setAttack(1);
                hero.setWeapon_name("Fists");
                hero.setDefense(0);
                hero.setArmor_name("None");
                System.out.println("You gave away everything you've got, but he doesn't seem to be satisfied and you get in a fight. Say your prayers...\n");
                while (hero.getHp() > 0 && thief.getHp() > 0) {
                    thief.fight(hero);
                    if (hero.getHp() <= 0) {
                        System.out.println("Game Over!");
                        highscore.readFile();
                        highscore.saveHighscore(hero);
                    } else if (thief.getHp() <= 0) {
                        thief.death();
                        System.out.println("You have done it! Congratulation!");
                        highscore.earnPoint();
                        highscore.readFile();
                        highscore.saveHighscore(hero);
                    }
                }
                break;
            }
            case 2: {
                while (hero.getHp() > 0 && thief.getHp() > 0) {
                    thief.fight(hero);
                    if (hero.getHp() <= 0) {
                        System.out.println("Game Over!");
                        highscore.readFile();
                        highscore.saveHighscore(hero);
                    } else if (thief.getHp() <= 0) {
                        thief.death();
                        System.out.println("You have done it! Congratulation!");
                        highscore.earnPoint();
                        highscore.readFile();
                        highscore.saveHighscore(hero);
                    }
                }
                break;
            }
        }
    }

    public void lakeGoblinEncounter(Hero hero, Highscore highscore) throws InterruptedException {
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("You go up to a lake to take a breather. Suddenly a goblin disrupts your peace\n");
        Goblin goblin = new Goblin();
        goblin.firstEncounter();
        System.out.println("What do you want to do?\n");
        System.out.println("\t1.Fight the goblin\n");
        System.out.println("\t2.Fight the goblin\n");
        Scanner scanner = new Scanner(System.in);
        this.option = scanner.nextInt();
        Thread.sleep(1000);
        System.out.println("Fight? Now that's a brave hero\n");
        while (hero.getHp() > 0 && goblin.getHp() > 0) {
            goblin.fight(hero);
            if (hero.getHp() <= 0) {
                System.out.println("Game Over!");
                highscore.readFile();
                highscore.saveHighscore(hero);
            } else if (goblin.getHp() <= 0) {
                goblin.death();
                System.out.println("You have done it! Congratulation!");
                highscore.earnPoint();
                highscore.readFile();
                highscore.saveHighscore(hero);
            }
        }
    }
}