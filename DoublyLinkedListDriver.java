public class DoublyLinkedListDriver {
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		
		Scanner scanner;
		
		System.out.print("Enter list type (i - int, d - double, s - string): ");
		scanner = new Scanner(System.in);
		char type = scanner.findInLine(".").charAt(0);
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(args[0]));
			String line;
			while (null != (line = reader.readLine())) {
				StringTokenizer st = new StringTokenizer(line, " ");
				while (st.hasMoreTokens()) {
					if (type == 'i') {
						list.push(Integer.valueOf(st.nextToken()));
					} else if (type == 'd') {
						list.push(Double.valueOf(st.nextToken()));
					} else if (type == 's') {
						list.push(st.nextToken());
					} else {
						System.out.println("Invalid Type !!");
						System.exit(0);
					}
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("File not found !!");
			System.exit(0);
		}
		
		/*list.push(Integer.valueOf(5));
		list.push(Integer.valueOf(3));
		list.push(Integer.valueOf(20));
		list.push(Integer.valueOf(10));
		list.push(Integer.valueOf(56));
		list.push(Integer.valueOf(10));
		list.push(Integer.valueOf(34));*/
		
		list.sortList();

		System.out.println("Commands:");
		System.out.println("(i) - Insert value");
		System.out.println("(d) - Delete value");
		System.out.println("(p) - Print list");
		System.out.println("(l) - Length");
		System.out.println("(t) - Print reverse");
		System.out.println("(r) - Reverse list");
		System.out.println("(b) - Delete Subsection");
		System.out.println("(s) - Swap Alternate");
		System.out.println("(q) - Quit program");

		char input = '0';
		boolean flag = true;
		boolean reverse_flag = false;
		do {
			if (flag) {
				System.out.print("\nEnter a Command: ");
			} else {
				System.out.print("\nInvalid command try again: ");
			}
			flag = true;
			scanner = new Scanner(System.in);
			input = scanner.findInLine(".").charAt(0);
			switch (input) {
			case 'i':
				System.out.print("\nThe list is: ");
				list.print();
				System.out.print("\nEnter a number to insert: ");
				scanner = new Scanner(System.in);
				Object value_insert = null;
				if (type == 'i') {
					value_insert = scanner.nextInt();
				} else if (type == 'd') {
					value_insert = scanner.nextDouble();
				} else if (type == 's') {
					value_insert = scanner.next();
				}
				list.insertItem(value_insert);
				list.sortList();
				System.out.print("\nThe list is: ");
				list.print();
				System.out.print("\nThe reverse list: ");
				list.printReverse();
				break;

			case 'd':
				System.out.print("\nThe list is: ");
				list.print();
				System.out.print("\nEnter a number to delete: ");
				scanner = new Scanner(System.in);
				Object value_delete = null;
				if (type == 'i') {
					value_delete = scanner.nextInt();
				} else if (type == 'd') {
					value_delete = scanner.nextDouble();
				} else if (type == 's') {
					value_delete = scanner.next();
				}
				if (list.length() > 0) {
					list.deleteItem(value_delete);
					System.out.print("\nThe list is: ");
					list.print();
					System.out.print("\nThe reverse list: ");
					list.printReverse();
				} else {
					System.out.print("\nYou cannot delete from an empty list");
				}
				break;

			case 'b':
				System.out.print("\nEnter the lower bound: ");
				scanner = new Scanner(System.in);
				Object lower_bound_value = null;
				if (type == 'i') {
					lower_bound_value = scanner.nextInt();
				} else if (type == 'd') {
					lower_bound_value = scanner.nextDouble();
				} else if (type == 's') {
					lower_bound_value = scanner.next();
				}
				System.out.print("\nEnter the upper bound: ");
				scanner = new Scanner(System.in);
				Object upper_bound_value = null;
				if (type == 'i') {
					upper_bound_value = scanner.nextInt();
				} else if (type == 'd') {
					upper_bound_value = scanner.nextDouble();
				} else if (type == 's') {
					upper_bound_value = scanner.next();
				}
				System.out.print("\nThe orginal list: ");
				list.print();
				list.deleteSubsection(list.findLowerBoundNode(lower_bound_value), list.findUpperBoundNode(upper_bound_value));
				System.out.print("\nThe modified list: ");
				list.print();
				System.out.print("\nThe reverse list: ");
				list.printReverse();
				break;

			case 's':
				System.out.print("\nThe orginal list: ");
				list.print();
				System.out.print("\nThe modified list: ");
				list.alternateSwap();
				list.print();
				System.out.print("\nThe reverse list: ");
				list.printReverse();
				break;

			case 'r':
				if (!reverse_flag) {
					list.deSortList();
					reverse_flag = true;
				} else {
					list.sortList();
					reverse_flag = false;
				}
				System.out.print("\nThe Orginal list: ");
				list.print();
				System.out.print("\nThe reversed list: ");
				list.printReverse();
				break;

			case 'p':
				System.out.print("\nThe list is: ");
				list.print();
				break;

			case 't':
				System.out.print("\nThe reverse list: ");
				list.printReverse();
				break;

			case 'l':
				System.out.print("\nThe length of the list is " + list.length());
				break;

			case 'q':
				System.out.println("===== QUIT =====");
				break;

			default:
				flag = false;
				break;
			}
		} while (input != 'q');
		scanner.close();
	}
}
