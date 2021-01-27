package PhoneBookMain;

import PhoneBookControll.PhoneBookControll;

public class PhoneBookMain {

	public static void main(String[] args) {		
		try {
			
			PhoneBookControll pbc = new PhoneBookControll();
			pbc.PhoneBookStart();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
