package PhoneBookControll;

import java.util.Scanner;

import phoneBook.PhoneBook;

public class PhoneBookControll {
	private Scanner sc;
	private PhoneBookManager pm;
	private PhoneBook pb;
	private int select;

//	--기본 생성자--
	public PhoneBookControll() throws Exception { // 기본 생성자 (인스턴스 객체를 생성할 때 생성됨)
		sc = new Scanner(System.in);
		this.pm = new PhoneBookManager();
		this.pb = new PhoneBook();
	}

//	--시작 메서드--
	public void PhoneBookStart() throws Exception {
		pm.pf.PhoneBookReadFile(); //파일의 존재 유무를 확인하는 메서드
		pm.phoneBookLoad();
		phoneBookMenu();
	}

//	--메뉴 메서드--
	public void phoneBookMenu() throws Exception {
		System.out.println("******************************************");
		System.out.println("*************핸드폰 관리 시스템****************");
		System.out.println("******************************************");
		System.out.println("****1. 저장목록 2. 저장하기 3. 수정하기 4. 삭제하기 5. 종료*********");
		System.out.println("******************************************");
		System.out.println("********사용하실 목록의 번호를 입력해주세요************");

		this.select = sc.nextInt(); //메인메뉴를 실행 시킬 번호

		phoneBookMenuSelect();
	}

//	--메뉴 선택 메서드--
	public void phoneBookMenuSelect() throws Exception {
		switch (select) {
		case 1:
			phoneBookList();
			break;
		case 2:
			phoneBookSave();
			break;
		case 3:
			phoneBookReserch();
			break;
		case 4:
			phoneBookDelect();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		default:
			System.out.println("잘못 입력 하셨습니다.");
		}

		phoneBookMenu();

	}

//	--파일을 입력받는 메서드--
	public void phoneBookDate() {
		System.out.print("이름 : ");
		pb.setName(sc.next());
		System.out.print("나이 : ");
		pb.setAge(sc.nextInt());
		System.out.print("전화번호 : ");
		pb.setNumber(sc.next());
	}

//	--현재 저장된 파일을 꺼내옴--
	public void phoneBookList() {
		System.out.println(pm.phoneSave[0]); //기본 데이터를 출력(앞에 No값이 들어가지 않기 위해 따로 뺌)
		
		for (int i = 1; i < pm.phoneSave.length; i++) {
			if (pm.phoneSave[i] == null) {
				break;
			}
			if (i < pm.phoneSave.length)
				System.out.println(i + "\t" + pm.phoneSave[i]);
		}
	}

//	--파일을 저장하는 메서드-- 
	public void phoneBookSave() throws Exception {
		phoneBookDate();
		pm.phoneBookSave(pb);
	}

//	--파일을 수정하는 메서드--
	public void phoneBookReserch() throws Exception {
		System.out.println("수정 할 No의 값을 입력");
		int st = sc.nextInt();

//		입력 값이 삭제할 수 없는 번호일경우 무한루프
		while (st < 0 || st > pm.count) {
			System.out.println("1~" + (pm.count - 1) + "의 값을 입력하세요");
			st = sc.nextInt();
		}
		System.out.println(pm.phoneSave[st]); // 현재 정보를 가져옴

		phoneBookDate();
		pm.phoneBookReserch(pb, st);
	}

//	--파일을 삭제하는 메서드--
	public void phoneBookDelect() throws Exception {
		System.out.println("삭제 할 No의 값을 입력");
		int st = sc.nextInt();
		
		while(true) {
			if(st > 0 && st < pm.count) {
				break;
			}else if(st == 0) {
				System.out.println("0번째 인덱스는 삭제할 수 없습니다.");
				System.exit(0);
			}
			System.out.println("1~"+(pm.count-1)+"의 값을 입력해 주세요");
			st = sc.nextInt();
		}

		pm.phoneBookDelete(st);
	}
}
