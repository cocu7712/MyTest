package shopDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.websocket.Session;

import connect.DBconn;

public class ShopDBbean {

	private static ShopDBbean shopDBbean = new ShopDBbean();
	
	public static ShopDBbean getShopDBbean() {
		return shopDBbean;
	}
	
//  로그인 하는 메소드
	public int userCheck(String id ,String passwd) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int x = -1;
		String sql = "select passwd from member where id = ?";
		String DBpasswd = "";
		
		try {
			
			con = DBconn.getDBConn();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				DBpasswd = rs.getString("passwd");
				
				//저장된 비밀번호와 같으면
				if(passwd.equals(DBpasswd)) {
					x = 1;	//같으면 1
				}else {
					x = 0;	//다르면 0
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(con != null) {con.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return x;	//-1이면 아이디 틀림
	}
	
	
	
	
//  회원정보 가져오기
	public ShopDataBean userdata(String userId) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member where id = ?";
		ShopDataBean data = null;
		
		try {
			
			con = DBconn.getDBConn();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			
			//해당 아이디의 데이터 정보 가져오기
			if(rs.next()) {
				
				data = new ShopDataBean();
				
				data.setId(rs.getString("id"));
				data.setPasswd(rs.getString("passwd"));
				data.setName(rs.getString("name"));
				data.setTel(rs.getString("tel"));
				data.setRag_date(rs.getTimestamp("reg_date"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(con != null) {con.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return data;	//가져온 데이터값 리턴
	}
//  회원가입 아이디 중복 확인
	public int userCheck(String id) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int x = -1;
		String sql = "select * from member where id = ?";
		String DBid = "";
		
		try {
			
			con = DBconn.getDBConn();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				DBid = rs.getString("id");
				
				//저장된 비밀번호와 같으면
				if(DBid.equals(id)) {
					x = 0;	//존재하면 0
				}else {
					x = 1;	//존재하지 않으면 1
				}
			}else {
				x = 1;	//존재하지 않으면 1
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(con != null) {con.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return x;	//-1이면 코드 실패
	}
	
	
//  회원가입 등록
	public void userInsert(ShopDataBean data) {
		
		Connection		  con = null;
		PreparedStatement ps  = null;
		
		String sql = "insert into member values(?,?,?,?,?)";
		
		try {
			
			con = DBconn.getDBConn();
			ps = con.prepareStatement(sql);
			ps.setString(1, data.getId());
			ps.setString(2, data.getPasswd());
			ps.setString(3, data.getName());
			ps.setString(4, data.getTel());
			ps.setTimestamp(5, data.getRag_date());
			
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) {ps.close();}
				if(con != null) {con.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
//  회원가입 등록
	public void userUpdate(ShopDataBean data, String userid) {
		
		Connection		  con = null;
		PreparedStatement ps  = null;
		
		String sql = "update member set id=?, passwd=?, name=?, tel=?, reg_date=? where id=? ";
		
		try {
			
			con = DBconn.getDBConn();
			ps = con.prepareStatement(sql);
			ps.setString(1, data.getId());
			ps.setString(2, data.getPasswd());
			ps.setString(3, data.getName());
			ps.setString(4, data.getTel());
			ps.setTimestamp(5, data.getRag_date());
			ps.setString(6, userid);
			
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) {ps.close();}
				if(con != null) {con.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
}
