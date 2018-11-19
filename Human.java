package com.company;

public class Human extends Unit {

    private int armor = 1;

    public Human(String name, int maxHP, int currHP, int minDamage, int maxDamage, int armor) {
        super(name, maxHP, currHP, minDamage, maxDamage);
        this.armor = armor;
    }

    public Human(String name, int maxHP, int minDamage, int maxDamage, int armor) {
        super(name, maxHP, minDamage, maxDamage);
        this.armor = armor;
    }

    public Human(int armor) {
        this.armor = armor;
    }

    @Override
    public int getDamage() {
        int delta = getMaxDamage() - getMinDamage();
        return (int) (Math.random() * delta + 1) + getMinDamage();
    }

    @Override
    public void setDamage(int damage) {
        damage = damage - armor;
        if (damage < 0) damage = 0;
        setCurrHP(getCurrHP() - damage);
        System.out.println(" -- " + damage);
    }

    @Override
    public void toAttack(Unit enemy) {
        System.out.print(this.getName()+" summon to "+ enemy.getName() +" damage ");
        enemy.setDamage(this.getDamage());
    }

}
