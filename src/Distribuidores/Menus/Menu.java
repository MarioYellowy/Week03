package Distribuidores.Menus;

import Distribuidores.Adquisition;
import Distribuidores.products.Accesory;
import Distribuidores.products.ProductFinal;
import Distribuidores.services.Maintenance;
import Distribuidores.services.Reparation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    List<ProductFinal> finalProducts = new ArrayList<>();
    List<Accesory> accesories = new ArrayList<>();
    List<Maintenance> maintenances  = new ArrayList<>();
    List<Reparation> reparations = new ArrayList<>();
    List<Adquisition> adquisitions = new ArrayList<>();

    private String welcomeMsg = """
                <<--Bienvenido a JalaShop-->>\
                
                Por favor elige que es lo que quieres hacer:\
                
                (1)Elegir un producto\
                
                (2)Elegir un servicio\
                
                (3)Obtener todos las adquisiciones del dia\
                
                (0)Salir
                """;

    boolean loop = true;
    Scanner sc = new Scanner(System.in);

    public Menu() {

        while(loop) {
            System.out.println(welcomeMsg);
            int input  = sc.nextInt();
            sc.nextLine();
            switch(input) {
                case 1 :
                    MenuProduct menuProduct = new MenuProduct(finalProducts, accesories, adquisitions);
                    break;
                case 2 :
                    MenuService menuService = new MenuService(maintenances, reparations, adquisitions);
                    break;
                case 3 :
                    getDailyAdquisitions();
                    break;
                case 0 :
                    loop = false;
            }
        }
    }

    public void getDailyAdquisitions() {
        System.out.println("Estas son las adquisiciones del dia:");
        LocalDate today = LocalDate.now();
        for (Adquisition adquisition : adquisitions) {
            if (adquisition.getDate().toLocalDate().equals(today)) {
                System.out.println(adquisition.toString());
            }
        }
    }
}



