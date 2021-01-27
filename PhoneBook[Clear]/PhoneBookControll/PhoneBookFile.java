package PhoneBookControll;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class PhoneBookFile {

	final String file = "Phone.txt";
	String startDate = "No.\t이름\t나이\t전화번호\n";

// 	--파일 확인 & 생성 메서드--
	public void PhoneBookReadFile() throws Exception {
		File f = new File(file); // 새로운 파일 객체 생성
		BufferedWriter bw;

//		파일이 있는지 확인하고 없으면 파일을 생성하고 기본 값을 넣음
		if (!f.exists()) {
			bw = new BufferedWriter(new FileWriter(f));
			bw.write(startDate);
			bw.close();
		}
	}
}
