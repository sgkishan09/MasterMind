import java.util.*;

public class Computer extends Player {
	public ArrayList<String> possibleWords;
	
	public Computer() {
		super("");
	}

	public Computer(int difficulty) {
		this.setWord(difficulty);
	}

	@Override
	public String guess() {
		return null;
	}

	@Override
	public void setWord(int length) {

	}

}
