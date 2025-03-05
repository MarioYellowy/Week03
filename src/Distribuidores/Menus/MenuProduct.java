package Distribuidores.Menus;

import Distribuidores.Adquisition;
import Distribuidores.Client;
import Distribuidores.Enums.ProductType;
import Distribuidores.products.Accesory;
import Distribuidores.products.ProductFinal;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class MenuProduct extends SubMenu{

    boolean loop = true;
    Scanner sc = new Scanner(System.in);

    public MenuProduct(List<ProductFinal> productFinals, List<Accesory> accesories, List<Adquisition> adquisitions) {
        while(loop) {
            showSubMenu();
            int input  = sc.nextInt();
            sc.nextLine();
            switch(input) {
                case 1 :
                    createNewProduct(productFinals);
                    break;
                case 2 :
                    createNewAccesory(accesories);
                    break;
                case 3 :
                    getAllProducts(productFinals);
                    createProductAdquisition(adquisitions, productFinals);
                    break;
                case 4 :
                    getAllAccesories(accesories);
                    createAccesoryAdquisition(adquisitions, accesories);
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
                (1)Crear nuevo producto
                (2)Crear nuevo accesorio
                (3)Elegir producto
                (4)Elegir accesorio
                (5)Cancelar
                """);
    }

    public void createNewProduct(List<ProductFinal> products) {
        System.out.println("Para crear el producto necesita indicar ciertos datos:");
        System.out.println("Comenzando por su nombre:");
        String name = sc.nextLine();
        System.out.println("Elija el color:");
        super.showColors();
        int color = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingresa el precio del producto:");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingresa una descripcion breve:");
        String description = sc.nextLine();
        System.out.println("Ingresa el descuento que tiene el producto:");
        double discount = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingresa el modelo del producto:");
        String model = sc.nextLine();
        ProductFinal newProduct = new ProductFinal(name, color, price, description, discount, model);

        products.add(newProduct);
    }

    public void createNewAccesory(List<Accesory> accesories) {
        System.out.println("Para crear el accesorio necesita indicar ciertos datos:");
        System.out.println("Comenzando por su nombre:");
        String name = sc.nextLine();
        System.out.println("Elija el color:");
        super.showColors();
        int color = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingresa el precio del accesorio:");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingresa una descripcion breve:");
        String description = sc.nextLine();
        System.out.println("Ingresa el descuento que tiene el accesorio:");
        double discount = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingresa el modelo del accesorio:");
        String model = sc.nextLine();
        Accesory newAccesory = new Accesory(name, color, price, description, discount, model);

        accesories.add(newAccesory);
    }

    @Override
    public Client createClient() {
        System.out.println("Se necesitan ciertos datos para poder obtener el producto");
        System.out.println("Nombre del cliente:");
        String name = sc.nextLine();
        System.out.println("Numero telefonico:");
        String phone = sc.nextLine();
        return new Client(name, phone);
    }

    public void getAllProducts(List<ProductFinal> products) {
        int count = 0;
        System.out.println("Estos son todos los productos");
        for (ProductFinal product : products) {
            if (product.getType() == ProductType.FINAL){
                System.out.println(count + ".- " + product.getName());
            }
            count++;
        }
    }

    public void getAllAccesories(List<Accesory> accesories) {
        int count = 0;
        System.out.println("Estos son todos los accesorios");
        for (Accesory accesory : accesories) {
            if (accesory.getType() == ProductType.ACCESORIO){
                System.out.println(count + ".- " + accesory.getName());
            }
            count++;
        }
    }

    public void createProductAdquisition(List<Adquisition> adquisitions, List<ProductFinal> products) {
        LocalDateTime date = LocalDateTime.now();
        Client client  = createClient();
        getAllProducts(products);
        System.out.println("Seleccione que producto quiere:");
        int index = sc.nextInt();
        sc.nextLine();
        ProductFinal productFinal = products.get(index);
        System.out.println("Por ultimo indique si tiene alguna observacion con respecto al producto:");
        String observation = sc.nextLine();

        Adquisition newAdquisition = new Adquisition(date, client, productFinal, observation);

        adquisitions.add(newAdquisition);

    }

    public void createAccesoryAdquisition(List<Adquisition> adquisitions, List<Accesory> accesories) {
        LocalDateTime date = LocalDateTime.now();
        Client client  = createClient();
        System.out.println("Estos son los productos disponibles:");
        getAllAccesories(accesories);
        System.out.println("Seleccione que producto quiere:");
        int index = sc.nextInt();
        sc.nextLine();
        Accesory accesory = accesories.get(index);
        System.out.println("Por ultimo indique si tiene alguna observacion con respecto al accesorio:");
        String observation = sc.nextLine();

        Adquisition newAdquisition = new Adquisition(date, client, accesory, observation);

        adquisitions.add(newAdquisition);

    }
}
