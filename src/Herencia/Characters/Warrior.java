package Herencia.Characters;

import Herencia.Enums.ECharacterType;

public class Warrior extends Character {

    private int strength, resistance;


    public Warrior(String name, int level, int experience, int lifePoints, int baseAttack, int baseDefense, int strength, int resistance) {

        super(name, level, experience, lifePoints, baseAttack, baseDefense, ECharacterType.WARRIOR);

        this.strength = strength;
        this.resistance = resistance;

    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    @Override
    public void attack(Character player) {
        if(player == null || player.getLifePoints() <= 0) {
            System.out.println("El objetivo no es válido o ya está derrotado.");
            return;
        }
        int damage = (this.getBaseAttack() + strength / 2) - player.getBaseDefense();
        if(damage < 0) {
            damage = 0;
        }
        player.setLifePoints(player.getLifePoints() - damage);
        System.out.println(this.getName() + " ataca a " + player.getName() + " causando " + damage + " puntos de daño.");
    }

    @Override
    public void hit(Character[] players) {
        for (Character player : players) {
            this.attack(player);
        }
    }

    @Override
    public void cure(Character player) {
        if(player == null || player.getLifePoints() <= 0){
            System.out.println("El objetivo no es válido o ya está derrotado.");
            return;
        }
        int healAmount = player.getLifePoints() / 3;
        player.setLifePoints(player.getLifePoints() + healAmount);
        System.out.println(this.getName() + " cura a " + player.getName() + " recuperando " + healAmount + " puntos de vida.");
    }

    @Override
    public void inspire(Character player) {
        if(player == null || player.getLifePoints() <= 0){
            System.out.println("El objetivo no es válido o ya está derrotado.");
            return;
        }
        int boost = this.getBaseAttack() / 3;
        player.setBaseAttack(player.getBaseAttack() + boost);
        System.out.println(this.getName() + " inspira a " + player.getName() + ", aumentando su ataque base en " + boost + ".");
    }
}
