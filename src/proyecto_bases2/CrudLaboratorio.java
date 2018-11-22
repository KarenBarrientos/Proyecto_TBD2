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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import jdk.nashorn.internal.runtime.JSType;

public class CrudLaboratorio {

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
            cquery += nombreColumnas[i] + " " + tipoDato[i] + ",";
        }
        cquery += "PRIMARY KEY (" + nombreColumnas[primaryKey] + ")";
        session.execute("CREATE TABLE " + nombreTabla + "(" + cquery + ")");
    }

    public static void eliminar_tabla(String tabla) {
        session.execute("DROP TABLE " + tabla);
    }

    public static void eliminar_datos(String tabla, String Condicional) {
        session.execute("DELETE FROM " + tabla + " WHERE " + Condicional);
    }

    public static void cantidad_datos(String tabla) {
        System.out.println(session.execute("SELECT COUNT(*) FROM " + tabla).all());
    }

    public static int select_datos(String tabla, String pais) {
        int Vistas = 0;
        ArrayList<Row> rs = (ArrayList<Row>) session.execute("SELECT SUM(peliculas_vistas) FROM clientes where pais='" + pais + "'");
        for (Row r : rs) {
            Vistas = r.getInt(0);
        }
        return Vistas;
    }

    public static void insertar_datos(String tabla, String[] columnas, ArrayList valores) {
        String campos = "";
        String values = "";

        for (int i = 0; i < columnas.length; i++) {
            campos += columnas[i] + ",";
            if (!JSType.isNumber(String.valueOf(valores.get(i)))) {
                values += "'" + valores.get(i) + ",";
            } else {
                values += valores.get(i) + ",";
            }
        }
        campos = campos.substring(0, campos.length() - 1);
        values = values.substring(0, values.length() - 1);
        session.execute("INSERT INTO " + tabla + " (" + campos + ") VALUES (" + values + ")");
    }

    public void create_Laboratorio(String id, String plazo_entrega, ArrayList<Productos> productos) {

        try {
            String ruta = "C:\\Users\\karen\\Documents\\NetBeansProjects\\Proyecto_TBD" + id + "lab" + ".txt";
            String contenido = "";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            String prot = "";
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < productos.size(); i++) {
                if (productos.get(i).isEstaProtegido()) {
                    prot = "0";
                } else {
                    prot = "1";
                }

                contenido += productos.get(i).getIdentificación() + "," + productos.get(i).getNombre() + "," + productos.get(i).getFabricante() + "," + String.valueOf(productos.get(i).getPrecioCosto()) + "," + String.valueOf(productos.get(i).getPrecioVenta()) + "," + String.valueOf(productos.get(i).getUnidades() + "," + prot + "\n");

            }
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String cqlStatementC = "INSERT INTO RDF.Laboratorios (id_Lab, plazoEntrega) "
                + "VALUES ('" + id + "', '" + plazo_entrega + "')";
        IniciarConexion();
        iniciarsesion("RDF");
        session.execute(cqlStatementC);
        finalizarConexion();
    }

    public void update_Laboratorio(String id, String plazo_entrega, Productos p) throws IOException {
        String cqlStatementU = "UPDATE RDF.Laboratorios "
                + "SET plazoEntrega = '" + plazo_entrega + "' "
                + "WHERE id_Lab = '" + id + "';";
        readp(id);
        int indice=0;
        for (int i = 0; i < prod.size(); i++) {
            if (prod.get(i).getIdentificación().equals(p.getIdentificación())) {
                indice=i;
            } 
        }
        if (prod.get(indice).getIdentificación().equals(p.getIdentificación())) {
                prod.remove(indice);
                prod.add(p);
            } else {
                prod.add(p);
            }
        try {
            String ruta = "C:\\Users\\karen\\Documents\\NetBeansProjects\\Proyecto_TBD" + id + "lab" + ".txt";
            String contenido = "";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            String prot = "";
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < prod.size(); i++) {
                if (prod.get(i).isEstaProtegido()) {
                    prot = "0";
                } else {
                    prot = "1";
                }

                contenido += prod.get(i).getIdentificación() + "," + prod.get(i).getNombre() + "," + prod.get(i).getFabricante() + "," + String.valueOf(prod.get(i).getPrecioCosto()) + "," + String.valueOf(prod.get(i).getPrecioVenta()) + "," + String.valueOf(prod.get(i).getUnidades() + "," + prot + "\n");

            }
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        IniciarConexion();
        iniciarsesion("RDF");
        session.execute(cqlStatementU);
        finalizarConexion();
    }

    public void delete_Laboratorio(String id) {
        String cqlStatementD = "DELETE FROM RDF.Laboratorios "
                + "WHERE id_Lab = '" + id + "';";

        IniciarConexion();
        iniciarsesion("RDF");
        session.execute(cqlStatementD);
        finalizarConexion();
    }

    public ArrayList<Productos> readp(String id) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/C:\\Users\\karen\\Documents\\NetBeansProjects\\Proyecto_TBD" + id + ".txt"));
        prod.clear();
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {

                StringTokenizer st = new StringTokenizer(line, ",");

                Productos p = new Productos(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), Integer.parseInt(st.nextToken()), false);
                String protegido = st.nextToken();
                if (protegido.equals("0")) {
                    p.setEstaProtegido(true);
                }
                prod.add(p);

                line = br.readLine();
            }

        } finally {
            br.close();
        }
        return prod;
    }

    public ArrayList<Laboratorio> read_Laboratorios() throws IOException {
        Labs.clear();
        String cqlStatement = "SELECT * FROM Laboratorios";
        for (Row row : session.execute(cqlStatement)) {
            StringTokenizer st = new StringTokenizer(row.toString(), ",");
            String id = st.nextToken();

            Laboratorio l = new Laboratorio(id, st.nextToken(), readp(id));
            Labs.add(l);
        }
        return Labs;
    }
    ArrayList<Laboratorio> Labs = new ArrayList();
    ArrayList<Productos> prod = new ArrayList();
}
