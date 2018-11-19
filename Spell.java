package com.company;

public class Spell implements Attack {

    private int damage = 1;
    private String name;

    public Spell(int damage, String name) {
        if (damage > 0)
            this.damage = damage;
        if (name != "")
        this.name = name;
    }
    public int getDamage(){
        return (int)(Math.random()*damage);
    }
    @Override
    public void toAttack(Unit enemy) {
        System.out.print("Spell "+this.toString()+" damaged " + enemy.getName());

        enemy.setDamage(this.getDamage());
    }

    @Override
    public String toString() {
        return name;
    }
}
