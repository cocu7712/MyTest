package PhoneBookControll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import phoneBook.PhoneBook;

public class PhoneBookManager {

	public PhoneBookFile pf;
	String phoneSave[] = new String[50]; // 가져온값을 배열에 저장
	int count; // 저장되어있는 데이터 갯수

	public PhoneBookManager() throws Exception {
		pf = new PhoneBookFile(); // PhoneBookFile 객체 생성
		pf.PhoneBookReadFile(); // PhoneBookReadFile 객체 생성
		phoneBookLoad(); // 파일을 읽어와서 배열에 저장하는 메서드 실행
	}

//	--저장된 파일을 읽어옴--
	public void phoneBookLoad() throws Exception {
		BufferedReader bfr = new BufferedReader(new FileReader(pf.file));
		int i = 0;
		
		// 읽어 올게 없으면 종료
		while ((phoneSave[i] = bfr.readLine()) != null) {
			i++;
		}
		
		// 기본값이 없다면 다시 생성
		if(phoneSave[0] == null) {
			BufferedWriter bfw = new BufferedWriter(new FileWriter(pf.file));
			bfw.write(pf.startDate);
			bfw.close();
		}
		
		count = i;
		bfr.close();
	}

//	--파일을 저장함--
	public void phoneBookSave(PhoneBook pb) throws Exception {
		BufferedWriter bwf = new BufferedWriter(new FileWriter(pf.file, true));

		bwf.write(pb.toString() + "\n");
		bwf.close();
		phoneBookLoad();
	}

//	--파일을 수정함--
	public void phoneBookReserch(PhoneBook pb, int a) throws Exception {
		BufferedWriter bwf = new BufferedWriter(new FileWriter(pf.file)); // 값을 전부 새로 받기위해 사용
		phoneSave[a] = (pb.toString());

		for (int i = 0; i < count; i++) {
			bwf.write(phoneSave[i] + "\n");
		}

		bwf.close();
		phoneBookLoad();
	}

	public void phoneBookDelete(int a) throws Exception {
		BufferedWriter bwf = new BufferedWriter(new FileWriter(pf.file)); // 값을 전부 새로 받기위해 사용
		String str;
		// 입력받은 No번째 저장된 값을 삭제
		System.out.println(count);
		for(int i = a; i < count; i++) {
			str = phoneSave[(i+1)];
			phoneSave[i] = str;
		}
		// 삭제한 배열 데이터를 다시 받음
		System.out.println(count);
		for(int i = 0; i < count-1; i++) {
			bwf.write(phoneSave[i]+"\n");
		}
		bwf.close();
		phoneBookLoad();
	}
}
