import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


public class MemoryBuilder {

	private HashMap < Integer , NextState > infoForNextStates;
	private HashMap < String , Integer > combinedStatesNames;
	private HashMap < Integer, String > orderOfStates;
	private List < String > NextStatesParser;
	private NextState followingState;
	private boolean [][] stateConnection;
	private String [] stateInputName;
	private boolean [] rowRemove;
	private int [] columnRemove;
	private int sizeOfCombinedStates;
	private int numberOfStates;
	private int mio;
	
	
	public void storeNames(String[] statesNames) {
		
		orderOfStates = new HashMap<Integer, String>();
		numberOfStates = statesNames.length;
		stateInputName = new String [numberOfStates];
		
		for(int i = 0; i < numberOfStates; i++){
			
			String TempStateName = statesNames[i];
			orderOfStates.put(i , TempStateName + ",");
			stateInputName[i] = TempStateName + ",";
		}
	}

	public void parseNextStates(String[] nextStates) {
		
		infoForNextStates = new HashMap<Integer, NextState>();
		String search = "\\w+(,?)";
		
		for(int i = 0; i < nextStates.length; i++){
		
			try {
				
				int separateColon = nextStates[i].indexOf(':');
				String atZeroInput = nextStates[i].substring(0 , separateColon);
				String atOneInput = nextStates[i].substring(separateColon + 1);
				NextStatesParser = RegexChecker.checker(search, nextStates[i]);
				
				NextStatesParser = RegexChecker.checker(search, atZeroInput);
				fillStateTable(NextStatesParser , false , i);
				
				NextStatesParser = RegexChecker.checker(search, atOneInput);
				fillStateTable(NextStatesParser , true , i);
				
				
			} catch (SQLException e) {
				
			}
			
		}
	}

	private void fillStateTable(List<String> nextStatesParser, boolean inputStatus, int stateNum) {
		
		boolean zeroInput = !inputStatus , zeroOutput = false;
		
		String state = nextStatesParser.get(0);
		String output = nextStatesParser.get(1);
		
		if(output.equals("0")) zeroOutput = true;
		
		if(zeroInput){
			
			followingState = new NextState();
			followingState.setNextStateZeroInput(state);
			followingState.setZeroOutputAtZeroInput(zeroOutput);
			
		} else {
			
			followingState = infoForNextStates.get(stateNum);
			followingState.setNextStateOneInput(state);
			followingState.setZeroOutputAtOneInput(zeroOutput);
		}
		
		infoForNextStates.put(stateNum, followingState);
	}
	
	public void formCombinedStates(){
		
		combinedStatesNames = new HashMap<String, Integer>();
		sizeOfCombinedStates = numberOfStates * (numberOfStates - 1) / 2;
		stateConnection = new boolean [sizeOfCombinedStates][sizeOfCombinedStates];
		int stateNum = 0;
		
		for(int i = 0; i < stateInputName.length; i++){
			
			for(int j = i + 1; j < stateInputName.length; j++){
				
				String newState = stateInputName[i] + stateInputName[j];
				String sameNewState = stateInputName[j] + stateInputName[i];
				
				combinedStatesNames.put(newState, stateNum);
				combinedStatesNames.put(sameNewState, stateNum++);
			
			}
		}
	}
	
	public void buildAdjacencyMatrix(){
		
		for(int i = 0; i < stateInputName.length; i++){
			
			String firstStateName = orderOfStates.get(i);
			NextState stateInfo = infoForNextStates.get(i);
			
			String nextStateZeroInput = stateInfo.getNextStateZeroInput();
			String nextStateOneInput = stateInfo.getNextStateOneInput();
			
			boolean zeroOutputAtZeroInput = stateInfo.isZeroOutputAtZeroInput();
			boolean zeroOutputAtOneInput = stateInfo.isZeroOutputAtOneInput();
			
			for(int j = i + 1; j < stateInputName.length; j++){
				
				String secondStateName = orderOfStates.get(j);
				NextState stateInfo2 = infoForNextStates.get(j);
				
				String nextStateZeroInput2 = stateInfo2.getNextStateZeroInput();
				String nextStateOneInput2 = stateInfo2.getNextStateOneInput();
				
				boolean zeroOutputAtZeroInput2 = stateInfo2.isZeroOutputAtZeroInput();
				boolean zeroOutputAtOneInput2 = stateInfo2.isZeroOutputAtOneInput();
				
				fillAdjacencyMatrix(firstStateName, nextStateZeroInput, nextStateOneInput,
				zeroOutputAtZeroInput, zeroOutputAtOneInput, secondStateName, 
				nextStateZeroInput2, nextStateOneInput2, zeroOutputAtZeroInput2,
				zeroOutputAtOneInput2);
			}
		}
		
	}
	
	private void fillAdjacencyMatrix(String firstStateName, String nextStateZeroInput, String nextStateOneInput,
			boolean zeroOutputAtZeroInput, boolean zeroOutputAtOneInput, String secondStateName, 
			String nextStateZeroInput2, String nextStateOneInput2, boolean zeroOutputAtZeroInput2,
			boolean zeroOutputAtOneInput2){
		
		String nextStateName = "";
		String currentNextState = firstStateName + secondStateName;
		
		if(!nextStateZeroInput.equals( nextStateZeroInput2 ) && zeroOutputAtZeroInput == zeroOutputAtZeroInput2 ){
				
			nextStateName = nextStateZeroInput + nextStateZeroInput2;
			int CurrentStateIndex = combinedStatesNames.get(currentNextState);
			int nextStateIndex = combinedStatesNames.get(nextStateName);
			
			stateConnection[CurrentStateIndex][nextStateIndex] = true;
		}
		
		if(!nextStateOneInput.equals( nextStateOneInput2 ) && zeroOutputAtOneInput == zeroOutputAtOneInput2 ){
			
			nextStateName = nextStateOneInput + nextStateOneInput2;
			int CurrentStateIndex = combinedStatesNames.get(currentNextState);
			int nextStateIndex = combinedStatesNames.get(nextStateName);
			
			stateConnection[CurrentStateIndex][nextStateIndex] = true;
		}
		
	}
	
	public String detemineMemoryType(){
		
		boolean falseRow = true;
		
		columnRemove = new int [sizeOfCombinedStates];
		rowRemove    = new boolean [sizeOfCombinedStates];
		
		while(falseRow){
			
			mio++;
			falseRow = false;
			
			for(int i = 0; i < sizeOfCombinedStates; i++){
				
				if(rowRemove[i] == true) continue;
				
				boolean isThereConnection = false;
				
				for(int j = 0; j < sizeOfCombinedStates; j++){
					
					if(columnRemove[j] != 0 && columnRemove[j] < mio) continue;
					
					if(stateConnection[i][j] == true){
						
						isThereConnection = true; 
						break;
					}
				}
				
				if(!isThereConnection){
					
					rowRemove[i] = true;
					columnRemove[i] = mio;
					falseRow = true;
				}
			}
			
		}
		
		return printMemoryType();
	}
	
	private String printMemoryType(){
		
		boolean finite = true;
		String memoryMio = String.valueOf(mio - 1); 
		
		for(int i = 0; i < sizeOfCombinedStates; i++){
			
			if(rowRemove[i] == false){
				
				finite = false;
				break;
			}
		}
		
		if(finite) return ("Memory is finite, Mio = " + memoryMio + ".");
		else return "Memory is infinte.";
	}
	
}
