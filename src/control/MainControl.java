package control;

import javax.swing.JTable;

import model.Database;
import view.MainFrame;

public class MainControl{
    MainFrame mainFrame;
    Database database;
    
    public MainControl(Database database) {
        this.database = database;
        mainFrame = new MainFrame();
        this.handleEvent();
    }
    private void handleEvent(){
        this.mainFrame.getAddButton().addActionListener(e->{
            this.startAdd();
        });
        this.mainFrame.getDelButton().addActionListener(e->{
            this.startDel();
        });
    }

    private void startAdd(){
        CreateController createController = new CreateController(mainFrame, database);
        createController.getCreateFrame().setVisible(true);

    }
    private void startDel(){
        JTable table = mainFrame.getTable();
        int row = table.getSelectedRow();
        
        String v = (String) table.getModel().getValueAt(row, 0);
        Integer value = Integer.parseInt(v);
        boolean done = database.delEmployees(value);

        mainFrame.getModel().removeRow(row);
    }
    

}
