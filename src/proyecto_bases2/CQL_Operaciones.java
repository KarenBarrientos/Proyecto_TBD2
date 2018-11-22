/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_bases2;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.exceptions.NoHostAvailableException;
import java.util.ArrayList;
import jdk.nashorn.internal.runtime.JSType;

/**
 *
 * @author jeanwahlung
 */
public class CQL_Operaciones {

    private static Cluster cluster;
    private static Session session;

    public static Cluster connect(String node) {
        return Cluster.builder().addContactPoint(node).build();
    }

    public static void IniciarConexion() {
        try {
            cluster = connect("127.0.0.1");
        } catch (NoHostAvailableException e) {
            throw new RuntimeException(e);

        }
        System.out.println("se conecto");

    }

    public static void iniciarsesion(String KeySpaceName) {
        try {
            session = cluster.connect(KeySpaceName);
        } catch (NoHostAvailableException e) {
            throw new RuntimeException(e);
        }
    }

    public static void Crear_KeySpace(String KeySpaceName) {
        session = cluster.connect();
        session.execute("CREATE KEYSPACE " + KeySpaceName + " WITH replication={'class':'SimpleStrategy','replication_factor':1}");
    }

    public static void Eliminar_Keyspace(String KeySpaceName) {
        session.execute("DROP KEYSPACE " + KeySpaceName);
    }

    public static void finalizarConexion() {
        session.close();
        cluster.close();
    }

    public static void crear_tabla(String nombreTabla, String[] nombreColumnas, String[] tipoDato, int primaryKey) {
        String cquery = "";
        for (int i = 0; i < nombreColumnas.length; i++) {
            cquery += nombreColumnas[i] +" "+ tipoDato[i]+",";
        }
        cquery += "PRIMARY KEY ("+ nombreColumnas[primaryKey]+")";
        session.execute("CREATE TABLE "+ nombreTabla + "("+cquery+")");
    }
    public static void eliminar_tabla(String tabla){
        session.execute("DROP TABLE "+ tabla);
    }
    
    public static void eliminar_datos(String tabla, String Condicional){
        session.execute("DELETE FROM "+ tabla+" WHERE "+ Condicional);
    }
    
    public static void cantidad_datos(String tabla){
        System.out.println(session.execute("SELECT COUNT(*) FROM "+ tabla).all());
    }
    
    public static int select_datos(String tabla , String pais){
        int Vistas=0;
        ArrayList<Row> rs =(ArrayList<Row>) session.execute("SELECT SUM(peliculas_vistas) FROM clientes where pais='"+pais+"'");
        for(Row r:rs){
            Vistas= r.getInt(0);
        }
        return Vistas;
    }
    
    public static void insertar_datos(String tabla , String[] columnas,ArrayList valores){
        String campos="";
        String values ="";
        
        for (int i = 0; i < columnas.length; i++) {
            campos += columnas[i] + ",";
            if(!JSType.isNumber(String.valueOf(valores.get(i)))){
                values+= "'"+ valores.get(i)+",";
            } else{
                values += valores.get(i)+",";
            }
        }
        campos = campos.substring(0, campos.length() -1);
        values = values.substring(0, values.length()-1);
        session.execute("INSERT INTO "+ tabla+" ("+ campos+") VALUES ("+ values+ ")");
    }
}
