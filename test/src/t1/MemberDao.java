package t1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDao {
	
	private static MemberDao instance = new MemberDao();
	
	private MemberDao()	{
	}
	
	public Connection getConnection() throws Exception{
		
		Context ct = new InitialContext();
		Context ec = (Context)ct.lookup("java:comp/env");
		DataSource ds = (DataSource)ec.lookup("jdbc/orcl");
		
		return ds.getConnection();
	}
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	public int insertMember(MemberDto dto) {
		int ri = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into members values(?,?,?,?,?,?)";
		
		try {
			
			con = getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.geteMail());
			ps.setTimestamp(5, dto.getrDate());
			ps.setString(6, dto.getAddress());
			ps.executeUpdate();
			
			ri = 1;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) {ps.close();}
				if(con != null) {con.close();}
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		return ri;
	}
	
	public int conFirmId(String id) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id from members where id = ?";
		int ri = 0;
		
		try {
			
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				ri = 1;
			}else {
				ri = 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(con != null) {con.close();}
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		return ri;
	}
	
	public int userCheck(String id,String pw) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select pw from members where id = ?";
		int ri = 0;
		String dbPw;
		
		
		try {
			
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dbPw = rs.getString("pw");
				if(dbPw.equals(pw)) {
					ri = 1;	//로그인 ok
				}else {
					ri = 0; //비번 x
				}
			}else {
				ri = -1;	//회원 x
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(con != null) {con.close();}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return ri;
	}
	
	
	public MemberDto getMember(String id) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		MemberDto dto = null;
		String sql = "select * from members where id = ?";
		
		
		try {
			
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.seteMail(rs.getString("eMail"));
				dto.setrDate(rs.getTimestamp("rDate"));
				dto.setAddress(rs.getString("address"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(con != null) {con.close();}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return dto;
	}
	

	public int updateMember(MemberDto dto) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "update members set pw=?,eMail=?,address=? where id=?";
		int ri = 0;
		
		try {
			
			con = getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPw());
			ps.setString(2, dto.geteMail());
			ps.setString(3, dto.getAddress());
			ps.setString(4, dto.getId());
			ri = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) {ps.close();}
				if(con != null) {con.close();}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return ri;
	}
	
	
	public ArrayList<MemberDto> membersAll() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		String sql = "select * from members";
		
		try {
			
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			System.out.println("===================");
			
			while(rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.seteMail(rs.getString("eMail"));
				dto.setrDate(rs.getTimestamp("rDate"));
				dto.setAddress(rs.getString("address"));
				dtos.add(dto);
			}
			System.out.println("--------------------");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) {ps.close();}
				if(con != null) {con.close();}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtos;
	}
}
