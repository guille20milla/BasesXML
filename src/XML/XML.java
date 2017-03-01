/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import Objetos.Equipo;
import Objetos.Jugador;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
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
            if (comprobarIdEquipo(e.getId_equipo())) {
                return false;
            } else {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                ResourceSet result = servicio.query("update insert " + e.toString() + " into /Equipos");
                col.close();
                return true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean insertarJugador(Equipo e, Jugador j) {
        try {
            if (comprobarIdJugador(j.getId_jugador())) {
                return false;
            } else {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                ResourceSet result = servicio.query("update insert " + j.toString() + " into /Equipos/Equipo[Id_equipo=" + e.getId_equipo() + "]/Jugadores");
                col.close();
                return true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
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

    public Jugador devolverJugadorPorId(Equipo e, int id) {
        Jugador jugadorADevolver = null;
        Set<Jugador> array = new TreeSet<Jugador>();
        array = e.getJugadores();
        Iterator<Jugador> jugadores = array.iterator();
        while (jugadores.hasNext()) {
            Jugador j = jugadores.next();
            if (j.getId_jugador() == id) {
                jugadorADevolver = j;
            }
        }
        return jugadorADevolver;
    }

    public boolean eliminarEquipo(Equipo e) {
        try {
            if (comprobarIdEquipo(e.getId_equipo())) {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                ResourceSet result = servicio.query(
                        "update delete /Equipos/Equipo[Id_equipo=" + e.getId_equipo() + "]");
                col.close();
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarJugador(Jugador j) {
        try {
            if (comprobarIdJugador(j.getId_jugador())) {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                ResourceSet result = servicio.query(
                        "update delete /Equipos/Equipo/Jugadores/Jugador[Id_jugador=" + j.getId_jugador() + "]");
                col.close();
                return true;
            } else {
                return false;
            }

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

    public boolean modificarEquipo(Equipo e) {
        try {
            if (comprobarIdEquipo(e.getId_equipo())) {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                ResourceSet result = servicio.query(
                        "update replace /Equipos/Equipo[Id_equipo=" + e.getId_equipo() + "] with" + e.toString());

                col.close();
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }

    public void modificarJugador(Jugador j) {
        try {
            XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            ResourceSet result = servicio.query(
                    "update replace /Equipos/Equipo/Jugadores/Jugador[Id_jugador=" + j.getId_jugador() + "] with" + j.toString());

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

    public boolean comprobarIdEquipo(int id) {
        //Devuelve true si el dep existe
        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                ResourceSet result = servicio.query(
                        "/Equipos/Equipo[Id_equipo=" + id + "]");
                ResourceIterator i;
                i = result.getIterator();
                col.close();
                if (!i.hasMoreResources()) {
                    return false;
                } else {
                    return true;
                }
            } catch (Exception e) {
                System.out.println("Error al consultar.");
                // e.printStackTrace();
            }
        } else {
            System.out.println("Error en la conexión. Comprueba datos.");
        }

        return false;
    }

    public boolean comprobarIdJugador(int id) {
        //Devuelve true si el dep existe
        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                ResourceSet result = servicio.query(
                        "/Equipos/Equipo/Jugadores/Jugador[Id_jugador=" + id + "]");
                ResourceIterator i;
                i = result.getIterator();
                col.close();
                if (!i.hasMoreResources()) {
                    return false;
                } else {
                    return true;
                }
            } catch (Exception e) {
                System.out.println("Error al consultar.");
                // e.printStackTrace();
            }
        } else {
            System.out.println("Error en la conexión. Comprueba datos.");
        }

        return false;
    }
}
