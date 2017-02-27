/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import Objetos.Equipo;
import Objetos.Jugador;
import java.util.ArrayList;
import java.util.Set;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

/**
 *
 * @author Alumno
 */
public class XML {

    static String driver = "org.exist.xmldb.DatabaseImpl"; //Driver para eXist
    static String URI = "xmldb:exist://localhost:8083/exist/xmlrpc/db/ColeccionPruebas"; //URI colección   
    static String usu = "admin"; //Usuario
    static String usuPwd = ""; //Clave
    static Collection col = null;

    public static Collection conectar() {

        try {
            Class cl = Class.forName(driver); //Cargar del driver 
            Database database = (Database) cl.newInstance(); //Instancia de la BD
            DatabaseManager.registerDatabase(database); //Registro del driver
            col = DatabaseManager.getCollection(URI, usu, usuPwd);
            return col;
        } catch (XMLDBException e) {
            System.out.println("Error al inicializar la BD eXist.");
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Error en el driver.");
            //e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("Error al instanciar la BD.");
            //e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("Error al instanciar la BD.");
            //e.printStackTrace();
        }
        return null;
    }

    public boolean insertarEquipo(Equipo e) {
        try {
            XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            ResourceSet result = servicio.query("update insert " + e.toString() + " into /Equipos");
            col.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public Equipo devolverEquipoPorId(int id) {
        try {
            XPathQueryService servicio;
            servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            ResourceSet result = servicio.query("/Equipos/Equipo[Id_equipo=" + id + "]");
            ResourceIterator i;
            i = result.getIterator();
            if (!i.hasMoreResources()) {
                return null;
            } else {
                Resource r = i.nextResource();
                Equipo f = new Equipo((String) r.getContent());
                col.close();
                return f;
            }
        } catch (XMLDBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean eliminarEquipo(Equipo e) {
        try {
            XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            ResourceSet result = servicio.query(
                    "update delete /Equipos/Equipo[Id_equipo=" + e.getId_equipo() + "]");
            col.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<Jugador> devolverJugadores() {
        ArrayList<Equipo> all = consultaEquipos();
        ArrayList<Jugador> set = new ArrayList<>();
        all.forEach(f -> {
            f.getJugadores().forEach(a -> {
                if (!set.contains(a)) {
                    set.add(a);
                }
            });
        });
        return set;
    }

    public void modificarEquipo(Equipo e) {
        try {
            XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            ResourceSet result = servicio.query(
                    "update replace /Equipos/Equipo[Id_equipo=" + e.getId_equipo() + "] with" + e.toString());

            col.close();
        } catch (Exception ex) {
        }
    }

    public ArrayList<Equipo> consultaEquipos() {
        ArrayList<Equipo> array = new ArrayList<Equipo>();
        if (conectar() != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                ResourceSet result = servicio.query("for $eq in /Equipos/Equipo return $eq");
                // recorrer los datos del recurso.  
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                }
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    Equipo e = new Equipo((String) r.getContent());
                    array.add(e);
                }
                col.close();
            } catch (XMLDBException e) {
                System.out.println(" ERROR AL CONSULTAR DOCUMENTO.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Error en la conexión. Comprueba datos.");
        }
        return array;
    }
}