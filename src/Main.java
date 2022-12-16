import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	Vector<warnet> vec = new Vector<>();
	
	String id;
	
	public void Menu() {
		System.out.println("================= WARNET Fx =================");
		System.out.println("1. Add Data");
		System.out.println("2. View Data");
		System.out.println("3. Update Data");
		System.out.println("4. Delete Data");
		System.out.println("5. Exit");
		System.out.println("Input >> ");
	}
	
	public void menuSnack() {
		System.out.println("================= WARNET Fx SNACK =================");
		System.out.println("MAKANAN : ");
		System.out.println("1. Indomie	5k");
		System.out.println("2. Keripik	5k");
		System.out.println("3. Roti		8k");
		System.out.println("4. Burger	12k\n");
		System.out.println("MINUMAN : ");
		System.out.println("5. Soda		8k");
		System.out.println("6. Cokelat	8k");
		System.out.println("7. Teh		5k");
		System.out.println("8. Air mineral	5k\n");
		
	}
		
	public String generateID() {
		id = "CU";
		int angka = 0;
		for(int i = 0; i < 3; i++) {
			angka = rand.nextInt(10);
			id = id + angka;
		}
		return id;
	}
	
	public void addData() {
		
		String name;
		String membership;
		Integer duration;
		String choose;
		Integer snack = 0;
		Integer qty= 0;
		
		Integer snackPrice=0;
		Integer totalPrice=0;	
		
		do {
		System.out.println("Input your Name : ");
		name = scan.nextLine();
		}while(name.length() < 1);
		
		id = generateID();
		
		do {
		System.out.println("Membership [Silver | Gold | Diamond] (case sensitive): ");
		membership = scan.nextLine();
		}while(!membership.equals("Silver") && !membership.equals("Gold") && !membership.equals("Diamond"));
		
		do {
		System.out.println("Duration (/hour): ");
		
		try {
			duration = scan.nextInt();
		} catch (Exception e) {
			duration = -1;
		}
		scan.nextLine();
		}while(duration < 1);
		
		do {
		System.out.println("Do You Want Some Snacks?");
		System.out.println("Yes or No (case sensitive)");
		choose = scan.nextLine();
		if(choose.equals("Yes")) {
			do {
			menuSnack();
			System.out.println("Please input the number of the snacks that you want : ");
			try {
				snack = scan.nextInt();	
			} catch (Exception e) {
				snack = -1;
			}
			scan.nextLine();
			}while(snack < 1 || snack > 8);
			
			do {
			System.out.println("Please input the quantity : ");
			
			try {
				qty = scan.nextInt();
			} catch (Exception e) {
				qty=-1;
			}
			scan.nextLine();
			}while (qty < 1);
			
			System.out.println("Thank you for order!");
		}
		
		}while(!choose.equals("Yes") && !choose.equals("No"));
	
		System.out.println("Press Enter to continue..");
		scan.nextLine();
		
		
		vec.add(new warnet(name, id, membership, duration, snack, qty, snackPrice, totalPrice));

	}

	public void viewData(Vector<warnet> vec ){
		if(vec.isEmpty()) System.out.println("No Data\n");
		else {
			System.out.println("==================================================================== WARNET Fx ====================================================================");
			System.out.println("No  Name 	Id 		Membership 		 Duration 	 Snacks		 Quantity 	 SnackPrice		totalPrice");
			for(int i = 0; i < vec.size(); i++) {
				System.out.println(i+1  + "   " + vec.get(i).getName() + " 	" + vec.get(i).getId() + " 		" + vec.get(i).getMembership() + " 			  " 
			+ vec.get(i).getDuration() + "           	 " + vec.get(i).getSnack() + " 	 	 " + vec.get(i).getqty() + " 	    	 " 
			+ vec.get(i).getSnackPrice() + " 			" + vec.get(i).getTotalPrice());
			}
			System.out.println("");
		}
	}
	
	public void deleteData() {
		if(vec.isEmpty()) {
			System.out.println("Tidak ada");
		} else {
			viewData(vec); 
			Integer index;
			do {
				System.out.println("choose number to delete: ");
				index = scan.nextInt();
				scan.nextLine();
			}while (index <1 || index > vec.size());
			vec.remove(index - 1 );
			viewData(vec);
		}	
	}
	
	public void updateData() {
		if(vec.isEmpty()) {
			System.out.println("Tidak ada");
		} else {
			int pilihan = -1;
			int duration = 0;
			do { 
				viewData(vec);
				System.out.println("Nomor Komputer yang ingin di Update [1 - " + vec.size() + "]: ");
				try {
					pilihan = scan.nextInt();
				} catch (Exception e) {
					pilihan = -1;
				}scan.nextLine();
			}while(pilihan < 1 || pilihan > vec.size());
		}
	}
	
	public Main() {
		Integer input;
	do {
		Menu();
		
		try {
			input = scan.nextInt();
		} catch (Exception e) {
			input = -1;
		}
		scan.nextLine();
		
		switch (input) {
		case 1:
			addData();
			break;
		case 2:
			viewData(vec);
			break;
//		case 3:
//			updateData();
//			break;
		case 4: 
			deleteData();
			break;
		}	
	}while (input!=5);
	}

	
	public static void main(String[] args) {
		new Main();
	}

}
