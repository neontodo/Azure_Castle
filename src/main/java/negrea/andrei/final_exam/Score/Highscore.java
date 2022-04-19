package negrea.andrei.final_exam.Score;

import negrea.andrei.final_exam.Hero.Hero;

import java.io.*;

public class Highscore {
    private int score;
    private String highscore;

    public Highscore() {
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getHighscore() {
        return highscore;
    }

    public void setHighscore(String highscore) {
        this.highscore = highscore;
    }

    public void earnPoint() {
        this.score = this.score + 1;
    }

    public void extraPoint() {
        this.score = this.score + 2;
    }

    public String readFile() {
        FileReader readFile = null;
        BufferedReader reader = null;
        try {
            readFile = new FileReader("src/main/resources/highscore.txt");
            reader = new BufferedReader(readFile);
            this.highscore = reader.readLine();
            return this.highscore;
        } catch (Exception e) {
            System.out.println("Highscore file not found.");
            e.printStackTrace();
            return "0";
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveHighscore(Hero hero) {
        readFile();
        if (getScore() > Integer.parseInt((this.highscore.split(":")[1]))) {
            setHighscore(hero.getName() + ":" + getScore());
        }
        File scoreFile = new File("src/main/resources/highscore.txt");
        if (!scoreFile.exists()) {
            try {
                scoreFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileWriter writeFile = null;
        BufferedWriter writer = null;
        try {
            writeFile = new FileWriter(scoreFile);
            writer = new BufferedWriter(writeFile);
            writer.write(getHighscore());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
