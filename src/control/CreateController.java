package control;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Database;
import model.Employee;
import view.CreateFrame;
import view.MainFrame;

public class CreateController {
    CreateFrame createFrame;
    Database database;
    MainFrame mainFrame;

    public CreateController(MainFrame mainFrame, Database database) {
        this.mainFrame = mainFrame;
        createFrame = new CreateFrame(this.mainFrame);
        this.database = database;
        handleEvents();
    }
    
    private void handleEvents(){
        createFrame.getAddButton().addActionListener(e->{
            startAdd(mainFrame.getModel());
        });
    }
    
    private void startAdd(DefaultTableModel model){
        String idStr = createFrame.getIdPanel().getValue();
        String nameStr = createFrame.getNamePanel().getValue();
        String cityStr = createFrame.getCityPanel().getValue();
        String salaryStr = createFrame.getSalaryPanel().getValue();
        Vector<String> empStr = new Vector<>();
        // empStr.add(idStr)
        // model.
        //TODO: set the table to show the added row without restarting 
        Employee emp = new Employee(nameStr, cityStr, Double.parseDouble(salaryStr));
        database.insertEmployee(emp);
        JOptionPane.showMessageDialog(createFrame, "Done");
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
