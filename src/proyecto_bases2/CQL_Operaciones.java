/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_bases2;

/**
 *
 * @author Karen Medina
 */
public class CQL_Operaciones {
    
    private static Cluster cluster;
    private static Session session;
    
    private static void IniciarConexion(){
        try {
            cluster = connect("192.168.0.1");
        } catch (NoMostAvailableException e) {
            throw new  RuntimeException(e);
            
        }
    }
    
    public static void IniciarSesion(String KeySpaceName){
        try {
            session = cluster.connect(KeySpaceName);
        } catch (NoMostAvailableException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void Crear_keySpace(String KeySpaceName){
        session = cluster.connect();
        session.execute("CREATE KEYSPACE "+ KeySpaceName + "WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1}")
    }
    
    public static void Eliminar_keySpace (String KeySpaceName){
        session.execute("DROP KEYSPACE "+ KeySpaceName);
    }
    
    public static void finalizarConexion(){
        session.close();
        cluster.close();
    }
}
