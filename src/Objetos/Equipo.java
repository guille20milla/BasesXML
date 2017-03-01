/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Alumno
 */
public class Equipo {

    private int id_equipo;
    private String nombre;
    private int fundacion;
    private Set<Jugador> jugadores;

    public Equipo(int id, String n, int f) {
        this.id_equipo = id;
        this.nombre = n;
        this.fundacion = f;
        this.jugadores = new HashSet<Jugador>();
    }

    public Equipo(String xml) {
        DocumentBuilder db;

        try {
            db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc;
            doc = db.parse(new InputSource(new StringReader(xml)));
            id_equipo = Integer.parseInt(doc.getElementsByTagName("Id_equipo").item(0).getFirstChild().getNodeValue());
            nombre = doc.getElementsByTagName("Nombre_equipo").item(0).getFirstChild().getNodeValue();
            fundacion = Integer.parseInt(doc.getElementsByTagName("Año_fundacion").item(0).getFirstChild().getNodeValue());
            jugadores = new TreeSet<Jugador>();

            NodeList xmlJugadores = doc.getElementsByTagName("Jugador");
            int numJugadores = xmlJugadores.getLength();
            for (int i = 0; i < numJugadores; i++) {
                String idJugador = xmlJugadores.item(i).getChildNodes().item(1).getFirstChild().getNodeValue();
                String nombreJugador = xmlJugadores.item(i).getChildNodes().item(3).getFirstChild().getNodeValue();
                String edadJugador = xmlJugadores.item(i).getChildNodes().item(5).getFirstChild().getNodeValue();
                String posicionJugador = xmlJugadores.item(i).getChildNodes().item(7).getFirstChild().getNodeValue();

                Jugador j = new Jugador(Integer.parseInt(idJugador), nombreJugador, Integer.parseInt(edadJugador), posicionJugador);
                jugadores.add(j);
            }
        } catch (SAXException ex) {
            Logger.getLogger(Equipo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Equipo.class.getName()).log(Level.SEVERE, null, ex);
        } catch(ParserConfigurationException ex ){
            ex.printStackTrace();
        }

    }

    /**
     * @return the id_equipo
     */
    public int getId_equipo() {
        return id_equipo;
    }

    /**
     * @param id_equipo the id_equipo to set
     */
    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fundacion
     */
    public int getFundacion() {
        return fundacion;
    }

    /**
     * @param fundacion the fundacion to set
     */
    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }

    /**
     * @return the jugadores
     */
    public Set<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     * @param jugadores the jugadores to set
     */
    public void setJugadores(Set<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    
    public String toString(){
		String jugadores = "";
		if (getJugadores().size() > 0){
			jugadores = "<Jugadores>";
			for(Jugador p : getJugadores()){
				jugadores += p.toString();
			}
			jugadores += "</Jugadores>";
		}
		return "<Equipo>"
				+ "<Id_equipo>" + getId_equipo() + "</Id_equipo>"
				+ "<Nombre_equipo>" + getNombre() + "</Nombre_equipo>"
                                + "<Año_fundacion>" + getFundacion() + "</Año_fundacion>"
				+ "<Jugadores>"+jugadores+"</Jugadores>"
				+ "</Equipo>";
	}
}
