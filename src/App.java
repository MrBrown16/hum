import control.MainControl;
import model.Database;


public class App {
    
    public static void main(String[] args) throws Exception {
        Database database = new Database();
        new MainControl(database);
    }
}
