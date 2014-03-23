package ibudget;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.Statement;

public class MySQLAccess {
	  private Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;

	  public void readDataBase() throws Exception {
	    try {
	      // this will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // setup the connection with the DB.
	      connect = DriverManager
	          .getConnection("jdbc:mysql://localhost/ibudget?"
	              + "user=root");
	      
	      statement = connect.createStatement();
	      resultSet = statement.executeQuery("select * from test_chinese");
	      //处理结果集
	      while (resultSet.next())
	      {
	        String name = resultSet.getString("name");
	        System.out.println(name);
	      }
	      resultSet.close();
	      
	    } catch (Exception e) {
	      throw e;
	    } finally {
	      
	    }

	  }

	  public static void main(String[] args) throws Exception{
		  MySQLAccess a = new MySQLAccess();
		  a.readDataBase();
		  
	  }
}
