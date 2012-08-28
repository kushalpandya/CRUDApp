/**
 * 
 */
package org.crudapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.crudapp.entity.CRUDAppUser;

/**
 * @author Kushal Pandya <kushal.pandya04@gmail.com>
 *
 */
public class DatabaseManager
{
	private String DATABASEDRIVER;
	private String DATABASEURL;
	
	private Connection con;
	
	public DatabaseManager()
	{
		ResourceBundle rb = ResourceBundle.getBundle("org.crudapp.Config");
		DATABASEDRIVER = rb.getString("DatabaseVendorDriver");
		DATABASEURL = rb.getString("DatabaseURL");
	}
	
	public void connect() throws ClassNotFoundException, SQLException
	{
		Class.forName(DATABASEDRIVER);
		con = DriverManager.getConnection(DATABASEURL);
	}
	
	public void insertUser(CRUDAppUser user) throws SQLException
	{
		PreparedStatement pst = con.prepareStatement("INSERT INTO crudapp (fname,lname,age,email,city) VALUES(?,?,?,?,?)");
		pst.setString(1, user.getFname());
		pst.setString(2, user.getLname());
		pst.setString(3, user.getAge());
		pst.setString(4, user.getEmail());
		pst.setString(5, user.getCity());
		pst.executeUpdate();
		pst.close();
	}
	
	public ArrayList<CRUDAppUser> selectUsers() throws SQLException
	{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM crudapp");
		
		ArrayList<CRUDAppUser> userlist = new ArrayList<>();
		CRUDAppUser user;
		while(rs.next())
		{
			user = new CRUDAppUser();
			user.setFname(rs.getString("fname"));
			user.setLname(rs.getString("lname"));
			user.setAge(rs.getString("age"));
			user.setEmail(rs.getString("email"));
			user.setCity(rs.getString("city"));
			
			userlist.add(user);
		}
		
		//return userlist.toArray(new CRUDAppUser[userlist.size()]);
		return userlist;
	}
	
	public CRUDAppUser searchByName(String fname) throws SQLException
	{
		PreparedStatement pst = con.prepareStatement("SELECT * FROM crudapp WHERE fname like ?");
		pst.setString(1, fname);
		ResultSet rs = pst.executeQuery();
		if(rs.next())
		{
			CRUDAppUser user = new CRUDAppUser();
			user.setFname(rs.getString("fname"));
			user.setLname(rs.getString("lname"));
			user.setAge(rs.getString("age"));
			user.setEmail(rs.getString("email"));
			user.setCity(rs.getString("city"));
			
			return user;
		}
		else
			return null;
	}
	
	public void disconnect() throws SQLException
	{
		con.close();
	}
}
