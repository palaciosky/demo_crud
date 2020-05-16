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
public class Update  {
    Update() throws SQLException {
    Scanner leer = new Scanner(System.in);
    Persona person = new Persona();
    ConexionCRUD utilerias = new ConexionCRUD();
        System.out.println("<< ACTUALIZAR REGISTROS >>");
        
        System.out.println("Ingresar id del registro a modificar: ");
        person.setIdRegistro(leer.nextInt());
        
        //reingreso de datos para actualizar
        String tablaBuscar = "tb_registro";
        String campoBuscar = "id_registro, nom_registro, email_registro, tel_registro";
        String condicionBuscar = "id_registro = "+person.getIdRegistro();
        utilerias.desplegarRegistros(tablaBuscar, campoBuscar, condicionBuscar);
        
        System.out.println();
        System.out.println("Nombre: ");
        person.setNomRegistro(leer.nextLine());
        person.setNomRegistro(leer.nextLine());
        
        System.out.println("Email ");
        person.setEmailRegistro(leer.nextLine());
        
        System.out.println("Telefono ");
        person.setTelRegistro(leer.nextLine());
        
       
        
        String tabla = "tb_registro";
        String camposValoresNuevos = "nom_registro ='"+person.getNomRegistro()+"',email_registro ='"+person.getEmailRegistro()+"', tel_registro = '"+person.getTelRegistro()+"'";
        
        utilerias.actualizarEliminarRegistro(tabla, camposValoresNuevos, condicionBuscar);
        System.out.println("Modificado correctamente!");
        MenuPrincipal.desplegarMenu();
    }
    
}
