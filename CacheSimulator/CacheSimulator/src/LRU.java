import java.util.concurrent.ThreadLocalRandom;

public class LRU implements IReplacement {

	@Override
	public int getIndex(int index, int cacheSize) {
		if (index < cacheSize - 1)
			return ++index;
		return ThreadLocalRandom.current().nextInt(0, cacheSize);
	}

}
