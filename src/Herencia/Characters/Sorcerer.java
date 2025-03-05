package Herencia.Characters;

import Herencia.Enums.ECharacterType;

public class Sorcerer extends Herencia.Characters.Character {

    private int intelligence, mana;

    public Sorcerer(String name, int level, int experience, int lifePoints, int baseAttack, int baseDefense, int intelligence, int mana ) {
        super(name, level, experience, lifePoints, baseAttack, baseDefense, ECharacterType.SORCERER);

        this.intelligence = intelligence;
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void attack(Character player) {
        if(player == null || player.getLifePoints() <= 0) {
            System.out.println("El objetivo no es válido o ya está derrotado.");
            return;
        }

        int damage = (this.getBaseAttack() + intelligence / 2) - player.getBaseDefense();
        if(damage < 0) {
            damage = 0;
        }
        player.setLifePoints(player.getLifePoints() - damage);
        System.out.println(this.getName() + " ataca a " + player.getName() + " causando " + damage + " puntos de daño.");
    }

    @Override
    public void cure(Character player) {
        if(player == null || player.getLifePoints() <= 0){
            System.out.println("El objetivo no es válido o ya está derrotado.");
            return;
        }
        int healAmount = intelligence * 2;
        player.setLifePoints(player.getLifePoints() + healAmount);
        System.out.println(this.getName() + " cura a " + player.getName() + " recuperando " + healAmount + " puntos de vida con magia.");
    }

    @Override
    public void conjure(Character player) {
        if(player == null || player.getLifePoints() <= 0){
            System.out.println("El objetivo no es válido o ya está derrotado.");
            return;
        }
        System.out.println(this.getName() + " conjura un hechizo sobre " + player.getName() + ", adormeciéndolo temporalmente.");
    }
}
