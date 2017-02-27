/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Objetos.Equipo;
import Objetos.Jugador;
import XML.XML;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alumno
 */
public class InterfazJugadores extends javax.swing.JFrame {

    XML conexion;
    Equipo e;

    /**
     * Creates new form InterfazJugadores
     */
    public InterfazJugadores(XML conexion, Equipo e) {
        this.conexion = conexion;
        this.e = e;
        initComponents();
        actualizarTabla();
        actualizarTabla1();
        setTitle("Gestion del equipo: "+e.getNombre());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actualizarTabla() {
        DefaultTableModel modelo = null;
        String[] titulos = {"Id_jugador", "Nombre", "Edad", "Posicion"};
        modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Set<Jugador> array = new TreeSet<Jugador>();
        array = e.getJugadores();
        Iterator<Jugador> jugadores = array.iterator();
        while (jugadores.hasNext()) {
            Jugador j = jugadores.next();
            String[] fila = new String[4];
            fila[0] = String.valueOf(j.getId_jugador());
            fila[1] = j.getNombre();
            fila[2] = String.valueOf(j.getEdad());
            fila[3] = j.getPosicion();

            modelo.addRow(fila);

        }
        getTablaJugadores().setModel(modelo);

        for (int i = 0; i < 4; i++) {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            getTablaJugadores().getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }

    public void actualizarTabla1() {
        DefaultTableModel modelo = null;
        String[] titulos = {"Id_jugador", "Nombre", "Edad", "Posicion"};
        modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Set<Jugador> array = new TreeSet<Jugador>();
        array = e.getJugadores();
        Iterator<Jugador> jugadores = array.iterator();
        while (jugadores.hasNext()) {
            Jugador j = jugadores.next();
            String[] fila = new String[4];
            fila[0] = String.valueOf(j.getId_jugador());
            fila[1] = j.getNombre();
            fila[2] = String.valueOf(j.getEdad());
            fila[3] = j.getPosicion();

            modelo.addRow(fila);

        }
        getTablaJugadores1().setModel(modelo);

        for (int i = 0; i < 4; i++) {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            getTablaJugadores().getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }

    public boolean comprobarDatosPanelInsertar() {
        if (comprobarEntero(getTextIdJugador().getText())) {
            if (comprobarString(getTextNombreJugador().getText())) {
                if (comprobarEntero(getTextEdadJugador().getText())) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(this, "Escribe una edad correcto", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Escribe un nombre correcto", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Escribe un id correcto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean comprobarEntero(String numero) {
        Pattern p = Pattern.compile("(\\d)+");
        Matcher m = p.matcher(numero);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean comprobarString(String palabra) {
        Pattern p = Pattern.compile("([A-Z]|[a-z]|ñ|Ñ)+");
        Matcher m = p.matcher(palabra);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public void limpiarPanelInsertar() {
        getTextEdadJugador().setText("");
        getTextIdJugador().setText("");
        getTextNombreJugador().setText("");
    }

    public void limpiarPanelModificar() {
        getTextEdadJugador1().setText("");
        getTextIdJugador1().setText("");
        getTextNombreJugador1().setText("");
        getTextPosicionJugador1().setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textIdJugador = new javax.swing.JTextField();
        textNombreJugador = new javax.swing.JTextField();
        textEdadJugador = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJugadores = new javax.swing.JTable();
        botonInsertar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        comboPosicionJuagdor = new javax.swing.JComboBox();
        botonLimpiarIns = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textIdJugador1 = new javax.swing.JTextField();
        textNombreJugador1 = new javax.swing.JTextField();
        textEdadJugador1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaJugadores1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        textPosicionJugador1 = new javax.swing.JTextField();
        botonEliminar = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        botonLimpiarMod = new javax.swing.JButton();

        setTitle("Gestion de jugadores");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setText("GESTIÓN DE JUGADORES");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Id_jugador");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nombre jugador");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Edad");

        tablaJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaJugadores);

        botonInsertar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonInsertar.setText("Insertar");
        botonInsertar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInsertarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Posicion");

        comboPosicionJuagdor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Portero", "Defensa", "Medio", "Delantero" }));

        botonLimpiarIns.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar.png"))); // NOI18N
        botonLimpiarIns.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonLimpiarIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarInsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textEdadJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textIdJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(166, 166, 166)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)))
                            .addComponent(botonInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboPosicionJuagdor, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(72, 72, 72))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(botonLimpiarIns)
                                .addGap(57, 57, 57))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textIdJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(textNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textEdadJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(comboPosicionJuagdor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonLimpiarIns))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(botonInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane2.addTab("Insertar", jPanel1);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 153, 0));
        jLabel7.setText("GESTIÓN DE JUGADORES");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Id_jugador");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Nombre jugador");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Edad");

        textNombreJugador1.setEditable(false);

        textEdadJugador1.setEditable(false);

        tablaJugadores1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaJugadores1);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Posicion");

        botonBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonBuscar.setForeground(new java.awt.Color(0, 204, 0));
        botonBuscar.setText("Buscar por Id");
        botonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        textPosicionJugador1.setEditable(false);

        botonEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonEliminar.setForeground(new java.awt.Color(255, 0, 51));
        botonEliminar.setText("Eliminar jugador");
        botonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonModificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonModificar.setForeground(new java.awt.Color(0, 0, 255));
        botonModificar.setText("Modificar jugador");
        botonModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        botonLimpiarMod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar.png"))); // NOI18N
        botonLimpiarMod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonLimpiarMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarModActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(textIdJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(botonBuscar))
                                    .addComponent(textEdadJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonLimpiarMod)
                                .addGap(58, 58, 58))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textPosicionJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textNombreJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(72, 72, 72))))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(textIdJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(textNombreJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonBuscar))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(textEdadJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(textPosicionJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonModificar)
                            .addComponent(botonEliminar)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonLimpiarMod)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane2.addTab("Modificaciones generales", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInsertarActionPerformed
        if (comprobarDatosPanelInsertar()) {
            int id = Integer.parseInt(getTextIdJugador().getText());
            String nombre = getTextNombreJugador().getText();
            int edad = Integer.parseInt(getTextEdadJugador().getText());
            String pos = getComboPosicionJuagdor().getSelectedItem().toString();
            Jugador j = new Jugador(id, nombre, edad, pos);
            if (conexion.insertarJugador(e,j)) {
                e.getJugadores().add(j);
                JOptionPane.showMessageDialog(this, "Jugador insertado", "Insertado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Ya existe jugador con este id o este nombre", "Error", JOptionPane.ERROR_MESSAGE);
            }

            actualizarTabla();
            actualizarTabla1();
            limpiarPanelInsertar();
        }
    }//GEN-LAST:event_botonInsertarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        if (comprobarEntero(getTextIdJugador1().getText())) {
            int id = Integer.parseInt(getTextIdJugador1().getText());
            Jugador j = conexion.devolverJugadorPorId(e,id);
            if (j == null) {
                JOptionPane.showMessageDialog(this, "No existe el jugador a borrar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (conexion.eliminarJugador(j)) {
                    e.getJugadores().remove(j);
                    JOptionPane.showMessageDialog(this, "Jugador eliminado", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No existe el jugador a borrar", "Error", JOptionPane.ERROR_MESSAGE);
                }
                actualizarTabla();
                actualizarTabla1();
                limpiarPanelModificar();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Escribe un id correcto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        if (comprobarEntero(getTextIdJugador1().getText())) {
            int id = Integer.parseInt(getTextIdJugador1().getText());
            Jugador j = conexion.devolverJugadorPorId(e,id);
            if (j == null) {
                JOptionPane.showMessageDialog(this, "No existe el jugador a modificar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                InterfazModificarJugador i = new InterfazModificarJugador(e,j, this);
                limpiarPanelModificar();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Escribe un id correcto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        if (comprobarEntero(getTextIdJugador1().getText())) {
            int id = Integer.parseInt(getTextIdJugador1().getText());
            Jugador j = conexion.devolverJugadorPorId(e, id);
            if (j == null) {
                JOptionPane.showMessageDialog(this, "No exixte nadie con este id", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                getTextNombreJugador1().setText(j.getNombre());
                getTextEdadJugador1().setText(String.valueOf(j.getEdad()));
                getTextPosicionJugador1().setText(j.getPosicion());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Escribe un id correcto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonLimpiarInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarInsActionPerformed
        limpiarPanelInsertar();
    }//GEN-LAST:event_botonLimpiarInsActionPerformed

    private void botonLimpiarModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarModActionPerformed
        limpiarPanelModificar();
    }//GEN-LAST:event_botonLimpiarModActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonInsertar;
    private javax.swing.JButton botonLimpiarIns;
    private javax.swing.JButton botonLimpiarMod;
    private javax.swing.JButton botonModificar;
    private javax.swing.JComboBox comboPosicionJuagdor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tablaJugadores;
    private javax.swing.JTable tablaJugadores1;
    private javax.swing.JTextField textEdadJugador;
    private javax.swing.JTextField textEdadJugador1;
    private javax.swing.JTextField textIdJugador;
    private javax.swing.JTextField textIdJugador1;
    private javax.swing.JTextField textNombreJugador;
    private javax.swing.JTextField textNombreJugador1;
    private javax.swing.JTextField textPosicionJugador1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the tablaJugadores
     */
    public javax.swing.JTable getTablaJugadores() {
        return tablaJugadores;
    }

    /**
     * @return the textEdadJugador
     */
    public javax.swing.JTextField getTextEdadJugador() {
        return textEdadJugador;
    }



    /**
     * @return the textIdJugador
     */
    public javax.swing.JTextField getTextIdJugador() {
        return textIdJugador;
    }

    /**
     * @return the textNombreJugador
     */
    public javax.swing.JTextField getTextNombreJugador() {
        return textNombreJugador;
    }

    /**
     * @return the comboPosicionJuagdor
     */
    public javax.swing.JComboBox getComboPosicionJuagdor() {
        return comboPosicionJuagdor;
    }

    /**
     * @return the textEdadJugador1
     */
    public javax.swing.JTextField getTextEdadJugador1() {
        return textEdadJugador1;
    }


    /**
     * @return the textIdJugador1
     */
    public javax.swing.JTextField getTextIdJugador1() {
        return textIdJugador1;
    }

    /**
     * @return the textNombreJugador1
     */
    public javax.swing.JTextField getTextNombreJugador1() {
        return textNombreJugador1;
    }

    /**
     * @return the textPosicionJugador1
     */
    public javax.swing.JTextField getTextPosicionJugador1() {
        return textPosicionJugador1;
    }

    /**
     * @return the tablaJugadores1
     */
    public javax.swing.JTable getTablaJugadores1() {
        return tablaJugadores1;
    }
}
