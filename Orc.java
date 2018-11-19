package com.company;

public class Orc extends Unit{

    int critical = 1;

    public Orc(String name, int maxHP, int currHP, int minDamage, int maxDamage, int critical) {
        super(name, maxHP, currHP, minDamage, maxDamage);
        this.critical = critical;
    }

    public Orc(String name, int maxHP, int minDamage, int maxDamage, int critical) {
        super(name, maxHP, minDamage, maxDamage);
        this.critical = critical;
    }

    public Orc(int critical) {
        this.critical = critical;
    }

    @Override
    public int getDamage() {
        int delta = getMaxDamage() - getMinDamage();
        delta = delta * (int)(Math.random() * critical + 1);
        return (int) (Math.random() * delta ) + getMinDamage();
    }

    @Override
    public void setDamage(int damage) {
        setCurrHP(getCurrHP() - damage);
        System.out.println(" -- " + damage);
    }


    @Override
    public void toAttack(Unit enemy)
    {
        System.out.print(this.getName()+" summon to "+ enemy.getName() +" damage ");
        enemy.setDamage(this.getDamage());
    }
}
