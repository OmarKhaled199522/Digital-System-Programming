import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the cache size");
		int size = input.nextInt();

		System.out.println("Choose replacement policy\n\t1 for FIFO\n\t2 for LRU");
		int replacement = input.nextInt();
		IReplacement replacementAlgo;
		if (replacement == 1)
			replacementAlgo = new Fifo();
		else
			replacementAlgo = new LRU();

		System.out.println(
				"Enter the mapping function:\n\t1 for Direct mapping.\n\t2 for Fully associative.\n\t3 for Set associative.");
		IMap mapping = null;
		switch (input.nextInt()) {
		case 1:
			mapping = new DirectMapped(size, replacementAlgo);
			break;
		case 2:
			mapping = new FullyAssociative(size, replacementAlgo);
			break;
		case 3:
			System.out.println("Enter number of sets");
			int SNumSets = input.nextInt();
			mapping = new SetAssociative(SNumSets, size, replacementAlgo);
			break;
		default:
			input.close();
			return;
		}
		Cache cache = new Cache(mapping);
		boolean running = true;
		while (running) {
			System.out.println(
					"\n\nChoose the required action:\n\t1 Enter sequence of blocks.\n\t2 Print cache contents.\n\t3 Stop simulation");
			int choice = input.nextInt();
			input.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter data separated by space");
				String blocks = input.nextLine();
				cache.cache(blocks.split("\\s+"));
				break;
			case 2:
				cache.printCache();
				break;
			default:
				System.out.println("Bye :)");
				running = false;
				break;
			}
		}

		input.close();
	}

}
