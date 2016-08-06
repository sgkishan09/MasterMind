
public class Human extends Player {

	public Human() {
		super("");
	}

	public Human(int difficulty) {
		this.setWord(difficulty);
	}

	@Override
	public String guess() {
		System.out.println("Enter your Guess :");
		return Util.getInput();
	}

	@Override
	public void setWord(int length) {
		System.out.println("Enter String of length " + length + " :");
		this.word = Util.getInput();
	}

}
