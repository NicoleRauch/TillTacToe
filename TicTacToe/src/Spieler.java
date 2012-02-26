public enum Spieler {
	LEER(" "), //
	KREUZ("X"), //
	KREIS("O");

	private final String muster;

	private Spieler(String muster) {
		this.muster = muster;
	}

	@Override
	public String toString() {
		return muster;
	}
}