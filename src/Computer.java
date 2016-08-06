
public class Computer extends Player {
	final int DEFAULT_DIFFICULTY = 4;
	int difficulty;

	public Computer() {
		difficulty = DEFAULT_DIFFICULTY;
	}

	public Computer(int difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public String guess() {
		return null;
	}

	@Override
	public void setWord(int length) {
		
	}

}
