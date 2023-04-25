package view;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Database;
import model.Employee;

public class MainFrame extends JFrame {

    DefaultTableModel model;
    JTable table;
    JScrollPane pane;
    Database database;
    JButton addButton;
    

    public MainFrame() {        
        this.initComponent();
        
        this.setComponent();
        this.setFrame();
    }
    private void initComponent(){
        this.model = new DefaultTableModel();
        this.table = new JTable(model);
        this.pane = new JScrollPane(table);
        this.database = new Database();
        this.addButton = new JButton("Add");
    }
    private void setFrame(){
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        this.add(pane);
        this.add(addButton);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);
    }
    private void setComponent(){
        Object[] labels = {"id", "name", "city", "salary"};
        this.model.setColumnIdentifiers(labels);

        ArrayList<Employee> empList = database.getEmployees();

        for(Employee emp: empList){
            Vector<String> empStr = new Vector<>();
            empStr.add(emp.getId().toString());
            empStr.add(emp.getName().toString());
            empStr.add(emp.getCity().toString());
            empStr.add(emp.getSalary().toString());
            model.addRow(empStr);
        }
    }
    public JButton getAddButton() {
        return addButton;
    }
    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }
    

}
