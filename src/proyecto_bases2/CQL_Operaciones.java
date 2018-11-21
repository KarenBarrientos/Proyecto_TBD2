/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_bases2;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.exceptions.NoHostAvailableException;
import java.io.IOException;
import java.util.ArrayList;
import javax.naming.ConfigurationException;
import jdk.nashorn.internal.runtime.JSType;


public class CQL_Operaciones {
    
    private static Cluster cluster;
    private static Session session;
    
    public static Cluster connect(String node){
        return Cluster.builder().addContactPoint(node).build();
    }

    private static void IniciarConexion() {
        try {
            cluster = connect("127.0.0.1");
        } catch (NoHostAvailableException e) {
            throw new RuntimeException(e);

        }
    }

    public static void IniciarSesion(String KeySpaceName) {
        try {
            session = cluster.connect(KeySpaceName);
        } catch (NoHostAvailableException e) {
            throw new RuntimeException(e);
        }
    }

    public static void Crear_keySpace(String KeySpaceName) {
        session = cluster.connect();
        session.execute("CREATE KEYSPACE " + KeySpaceName + "WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1}");
    }

    public static void Eliminar_keySpace(String KeySpaceName) {
        session.execute("DROP KEYSPACE " + KeySpaceName);
    }

    public static void finalizarConexion() {
        session.close();
        cluster.close();
    }
    
}
