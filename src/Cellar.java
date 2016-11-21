import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cellar {

	private boolean beingAccessed = false;
	private List<Pumpkin> pumpkins = new ArrayList<Pumpkin>();
	private final Rat[] rats;

	public Cellar(int AmountOfRats) {
		// Create and start Rat threads
		this.rats = new Rat[AmountOfRats];
		for (int i = 0; i < AmountOfRats; i++) {
			rats[i] = new Rat(this);
			rats[i].start();
		}
	}

	public synchronized void put(Pumpkin p) {
		while (beingAccessed) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		beingAccessed = true;
		pumpkins.add(p);
		System.out.println("Put Pumpkin " + p.created + " size: " + pumpkins.size());
		beingAccessed = false;
		notify();
	}

	public synchronized Pumpkin eat() {
		while (beingAccessed) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		Pumpkin atePumpkin = null;
		while (atePumpkin == null) {
			beingAccessed = true;
			// Save a list of available non-evil pumpkins
			List<Integer> nonEvilPumpkins = new ArrayList<Integer>();
			for (int i = 0; i < pumpkins.size(); i++) {
				if (!pumpkins.get(i).isEvil()) {
					nonEvilPumpkins.add(i);
				}
			}

			// If there is at least 1 pumpkin
			if (!nonEvilPumpkins.isEmpty()) {
				int randomPumpkinLocation = getRandomID(nonEvilPumpkins);
				atePumpkin = pumpkins.get(randomPumpkinLocation);
				System.out.println("("+nonEvilPumpkins.size()+"/"
						+pumpkins.size()+")\tAte "+atePumpkin.created);
				pumpkins.remove(randomPumpkinLocation);
				beingAccessed = false;
			} else {
				// If not wait until something has changed and try and get a
				// random pumpkin again as some could have went off or been
				// eaten
				try {
					beingAccessed = false;
					wait();
				} catch (InterruptedException e) {}
			}
		}
		notify();
		return atePumpkin;
	}

	/**
	 * Pass in [2,5,3] and get either 2, 5 or 3 returned.
	 */
	private Integer getRandomID(List<Integer> x) {
		try {
			return x.get((new Random()).nextInt(x.size()));
		} catch (Throwable e) {
			return null;
		}
	}
}