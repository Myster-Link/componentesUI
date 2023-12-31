
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.componentes.ui.panels;

import com.componentes.controllers.PersistenceManager;
import com.componentes.entitys.*;
import com.componentes.services.*;
import com.componentes.utils.TablaUtils;
import jakarta.persistence.EntityManager;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author chris
 */
public class ProyectoPanel extends javax.swing.JPanel {

    EntityManager em;

    Comentario comentario;
    Proyectos proyecto;
    Empleados empleado;

    ComentarioService comentarioService;
    ProyectoService proyectoService;
    EmpleadoService empleadoService;

    public ProyectoPanel() {
        initComponents();

        em = PersistenceManager.getEntityManager();

        rellenarTabla();

        jTable3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Verificar si la selección de fila cambió
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTable3.getSelectedRow();
                    if (selectedRow != -1) {
                        // Obtener datos de la fila seleccionada y hacer lo que necesites
                        Object id = jTable3.getValueAt(selectedRow, 0);
                        Object nombre = jTable3.getValueAt(selectedRow, 1);
                        Object lider = jTable3.getValueAt(selectedRow, 2);
                        Object cedulaLider = jTable3.getValueAt(selectedRow, 3);

                        NombreProyecto.setText(nombre.toString());
                        CedulaLider.setText(cedulaLider.toString());

                        proyecto = new Proyectos();

                        proyecto.setId(Integer.parseInt(id.toString()));
                        proyecto.setNombreProyecto(nombre.toString());
                    }
                }
            }
        });

        TableComentarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Verificar si la selección de fila cambió
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = TableComentarios.getSelectedRow();
                    if (selectedRow != -1) {
                        // Obtener datos de la fila seleccionada y hacer lo que necesites
                        Object id = TableComentarios.getValueAt(selectedRow, 0);
                        Object text = TableComentarios.getValueAt(selectedRow, 1);

                        ComentarioProyecto.setText(text.toString());

                        comentario = new Comentario();

                        comentario.setId(Integer.parseInt(id.toString()));
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        NombreProyecto = new javax.swing.JTextField();
        CedulaLider = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        BtnGuardarComentarios = new javax.swing.JButton();
        BtnLimpiarCamposProyecto = new javax.swing.JButton();
        BtnCancelarProyecto = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        ComentarioProyecto = new javax.swing.JTextField();
        BtnGuardarProyecto = new javax.swing.JButton();
        BtnCancelarComentario = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableComentarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Nombre el proyecto");

        NombreProyecto.setBackground(new java.awt.Color(204, 204, 204));

        CedulaLider.setBackground(new java.awt.Color(204, 204, 204));

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Cedula del lider");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre del proyecto", "Empleado lider"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        BtnGuardarComentarios.setBackground(new java.awt.Color(0, 0, 153));
        BtnGuardarComentarios.setForeground(new java.awt.Color(255, 255, 255));
        BtnGuardarComentarios.setText("Guardar");
        BtnGuardarComentarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarComentariosActionPerformed(evt);
            }
        });

        BtnLimpiarCamposProyecto.setBackground(new java.awt.Color(102, 102, 255));
        BtnLimpiarCamposProyecto.setForeground(new java.awt.Color(255, 255, 255));
        BtnLimpiarCamposProyecto.setText("Limpiar campos");
        BtnLimpiarCamposProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarCamposProyectoActionPerformed(evt);
            }
        });

        BtnCancelarProyecto.setBackground(new java.awt.Color(204, 0, 0));
        BtnCancelarProyecto.setForeground(new java.awt.Color(255, 255, 255));
        BtnCancelarProyecto.setText("Eliminar");
        BtnCancelarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarProyectoActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Agregar comentarios");

        ComentarioProyecto.setBackground(new java.awt.Color(204, 204, 204));

        BtnGuardarProyecto.setBackground(new java.awt.Color(0, 0, 153));
        BtnGuardarProyecto.setForeground(new java.awt.Color(255, 255, 255));
        BtnGuardarProyecto.setText("Guardar");
        BtnGuardarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarProyectoActionPerformed(evt);
            }
        });

        BtnCancelarComentario.setBackground(new java.awt.Color(204, 0, 0));
        BtnCancelarComentario.setForeground(new java.awt.Color(255, 255, 255));
        BtnCancelarComentario.setText("Eliminar");
        BtnCancelarComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarComentarioActionPerformed(evt);
            }
        });

        TableComentarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id ", "Comentario", "Proyecto"
            }
        ));
        jScrollPane2.setViewportView(TableComentarios);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 102, 255));
        jLabel1.setText("COMENTARIOS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 102, 255));
        jLabel2.setText("PROYECTOS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ComentarioProyecto))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(BtnGuardarProyecto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtnCancelarProyecto))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(CedulaLider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                        .addComponent(NombreProyecto, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(BtnLimpiarCamposProyecto))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(BtnGuardarComentarios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnCancelarComentario)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(NombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CedulaLider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BtnCancelarProyecto)
                                    .addComponent(BtnGuardarProyecto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnLimpiarCamposProyecto)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ComentarioProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BtnGuardarComentarios)
                                    .addComponent(BtnCancelarComentario))
                                .addContainerGap())
                            .addComponent(jScrollPane3)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1128, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void rellenarTabla() {
        try (EntityManager em = PersistenceManager.getEntityManager()) {
            // Para Proyectos
            ProyectoService proyectoService = new ProyectoService();
            ComentarioService comentarioService = new ComentarioService();

            String[] columnsProyecto = {"ID", "NombreProyecto", "Lider Proyecto", "Cedula del lider"};
            List<Proyectos> proyectos = proyectoService.readAll(em);
            String[] attProyect = {"Id", "NombreProyecto", "LiderProyecto.Nombre", "LiderProyecto.Cedula"};
            TablaUtils.rellenarTabla(jTable3, columnsProyecto, proyectos, attProyect);

            String[] columnsComen = {"Id", "Texto", "Proyecto"};
            List<Comentario> comentarios = comentarioService.readAll(em);
            String[] attComen = {"Id", "Texto", "Proyecto.NombreProyecto"};
            TablaUtils.rellenarTabla(TableComentarios, columnsComen, comentarios, attComen);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            PersistenceManager.closeEntityManager(em);
        }
    }


    private void BtnGuardarComentariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarComentariosActionPerformed

        try (EntityManager em = PersistenceManager.getEntityManager()) {
            if (!ComentarioProyecto.getText().equals("")) {

                comentario = new Comentario();

                comentarioService = new ComentarioService();

                if (proyecto != null && proyecto.getId() != null) {
                    proyectoService = new ProyectoService();
                    proyecto = proyectoService.read(em, proyecto.getId());

                    if (proyecto != null) {
                        comentario.setTexto(ComentarioProyecto.getText());
                        comentario.setProyecto(proyecto);

                        comentarioService.create(em, comentario);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al obtener el proyecto", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un proyecto válido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rellene los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            BtnLimpiarCamposProyectoActionPerformed(null);
            PersistenceManager.closeEntityManager(em);
            rellenarTabla();
        }
    }//GEN-LAST:event_BtnGuardarComentariosActionPerformed

    private void BtnLimpiarCamposProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarCamposProyectoActionPerformed
        NombreProyecto.setText("");
        CedulaLider.setText("");
        ComentarioProyecto.setText("");
        jTable3.clearSelection();
        TableComentarios.clearSelection();

        if (this.proyecto != null) {
            this.proyecto.setId(0);
        }
        if (this.empleado != null) {
            this.empleado.setId(0);
        }
        if (this.comentario != null) {
            this.comentario.setId(0);
        }

    }//GEN-LAST:event_BtnLimpiarCamposProyectoActionPerformed

    private void BtnCancelarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarProyectoActionPerformed

        try (EntityManager em = PersistenceManager.getEntityManager()) {

            proyectoService = new ProyectoService();

            if (proyecto.getId() != null) {
                proyectoService.delete(em, proyecto.getId());
                JOptionPane.showMessageDialog(null, "Eliminado correctamente", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un proyecto", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            BtnLimpiarCamposProyectoActionPerformed(null);
            PersistenceManager.closeEntityManager(em);
            rellenarTabla();
        }
    }//GEN-LAST:event_BtnCancelarProyectoActionPerformed

    private void BtnGuardarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarProyectoActionPerformed

        try (EntityManager em = PersistenceManager.getEntityManager()) {
            if (!NombreProyecto.getText().equals("") && !CedulaLider.getText().equals("")) {

                proyecto = new Proyectos();
                empleado = new Empleados();

                proyectoService = new ProyectoService();
                empleadoService = new EmpleadoService();

                empleado = empleadoService.readAllByCedula(em, Integer.parseInt(CedulaLider.getText()));

                if (empleado != null) {
                    proyecto.setNombreProyecto(NombreProyecto.getText());
                    proyecto.setLiderProyecto(empleado);

                    proyectoService.create(em, proyecto);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al obtener el empleado", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Rellene los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            BtnLimpiarCamposProyectoActionPerformed(null);
            PersistenceManager.closeEntityManager(em);
            rellenarTabla();
        }
    }//GEN-LAST:event_BtnGuardarProyectoActionPerformed

    private void BtnCancelarComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarComentarioActionPerformed
        try (EntityManager em = PersistenceManager.getEntityManager()) {

            comentarioService = new ComentarioService();

            if (comentario.getId() != null) {
                comentarioService.delete(em, comentario.getId());
                JOptionPane.showMessageDialog(null, "Eliminado correctamente", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un proyecto", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            BtnLimpiarCamposProyectoActionPerformed(null);
            PersistenceManager.closeEntityManager(em);
            rellenarTabla();
        }
    }//GEN-LAST:event_BtnCancelarComentarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelarComentario;
    private javax.swing.JButton BtnCancelarProyecto;
    private javax.swing.JButton BtnGuardarComentarios;
    private javax.swing.JButton BtnGuardarProyecto;
    private javax.swing.JButton BtnLimpiarCamposProyecto;
    private javax.swing.JTextField CedulaLider;
    private javax.swing.JTextField ComentarioProyecto;
    private javax.swing.JTextField NombreProyecto;
    private javax.swing.JTable TableComentarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
