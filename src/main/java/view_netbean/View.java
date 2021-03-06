/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_netbean;

import controller.CovidReportController;
import exception.CovidException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.ResultTable;
import model.enumm.GroupMethod;
import model.enumm.ReportMetric;
import model.enumm.WayOfCalculation;
import model.time_range.TimeRange;
import model.time_range.TimeRangeTypeFive;
import model.time_range.TimeRangeTypeFour;
import model.time_range.TimeRangeTypeOne;
import model.time_range.TimeRangeTypeThree;
import model.time_range.TimeRangeTypeTwo;

/**
 *
 */
public class View extends javax.swing.JFrame {

    private CovidReportController controller;
    private Map<String, String> countryMapping;
    private Map<String, Set<String>> continentMapping;

    /**
     * Creates new form View
     */
    public View() {
        controller = new CovidReportController();
        initComponents();
        countryMapping = controller.getCountries();
        continentMapping = controller.getContinents();
        List<String> continentChoices = new ArrayList<>(continentMapping.keySet());
        Collections.sort(continentChoices);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(continentChoices.toArray(String[]::new)));
        updateContriesSelectBoxByContinent();
        updateTimeRangeComb();
    }

    private void updateContriesSelectBoxByContinent() {
        String selected = jComboBox1.getSelectedItem().toString();
        List<String> newChoices = new ArrayList<>(continentMapping.get(selected));
        Collections.sort(newChoices);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(newChoices.toArray(String[]::new)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COVID 19 SUMMARY");

        jLabel1.setText("Continent");

        jLabel2.setText("Country");

        jLabel4.setText("Time range");

        jLabel5.setText("Group method");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField1.setText("jTextField1");
        jTextField1.setUI(null);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "group(s)", "day(s)" }));

        jLabel6.setText("Metric");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Positive Cases", "Deaths", "People Vaccinated" }));

        jLabel7.setText("Way of calculation");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "New Total", "Up To" }));

        jLabel8.setText("Display");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tabular", "Chart" }));

        jButton1.setText("Summary");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("End");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Range", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A pair of start date and end date (inclusive)", "A number of days from a particular date", "A number of weeks from a particular date", "A number of days to a particular date", "A number of weeks to a particular date" }));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel6))
                                        .addGap(67, 67, 67)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox7, javax.swing.GroupLayout.Alignment.TRAILING, 0, 255, Short.MAX_VALUE)
                                    .addComponent(jTextField4)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel3)
                        .addContainerGap(347, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private Integer getNumberOfGroup() {
        Integer numberOfGroups = -1;
        System.out.println(jTextField2.getText());
        try {
            numberOfGroups = Integer.parseInt(jTextField2.getText());
            if (numberOfGroups < 0) {
                JOptionPane.showMessageDialog(null, "Group method - less than 0");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Group method - wrong format");
        }
        return numberOfGroups;
    }

    private TimeRange getTimeRange() {
        Integer selected = jComboBox7.getSelectedIndex();
        String up = jTextField3.getText();
        String down = jTextField4.getText();
        switch (selected) {
            case 0:
                return new TimeRangeTypeOne(getDate(up), getDate(down));
            case 1:
                return new TimeRangeTypeTwo(getInteger(up), getDate(down));
            case 2:
                return new TimeRangeTypeThree(getInteger(up), getDate(down));
            case 3:
                return new TimeRangeTypeFour(getInteger(up), getDate(down));
            case 4:
                return new TimeRangeTypeFive(getInteger(up), getDate(down));
        }
        return null;
    }

    private Integer getInteger(String text) {
        return Integer.parseInt(text);
    }

    private boolean isPositiveNumber(String text) {
        try {
            return Integer.parseInt(text) > 0;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean isDate(String text) {
        final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy");
        try {
            LocalDate localDate = LocalDate.parse(text, FORMATTER);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    private LocalDate getDate(String text) {
        final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy");
        try {
            LocalDate localDate = LocalDate.parse(text, FORMATTER);
            return localDate;
        } catch (Exception ex) {
            return null;
        }
    }

    private boolean validateTimeRange() {
        Integer selected = jComboBox7.getSelectedIndex();
        String up = jTextField3.getText();
        String down = jTextField4.getText();
        switch (selected) {
            case 0:
                return isDate(up) && isDate(down) && (getDate(up).isBefore(getDate(down)) || getDate(up).equals(getDate(down)));
            case 1:
                return isPositiveNumber(up) && isDate(down);
            case 2:
                return isPositiveNumber(up) && isDate(down);
            case 3:
                return isPositiveNumber(up) && isDate(down);
            case 4:
                return isPositiveNumber(up) && isDate(down);
        }
        return false;
    }

    private ReportMetric getReportMetric(String metricStr) {
        switch (metricStr) {
            case "Positive Cases":
                return ReportMetric.TOTAL_NEW_CASES;
            case "Deaths":
                return ReportMetric.TOTAL_DEATH_CASES;
            case "People Vaccinated":
                return ReportMetric.TOTAL_PEOPLE_VACCINATED;
        }
        return null;
    }

    private WayOfCalculation getWayOfCalculation(String wocStr) {
        switch (wocStr) {
            case "New Total":
                return WayOfCalculation.NEW_TOTAL;
            case "Up To":
                return WayOfCalculation.UP_TO;
        }
        return null;
    }
    
    private GroupMethod getGroupMethod(String gmStr) {
        switch (gmStr) {
            case "group(s)":
                return GroupMethod.GROUPS;
            case "day(s)":
                return GroupMethod.DAYS;
        }
        return null;
    }
    
    private void setDataToTable(List<ResultTable> results) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        int rowCount = 0;
        for(ResultTable resultTable: results) {
            model.insertRow(rowCount, new Object[]{resultTable.getRange(), resultTable.getValue()});
            ++rowCount;
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Integer numberOfGroups = getNumberOfGroup();
        if (numberOfGroups != -1) {
            if (validateTimeRange()) {
                TimeRange timeRange = getTimeRange();
                System.out.println("Start date: " + timeRange.getStartDate().toString());
                System.out.println("End date: " + timeRange.getEndDate().toString());
                String country = jComboBox2.getSelectedItem().toString();
                String continent = jComboBox1.getSelectedItem().toString();
                GroupMethod groupMethod = getGroupMethod(jComboBox3.getSelectedItem().toString());
                ReportMetric metric = getReportMetric(jComboBox4.getSelectedItem().toString());
                WayOfCalculation wayOfCalculation = getWayOfCalculation(jComboBox5.getSelectedItem().toString());
                System.out.println(country);
                System.out.println(continent);
                System.out.println(numberOfGroups);
                System.out.println(groupMethod);
                System.out.println(metric);
                System.out.println(wayOfCalculation);
                try {
                    List<ResultTable> result = controller.doReport(country, continent, timeRange, numberOfGroups, groupMethod, metric, wayOfCalculation);
                    setDataToTable(result);
                    System.out.println(result);
                } catch (CovidException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Time range - wrong format");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void updateTimeRangeComb() {
        Integer selected = jComboBox7.getSelectedIndex();
        switch (selected) {
            case 0:
                jLabel9.setText("Start date");
                jLabel10.setText("End date");
                jTextField3.setText("dd/mm/yyyy");
                jTextField4.setText("dd/mm/yyyy");
                break;
            case 1:
                jLabel9.setText("Number of days");
                jLabel10.setText("From date");
                jTextField3.setText("");
                jTextField4.setText("dd/mm/yyyy");
                break;
            case 2:
                jLabel9.setText("Number of weeks");
                jLabel10.setText("From date");
                jTextField3.setText("");
                jTextField4.setText("dd/mm/yyyy");
                break;
            case 3:
                jLabel9.setText("Number of days");
                jLabel10.setText("To date");
                jTextField3.setText("");
                jTextField4.setText("dd/mm/yyyy");
                break;
            case 4:
                jLabel9.setText("Number of weeks");
                jLabel10.setText("To date");
                jTextField3.setText("");
                jTextField4.setText("dd/mm/yyyy");
                break;
        }
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        updateContriesSelectBoxByContinent();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        updateTimeRangeComb();
    }//GEN-LAST:event_jComboBox7ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
