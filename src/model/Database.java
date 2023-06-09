package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
    String url = "jdbc:mariadb://localhost:3306/hum";
    String className = "org.mariadb.jdbc.Driver";

    public Database() {
    }

    public Connection createConnection(String url, String className) throws SQLException, ClassNotFoundException{
        Connection connection = null;
        Class.forName(className);
        connection = DriverManager.getConnection(url, "hum", "titok");
        return connection;
    }   

    public void closeConnection(Connection connection) throws SQLException{
        connection.close();
    }
    

    public int insertEmployee(Employee employee){
        int id = 0;
        try {
            id = tryInsertEmployee(employee);
            
        } catch (SQLException e) {
            System.err.println("Hiba az adatbázishoz való kapcsolódás sikertelen"+ e.getMessage());
        } catch (ClassNotFoundException e){
            System.err.println("Nincs mariadb betöltve");
        }
        return id;
    }
    
    private int tryInsertEmployee(Employee employee) throws SQLException, ClassNotFoundException{
        Connection connection = createConnection(url,className);
        String sql = "INSERT INTO employees" + "(name, city, salary) VALUES" + "(?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, employee.name);
        preparedStatement.setString(2, employee.city);
        preparedStatement.setDouble(3, employee.salary);
        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();
        int id = 0;
        if (rs.next()) {
            id = rs.getInt(1);
            // System.out.println(preparedStatement.toString());
            // System.out.println(id);
        }

        closeConnection(connection);
        return id;
    }
    


    public ArrayList<Employee> getEmployees(){
        ArrayList<Employee> empList;
        try {
            empList = tryGetEmployees();
        } catch (Exception e) {
            System.err.println("Hiba a dolgozók beolvasásában"+ e);
            empList = null;
        }
        return empList;
    }

    private ArrayList<Employee> tryGetEmployees() throws SQLException, ClassNotFoundException{
        
        Connection connection = createConnection(url, className);
        String sql = "SELECT * FROM employees";
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        ArrayList<Employee> empList = convResSetToList(res);

        closeConnection(connection);
        return empList;
        
    }



    public boolean delEmployees(Integer id){
        boolean done = false;
        try {
            done = tryDelEmployees(id);
        } catch (Exception e) {
            System.err.println("Hiba a record törlésében"+ e);
        }
        return done;
    }

    private boolean tryDelEmployees(Integer id) throws SQLException, ClassNotFoundException{
        
        Connection connection = createConnection(url, className);
        String sql = "DELETE FROM employees WHERE id=?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        boolean done = preparedStatement.execute();
        closeConnection(connection);
        
        return done;
    }



    private ArrayList<Employee> convResSetToList(ResultSet res) throws SQLException{
        ArrayList<Employee> empList = new ArrayList<>();
        while(res.next()){
            
            Employee emp = new Employee(res.getInt("id"), res.getString("name"), res.getString("city"), res.getDouble("salary"));
            empList.add(emp);
        }
        return empList;
        
    }

    public void update(Employee emp){
        try {
            tryUpdate(emp);
        } catch (SQLException e) {
            System.err.println("Hiba az update során " + e);
        }catch(Exception e){
            System.err.println("Hiba az update során " + e);
        }
    }

    private void tryUpdate(Employee emp) throws ClassNotFoundException, SQLException{

        Connection connection = createConnection(url, className);
        String sql = "UPDATE employees SET " + "name=?, city=?, salary=? " + "WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, emp.name);
        preparedStatement.setString(2, emp.city);
        preparedStatement.setDouble(3, emp.salary);
        preparedStatement.setInt(4, emp.id);
        preparedStatement.execute();
        closeConnection(connection);
    }
}
