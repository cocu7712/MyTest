package connect;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class DBconn {

	public static Connection getDBConn() throws Exception{
		
		Context ct = new InitialContext();
		Context evn = (Context)ct.lookup("java:comp/env");
		DataSource ds = (DataSource)evn.lookup("jdbc/orcl");
		
		return ds.getConnection();
	}
	
}
