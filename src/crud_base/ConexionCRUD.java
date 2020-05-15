/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_base;
import java.sql.*;

/**
 *
 * @author Palacios
 */
public class ConexionCRUD {
   private final String servidor = "jdbc:mysql://127.0.0.1:3306/db_registros";
    //Nombre de usuario de la base de datos (root por defecto )
    private final String usuario = "root";
    //la password de la misma
    private final String clave = "";
    //La liberia de de mysqlo
    private final String driverConector = "com.mysql.jdbc.Driver";
    //el objeto de la clase Connnertion del paquete java.sql
    private static Connection conexion;
    
    public ConexionCRUD(){
    try {
     Class.forName(driverConector);//Levantar el driver
     //Establece conexion
     conexion = DriverManager.getConnection(servidor, usuario, clave);
    }catch (ClassNotFoundException | SQLException e){
        System.out.println("SE DAÑO ESTA DB! :"+e.getMessage());
    }
    
    }

  public Connection getConnection(){
  return conexion;//Devuelve el objeto conexion
  }

  public void guardarRegistos (String tabla,String camposTabla,String valoresCampos){
  ConexionCRUD conectar = new ConexionCRUD();
  Connection cone = conectar.getConnection();
  try{
  //Definir la setencia sql
  String sqlQueryStmt ="INSERT INTO "+tabla+"("+camposTabla+") VALUES ("+valoresCampos+");";
  //Establecemos la comunicacion entre nuestra aplicacion java y la database
  Statement stmt; //Envia sentencias sql a la database
  stmt = cone.createStatement();
  stmt.executeUpdate(sqlQueryStmt);//Ejecuta la setencia sql
  //Cerrar el statement y la conexio. se cierran en onrden inverso de como se ha abierto
  stmt.close();
  cone.close();
  System.out.println("Registro Guardado");
  }catch(SQLException e){
      System.out.println("Error de ingreso "+e.getMessage());
  }
  }
  public void actualizarEliminarRegistro(String tabla, String valoresCamposNuevos, String condicion){
  //Cargar la conexion
  ConexionCRUD conectar = new ConexionCRUD();
  Connection cone = conectar.getConnection();
  try{
  Statement stmt;
  String sqlQueryStmt;
  //Verificar que valoresCamposNuevos venga vacia y asi seleccionar si es borrar o registrar nuevo
      if (valoresCamposNuevos.isEmpty()) {
          sqlQueryStmt = "DELETE FROM "+ tabla + " WHERE " +condicion+ ";";          
      }else{
         sqlQueryStmt = "UPDATE "+ tabla +" SET "+ valoresCamposNuevos + " WHERE " + condicion + ";";
         
      }
      stmt = cone.createStatement();
      stmt.executeUpdate(sqlQueryStmt);
      stmt.close();
      
  }catch(SQLException ex){
      System.out.println("Paso el siguiente error "+ex.getMessage());
  }
 
  }
  
  public void desplegarRegistros (String tablaBuscar, String camposBuscar, String condicionBuscar ) throws SQLException{
  //Cargar la conexion
  ConexionCRUD conectar = new ConexionCRUD();
  Connection cone = conectar.getConnection();
  try{
   Statement stmt;
   String sqlQueryStmt;
      if (condicionBuscar.equals("")) {
          sqlQueryStmt = "SELECT " + camposBuscar + " FROM " + tablaBuscar + ";";
           
      }else{
          sqlQueryStmt = " SELECT " + camposBuscar + " FROM " + tablaBuscar + " WHERE " + condicionBuscar;
      }
    stmt = cone.createStatement();
    stmt.executeQuery(sqlQueryStmt);
    //le indicamos que ejecute la consulta de la tabla y le pasamos por argumentos nuestra sentencia
    try(ResultSet miResultSet = stmt.executeQuery(sqlQueryStmt)){
        if (miResultSet.next()) {//Ubica el cursor en la primera fila el numero de columnas de la consulta
            ResultSetMetaData metaData = miResultSet.getMetaData();
            int numColumnas = metaData.getColumnCount();
            System.out.println("<< REGISTROS ALMACENADOS");
            System.out.println();
            
            for (int i = 1; i <= numColumnas; i++) {
                //Muestra los titulos de las columnas y %-20s/t indica la separacion entre columnas
                System.out.printf("%-20s\t", metaData.getColumnName(i));
            }
            System.out.println();
            do {
                for (int i = 1; i <= numColumnas; i++) {
                    System.out.printf("%-20s\t", miResultSet.getObject(i));
                }
                System.out.println();
            } while (miResultSet.next());
            System.out.println();
            
        }else{
            System.out.println("No se han encontrado ningun registro");
        }
        miResultSet.close(); //Cerrar el ResultSet
    }finally{
    //Cerrar el Statement y la Conexion; se cierran en orden inverso de como se ha abierto
    stmt.close();
    cone.close();
    }
    
   } catch (SQLException ex){
      System.out.println("Ocurrio el siguiente Error; "+ex.getMessage());
   }
  }  
}
