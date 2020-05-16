/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_base;
import java.sql.SQLException;


/**
 *
 * @author Palacios
 */
public class Read {
public Read() throws SQLException{
    System.out.println("<< CONSULTA DE REGISTROS >>");
    mostrarResultados();
} 

private void mostrarResultados() throws SQLException{
try{
ConexionCRUD utilerias = new ConexionCRUD();
String tabla = "tb_registro";
String camposTabla = "*";
//Condicion que se envia vacia para indicar que todos los registros se necesitan mostrar
String condicionBusqueda = "";
//Metodo que realiza la busqueda
utilerias.desplegarRegistros(tabla, camposTabla, condicionBusqueda);
}catch(SQLException ex){
    System.out.println("Error en la busqueda de:"+ex.getMessage());
}finally{
MenuPrincipal.desplegarMenu();
}
}
}
