package com.db.controller;

import java.io.File;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.db.dto.ComSignUpDTO;
import com.db.dto.MemSignUpDTO;
import com.db.service.SignUpService;

@Controller
public class SignUpController {
	private SignUpService service;
	
	public SignUpController(SignUpService service) {
		this.service = service;
	}
	//회원가입 페이지 접근
	@RequestMapping("/Sign_up")
	public String MainSign() {
		return "/Sign_up";
	}
	//member 회원가입 서비스
	@RequestMapping("/MemSign_up")
	public String MemSign_up(MemSignUpDTO memSginUpDTO,HttpSession session) {
		memSginUpDTO.setMem_birth();
		service.insertMem(memSginUpDTO);
		MemSignUpDTO member = service.selectUser(memSginUpDTO.getMem_useremail());
		session.setAttribute("member",member);
		return "redirect:/main"; //일반회원 메인으로
	}
	//company 회원가입 서비스
	@RequestMapping("/ComSign_up")
	public String ComSign_up(ComSignUpDTO comSignUpDTO,MultipartHttpServletRequest multi,HttpSession session){ //murtiparthHttpServletRequest는 servletRequest를 상속받아 구현된 인터페이스로 업로드된 파일을 처리하기 위한 여러 메소드 제공
		
		//저장 경로 설정
		String root = multi.getSession().getServletContext().getRealPath("/");//웹서비스 root 경로
		String path = root + "resources/upLoadImg/";
		//String rootPath = FileSystemView.getFileSystemView().getHomeDirectory().toString();
	  
		System.out.print("저장경로 설정"+path);
		//파일객체 생성
		//File dir = new File(path);
	    
		//전송된 파일들(getFileName)을 불러오기 위한 반복자(formdata 탐색)
		Iterator<String> files = multi.getFileNames();
		
		while(files.hasNext()) {
			String uploadFile = files.next();
			MultipartFile mFile = multi.getFile(uploadFile);
			String fileName = mFile.getOriginalFilename();
			String filePath = "resources/upLoadImg/" + fileName;
			
			System.out.print("파일 업로드 작업 완료");
			comSignUpDTO.setCom_img(filePath);
			System.out.print(filePath + "파일 저장 위치 얍");
			
			
			//현재 프로젝트(서버)의 resources 경로
			System.out.print("파일 파라미터 이름"+mFile.getName()+", 파일 사이즈 "+mFile.getSize()+", 파일의 실제 이름 "+mFile.getOriginalFilename());
			try {
				mFile.transferTo(new File(path+fileName));
			}catch(Exception e) {
				System.out.print(e);
			}
		}
//		String root = files.getSession().getServletContext().getRealPath("/");//웹서비스 root 경로
//		String path = root + "resources/upLoadImg/";
//		String filePath = path + "/" + files.getOriginalFilename();
//		System.out.print("파일 파라미터 이름"+files.getName()+", 파일 사이즈 "+files.getSize()+", 파일의 실제 이름 "+files.getOriginalFilename());
//		File dest = new File(filePath);
//		System.out.print("파일 객체 생성 완료");
//		try {
//			files.transferTo(dest);
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		service.insertCom(comSignUpDTO);
		session.setAttribute("company", comSignUpDTO);
		return "redirect:/main"; //기업회원 메인으로
	}
	
	//주소팝업 오픈
	@RequestMapping("/jusoPopup")
	public String JusoPopup() {
		return "/jusoPopup";
	}
	
	@ResponseBody
	@RequestMapping("/UserEmailSearch")
	public int UserEmailSearch(@RequestBody String member_email) {
		int count = service.selectUserEmail(member_email);
//		String x;
//		if(count == 1) {
//			x="1";
//		}else {
//			x="0";
//		}
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("mem_userid", x);
//		return map;
		return count;
	}
	
	
	@ResponseBody
	@RequestMapping("/CompanyEmailSearch")
	public int CompanyEmailSearch(@RequestBody String company_email) {
		int count = service.selectCompanyEmail(company_email);
		return count;
	}
}
