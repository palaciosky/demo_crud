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
  
}
