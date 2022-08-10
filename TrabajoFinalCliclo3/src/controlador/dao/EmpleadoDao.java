/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.conexion.SQLclass;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.SumKids.Empleados;

/**
 *
 * @author Jordy
 */
public class EmpleadoDao extends AdaptadorDao<Empleados>{
        private Empleados empleado;
        
        public Empleados getEmpleado(){
            if (empleado==null) {
                empleado = new Empleados();
                
            }
            return empleado;
        }
        public void setEmpleado(Empleados em){
            this.empleado=em;
        }
        
        public EmpleadoDao(){
            super(Empleados.class);
        }
        public Boolean guardarModificar(){
            try{
                if (this.getEmpleado().getId_empleado()!= null) {
                    modificar(this.getEmpleado());
                    
                }else{
                    guardar(this.getEmpleado());
                }
                return true;
            }catch(Exception e){
                System.out.println("Error"+e);
                return false;
            }
        }
        
         public Autorizacion entrar(Persona p) {
        Autorizacion au = new Autorizacion();
        au.setuOD(2);
        try {
            String slq = "SELECT Nombre FROM persona WHERE Clave='" + p.getClave() + "'";
            PreparedStatement pps = con.prepareStatement(slq);
            ResultSet rs = pps.executeQuery();
            while (rs.next()) {
                au.setAuto(true);

            }

            slq = "SELECT Nombre FROM admin WHERE Clave='" + p.getClave() + "'";
            pps = con.prepareStatement(slq);
            rs = pps.executeQuery();
            while (rs.next()) {
                au.setAuto(true);
             
            }

        } catch (SQLException ex) {
        }
        if (au.isAuto() ) {
            au.setAuto(false);
            try {
                String slq = "SELECT Clave FROM persona WHERE Nombre='" + p.getNombre() + "'";
                PreparedStatement pps = con.prepareStatement(slq);
                ResultSet rs = pps.executeQuery();
                while (rs.next()) {
                    au.setP(p);
                    au.setAuto(true);
                    au.setuOD(0);
                }
                slq = "SELECT Clave FROM admin WHERE Nombre='" + p.getNombre() + "'";
                pps = con.prepareStatement(slq);
                rs = pps.executeQuery();
                while (rs.next()) {
                    au.setP(p);
                    au.setAuto(true);
                    au.setuOD(1);
                }
            } catch (SQLException ex) {
            }
        }
        return au;
    }
}
