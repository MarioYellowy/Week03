package Herencia.Characters;

import Herencia.Enums.ECharacterType;
import Herencia.Actions.*;

public  class Character implements IAttack, IGainExperience, ILevelUp, IShowStatus, ICure, IInspire, IConjure, IObserve, IHit {

    private String name;
    private int level, experience, lifePoints, baseAttack, baseDefense;
    private ECharacterType characterType;

    public Character(String name, int level, int experience, int lifePoints, int baseAttack, int baseDefense, ECharacterType characterType) {
        this.name = name;
        this.level = level;
        this.experience = experience;
        this.lifePoints = lifePoints;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.characterType = characterType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public ECharacterType getCharacterType() {
        return characterType;
    }

    public void setCharacterType(ECharacterType characterType) {
        this.characterType = characterType;
    }

    @Override
    public void attack(Character character) {

    }

    @Override
    public void hit(Character[] characters) {

    }

    @Override
    public void gainExperience(int experience) {

    }

    @Override
    public void levelUp() {

    }

    @Override
    public String showStatus() {
        return "Nombre: " + name +
                "\nNivel: " + level +
                "\nExperiencia: " + experience +
                "\nPuntos de vida: " + lifePoints +
                "\nAtaque base: " + baseAttack +
                "\nDefensa base: " + baseDefense +
                "\nTipo: " + characterType;
    }

    @Override
    public void cure(Character character) {

    }

    @Override
    public void inspire(Character character) {

    }

    @Override
    public void conjure(Character character) {

    }

    @Override
    public void observe(Character character) {

    }
}
