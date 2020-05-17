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
public class Delete {
    Delete() throws SQLException{
        Scanner leer = new Scanner(System.in);
        ConexionCRUD utilerias = new ConexionCRUD();
        System.out.println("<< ELIMINAR REGISTROS >>");
         
        System.out.println("Ingrese el id del registro: ");
        String idEstudianteEliminar =leer.next();
        //Reingreso de datos para actualizar
        String tabla = "tb_inf";
        String campos = "*";
        String condicion = "id_estudiante = "+idEstudianteEliminar;
        utilerias.desplegarRegistros(tabla, campos, condicion);
        
        System.out.println("¿Estas seguro? Presione <Y> PARA ELIMINAR");
        String confirmarBorrar = leer.next();
        
        if ("Y".equals(confirmarBorrar)) {
            //Se le deja vacio el metodo actualizarEliminarRegistro
            //envie solamente los parametros de tabla y condicion y poder eliminar
            String valoresCamposNuevos = "";
            utilerias.actualizarEliminarRegistro(tabla, valoresCamposNuevos, condicion);
            System.out.println("Registro Eliminado sastifactoriamente");
        }
       MenuPrincipal.desplegarMenu();
    }
}
