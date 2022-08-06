package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Databaseconnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");  
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "$whistle27$");
        
        Statement stm = con.createStatement();
       // stm.executeUpdate("insert into eproduct (name,price,date_added) values('Desktop', 128.12, now())");
        //stm.executeUpdate("update eproduct set price=1000.00 where name='Desktop'");
        stm.execute("delete from eproduct where name='Desktop'");
        ResultSet result = stm.executeQuery("select * from eproduct");
        
        while(result.next()) {
            
            System.out.print(result.getInt("ID")+ "\t");
            System.out.print(result.getString("name")+ "\t");
            System.out.print(result.getDouble("price"));
        }
    }
}
