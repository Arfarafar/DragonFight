package com.company;

public class Main {

    public static void main(String[] args) {
        Unit orc = new Orc("Саурфанг", 600, 18, 35, 3);
        Unit human = new Human("Джайна", 400,  20, 70, 10);
        Dragon dragon = new Dragon("Алекстраза", 1500, 20, 50,14, 20,10,5 );
        Spell fireball = new Spell(250,"fireball");

        while (orc.isAlive() || human.isAlive() && dragon.isAlive()){
            Unit.fightTheDragon(2,dragon, orc, human, fireball);
            System.out.println(orc + " " + human+ " "+dragon);
            System.out.println();

        }
        if (dragon.isAlive()){
            System.out.println("The_Dragon_Killed_Your_Squad");
        }

    }
}
