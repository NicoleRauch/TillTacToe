package javaCode;

import scalaCode.Spieler;

public interface ISpielbrett {
	
	  void naechsterZugAufFeld(int zeilennummer, int spaltennummer);
	  
	  Spieler werHatGewonnen();

	boolean sindAlleFelderBelegt();

	Spieler getSpieler(int zeilennummer, int spaltennummer);

}