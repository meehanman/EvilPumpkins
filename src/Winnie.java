public class Winnie extends Thread {
	Cellar cellar;

	public Winnie() {
		cellar = new Cellar(9);
	}

	public void run() {
		while (true) {
			carvePumpkin();
		}
	}

	private void carvePumpkin() {
		try {
			Thread.sleep(TimeKeeper.hours(1));
			cellar.put(new Pumpkin());
		} catch (InterruptedException e) {
		}
	}

}