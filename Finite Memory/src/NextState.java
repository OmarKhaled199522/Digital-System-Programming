
public class NextState {

	private boolean zeroOutputAtZeroInput;
	private boolean zeroOutputAtOneInput;
	private String nextStateZeroInput;
	private String nextStateOneInput;
	
	

	public String getNextStateZeroInput() {
		return nextStateZeroInput;
	}

	public void setNextStateZeroInput(String nextStateZeroInput) {
		this.nextStateZeroInput = nextStateZeroInput;
	}

	public String getNextStateOneInput() {
		return nextStateOneInput;
	}

	public void setNextStateOneInput(String nextStateOneInput) {
		this.nextStateOneInput = nextStateOneInput;
	}

	public boolean isZeroOutputAtZeroInput() {
		return zeroOutputAtZeroInput;
	}

	public void setZeroOutputAtZeroInput(boolean zeroOutputAtZeroInput) {
		this.zeroOutputAtZeroInput = zeroOutputAtZeroInput;
	}

	public boolean isZeroOutputAtOneInput() {
		return zeroOutputAtOneInput;
	}

	public void setZeroOutputAtOneInput(boolean zeroOutputAtOneInput) {
		this.zeroOutputAtOneInput = zeroOutputAtOneInput;
	}
	
}
