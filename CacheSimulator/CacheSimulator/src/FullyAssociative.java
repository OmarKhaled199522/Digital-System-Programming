
public class FullyAssociative implements IMap {
	private String[] cache;
	private int insertionIndex;
	private int blockSize;
	private IReplacement replacement;

	public FullyAssociative(int cacheSize, IReplacement replacement) {
		cache = new String[cacheSize];
		insertionIndex = -1;
		this.blockSize = 4;
		this.replacement = replacement;
	}

	@Override
	public void cache(String... objects) {
		int size = cache.length;
		for (String obj : objects) {
			insertionIndex = replacement.getIndex(insertionIndex, size);
			cache[insertionIndex] = obj;
		}
	}

	@Override
	public void print() {
		int j = 0;
		for (int i = 0; i < cache.length; i++) {
			if (i % blockSize == 0)
				System.out.format("\nBlock%-4d", j++);
			String item = cache[i];
			System.out.format("%-5s", item == null ? "*" : item);
		}
	}
}
