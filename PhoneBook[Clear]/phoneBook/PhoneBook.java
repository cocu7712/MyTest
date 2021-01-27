package phoneBook;

import java.util.Scanner;

public class PhoneBook {
	private Scanner sc;
	private String name;
	private int age;
	private String number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PhoneBook() { // »ý¼ºÀÚ
	}

	public String toString() {
		String str = getName() + "\t" + getAge() + "\t" + getNumber();
		return str;
	}
}
