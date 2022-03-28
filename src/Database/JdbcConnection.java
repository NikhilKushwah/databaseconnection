package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException 
	{
		
		String host ="localhost"; //this will be your local machine
		String port= "3306"; // this will be by default
		// creating connection with database
		Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qadbt", "root", "Nikhilkush@123");
		
		//creating a statement as a path for database
		Statement s=con.createStatement();
		
		//Now writing query by running this code it will execute in database
		ResultSet rs=s.executeQuery("select * from Employeeinfo where name='shyam';");
		
		
		// creating while loop coz these rs are stored in index so to move on next column 
		while (rs.next())
		{
			// now using selenium 
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver99\\chromedriver.exe");
			
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.facebook.com/");
			
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(rs.getString("name"));
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(rs.getString("id"));
		}

	}

}
