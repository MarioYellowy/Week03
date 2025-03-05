package Distribuidores.Menus;


import Distribuidores.Adquisition;
import Distribuidores.Client;
import Distribuidores.Enums.ServiceType;
import Distribuidores.services.Maintenance;
import Distribuidores.services.Reparation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class MenuService extends SubMenu {

    boolean loop = true;
    Scanner sc = new Scanner(System.in);

    public MenuService(List<Maintenance> maintenances, List<Reparation> reparations, List<Adquisition> adquisitions) {
        while(loop) {
            showSubMenu();
            int input  = sc.nextInt();
            sc.nextLine();
            switch(input) {
                case 1 :
                    createNewMaintenance(maintenances);
                    break;
                case 2 :
                    createNewReparation(reparations);
                    break;
                case 3 :
                    getAllMaintenance(maintenances);
                    createMaintenancesAdquisition(adquisitions, maintenances);
                    break;
                case 4 :
                    getAllReparations(reparations);
                    createReparationAdquisition(adquisitions, reparations);
                    break;
                case 5 :
                    loop = false;
                    break;
            }
        }
    }

    @Override
    public void showSubMenu() {
        System.out.println("""
                Que accion quiere realizar:
                (1)Crear nuevo servicio de mantenimiento
                (2)Crear nuevo servicio de reparacion
                (3)Elegir servicio de mantenimiento
                (4)Elegir servicio de reparacion
                (5)Cancelar
                """);
    }

    public void createNewMaintenance(List<Maintenance> maintenances) {
        System.out.println("Para crear el servicio de mantenimiento necesita indicar ciertos datos:");
        System.out.println("Comenzando por su nombre:");
        String name = sc.nextLine();
        System.out.println("Inserta un descripcion breve:");
        String description = sc.nextLine();
        System.out.println("Ahora inserta el costo:");
        double cost = sc.nextDouble();
        sc.nextLine();
        System.out.println("Por ultimo el descuento con el que cuenta");
        double discount = sc.nextDouble();
        sc.nextLine();
        Maintenance newMaintenance = new Maintenance(name, description, cost, discount);

        maintenances.add(newMaintenance);
    }

    public void createNewReparation(List<Reparation> reparations) {
        System.out.println("Para crear el servicio de reparacion necesita indicar ciertos datos:");
        System.out.println("Comenzando por su nombre:");
        String name = sc.nextLine();
        System.out.println("Inserta un descripcion breve:");
        String description = sc.nextLine();
        System.out.println("Ahora inserta el costo:");
        double cost = sc.nextDouble();
        sc.nextLine();
        System.out.println("Por ultimo el descuento con el que cuenta");
        double discount = sc.nextDouble();
        sc.nextLine();
        Reparation newReparation = new Reparation(name, description, cost, discount);

        reparations.add(newReparation);
    }

    @Override
    public Client createClient() {
        System.out.println("Se necesitan ciertos datos para poder obtener el servicio");
        System.out.println("Nombre del cliente:");
        String name = sc.nextLine();
        System.out.println("Numero telefonico:");
        String phone = sc.nextLine();
        return new Client(name, phone);
    }

    public void getAllMaintenance(List<Maintenance> maintenances) {
        int count = 0;
        for (Maintenance maintenance : maintenances) {
            if (maintenance.getServiceType() == ServiceType.MAINTENANCE){
                System.out.println(count + ".- " + maintenance.getName());
            }
            count++;
        }
    }

    public void getAllReparations(List<Reparation> reparations) {
        int count = 0;
        for (Reparation reparation : reparations) {
            if (reparation.getServiceType() == ServiceType.REPARATION){
                System.out.println(count + ".- " + reparation.getName());
            }
            count++;
        }
    }

    public void createMaintenancesAdquisition(List<Adquisition> adquisitions, List<Maintenance> maintenances) {
        LocalDateTime date = LocalDateTime.now();
        Client client  = createClient();
        System.out.println("Estos son los servicios de mantenimiento disponibles:");
        getAllMaintenance(maintenances);
        System.out.println("Seleccione que mantenimiento quiere:");
        int index = sc.nextInt();
        sc.nextLine();
        Maintenance maintenance = maintenances.get(index);
        System.out.println("Por ultimo indique si tiene alguna observacion con respecto al mantenimiento:");
        String observation = sc.nextLine();

        Adquisition newAdquisition = new Adquisition(date, client, maintenance, observation);

        adquisitions.add(newAdquisition);

    }

    public void createReparationAdquisition(List<Adquisition> adquisitions, List<Reparation> reparations) {
        LocalDateTime date = LocalDateTime.now();
        Client client  = createClient();
        System.out.println("Estos son los servicios de reparacion disponibles:");
        getAllReparations(reparations);
        System.out.println("Seleccione que producto quiere:");
        int index = sc.nextInt();
        sc.nextLine();
        Reparation reparation = reparations.get(index);
        System.out.println("Por ultimo indique si tiene alguna observacion con respecto al accesorio:");
        String observation = sc.nextLine();

        Adquisition newAdquisition = new Adquisition(date, client, reparation, observation);

        adquisitions.add(newAdquisition);

    }
}
