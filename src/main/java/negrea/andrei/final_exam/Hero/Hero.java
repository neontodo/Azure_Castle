package negrea.andrei.final_exam.Hero;

public class Hero {
    private double hp = 22;
    private int attack = 4;
    private int defense = 1;
    private String name;
    private String weapon_name;
    private String armor_name;

    public Hero(String name) {
        this.name = name;
        this.weapon_name = "rusty knife";
        this.armor_name = "leather tunic";
    }

    public int getHp() {
        return (int)this.hp;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public String getName() {
        return name;
    }

    public String getWeapon_name() {
        return weapon_name;
    }

    public void setWeapon_name(String weapon_name) {
        this.weapon_name = weapon_name;
    }

    public String getArmor_name() {
        return armor_name;
    }

    public void setArmor_name(String armor_name) {
        this.armor_name = armor_name;
    }
}
