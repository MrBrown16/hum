package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    public Database() {
        Employee employee = new Employee(1,"Marduk Árpád","Miskolc", 395.0);
        this.insertEmployee(employee);
    }
    
    public void insertEmployee(Employee employee){
        try {
            tryInsertEmployee(employee);
        } catch (SQLException e) {
            System.err.println("Hiba az adatbázishoz való kapcsolódás sikertelen");
        } catch (ClassNotFoundException e){
            System.err.println("Nincs mariadb betöltve");
        }
    }

    public void tryInsertEmployee(Employee employee) throws SQLException, ClassNotFoundException{
        
        Connection connection = null;
        String url = "jdbc:mariadb://localhost:3306/hum";
        Class.forName("org.mariadb.jdbc.Driver");
        connection = DriverManager.getConnection(url, "hum", "titok");
        //'Kiss Pali', 'Szeged', 347
        String sql = "INSERT INTO employees" + "(name, city, salary) VALUES" + "(?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.name);
        preparedStatement.setString(2, employee.city);
        preparedStatement.setDouble(3, employee.salary);
        //preparedStatement.execute();
        System.out.println(preparedStatement.toString());
        System.out.println("BU!");
        connection.close();
    }
}
