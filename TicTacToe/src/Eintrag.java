public enum Eintrag {
	LEER("-"), //
	KREUZ("X"), //
	KREIS("O");

	private final String muster;

	private Eintrag(String muster) {
		this.muster = muster;
	}

	@Override
	public String toString() {
		return muster;
	}
}