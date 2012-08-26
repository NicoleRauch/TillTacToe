package javaCode;

import scalaCode.Spieler;

public interface SpielbrettListener {

	void valueChangedAt(int zeile, int spalte, Spieler spieler);
	
}
