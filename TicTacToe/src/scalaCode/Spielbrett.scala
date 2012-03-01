package scalaCode;
import javaCode.ISpielbrett
 
class Spielbrett extends ISpielbrett {

  var aktuellerSpieler : Spieler = Kreuz;

  val kaestchen = new Array[Array[Kaestchen]](3)
  kaestchen(0) = Array(new Kaestchen, new Kaestchen, new Kaestchen)
  kaestchen(1) = Array(new Kaestchen, new Kaestchen, new Kaestchen)
  kaestchen(2) = Array(new Kaestchen, new Kaestchen, new Kaestchen)

  def naechsterZugAufFeld(zeilennummer: Int, spaltennummer: Int) = {
    if (kaestchen(zeilennummer)(spaltennummer).get() == Niemand) {
      kaestchen(zeilennummer)(spaltennummer).set(aktuellerSpieler);
      derNaechsteSpielerIstDran();
    }
  }
  
  def sindAlleFelderBelegt = {
	  (kaestchen(0) ++ kaestchen(1) ++ kaestchen(2)).filter(kaestchen => kaestchen.get() == Niemand).isEmpty
  }

  def werHatGewonnen = {
    (untersucheSpaltenAufGewinner
++    untersucheZeilenAufGewinner
++    untersucheDiagonalenAufGewinner
)
    .filter(spieler => spieler != Niemand).headOption.getOrElse(Niemand)
  }

  private def untersucheZeilenAufGewinner = {
    untersucheZeileAufGewinner(0) ::
    untersucheZeileAufGewinner(1) ::
    untersucheZeileAufGewinner(2) :: Nil 
  }
  
    private def untersucheZeileAufGewinner(zeilennummer: Int) = {
    if (kaestchen(zeilennummer)(0).get() ==
      kaestchen(zeilennummer)(1).get() &&
      kaestchen(zeilennummer)(1).get() ==
      kaestchen(zeilennummer)(2).get()) {
      kaestchen(zeilennummer)(0).get()
    } else Niemand
  }

  private def untersucheDiagonalenAufGewinner = {
    untersucheDiagonale1AufGewinner ::
    untersucheDiagonale2AufGewinner :: Nil 
  }
  
      private def untersucheDiagonale1AufGewinner = {
    if (kaestchen(0)(0).get() ==
      kaestchen(1)(1).get() &&
      kaestchen(1)(1).get() ==
      kaestchen(2)(2).get()) {
      kaestchen(2)(2).get()
    } else Niemand
  }

      private def untersucheDiagonale2AufGewinner = {
	  if (kaestchen(0)(2).get() ==
		  kaestchen(1)(1).get() &&
		  kaestchen(1)(1).get() ==
			  kaestchen(2)(0).get()) {
		  kaestchen(2)(0).get()
	  } else Niemand
  }

  
  private def untersucheSpaltenAufGewinner = {
    untersucheSpalteAufGewinner(0) ::
    untersucheSpalteAufGewinner(1) ::
    untersucheSpalteAufGewinner(2) :: Nil
  }

  private def untersucheSpalteAufGewinner(spaltennummer: Int) = {
    if (kaestchen(0)(spaltennummer).get() ==
      kaestchen(1)(spaltennummer).get() &&
      kaestchen(1)(spaltennummer).get() ==
      kaestchen(2)(spaltennummer).get()) {
      kaestchen(0)(spaltennummer).get()
    } else Niemand
  }

  private def derNaechsteSpielerIstDran() {
    if (aktuellerSpieler == Kreuz) {
      aktuellerSpieler = Kreis;
    } else if (aktuellerSpieler == Kreis) {
      aktuellerSpieler = Kreuz;
    }
  }

  def getSpieler(zeilennummer: Int, spaltennummer: Int) = {
    kaestchen(zeilennummer)(spaltennummer).get
  }

  override def toString = {
    gibZeileAus(0) + gibZeileAus(1) + gibZeileAus(2)
  }

  private def gibZeileAus(zeilennummer: Int): java.lang.String = {
    kaestchen(zeilennummer)(0).toString + kaestchen(zeilennummer)(1) + kaestchen(zeilennummer)(2) + "\n"
  }
}

class Kaestchen {
  var spieler : Spieler = Niemand

  def get() = spieler

  def set(neuerSpieler: Spieler) = {
    spieler = neuerSpieler
  }

  override def toString = {
    " " + spieler + " "
  }
}

