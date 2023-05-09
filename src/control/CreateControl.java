package control;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.CreateModel;
import model.Database;
import model.Employee;
import view.CreateFrame;
import view.MainFrame;

public class CreateControl {
    CreateFrame createFrame;
    Database database;
    MainFrame mainFrame;
    CreateModel createModel;

    public CreateControl(MainFrame mainFrame, Database database) {
        this.mainFrame = mainFrame;
        createFrame = new CreateFrame(this.mainFrame);
        this.database = database;
        createModel = new CreateModel();
        handleEvents();
    }
    
    private void handleEvents(){
        createFrame.getSaveButton().addActionListener(e->{
            startSave();
        });
    }
    private void startSave(){
        if (createModel.isAdding()) {
            startAdd();
        }else{
            startUpdate();
        }
    }
    
    private void startAdd(){
        String idStr = createFrame.getIdPanel().getValue();
        String nameStr = createFrame.getNamePanel().getValue();
        String cityStr = createFrame.getCityPanel().getValue();
        String salaryStr = createFrame.getSalaryPanel().getValue();
        Employee emp = new Employee(nameStr, cityStr, Double.parseDouble(salaryStr));
        Integer id = database.insertEmployee(emp);
        Vector<String> empStr = new Vector<>();
        empStr.add(id.toString());
        empStr.add(nameStr);
        empStr.add(cityStr);
        empStr.add(salaryStr);
        mainFrame.getModel().addRow(empStr);
        
        // JOptionPane.showMessageDialog(createFrame, "Done");
        setToEmpty();
        createFrame.setVisible(false);
    }
    
    
    private void startUpdate() {
        String idStr = createFrame.getIdPanel().getValue();
        String nameStr = createFrame.getNamePanel().getValue();
        String cityStr = createFrame.getCityPanel().getValue();
        String salaryStr = createFrame.getSalaryPanel().getValue();
        Integer id = Integer.parseInt(idStr);
        Double salary = Double.parseDouble(salaryStr);

        int selected = createModel.getSelected();
        JTable table = mainFrame.getTable();
        
        table.getModel().setValueAt(nameStr, selected, 1);
        table.getModel().setValueAt(cityStr, selected, 2);
        table.getModel().setValueAt(salary, selected, 3);
        
        Employee emp = new Employee(id, nameStr, cityStr, salary);
        database.update(emp);
        
        createModel.setAdding(true);
        createFrame.setVisible(false);
        setToEmpty();
    }

    private void setToEmpty() {
        createFrame.getIdPanel().setValue("");
        createFrame.getNamePanel().setValue("");
        createFrame.getCityPanel().setValue("");
        createFrame.getSalaryPanel().setValue("");
    }
    
    public CreateFrame getCreateFrame() {
        return createFrame;
    }
}
