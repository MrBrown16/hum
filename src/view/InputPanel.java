package view;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class InputPanel extends JPanel{
    JLabel label;
    JTextField field;



    public InputPanel() {
        initComponent();
        setPanel();
        
    }
    public InputPanel(String text) {
        initComponent();
        setLabel(text);
        setPanel();
        
    }
    
    private void initComponent(){
        label = new JLabel();
        field = new JTextField();
    }

    public void setLabel(String text){
        label.setText(text);
    }

    public String getLabel(){
        return label.getText();
    }

    private void setPanel(){
        this.add(this.label);
        this.add(this.field);
        this.setLayout(new GridLayout(1,2));
    }
    public void setValue(String text){
        field.setText(text);
    }

    public String getValue(){
        return field.getText();
    }
    
}
