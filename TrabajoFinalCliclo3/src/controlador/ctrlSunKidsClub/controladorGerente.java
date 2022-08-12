/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ctrlSunKidsClub;

import controlador.conexion.SQLclass;
import controlador.dao.AdaptadorDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.SumKids.Estudiantes;
import modelo.SumKids.Gerente;
import modelo.SumKids.Profesores;
import modelo.enums.estadoMatricula;

/**
 *
 * @author Jose Yangari
 */
public class controladorGerente  extends AdaptadorDao<Gerente>{
   
    private Gerente gerente;
   
   public controladorGerente(){
            super(Gerente.class);
        }
    public Gerente getGerente(){
            if (gerente==null) {
               gerente = new Gerente();
            }
            return gerente;
        }
   
    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
   public void AsignarDocente(){
       Estudiantes e = new Estudiantes();
     
   }
     public Boolean guardarModificar(){
            try{
                if (this.getGerente().getId_empleado()!= null) {
                    modificar(this.getGerente());
                }else{
                    guardar(this.getGerente());
                }
                return true;
            }catch(Exception e){
                System.out.println("Error"+e);
                return false;
            }
        }
     
     
}