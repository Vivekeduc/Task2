package vivproject;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author vivek
 */
public class DatabaseConnection {

    /**
     * @param args the command line arguments
     */
    String JDBC_Driver = "com.mysql.jdbc.Driver"; //we need to give Driver details since we are connecting to mySQL which is not from Oracle family
    String DB_URL = "jdbc:mysql://localhost/employees";
    Connection conn = null;
    Statement stmt = null;
    //Credentials
    String USER = "root", PASSWORD = "password";

    Scanner input = new Scanner(System.in);
    int emp_id;
    String first_name, last_name, address;

    DatabaseConnection() {

    }

    public void insertEmployee() throws Exception {
        System.out.println("Enter Employee ID:");
        emp_id = input.nextInt();

        System.out.println("Enter First Name:");
        first_name = input.next();

        System.out.println("Enter Last Name:");
        last_name = input.next();

        System.out.println("Enter Address:");
        address = input.next();

        stmt.executeUpdate("INSERT INTO employee VALUES (" + emp_id + ",'" + first_name + "','" + last_name + "','" + address + "')");

        System.out.println("Details Saved!!");
    }

    public void updateEmployee() throws Exception {

        System.out.println("Enter Employee ID:");
        emp_id = input.nextInt();

        System.out.println("Enter First Name:");
        first_name = input.next();

        System.out.println("Enter Last Name:");
        last_name = input.next();

        System.out.println("Enter Address:");
        address = input.next();

        stmt.executeUpdate("UPDATE employee SET first_name = '" + first_name + "',last_name = '" + last_name + "',address = '" + address + "' where emp_id= " + emp_id);

        System.out.println("Details Updated!!");

    }
    
    public void deleteEmployee() throws SQLException{
    
        System.out.println("Delete Employee:\nEnter Employee ID to Delete:");
        emp_id = input.nextInt();

        stmt.execute("DELETE from employee where emp_id = "+emp_id+"");
        
        System.out.println("Details deleted!!");
    }
    public void showEmployee() throws Exception{
    
        System.out.println("Employee Details:");
//        emp_id = input.nextInt();

        stmt.execute("SELECT * from employee WHERE emp_id= "+emp_id+"");
        
       // System.out.println("Details deleted!!");
    }
     public void showAllEmployee() throws Exception{
    
        System.out.println("Employee Details:");
//        emp_id = input.nextInt();

        stmt.execute("SELECT * from employee");
        
       // System.out.println("Details deleted!!");
    }

    public void employeeOperations() {
        try {
            Class.forName(JDBC_Driver);

            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = conn.createStatement();

            System.out.println("Please enter 1 for Insert, 2 for Update, 3 for Delete, 4 for Show Employee, 5 for Showll All Employees & 6 for exit");

            while (true) {

                int userInput = input.nextInt();
                if (userInput == 1){
                    insertEmployee();
                } else if(userInput == 2) {
                     updateEmployee();
                }else if(userInput == 3) {
                     deleteEmployee();
                }
                else if(userInput == 4) {
                     showAllEmployee();
                }

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {

        new DatabaseConnection().employeeOperations();

    }

    
}
