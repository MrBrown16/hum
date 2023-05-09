package view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import model.Employee;

public class CreateFrame extends JDialog{
    MainFrame mainFrame;
    InputPanel idPanel;
    InputPanel namePanel;
    InputPanel cityPanel;
    InputPanel salaryPanel;
    JPanel jPanel;
    JButton saveButton;
    
    public CreateFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initAddPanel();
        setAddPanel();
    }

    private void initAddPanel(){
        idPanel = new InputPanel("Id: ");
        namePanel = new InputPanel("Name: ");
        cityPanel = new InputPanel("City: ");
        salaryPanel = new InputPanel("Salary: ");
        saveButton = new JButton("Save");
        
        
    }

    private void setAddPanel() {
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        this.add(this.idPanel);
        this.add(this.namePanel);
        this.add(this.cityPanel);
        this.add(this.salaryPanel);
        this.add(saveButton);
        this.setSize(200, 150);
        this.setModal(true);
        this.setLocationRelativeTo(mainFrame);
    }
    
    public void setEmployee(Employee employee){
        idPanel.field.setText(employee.getId().toString());
        namePanel.field.setText(employee.getName());
        cityPanel.field.setText(employee.getCity());
        salaryPanel.field.setText(employee.getSalary().toString());
    }

    public JButton getSaveButton() {
        return saveButton;
    }
    public InputPanel getIdPanel() {
        return idPanel;
    }
    public void setIdPanel(InputPanel idPanel) {
        this.idPanel = idPanel;
    }
    public InputPanel getNamePanel() {
        return namePanel;
    }
    public void setNamePanel(InputPanel namePanel) {
        this.namePanel = namePanel;
    }
    public InputPanel getCityPanel() {
        return cityPanel;
    }
    public void setCityPanel(InputPanel cityPanel) {
        this.cityPanel = cityPanel;
    }
    public InputPanel getSalaryPanel() {
        return salaryPanel;
    }
    public void setSalaryPanel(InputPanel salaryPanel) {
        this.salaryPanel = salaryPanel;
    }

}
