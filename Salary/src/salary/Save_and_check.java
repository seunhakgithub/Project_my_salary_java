/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salary;

import com.toedter.calendar.JDateChooser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author SeunHak
 */
public class Save_and_check {

    private String id;
    private String Save;
    private String date;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    public Save_and_check(String id, String Save, String date) {
        this.id = id;
        this.Save = Save;
        this.date = date;
    }

    public Save_and_check() {
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the Save
     */
    public String getSave() {
        return Save;
    }

    /**
     * @param Save the Save to set
     */
    public void setSave(String Save) {
        this.Save = Save;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    DefaultTableModel mod;
    Statement s;
    ResultSet r;

    public void Default_ID() throws SQLException {
        s = Datacon.getDatacon().createStatement();
        s.execute("ALTER TABLE `save`\n"
                + "AUTO_INCREMENT=1;\n"
                + "");

    }

    public void add(JTable tb, JTextField txtid, JTextField txtsave, JDateChooser date) throws SQLException {
        id = txtid.getText();
        Save = txtsave.getText().trim();
        SimpleDateFormat df = new SimpleDateFormat(" yyyy-MM-dd");
        String d = ((JTextField) date.getDateEditor().getUiComponent()).getText().trim();

        String st[] = {id, Save, d};
        mod = (DefaultTableModel) tb.getModel();
        mod.addRow(st);
        s = Datacon.getDatacon().createStatement();
        s.execute("INSERT INTO save(Save,date)VALUE('" + Save + "','" + d + "')");
        s.close();

        mod.setRowCount(0);
        windows_open(tb);
        Default_ID();

    }

//    public void Show_Id(JTextField txt_id) throws SQLException {
//        s = Datacon.getDatacon().createStatement();
//        r = s.executeQuery("SELECT ID FROM save");
//        if (r.last()) {
//            
//                txt_id.setText(r.getString("ID"));
//        }else
//            s.close();
//            r.close();
//
//        }
    public void Update(JTable tb, JTextField txtid, JTextField txtsave, JDateChooser dd) throws SQLException {
        int click = JOptionPane.showConfirmDialog(null, "Aer you sur");
        if (JOptionPane.YES_NO_CANCEL_OPTION != click) {

            id = txtid.getText();
            Save = txtsave.getText();
            SimpleDateFormat df = new SimpleDateFormat(" yyyy-MM-dd");
            String d = ((JTextField) dd.getDateEditor().getUiComponent()).getText();
            s = Datacon.getDatacon().createStatement();
            s.execute("UPDATE save set Save='" + Save + "',date='" + d + "' where id='" + id + "'");
            s.close();
            mod.setRowCount(0);
            windows_open(tb);
        }
    }

    public void delect(JTable table) throws SQLException {
        int click = JOptionPane.showConfirmDialog(null, "Aer you sur");
        if (click == JOptionPane.YES_OPTION) {
            mod = (DefaultTableModel) table.getModel();
            int[] rowselct = table.getSelectedRows();
            int id_row[] = new int[rowselct.length];
            for (int i = 0; i < id_row.length; i++) {
                id_row[i] = Integer.valueOf("" + mod.getValueAt(rowselct[i], 0));
            }

            try (Statement s1 = Datacon.getDatacon().createStatement()) {
                for (int i = 0; i < id_row.length; i++) {
                    s1.execute("DELETE from save where id=" + id_row[i]);

                }
                s1.close();
            }

            mod.setRowCount(0);
            windows_open(table);
            Default_ID();

        }
    }

    public void select(JTable table, JTextField txtID, JTextField txtSave, JDateChooser da) throws ParseException, SQLException {

        DecimalFormat d = new DecimalFormat("####");
        mod = (DefaultTableModel) table.getModel();
        int indext = table.getSelectedRow();
        txtID.setText(mod.getValueAt(indext, 0).toString());
        txtSave.setText(mod.getValueAt(indext, 1).toString());
        Date dat = new SimpleDateFormat("yyyy-mm-dd").parse((String) mod.getValueAt(indext, 2));
        da.setDate(dat);

        // txtTotal.setText(mod.getValueAt(indext, 0).toString());
    }

    public void windows_open(JTable tb) throws SQLException {
        s = Datacon.getDatacon().createStatement();
        r = s.executeQuery("select* from save");
        if (r.first()) {
            do {

                id = r.getString("ID");
                Save = r.getString("save");
                date = r.getDate("date").toString();
                String st[] = {id, Save, date};
                mod = (DefaultTableModel) tb.getModel();
                mod.addRow(st);
            } while (r.next());
            s.close();
            r.close();

        }

    }

}
