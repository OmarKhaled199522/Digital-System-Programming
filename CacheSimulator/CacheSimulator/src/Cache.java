public class Cache {
	private IMap map;

	public Cache(IMap map) {
		this.map = map;
	}

	public void cache(String... objects) {
		map.cache(objects);
	}

	public void printCache() {
		map.print();
	}

	public void exit() {
		System.exit(0);
	}
}
