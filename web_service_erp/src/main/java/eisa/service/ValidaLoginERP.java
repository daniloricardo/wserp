package eisa.service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidaLoginERP {
	
	@Autowired
	DataSource dataSource;

	public  boolean login(String user,String senha) throws SQLException, IOException, ClassNotFoundException{
		
		if(user.equals("SUPERVISOR")){
			user = "sa";
		}
		
		String query = "select * from sys.sql_logins where name = '"+user+"' and PWDCOMPARE('"+senha+"',password_hash) = 1";
		Statement st = dataSource.getConnection().createStatement();
		ResultSet rs = st.executeQuery(query);
		boolean valida = rs.next();
		st.close();
		dataSource.getConnection().close();
		return valida;
	}
}
