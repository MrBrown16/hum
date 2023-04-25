package control;

import javax.swing.JOptionPane;

import model.Database;
import model.Employee;
import view.CreateFrame;
import view.MainFrame;

public class CreateController {
    CreateFrame createFrame;
    Database database;
    MainFrame mainFrame;

    public CreateController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        createFrame = new CreateFrame(this.mainFrame);
        database = new Database();
        handleEvents();
    }
    
    public CreateFrame getCreateFrame() {
    return createFrame;
    }
    private void handleEvents(){
        createFrame.getAddButton().addActionListener(e->{
            System.out.println("bu:(");
            startAdd();
        });
    }

    private void startAdd(){
        String idStr = createFrame.getIdPanel().getValue();
        String nameStr = createFrame.getNamePanel().getValue();
        String cityStr = createFrame.getCityPanel().getValue();
        String salaryStr = createFrame.getSalaryPanel().getValue();

        Employee emp = new Employee(Integer.parseInt(idStr), nameStr, cityStr, Double.parseDouble(salaryStr));
        database.insertEmployee(emp);
        JOptionPane.showMessageDialog(createFrame, "Done");

    }
}
