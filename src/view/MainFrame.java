package view;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Database;
import model.Employee;

public class MainFrame extends JFrame {
    
    DefaultTableModel model;
    JScrollPane pane;
    JTable table;
    Database database;
    JPanel buttonPanel;
    JButton addButton;
    JButton delButton;
    JButton editButton;
    
    public MainFrame() {        
        this.initComponent();
        
        this.setComponent();
        this.setFrame();
    }
    private void initComponent(){
        model = new DefaultTableModel();
        table = new JTable(model);
        pane = new JScrollPane(table);
        database = new Database();
        buttonPanel = new JPanel();
        addButton = new JButton("Add");
        delButton = new JButton("Del");
        editButton = new JButton("Edit");
    }
    private void setFrame(){
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        this.add(pane);
        buttonPanel.add(addButton);
        buttonPanel.add(delButton);
        buttonPanel.add(editButton);
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.LINE_AXIS));
        this.add(buttonPanel);
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
    public JPanel getButtonPanel() {
        return buttonPanel;
    }
    public JButton getDelButton() {
        return delButton;
    }
    public JButton getEditButton() {
        return editButton;
    }
    public JTable getTable() {
        return table;
    }
    public DefaultTableModel getModel() {
        return model;
    }
}
