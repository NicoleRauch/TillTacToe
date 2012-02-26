import Spieler._

class Spielbrett {

  val kaestchen = new Array[Array[Kaestchen]](3)
  kaestchen(0) = Array(new Kaestchen, new Kaestchen, new Kaestchen)
  kaestchen(1) = Array(new Kaestchen, new Kaestchen, new Kaestchen)
  kaestchen(2) = Array(new Kaestchen, new Kaestchen, new Kaestchen)

  def get(zeilennummer: Int, spaltennummer: Int) = {
    kaestchen(zeilennummer)(spaltennummer)
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
  
  def set(neuerSpieler : Spieler) = {
    spieler = neuerSpieler
  }

  override def toString = {
    " " + spieler + " "
  }
}

