import java.util.Arrays;

public class SetAssociative implements IMap {
	private String[][] cache;
	private int[] insertionIndices;
	private IReplacement replacement;
	private int blocksPerSet;

	public SetAssociative(int numSets, int cacheSize, IReplacement replacement) {
		cache = new String[cacheSize / 4][4];
		insertionIndices = new int[cacheSize / 4];
		Arrays.fill(insertionIndices, -1);
		this.replacement = replacement;
		blocksPerSet = cacheSize / 4 / numSets;
	}

	@Override
	public void cache(String... objects) {
		int size = cache[0].length;
		int blocks = insertionIndices.length;
		for (String obj : objects) {
			int block = Integer.parseInt(obj) % blocks;
			insertionIndices[block] = replacement.getIndex(insertionIndices[block], size);
			cache[block][insertionIndices[block]] = obj;
		}
	}

	@Override
	public void print() {
		for (int i = 0; i < cache.length; i++) {
			int set = i % blocksPerSet;
			if (set == 0)
				System.out.format("\nSet%-4d", i / blocksPerSet);
			else
				System.out.format("\n   %-4s", " ");
			for (int j = 0; j < cache[0].length; j++) {
				String item = cache[i][j];
				System.out.format("%-5s", item == null ? "*" : item);
			}
		}
	}

}
