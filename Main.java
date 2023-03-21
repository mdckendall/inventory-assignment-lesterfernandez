import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
	private static class Inventory {
		public String name;
		public String serial;
		public int value;

		public String toString() {
			return String.format("%s,%s,%d", name, serial, value);
		}
	}

	private static final Scanner scanner = new Scanner(System.in);
	private static final List<Inventory> items = new ArrayList<>();

	private static void addItem() {
		Inventory item = new Inventory();
		System.out.println("Enter the name:");
		item.name = scanner.nextLine();
		System.out.println("Enter the serial number:");
		item.serial = scanner.nextLine();
		System.out.println("Enter the value in dollars (whole number):");
		item.value = Integer.parseInt(scanner.nextLine());
		items.add(item);
	}

	private static void deleteItem() {
		System.out.println("Enter the serial number of the item to delete:");
		String serial = scanner.nextLine();
		items.removeIf(item -> item.serial.equals(serial));
	}

	private static void updateItem() {
		System.out.println("Enter the serial number of the item to change:");
		String serial = scanner.nextLine();
		System.out.println("Enter the new name:");
		String name = scanner.nextLine();
		System.out.println("Enter the new value in dollars (whole number):");
		int value = Integer.parseInt(scanner.nextLine());

		Inventory itemFound =
				items.stream().filter(item -> item.serial.equals(serial)).findFirst().get();

		itemFound.name = name;
		itemFound.value = value;
	}

	private static void showItems() {
		items.forEach(System.out::println);
	}

	public static void main(String[] args) {
		int option = -1;
		while (option != 5) {
			System.out.println("Press 1 to add an item.");
			System.out.println("Press 2 to delete an item.");
			System.out.println("Press 3 to update an item.");
			System.out.println("Press 4 to show all the items.");
			System.out.println("Press 5 to quit the program.");
			option = Integer.parseInt(scanner.nextLine());
			switch (option) {
				case 1:
					addItem();
					break;
				case 2:
					deleteItem();
					break;
				case 3:
					updateItem();
					break;
				case 4:
					showItems();
					break;
			}
		}
	}
}
