package control;

import javax.swing.JTable;


import model.Database;
import model.Employee;
import view.MainFrame;

public class MainControl{
    CreateControl createControl;
    MainFrame mainFrame;
    Database database;
    
    public MainControl(Database database) {
        this.database = database;
        mainFrame = new MainFrame();
        createControl = new CreateControl(mainFrame, database);
        this.handleEvent();
    }
    private void handleEvent(){
        this.mainFrame.getAddButton().addActionListener(e->{
            this.startAdd();
        });
        this.mainFrame.getDelButton().addActionListener(e->{
            this.startDel();
        });
        this.mainFrame.getEditButton().addActionListener(e->{
            this.startEdit();
        });
    }

    private void startAdd(){
        createControl.createModel.setAdding(true);
        createControl.createFrame.setTitle("Add");
        createControl.getCreateFrame().setVisible(true);
        
        
    }
    private void startDel(){
        JTable table = mainFrame.getTable();
        int row = table.getSelectedRow();
        if (row != -1) {
            String v = (String) table.getModel().getValueAt(row, 0);
            Integer value = Integer.parseInt(v);
            boolean done = database.delEmployees(value);
            
            mainFrame.getModel().removeRow(row);
        }
        
    }
    private void startEdit() {
        JTable table = mainFrame.getTable();
        int row = table.getSelectedRow();
        createControl.createModel.setAdding(false);
        createControl.createModel.setSelected(row);


        if (row == -1) return;
        
        String idStr = (String) table.getModel().getValueAt(row, 0);
        String nameStr = (String) table.getModel().getValueAt(row, 1);
        String cityStr = (String) table.getModel().getValueAt(row, 2);
        String salaryStr = (String) table.getModel().getValueAt(row, 3);
        Integer id = Integer.parseInt(idStr);
        Double salary = Double.parseDouble(salaryStr);
        Employee employee = new Employee(id, nameStr, cityStr, salary);
        createControl.createFrame.setTitle("Edit");
        createControl.createFrame.setEmployee(employee);
        createControl.getCreateFrame().setVisible(true);

    }
    
    
}
