class Pumpkin {
	public long created;

	public Pumpkin() {
		this.created = System.currentTimeMillis();
	}

	public boolean isEvil() {
		return (System.currentTimeMillis() - this.created) >= TimeKeeper.hours(13);
	}
}