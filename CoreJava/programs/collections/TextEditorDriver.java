import java.util.Scanner;

public class TextEditorDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TextEditor editor = new TextEditor();
		
		System.out.println("=== MINI TEXT EDITOR ===");
		System.out.println("1. Add Text");
		System.out.println("2. Delete Text");
		System.out.println("3. Search Word");
		System.out.println("4. Replace Word");
		System.out.println("5. Undo");
		System.out.println("6. Redo");
		System.out.println("7. Display Document");
		System.out.println("8. Exit");
		
		while(true) {
			System.out.print("Choose: ");
			int ch = sc.nextInt();
			
			sc.nextLine();
			switch(ch) {
			
			case 1:
				System.out.print("Enter text: ");
				String text=sc.nextLine();
				editor.addText(text);
				System.out.println();
				break;
				
			case 2:
				System.out.print("Enter number of characters to delete: ");
				int n=sc.nextInt();
				editor.deleteText(n);
				System.out.println();

				break;
				
			case 3:
				System.out.print("Enter word to search: ");
				editor.searchWord(sc.next());
				System.out.println();

				break;
				
			case 4:
				System.out.print("Enter word to replace: ");
				String oldW = sc.next();
				System.out.print("Enter replacement: ");
				String newW = sc.next();
				editor.replaceWord(oldW, newW);
				System.out.println();

				break;
				
			case 5:
				editor.undo();
				System.out.println();

				break;

			case 6:
				editor.redo();
				System.out.println();

				break;

			case 7:
				editor.display();
				System.out.println();

				break;
				
			case 8:
				System.out.println("Exiting editor...");
				sc.close();
				return;
			
			default:
				System.out.println("Invalid choice!");
				break;
			}
		}
	}
}
