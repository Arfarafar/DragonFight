package com.company;

import java.util.ArrayList;

public class Dragon extends Unit {

    private int armor = 15;
    private int splash = 10;
    private int heal = 7;
    private int critical = 3;

    public Dragon(String name, int maxHP, int minDamage, int maxDamage, int armor, int splash, int heal, int critical) {
        super(name, maxHP, minDamage, maxDamage);
        this.armor = armor;
        this.splash = splash;
        this.heal = heal;
        this.critical = critical;
    }

    @Override
    public int getDamage() {
        int delta = getMaxDamage() - getMinDamage();
        delta = delta * (int)(Math.random() * critical + 1);
        int alfa =(int) (Math.random() * delta + 1) + getMinDamage();
        int lifeSteal =(int)( alfa* Math.random());
        setCurrHP(getCurrHP()+ lifeSteal);
        System.out.println("Dragon lifeSteal +"+  lifeSteal);
        return alfa;
    }

    public int getSplashDamage(int countWarr) {

        int alfa =(int) (Math.random() * splash *  critical + 1);
        int lifeSteal = (int)( alfa* Math.random()*countWarr);
        setCurrHP(getCurrHP()+ lifeSteal);
        System.out.println("Dragon SplashLifeSteal +"+  lifeSteal);
        return alfa;
    }

    @Override
    public void setDamage(int damage) {
        damage = damage - armor;
        if (damage < 0) damage = 0;
        setCurrHP(getCurrHP() - damage + heal);
        System.out.println(" -- " + damage);
        if ( getCurrHP() == 0){
            System.out.println();
            System.out.println("Dragon_Defeated");
            System.exit(0);
        }
        System.out.println("Dragon heals +"+  heal);

    }

    @Override
    public void toAttack(Unit enemy) {
        int a = this.getDamage();
        System.out.print("Dragon summon to "+ enemy.getName() +" damage ");
        enemy.setDamage(a);

    }

    public void splashAttack(ArrayList arr){

        int a = this.getSplashDamage(arr.size());
        for ( Object enemy : arr ) {
            System.out.print("Dragon summon to "+ ((Unit)enemy).getName() +" damage ");
            ((Unit)enemy).setDamage(a);
        }
    }

}
