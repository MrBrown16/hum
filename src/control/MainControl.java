package control;

import view.MainFrame;

public class MainControl{
    MainFrame mainFrame;


    public MainControl() {
        mainFrame = new MainFrame();
        this.handleEvent();
    }
    private void handleEvent(){
        this.mainFrame.getAddButton().addActionListener(e->{
            this.startAdd();
        });
    }

    private void startAdd(){
        CreateController createController = new CreateController(mainFrame);
        createController.getCreateFrame().setVisible(true);

    }
    

}
