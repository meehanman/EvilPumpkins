public class Rat extends Thread {
	Cellar cellar;

	public Rat(Cellar c) {
		this.cellar = c;
	}

	public void run() {
		while (true) {
			eatPumpkin();
		}
	}

	private void eatPumpkin() {
		try {
			cellar.eat();
			Thread.sleep(TimeKeeper.hours(24));
		} catch (InterruptedException e) {
		}
	}

}
