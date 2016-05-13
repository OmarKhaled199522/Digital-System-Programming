import java.util.Arrays;

public class DirectMapped implements IMap {
	private String[][] cache;
	private int[] insertionIndices;
	private IReplacement replacement;

	public DirectMapped(int cacheSize, IReplacement replacement) {
		cache = new String[cacheSize / 4][4];
		insertionIndices = new int[cacheSize / 4];
		Arrays.fill(insertionIndices, -1);
		this.replacement = replacement;
	}

	@Override
	public void cache(String... objects) {
		int size = cache[0].length;
		int sets = insertionIndices.length;
		for (String obj : objects) {
			int set = Integer.parseInt(obj) % sets;
			insertionIndices[set] = replacement.getIndex(insertionIndices[set], size);
			cache[set][insertionIndices[set]] = obj;
		}
	}

	@Override
	public void print() {
		for (int i = 0; i < cache.length; i++) {
			System.out.format("\nSet%-4d", i);
			for (int j = 0; j < cache[0].length; j++) {
				String item = cache[i][j];
				System.out.format("%-5s", item == null ? "*" : item);
			}
		}
	}
}
