
public class Fifo implements IReplacement {

	@Override
	public int getIndex(int index, int cacheSize) {
		if (index == cacheSize - 1)
			return 0;
		return ++index;
	}

}
