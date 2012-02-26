import Spieler._

class Spielbrett {

  var aktuellerSpieler = Spieler.KREUZ;

  val kaestchen = new Array[Array[Kaestchen]](3)
  kaestchen(0) = Array(new Kaestchen, new Kaestchen, new Kaestchen)
  kaestchen(1) = Array(new Kaestchen, new Kaestchen, new Kaestchen)
  kaestchen(2) = Array(new Kaestchen, new Kaestchen, new Kaestchen)

  def naechsterZugAufFeld(zeilennummer: Int, spaltennummer: Int) = {
    if (kaestchen(zeilennummer)(spaltennummer).get() == Spieler.LEER) {
      kaestchen(zeilennummer)(spaltennummer).set(aktuellerSpieler);
      derNaechsteSpielerIstDran();
    }
  }

  def werHatGewonnen = {
    (untersucheSpaltenAufGewinner
++    untersucheZeilenAufGewinner
++    untersucheDiagonalenAufGewinner
)
    .filter(spieler => spieler != Spieler.LEER).headOption.getOrElse(Spieler.LEER)
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
    } else Spieler.LEER
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
    } else Spieler.LEER
  }

      private def untersucheDiagonale2AufGewinner = {
	  if (kaestchen(0)(2).get() ==
		  kaestchen(1)(1).get() &&
		  kaestchen(1)(1).get() ==
			  kaestchen(2)(0).get()) {
		  kaestchen(2)(0).get()
	  } else Spieler.LEER
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
    } else Spieler.LEER
  }

  private def derNaechsteSpielerIstDran() {
    if (aktuellerSpieler == Spieler.KREUZ) {
      aktuellerSpieler = Spieler.KREIS;
    } else if (aktuellerSpieler == Spieler.KREIS) {
      aktuellerSpieler = Spieler.KREUZ;
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
  var spieler = LEER

  def get() = spieler

  def set(neuerSpieler: Spieler) = {
    spieler = neuerSpieler
  }

  override def toString = {
    " " + spieler + " "
  }
}

