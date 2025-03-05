package Herencia;

import Herencia.Characters.Character;
import Herencia.Characters.Hunter;
import Herencia.Characters.Sorcerer;
import Herencia.Characters.Warrior;
import Herencia.Enums.ECharacterType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private List<Character> characters;
    private Scanner sc;

    public Game() {
        characters = new ArrayList<>();
        sc = new Scanner(System.in);
        createPlayers();
        showPlayers();
        runGame();
    }

    private void createPlayers() {
        System.out.println("Antes de comenzar, crea entre 2 y 5 personajes.");
        System.out.print("Número de jugadores: ");
        int numPlayers = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Seleccione el tipo de personaje para el jugador " + (i + 1) + ":");
            System.out.println("(1) Guerrero");
            System.out.println("(2) Hechicero");
            System.out.println("(3) Cazador");
            int choice = sc.nextInt();
            sc.nextLine();
            System.out.print("Ingrese el nombre del personaje: ");
            String name = sc.nextLine();

            switch (choice) {
                case 1:
                    characters.add(new Warrior(name, 1, 0, 100, 10, 5, 15, 10));
                    break;
                case 2:
                    characters.add(new Sorcerer(name, 1, 0, 80, 8, 4, 20, 30));
                    break;
                case 3:
                    characters.add(new Hunter(name, 1, 0, 90, 9, 6, 25, 15));
                    break;
                default:
                    System.out.println("Opción inválida, se creará un Guerrero por defecto.");
                    characters.add(new Warrior(name, 1, 0, 100, 10, 5, 15, 10));
                    break;
            }
        }
    }

    private void showPlayers() {
        System.out.println("\nLista de personajes:");
        for (int i = 0; i < characters.size(); i++) {
            System.out.println(i + ". " + characters.get(i).showStatus());
        }
    }

    private void runGame() {
        int turn = 0;
        while (countAlive() > 1) {
            Character current = characters.get(turn % characters.size());
            if (current.getLifePoints() <= 0) {
                turn++;
                continue;
            }
            System.out.println("\nTurno de: " + current.getName());
            showActionOptions(current);
            int action = sc.nextInt();
            sc.nextLine();
            executeAction(current, action);
            turn++;
        }
        System.out.println("\nEl juego ha terminado.");
        for (Character c : characters) {
            if (c.getLifePoints() > 0) {
                System.out.println("Ganador: " + c.getName());
            }
        }
    }

    private int countAlive() {
        int count = 0;
        for (Character c : characters) {
            if (c.getLifePoints() > 0) {
                count++;
            }
        }
        return count;
    }

    private void showActionOptions(Character character) {
        ECharacterType type = character.getCharacterType();
        if (type == ECharacterType.WARRIOR) {
            System.out.println("Opciones para Guerrero:");
            System.out.println("(0) Atacar a un jugador");
            System.out.println("(1) Atacar a varios jugadores");
            System.out.println("(2) Curar a un jugador");
            System.out.println("(3) Inspirar a un jugador");
        } else if (type == ECharacterType.SORCERER) {
            System.out.println("Opciones para Hechicero:");
            System.out.println("(0) Atacar a un jugador");
            System.out.println("(1) Curar a un jugador");
            System.out.println("(2) Conjurar a un jugador");
        } else if (type == ECharacterType.HUNTER) {
            System.out.println("Opciones para Cazador:");
            System.out.println("(0) Atacar a un jugador");
            System.out.println("(1) Atacar a varios jugadores");
            System.out.println("(2) Inspirar a un jugador");
            System.out.println("(3) Observar a un jugador");
        }
        System.out.print("Seleccione una opción: ");
    }

    private void executeAction(Character character, int action) {
        ECharacterType type = character.getCharacterType();
        if (type == ECharacterType.WARRIOR) {
            Warrior w = (Warrior) character;
            switch (action) {
                case 0:
                    w.attack(selectTarget(character));
                    break;
                case 1:
                    w.hit(selectMultipleTargets(character));
                    break;
                case 2:
                    w.cure(selectTarget(character));
                    break;
                case 3:
                    w.inspire(selectTarget(character));
                    break;
                default:
                    System.out.println("Acción inválida.");
                    break;
            }
        } else if (type == ECharacterType.SORCERER) {
            Sorcerer s = (Sorcerer) character;
            switch (action) {
                case 0:
                    s.attack(selectTarget(character));
                    break;
                case 1:
                    s.cure(selectTarget(character));
                    break;
                case 2:
                    s.conjure(selectTarget(character));
                    break;
                default:
                    System.out.println("Acción inválida.");
                    break;
            }
        } else if (type == ECharacterType.HUNTER) {
            Hunter h = (Hunter) character;
            switch (action) {
                case 0:
                    h.attack(selectTarget(character));
                    break;
                case 1:
                    h.hit(selectMultipleTargets(character));
                    break;
                case 2:
                    h.inspire(selectTarget(character));
                    break;
                case 3:
                    h.observe(selectTarget(character));
                    break;
                default:
                    System.out.println("Acción inválida.");
                    break;
            }
        }
    }

    private Character selectTarget(Character current) {
        System.out.println("Seleccione el índice del objetivo:");
        for (int i = 0; i < characters.size(); i++) {
            Character c = characters.get(i);
            if (!c.equals(current) && c.getLifePoints() > 0) {
                System.out.println(i + ". " + c.getName() + " (Vida: " + c.getLifePoints() + ")");
            }
        }
        int index = sc.nextInt();
        sc.nextLine();
        return characters.get(index);
    }

    private Character[] selectMultipleTargets(Character current) {
        System.out.println("Seleccione los índices de los objetivos (separados por espacios):");
        for (int i = 0; i < characters.size(); i++) {
            Character c = characters.get(i);
            if (!c.equals(current) && c.getLifePoints() > 0) {
                System.out.println(i + ". " + c.getName() + " (Vida: " + c.getLifePoints() + ")");
            }
        }
        String line = sc.nextLine();
        String[] parts = line.split(" ");
        Character[] targets = new Character[parts.length];
        for (int i = 0; i < parts.length; i++) {
            int idx = Integer.parseInt(parts[i]);
            targets[i] = characters.get(idx);
        }
        return targets;
    }
}
