package com.company;

import java.util.ArrayList;

abstract public class Unit implements Attack {
    private String name = "NoName";
    private int maxHP = 1;
    private int currHP = 1;
    private int minDamage = 1;
    private int maxDamage = 1;

    public static void battle(Attack... arr){
        for (Attack from : arr)
        {
            for (Attack to : arr) {
                if(from.equals(to)) continue;
                if (to.getClass() == Spell.class) continue;
                from.toAttack((Unit) to);
            }
        }
    }

    public static void fightTheDragon( int squadCol,Dragon boss, Attack... arr){

        ArrayList a = new ArrayList();
        for (Attack from : arr){
            if (from.getClass() != Spell.class) {
                if (((Unit) from).isAlive()) {
                    a.add((Unit) from);

                }
            }

            if((from.getClass() == Orc.class || from.getClass() == Human.class) && !(((Unit) from).isAlive()) ) {
                continue;
            }
            else
           from.toAttack(boss);
        }


        if (Math.random()*100 < 70){
            boss.toAttack((Unit)a.get((int) (Math.random()*a.size())));
        }
        else
        {
         boss.splashAttack(a);
        }
    }





    public Unit(String name, int maxHP, int currHP, int minDamage, int maxDamage) {
        if (!name.equals("")) // name != ""
            this.name = name;
        if (maxHP > 0)
            this.maxHP = maxHP;
        if (currHP > 0)
            this.currHP = currHP;
        if (minDamage > 0)
            this.minDamage = minDamage;
        if (maxDamage > 0)
            this.maxDamage = maxDamage;
        if (minDamage > maxDamage)
            this.minDamage = maxDamage;
        if (currHP > maxHP)
            this.currHP = maxHP;

    }

    public Unit(String name, int maxHP, int minDamage, int maxDamage) {
        if (!name.equals("")) // name != ""
            this.name = name;
        if (maxHP > 0) {
            this.maxHP = maxHP;
            this.currHP = maxHP;
        }
        if (minDamage > 0)
            this.minDamage = minDamage;
        if (maxDamage > 0)
            this.maxDamage = maxDamage;
        if (minDamage > maxDamage)
            this.minDamage = maxDamage;
        if (currHP > maxHP)
            this.currHP = maxHP;

    }


    public Unit() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("")) // name == ""
            return;
        else
            this.name = name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        if (maxHP > 0)
            this.maxHP = maxHP;
        if (currHP > maxHP)
            currHP = maxHP;
    }

    public int getCurrHP() {
        return currHP;
    }

    public void setCurrHP(int currHP) {
        this.currHP = currHP;
        if (currHP < 0)
            this.currHP = 0;
        if (currHP > maxHP)
            this.currHP = maxHP;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        if (minDamage > 0)
            this.minDamage = minDamage;
        if (minDamage > maxDamage)
            minDamage = maxDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        if (maxDamage > 0)
            this.maxDamage = maxDamage;
        if (minDamage > maxDamage)
            minDamage = maxDamage;
    }

    abstract public int getDamage(); // учту крит урон
    abstract public void setDamage(int damage); // учту броню



    @Override
    public String toString() {
        return name + " " + currHP;
    }

    public boolean isAlive() {
        return currHP > 0;
    }
}
