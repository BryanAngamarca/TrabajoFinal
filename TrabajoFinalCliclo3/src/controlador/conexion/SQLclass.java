
package controlador.conexion;



import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author jordy
 */
public class SQLclass {
    private static final String driver ="oracle.jdbc.driver.OracleDriver";
    private static final String url ="jdbc:oracle:thin:@localhost:1521:XE";
   private static final String user = "SUNKIDS";
    private static final String password = "sunkids";
    public static Connection conecction;
    public SQLclass() {
    }
    public static Connection getConection(){
        if (conecction == null) 
            Conexion();
            return conecction;
    }
    
     public static Connection Conexion(){
      conecction = null;
         try {
            Class.forName(driver);
           DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
             System.out.println("Conectando a la base de datos Sunkids");
           conecction = DriverManager.getConnection(url, user, password);
             System.out.println("conectado");
         }catch (Exception e) {
            System.out.println("Fallo de conexion error!: "+e);
        }
               return conecction;
    }
     public static void main(String[] args) {
       Connection cn  = SQLclass.getConection();
       try  {
           System.out.println(cn.getCatalog());
       }catch(Exception e ){
           System.out.println("eroor");
       }
    }
  
}
