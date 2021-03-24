package t1;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MembersAllService implements Service {

	public MembersAllService()	{
		
	}
	
	@Override
	public ArrayList<MemberDto> execute(HttpServletRequest request,HttpServletResponse response){
		
		MemberDao dao = MemberDao.getInstance();
		return dao.membersAll();
	}
}
