import org.junit.Test;


public class Testing {

	MemoryAdapter adaptor = new MemoryAdapter();
	
	@Test
	public void test1() {
		
		String [] statesNames = {"A", "B", "C", "D"};
		adaptor.enterStatesNames(statesNames);
		
		String [] nextStates = {"B,0:B,0", "C,0:D,0" , "D,0:C,0", "A,0:C,1"};
		adaptor.enterNextStates(nextStates);
		
		String output = adaptor.checkMemoryStatus();
		
		System.out.println(output);
	}

	@Test
	public void test2() {
		
		String [] statesNames = {"A", "B", "C", "D" , "E"};
		adaptor.enterStatesNames(statesNames);
		
		String [] nextStates = {"D,0:C,1", "A,0:E,0" , "C,1:E,0", "C,1:C,1", "B,0:B,1"};
		adaptor.enterNextStates(nextStates);
		
		String output = adaptor.checkMemoryStatus();
		
		System.out.println(output);
	}
	
	@Test
	public void test3() {
		
		String [] statesNames = {"A", "B", "C", "D" , "E"};
		adaptor.enterStatesNames(statesNames);
		
		String [] nextStates = {"B,0:E,0", "C,0:D,0" , "D,0:C,0", "E,0:A,0", "E,0:A,1"};
		adaptor.enterNextStates(nextStates);
		
		String output = adaptor.checkMemoryStatus();
		
		System.out.println(output);
	}
	
	@Test
	public void test4() {
		
		String [] statesNames = {"A", "B", "C", "D" , "E"};
		adaptor.enterStatesNames(statesNames);
		
		String [] nextStates = {"D,1:E,0", "A,0:B,1" , "C,0:B,0", "C,1:B,1", "A,0:B,0"};
		adaptor.enterNextStates(nextStates);
		
		String output = adaptor.checkMemoryStatus();
		
		System.out.println(output);
	}
	
	@Test
	public void test5() {
		
		String [] statesNames = {"A", "B", "C", "D"};
		adaptor.enterStatesNames(statesNames);
		
		String [] nextStates = {"A,0:B,1", "C,1:D,0" , "D,0:C,1", "B,1:A,0"};
		adaptor.enterNextStates(nextStates);
		
		String output = adaptor.checkMemoryStatus();
		
		System.out.println(output);
	}
	
	@Test
	public void test6() {
		
		String [] statesNames = {"A", "B", "C", "D"};
		adaptor.enterStatesNames(statesNames);
		
		String [] nextStates = {"C,0:C,0", "D,1:A,0" , "C,1:B,0", "D,1:D,1"};
		adaptor.enterNextStates(nextStates);
		
		String output = adaptor.checkMemoryStatus();
		
		System.out.println(output);
	}
	
	@Test
	public void test7() {
		
		String [] statesNames = {"A", "B", "C", "D", "E", "F"};
		adaptor.enterStatesNames(statesNames);
		
		String [] nextStates = {"B,0:C,0", "D,0:E,1" , "F,1:D,0", "F,1:F,1", "B,0:B,0" , "A,1:A,1"};
		adaptor.enterNextStates(nextStates);
		
		String output = adaptor.checkMemoryStatus();
		
		System.out.println(output);
	}
	
	@Test
	public void test8() {
		
		String [] statesNames = {"A", "B", "C", "D"};
		adaptor.enterStatesNames(statesNames);
		
		String [] nextStates = {"B,0:D,0", "C,0:C,0" , "D,0:A,0", "D,0:A,1"};
		adaptor.enterNextStates(nextStates);
		
		String output = adaptor.checkMemoryStatus();
		
		System.out.println(output);
	}
	
	@Test
	public void test9() {
		
		String [] statesNames = {"A", "B", "C", "D"};
		adaptor.enterStatesNames(statesNames);
		
		String [] nextStates = {"B,0:C,1", "D,0:C,0" , "D,0:B,1", "C,0:A,0"};
		adaptor.enterNextStates(nextStates);
		
		String output = adaptor.checkMemoryStatus();
		
		System.out.println(output);
	}
	
	
}
