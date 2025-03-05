package Distribuidores.Menus;

import Distribuidores.Client;

public abstract class SubMenu {

    public SubMenu() {}

    public abstract void showSubMenu();

    public abstract Client createClient();

    public void showColors() {
        System.out.println("""
                Estos son los colores disponibles:\
                
                (0) Azul
                (1) Rojo
                (2) Verde
                (3) Negro
                (4) Blanco
                (5) Amarillo
                (6) Gris
                (7) Dorado
                """);
    }

}
