/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Objetos.Equipo;
import XML.XML;
import java.util.ArrayList;
import java.util.Iterator;
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
public class InterfazEquipos extends javax.swing.JFrame {

    XML conexion;

    /**
     * Creates new form Interfaz
     */
    public InterfazEquipos(XML conexion) {
        this.conexion = conexion;
        initComponents();
        actualizarTabla();
        actualizarTabla1();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actualizarTabla() {
        DefaultTableModel modelo = null;
        String[] titulos = {"Id_equipo", "Nombre", "Fundacion", "¿Tiene jugadores?"};
        modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ArrayList<Equipo> array = new ArrayList<Equipo>();
        array = conexion.consultaEquipos();
        Iterator<Equipo> equipos = array.iterator();
        while (equipos.hasNext()) {
            Equipo e = equipos.next();
            String[] fila = new String[4];
            fila[0] = String.valueOf(e.getId_equipo());
            fila[1] = e.getNombre();
            fila[2] = String.valueOf(e.getFundacion());
            if (e.getJugadores().size() == 0) {
                fila[3] = "No tiene jugadores";
            } else {
                fila[3] = "Tiene jugadores";
            }

            modelo.addRow(fila);

        }
        getTablaEquipos().setModel(modelo);

        for (int i = 0; i < 4; i++) {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            getTablaEquipos().getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }
    
    public void actualizarTabla1() {
        DefaultTableModel modelo = null;
        String[] titulos = {"Id_equipo", "Nombre", "Fundacion", "¿Tiene jugadores?"};
        modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ArrayList<Equipo> array = new ArrayList<Equipo>();
        array = conexion.consultaEquipos();
        Iterator<Equipo> equipos = array.iterator();
        while (equipos.hasNext()) {
            Equipo e = equipos.next();
            String[] fila = new String[4];
            fila[0] = String.valueOf(e.getId_equipo());
            fila[1] = e.getNombre();
            fila[2] = String.valueOf(e.getFundacion());
            if (e.getJugadores().size() == 0) {
                fila[3] = "No tiene jugadores";
            } else {
                fila[3] = "Tiene jugadores";
            }

            modelo.addRow(fila);

        }
        getTablaEquipos1().setModel(modelo);

        for (int i = 0; i < 4; i++) {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            getTablaEquipos().getColumnModel().getColumn(i).setCellRenderer(tcr);
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
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(palabra);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }
    
    public void limpiarPanelInsertar(){
        getTextIdEquipo().setText("");
        getTextNombreEquipo().setText("");
        getTextFundacionEquipo().setText("");
    }
    
    public void limpiarPanelModificar(){
        getTextIdEquipo1().setText("");
        getTextNombreEquipo1().setText("");
        getTextFundacionEquipo1().setText("");
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
        textIdEquipo = new javax.swing.JTextField();
        textNombreEquipo = new javax.swing.JTextField();
        textFundacionEquipo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEquipos = new javax.swing.JTable();
        botonInsertar = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textIdEquipo1 = new javax.swing.JTextField();
        textNombreEquipo1 = new javax.swing.JTextField();
        textFundacionEquipo1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEquipos1 = new javax.swing.JTable();
        botonLimpiar1 = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();
        botonGestion = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();

        setTitle("Gestion de equipos");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setText("GESTIÓN DE EQUIPOS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Id_equipo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nombre equipo");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Fundacion equipo");

        tablaEquipos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaEquipos);

        botonInsertar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonInsertar.setText("Insertar");
        botonInsertar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInsertarActionPerformed(evt);
            }
        });

        botonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar.png"))); // NOI18N
        botonLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(textFundacionEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(botonInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botonLimpiar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(textIdEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(textNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(175, 175, 175))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textIdEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(textNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(textFundacionEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(botonLimpiar))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Insertar", jPanel1);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 153, 0));
        jLabel5.setText("GESTIÓN DE EQUIPOS");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Id_equipo");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Nombre equipo");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Fundacion equipo");

        textNombreEquipo1.setEditable(false);

        textFundacionEquipo1.setEditable(false);

        tablaEquipos1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaEquipos1);

        botonLimpiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar.png"))); // NOI18N
        botonLimpiar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiar1ActionPerformed(evt);
            }
        });

        botonBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonBuscar.setForeground(new java.awt.Color(51, 204, 0));
        botonBuscar.setText("Buscar por id");
        botonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonGestion.setBackground(new java.awt.Color(0, 153, 0));
        botonGestion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonGestion.setForeground(new java.awt.Color(255, 255, 0));
        botonGestion.setText("Fichar/Despedir jugadores");
        botonGestion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionActionPerformed(evt);
            }
        });

        botonEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonEliminar.setForeground(new java.awt.Color(255, 0, 51));
        botonEliminar.setText("Eliminar equipo");
        botonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonModificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonModificar.setForeground(new java.awt.Color(0, 0, 255));
        botonModificar.setText("Modificar equipo");
        botonModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(textIdEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textNombreEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(textFundacionEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonGestion, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)
                                .addComponent(botonLimpiar1)))
                        .addGap(41, 41, 41))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(175, 175, 175))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textIdEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(textNombreEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(textFundacionEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(botonGestion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonModificar)
                            .addComponent(botonEliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(botonLimpiar1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInsertarActionPerformed
        if (comprobarEntero(getTextIdEquipo().getText())) {
            if (comprobarString(getTextNombreEquipo().getText())) {
                if (comprobarEntero(getTextFundacionEquipo().getText()) && getTextFundacionEquipo().getText().length() == 4) {
                    int id = Integer.parseInt(getTextIdEquipo().getText());
                    String nombre = getTextNombreEquipo().getText();
                    int fundacion = Integer.parseInt(getTextFundacionEquipo().getText());
                    Equipo e = new Equipo(id, nombre, fundacion);
                    if (conexion.insertarEquipo(e)) {
                        JOptionPane.showMessageDialog(this, "Equipo insertado", "Insertado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Ya existe equipo con este id o este nombre", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    actualizarTabla();
                    actualizarTabla1();
                    limpiarPanelInsertar();
                } else {
                    JOptionPane.showMessageDialog(this, "Escribe un año correcto de 4 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Escribe un nombre correcto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Escribe un id correcto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonInsertarActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        limpiarPanelInsertar();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiar1ActionPerformed
        limpiarPanelModificar();
    }//GEN-LAST:event_botonLimpiar1ActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        if(comprobarEntero(getTextIdEquipo1().getText())){
            int id = Integer.parseInt(getTextIdEquipo1().getText());
            Equipo e = conexion.devolverEquipoPorId(id);
            if (e == null) {
                JOptionPane.showMessageDialog(this, "No exixte equipo con este id", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                getTextNombreEquipo1().setText(e.getNombre());
                getTextFundacionEquipo1().setText(String.valueOf(e.getFundacion()));
            }
        }else{
            JOptionPane.showMessageDialog(this, "Escribe un id correcto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        if (comprobarEntero(getTextIdEquipo1().getText())) {
            Equipo e = conexion.devolverEquipoPorId(Integer.parseInt(getTextIdEquipo1().getText()));
            if (e == null) {
                JOptionPane.showMessageDialog(this, "No existe el equipo a borrar", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                if (conexion.eliminarEquipo(e)) {
                    JOptionPane.showMessageDialog(this, "Equipo eliminado", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No existe el equipo a borrar", "Error", JOptionPane.ERROR_MESSAGE);
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
        if (comprobarEntero(getTextIdEquipo1().getText())) {
            Equipo e = conexion.devolverEquipoPorId(Integer.parseInt(getTextIdEquipo1().getText()));
            if (e == null) {
                JOptionPane.showMessageDialog(this, "No existe el equipo a modificar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                InterfazModificarEquipo i = new InterfazModificarEquipo(e, this);
                limpiarPanelModificar();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Escribe un id correcto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionActionPerformed
        if (comprobarEntero(getTextIdEquipo1().getText())) {
            Equipo e = conexion.devolverEquipoPorId(Integer.parseInt(getTextIdEquipo1().getText()));
            if (e == null) {
                JOptionPane.showMessageDialog(this, "No existe el equipo a gestionar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                InterfazGestion i = new InterfazGestion(e,conexion,this);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Escribe un id correcto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonGestionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGestion;
    private javax.swing.JButton botonInsertar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonLimpiar1;
    private javax.swing.JButton botonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tablaEquipos;
    private javax.swing.JTable tablaEquipos1;
    private javax.swing.JTextField textFundacionEquipo;
    private javax.swing.JTextField textFundacionEquipo1;
    private javax.swing.JTextField textIdEquipo;
    private javax.swing.JTextField textIdEquipo1;
    private javax.swing.JTextField textNombreEquipo;
    private javax.swing.JTextField textNombreEquipo1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the tablaEquipos
     */
    public javax.swing.JTable getTablaEquipos() {
        return tablaEquipos;
    }

    /**
     * @return the textFundacionEquipo
     */
    public javax.swing.JTextField getTextFundacionEquipo() {
        return textFundacionEquipo;
    }

    /**
     * @return the textIdEquipo
     */
    public javax.swing.JTextField getTextIdEquipo() {
        return textIdEquipo;
    }

    /**
     * @return the textNombreEquipo
     */
    public javax.swing.JTextField getTextNombreEquipo() {
        return textNombreEquipo;
    }

    /**
     * @return the tablaEquipos1
     */
    public javax.swing.JTable getTablaEquipos1() {
        return tablaEquipos1;
    }

    /**
     * @return the textFundacionEquipo1
     */
    public javax.swing.JTextField getTextFundacionEquipo1() {
        return textFundacionEquipo1;
    }

    /**
     * @return the textIdEquipo1
     */
    public javax.swing.JTextField getTextIdEquipo1() {
        return textIdEquipo1;
    }

    /**
     * @return the textNombreEquipo1
     */
    public javax.swing.JTextField getTextNombreEquipo1() {
        return textNombreEquipo1;
    }
}
