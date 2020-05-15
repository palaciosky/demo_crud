/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_base;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Palacios
 */
public class Persona {
 private int idRegistro;
 private String nomRegistro;
 private String emailRegistro;
 private String telRegistro;
 
public int getIdRegistro()
{
  return idRegistro;
}

public void setIdRegistro (int idRegistro){
this.idRegistro = idRegistro;
}
//////////////////////////////

public String getNomRegistro()
{
  return nomRegistro;
}

public void setNomRegistro (String nomRegistro){
this.nomRegistro = nomRegistro;
}

//////////////////////////////

public String getEmailRegistro()
{
  return emailRegistro;
}

public void setEmailRegistro (String emailRegistro){
this.emailRegistro = emailRegistro;
}

//////////////////////////////

public String getTelRegistro()
{
  return telRegistro;
}

public void setTelRegistro (String telRegistro){
this.telRegistro = telRegistro;
}
}
