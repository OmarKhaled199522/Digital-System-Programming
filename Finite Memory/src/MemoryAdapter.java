
public class MemoryAdapter implements MemoryInterface {

	MemoryBuilder builder = new MemoryBuilder();
	
	@Override
	public void enterStatesNames(String[] statesNames) {
		
		builder.storeNames(statesNames);
		
	}

	@Override
	public void enterNextStates(String[] nextStates) {
		
		builder.parseNextStates(nextStates);
		builder.formCombinedStates();
	}

	@Override
	public String checkMemoryStatus() {
		
		builder.buildAdjacencyMatrix();
		return builder.detemineMemoryType();
	}

}
