/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import services.Structer;

/**
 *
 * @author sing1
 */
public class ListStructDialog extends javax.swing.JDialog {
    private Structer structer = new Structer();
    /**
     * Creates new form ListStructDialog
     */
    public ListStructDialog(java.awt.Frame parent, boolean modal, String title) {
        super(parent, modal);
        initComponents();
        setTitle(title);
        try {
            loadData();
            reset();
            this.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot load data", "Error", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }

    private void loadData() throws IOException {
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) this.tblListStruct.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        this.tblListStruct.setModel(structer.getListStructs());
        this.tblListStruct.setDefaultEditor(Object.class, null);
        this.tblListStruct.setFocusable(false);
        this.tblListStruct.setAutoCreateRowSorter(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListStruct = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnDuplicate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("List struct");
        setIconImage(((MainForm) this.getParent()).getIconImage());
        setMinimumSize(new java.awt.Dimension(550, 400));

        tblListStruct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Struct name", "Type file", "Header", "Type list", "Object"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListStruct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListStructMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListStruct);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnDuplicate.setText("Dupplicate");
        btnDuplicate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuplicateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(btnDuplicate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnDuplicate)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reset() {
        this.tblListStruct.clearSelection();
        this.btnEdit.setEnabled(false);
        this.btnDelete.setEnabled(false);
        this.btnDuplicate.setEnabled(false);
    }

    public void updateStruct(String structName, String typeFile, String header, String typeList, String object, String fileNameOutput) {
        int selectedRow = this.tblListStruct.getSelectedRow();
        this.tblListStruct.setValueAt(structName, selectedRow, 0);
        this.tblListStruct.setValueAt(typeFile, selectedRow, 1);
        this.tblListStruct.setValueAt(header, selectedRow, 2);
        this.tblListStruct.setValueAt(typeList, selectedRow, 3);
        this.tblListStruct.setValueAt(object, selectedRow, 4);
        this.tblListStruct.setValueAt(fileNameOutput, selectedRow, 5);
    }

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (this.tblListStruct.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(this, "Please select only one struct to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (this.tblListStruct.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a struct to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = this.tblListStruct.getSelectedRow();
        String name = (String) this.tblListStruct.getValueAt(row, 0);
        new StructDialog((MainForm) this.getParent(), true, this, "Edit struct", name);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int[] selectedRows = this.tblListStruct.getSelectedRows();
        if (selectedRows.length < 1) {
            JOptionPane.showMessageDialog(this, "Please select a struct to delete", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected structs?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            List<String> deleted = new ArrayList<String>();
            List<String> notDeleted = new ArrayList<String>();
            List<String> errors = new ArrayList<String>();
            DefaultTableModel model = (DefaultTableModel) this.tblListStruct.getModel();
            MainForm rootParent = (MainForm) this.getParent();
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                String name = (String) this.tblListStruct.getValueAt(selectedRows[i], 0);
                try {
                    String result = structer.deleteStruct(name);
                    deleted.add(result);
                    model.removeRow(selectedRows[i]);
                    rootParent.removeStruct(result);
                } catch (Exception e) {
                    notDeleted.add(name);
                    errors.add(e.getMessage());
                }
            }
            reset();
            String error = errors.size() > 0 ? "\nError: " + String.join("\n", errors) : "";
            JOptionPane.showMessageDialog(this, "Deleted: " + String.join(", ", deleted) + "\nNot deleted: " + String.join(", ", notDeleted) + error, "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDuplicateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuplicateActionPerformed
        if (this.tblListStruct.getSelectedRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Please select a struct to duplicate.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (this.tblListStruct.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(this, "Please select only one struct to duplicate.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        MainForm rootParent = (MainForm) this.getParent();
        StructNameDialog structNameDialog = new StructNameDialog(rootParent, true);
        try {
            if (structNameDialog.isOK()) {
                String sourceStructName = (String) this.tblListStruct.getValueAt(this.tblListStruct.getSelectedRow(), 0);
                HashMap<String, String> struct = structer.duplicateStruct(sourceStructName, structNameDialog.getStructName());
                DefaultTableModel model = (DefaultTableModel) this.tblListStruct.getModel();
                model.addRow(new Object[]{struct.get("STRUCT_NAME"), struct.get("TYPE_FILE"), struct.get("HEADER"), struct.get("TYPE_LIST"), struct.get("OBJECT"), struct.get("FILE_NAME_OUTPUT")});
                rootParent.addStruct(struct.get("STRUCT_NAME"));
                reset();
                JOptionPane.showMessageDialog(this, "Duplicated struct: " + struct.get("STRUCT_NAME"), "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        structNameDialog.dispose();
    }//GEN-LAST:event_btnDuplicateActionPerformed

    private void tblListStructMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListStructMouseClicked
        if (this.tblListStruct.getSelectedRowCount() > 1) {
            this.btnEdit.setEnabled(false);
            this.btnDuplicate.setEnabled(false);
            this.btnDelete.setEnabled(true);
            return;
        }
        if (this.tblListStruct.getSelectedRowCount() < 1) {
            this.btnEdit.setEnabled(false);
            this.btnDuplicate.setEnabled(false);
            this.btnDelete.setEnabled(false);
            return;
        }
        if (this.tblListStruct.getSelectedRowCount() == 1) {
            this.btnEdit.setEnabled(true);
            this.btnDuplicate.setEnabled(true);
            this.btnDelete.setEnabled(true);
                if (evt.getClickCount() == 2) {
                    btnEditActionPerformed(null);
                }
            return;
        }
    }//GEN-LAST:event_tblListStructMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListStructDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListStructDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListStructDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListStructDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListStructDialog dialog = new ListStructDialog(new MainForm(), true, "List structs");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDuplicate;
    private javax.swing.JButton btnEdit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListStruct;
    // End of variables declaration//GEN-END:variables
}