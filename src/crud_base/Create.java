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
public class Create {
    Create() throws SQLException {
     Scanner leer = new Scanner(System.in);
     Persona person = new Persona();// Objeto person de la clase Persona
        System.out.println("<< CREAR REGISTRO >>");
        
        System.out.println("| Nombre |");
        person.setNomRegistro(leer.nextLine());
        
        System.out.println("| Correo Electronico |");
        person.setEmailRegistro(leer.nextLine());
        
        System.out.println("| Telefonico  |");
        person.setTelRegistro(leer.nextLine());
        
        
        
        String tabla ="tb_registro";
        String camposTabla ="nom_registro, email_registro, tel_registro";
        String valoresCampos ="'"+person.getNomRegistro()+"','"+person.getEmailRegistro()+"','"+person.getTelRegistro()+"'";
        //Instacia u objeto de la clase ConexionCRUD
        ConexionCRUD utilerias = new ConexionCRUD();
        //Se envian los parametros necesarios pára guardar los registros al meotodo guardarRegistros
        utilerias.guardarRegistos(tabla,camposTabla,valoresCampos);
        MenuPrincipal.desplegarMenu();
    }
}
