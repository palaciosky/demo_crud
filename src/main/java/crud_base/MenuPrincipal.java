/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_base;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Palacios
 */
public class MenuPrincipal {
    public static void main(String[] args) throws SQLException {
        desplegarMenu();
    }

    public static void desplegarMenu() throws SQLException {
        Scanner opcionSeleccionada = new Scanner(System.in); 
        String opcionMenu;
        //menu que se va a desplegar
        System.out.println("***************************************");
        System.out.println("|   MENU CRUD DE ESTUDIANTES            ");
        System.out.println("****************************************");
        System.out.println("| Opciones: |");
        System.out.println("|           1. Crear registros          ");
        System.out.println("|           2. Consultar registros      ");
        System.out.println("|           3. Actualizar registros     ");
        System.out.println("|           4. Eliminar registros       ");
        System.out.println("            5. Salir                    ");
        System.out.println("***************************************");
        System.out.println("Seleccione opción: ");
        opcionMenu = opcionSeleccionada.next();
   
      switch(opcionMenu){
          case "1": 
              //Create create = new Create();
              break;
          case "2":
              //Read read = new Read();
              break;
          case "3":
              //Update update = new Update();
              break;
          case "4":
             //Delete delete = new Delete();
              break;
          case "5":
              System.exit(0);
              break;
          default:
           System.out.println("Seleccion no valida");
           break;
      }
    
    }
}

