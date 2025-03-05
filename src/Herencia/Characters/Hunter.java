package Herencia.Characters;

import Herencia.Enums.ECharacterType;

public class Hunter extends Character {

    private int speed, intelligence;

    public Hunter(String name, int level, int experience, int lifePoints, int baseAttack, int baseDefense, int speed, int intelligence) {
        super(name, level, experience, lifePoints, baseAttack, baseDefense, ECharacterType.HUNTER);

        this.speed = speed;
        this.intelligence = intelligence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void attack(Character player) {
        if(player == null || player.getLifePoints() <= 0) {
            System.out.println("El objetivo no es válido o ya está derrotado.");
            return;
        }
        int damage = (this.getBaseAttack() + speed / 2) - player.getBaseDefense();
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
    public void inspire(Character player) {
        if(player == null || player.getLifePoints() <= 0) {
            System.out.println("El objetivo no es válido o ya está derrotado.");
            return;
        }
        int boost = this.getBaseDefense() / 3;
        player.setBaseDefense(player.getBaseDefense() + boost);
        System.out.println(this.getName() + " inspira a " + player.getName() + ", aumentando su defensa base en " + boost + ".");
    }

    @Override
    public void observe(Character player) {
        if(player == null) {
            System.out.println("El objetivo no es válido.");
            return;
        }
        System.out.println("Observando a " + player.getName() + ":");
        System.out.println(player.showStatus());
    }
}
