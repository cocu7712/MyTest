package PhoneBookControll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import phoneBook.PhoneBook;

public class PhoneBookManager {

	public PhoneBookFile pf;
	String phoneSave[] = new String[50]; // �����°��� �迭�� ����
	int count; // ����Ǿ��ִ� ������ ����

	public PhoneBookManager() throws Exception {
		pf = new PhoneBookFile(); // PhoneBookFile ��ü ����
		pf.PhoneBookReadFile(); // PhoneBookReadFile ��ü ����
		phoneBookLoad(); // ������ �о�ͼ� �迭�� �����ϴ� �޼��� ����
	}

//	--����� ������ �о��--
	public void phoneBookLoad() throws Exception {
		BufferedReader bfr = new BufferedReader(new FileReader(pf.file));
		int i = 0;
		
		// �о� �ð� ������ ����
		while ((phoneSave[i] = bfr.readLine()) != null) {
			i++;
		}
		
		// �⺻���� ���ٸ� �ٽ� ����
		if(phoneSave[0] == null) {
			BufferedWriter bfw = new BufferedWriter(new FileWriter(pf.file));
			bfw.write(pf.startDate);
			bfw.close();
		}
		
		count = i;
		bfr.close();
	}

//	--������ ������--
	public void phoneBookSave(PhoneBook pb) throws Exception {
		BufferedWriter bwf = new BufferedWriter(new FileWriter(pf.file, true));

		bwf.write(pb.toString() + "\n");
		bwf.close();
		phoneBookLoad();
	}

//	--������ ������--
	public void phoneBookReserch(PhoneBook pb, int a) throws Exception {
		BufferedWriter bwf = new BufferedWriter(new FileWriter(pf.file)); // ���� ���� ���� �ޱ����� ���
		phoneSave[a] = (pb.toString());

		for (int i = 0; i < count; i++) {
			bwf.write(phoneSave[i] + "\n");
		}

		bwf.close();
		phoneBookLoad();
	}

	public void phoneBookDelete(int a) throws Exception {
		BufferedWriter bwf = new BufferedWriter(new FileWriter(pf.file)); // ���� ���� ���� �ޱ����� ���
		String str;
		// �Է¹��� No��° ����� ���� ����
		System.out.println(count);
		for(int i = a; i < count; i++) {
			str = phoneSave[(i+1)];
			phoneSave[i] = str;
		}
		// ������ �迭 �����͸� �ٽ� ����
		System.out.println(count);
		for(int i = 0; i < count-1; i++) {
			bwf.write(phoneSave[i]+"\n");
		}
		bwf.close();
		phoneBookLoad();
	}
}
