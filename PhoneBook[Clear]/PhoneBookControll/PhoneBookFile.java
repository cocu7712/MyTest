package PhoneBookControll;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class PhoneBookFile {

	final String file = "Phone.txt";
	String startDate = "No.\t�̸�\t����\t��ȭ��ȣ\n";

// 	--���� Ȯ�� & ���� �޼���--
	public void PhoneBookReadFile() throws Exception {
		File f = new File(file); // ���ο� ���� ��ü ����
		BufferedWriter bw;

//		������ �ִ��� Ȯ���ϰ� ������ ������ �����ϰ� �⺻ ���� ����
		if (!f.exists()) {
			bw = new BufferedWriter(new FileWriter(f));
			bw.write(startDate);
			bw.close();
		}
	}
}
