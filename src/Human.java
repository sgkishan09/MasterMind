
public class Human extends Player {

	public Human() {
		super("");
	}

	public Human(String word) {
		super(word);
	}

	@Override
	public String guess() {
		return null;
	}

	@Override
	public void setWord(int length) {
		System.out.println("Enter String of length " + length + " :");
		this.word = Util.getInput();
	}

}
