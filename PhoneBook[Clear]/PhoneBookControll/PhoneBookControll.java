package PhoneBookControll;

import java.util.Scanner;

import phoneBook.PhoneBook;

public class PhoneBookControll {
	private Scanner sc;
	private PhoneBookManager pm;
	private PhoneBook pb;
	private int select;

//	--�⺻ ������--
	public PhoneBookControll() throws Exception { // �⺻ ������ (�ν��Ͻ� ��ü�� ������ �� ������)
		sc = new Scanner(System.in);
		this.pm = new PhoneBookManager();
		this.pb = new PhoneBook();
	}

//	--���� �޼���--
	public void PhoneBookStart() throws Exception {
		pm.pf.PhoneBookReadFile(); //������ ���� ������ Ȯ���ϴ� �޼���
		pm.phoneBookLoad();
		phoneBookMenu();
	}

//	--�޴� �޼���--
	public void phoneBookMenu() throws Exception {
		System.out.println("******************************************");
		System.out.println("*************�ڵ��� ���� �ý���****************");
		System.out.println("******************************************");
		System.out.println("****1. ������ 2. �����ϱ� 3. �����ϱ� 4. �����ϱ� 5. ����*********");
		System.out.println("******************************************");
		System.out.println("********����Ͻ� ����� ��ȣ�� �Է����ּ���************");

		this.select = sc.nextInt(); //���θ޴��� ���� ��ų ��ȣ

		phoneBookMenuSelect();
	}

//	--�޴� ���� �޼���--
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
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
		default:
			System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
		}

		phoneBookMenu();

	}

//	--������ �Է¹޴� �޼���--
	public void phoneBookDate() {
		System.out.print("�̸� : ");
		pb.setName(sc.next());
		System.out.print("���� : ");
		pb.setAge(sc.nextInt());
		System.out.print("��ȭ��ȣ : ");
		pb.setNumber(sc.next());
	}

//	--���� ����� ������ ������--
	public void phoneBookList() {
		System.out.println(pm.phoneSave[0]); //�⺻ �����͸� ���(�տ� No���� ���� �ʱ� ���� ���� ��)
		
		for (int i = 1; i < pm.phoneSave.length; i++) {
			if (pm.phoneSave[i] == null) {
				break;
			}
			if (i < pm.phoneSave.length)
				System.out.println(i + "\t" + pm.phoneSave[i]);
		}
	}

//	--������ �����ϴ� �޼���-- 
	public void phoneBookSave() throws Exception {
		phoneBookDate();
		pm.phoneBookSave(pb);
	}

//	--������ �����ϴ� �޼���--
	public void phoneBookReserch() throws Exception {
		System.out.println("���� �� No�� ���� �Է�");
		int st = sc.nextInt();

//		�Է� ���� ������ �� ���� ��ȣ�ϰ�� ���ѷ���
		while (st < 0 || st > pm.count) {
			System.out.println("1~" + (pm.count - 1) + "�� ���� �Է��ϼ���");
			st = sc.nextInt();
		}
		System.out.println(pm.phoneSave[st]); // ���� ������ ������

		phoneBookDate();
		pm.phoneBookReserch(pb, st);
	}

//	--������ �����ϴ� �޼���--
	public void phoneBookDelect() throws Exception {
		System.out.println("���� �� No�� ���� �Է�");
		int st = sc.nextInt();
		
		while(true) {
			if(st > 0 && st < pm.count) {
				break;
			}else if(st == 0) {
				System.out.println("0��° �ε����� ������ �� �����ϴ�.");
				System.exit(0);
			}
			System.out.println("1~"+(pm.count-1)+"�� ���� �Է��� �ּ���");
			st = sc.nextInt();
		}

		pm.phoneBookDelete(st);
	}
}
