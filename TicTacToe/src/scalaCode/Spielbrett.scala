package scalaCode;
import javaCode.ISpielbrett

class Spielbrett extends ISpielbrett {

  var aktuellerSpieler: Spieler = Kreuz;

  val kaestchen = new Array[Array[Spieler]](3)
  kaestchen(0) = Array(Niemand, Niemand, Niemand)
  kaestchen(1) = Array(Niemand, Niemand, Niemand)
  kaestchen(2) = Array(Niemand, Niemand, Niemand)

  def getSpieler(zeilennummer: Int, spaltennummer: Int) = {
    kaestchen(zeilennummer)(spaltennummer)
  }

  def naechsterZugAufFeld(zeilennummer: Int, spaltennummer: Int) = {
    if (kaestchen(zeilennummer)(spaltennummer) == Niemand) {
      kaestchen(zeilennummer)(spaltennummer) = aktuellerSpieler;
      derNaechsteSpielerIstDran();
    }
  }

  def sindAlleFelderBelegt = {
    (kaestchen(0) ++ kaestchen(1) ++ kaestchen(2)).filter(kaestchen => kaestchen == Niemand).isEmpty
  }

  def istDasSpielbrettLeer = {
	  (kaestchen(0) ++ kaestchen(1) ++ kaestchen(2)).filter(kaestchen => kaestchen == Kreis || kaestchen == Kreuz).isEmpty
  }
  
  def werHatGewonnen = {
    (untersucheSpaltenAufGewinner
      ++ untersucheZeilenAufGewinner
      ++ untersucheDiagonalenAufGewinner)
      .filter(spieler => spieler != Niemand).headOption.getOrElse(Niemand)
  }

  private def untersucheZeilenAufGewinner = {
    untersucheZeileAufGewinner(0) ::
      untersucheZeileAufGewinner(1) ::
      untersucheZeileAufGewinner(2) :: Nil
  }

  private def untersucheZeileAufGewinner(zeilennummer: Int) = {
    if (kaestchen(zeilennummer)(0) ==
      kaestchen(zeilennummer)(1) &&
      kaestchen(zeilennummer)(1) ==
      kaestchen(zeilennummer)(2)) {
      kaestchen(zeilennummer)(0)
    } else Niemand
  }

  private def untersucheDiagonalenAufGewinner = {
    untersucheDiagonale1AufGewinner ::
      untersucheDiagonale2AufGewinner :: Nil
  }

  private def untersucheDiagonale1AufGewinner = {
    if (kaestchen(0)(0) ==
      kaestchen(1)(1) &&
      kaestchen(1)(1) ==
      kaestchen(2)(2)) {
      kaestchen(2)(2)
    } else Niemand
  }

  private def untersucheDiagonale2AufGewinner = {
    if (kaestchen(0)(2) ==
      kaestchen(1)(1) &&
      kaestchen(1)(1) ==
      kaestchen(2)(0)) {
      kaestchen(2)(0)
    } else Niemand
  }

  private def untersucheSpaltenAufGewinner = {
    untersucheSpalteAufGewinner(0) ::
      untersucheSpalteAufGewinner(1) ::
      untersucheSpalteAufGewinner(2) :: Nil
  }

  private def untersucheSpalteAufGewinner(spaltennummer: Int) = {
    if (kaestchen(0)(spaltennummer) ==
      kaestchen(1)(spaltennummer) &&
      kaestchen(1)(spaltennummer) ==
      kaestchen(2)(spaltennummer)) {
      kaestchen(0)(spaltennummer)
    } else Niemand
  }

  private def derNaechsteSpielerIstDran() {
    if (aktuellerSpieler == Kreuz) {
      aktuellerSpieler = Kreis;
    } else if (aktuellerSpieler == Kreis) {
      aktuellerSpieler = Kreuz;
    }
  }
}

