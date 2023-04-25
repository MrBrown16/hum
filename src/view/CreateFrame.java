package view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class CreateFrame extends JDialog{
    MainFrame mainFrame;
    InputPanel idPanel;
    InputPanel namePanel;
    InputPanel cityPanel;
    InputPanel salaryPanel;
    JPanel jPanel;
    JButton addButton;
    
    public CreateFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        addPanel();
        
    }

    private void addPanel(){
        this.idPanel = new InputPanel("Id: ");
        this.namePanel = new InputPanel("Name: ");
        this.cityPanel = new InputPanel("City: ");
        this.salaryPanel = new InputPanel("Salary: ");
        addButton = new JButton("Add");
        
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        this.add(this.idPanel);
        this.add(this.namePanel);
        this.add(this.cityPanel);
        this.add(this.salaryPanel);
        this.add(addButton);
        this.setSize(200, 150);
        this.setModal(true);
        this.setLocationRelativeTo(this.mainFrame);
    }
    
    public JButton getAddButton() {
        return addButton;
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
