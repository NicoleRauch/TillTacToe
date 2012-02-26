import Eintrag._

class Spielbrett {

  val kaestchen = new Array[Array[Kaestchen]](3)
  kaestchen(0) = Array(new Kaestchen, new Kaestchen, new Kaestchen)
  kaestchen(1) = Array(new Kaestchen, new Kaestchen, new Kaestchen)
  kaestchen(2) = Array(new Kaestchen, new Kaestchen, new Kaestchen)
  
  def gibAus = {
    gibZeileAus(0) + gibZeileAus(1) + gibZeileAus(2)
    }
  
  private def gibZeileAus(zeilennummer : Int) = {
    kaestchen(zeilennummer)(0).gibAus + kaestchen(zeilennummer)(1).gibAus + kaestchen(zeilennummer)(2).gibAus + "\n"
  }
  
}

class Kaestchen {
  val eintrag = LEER
  
  
  
  def gibAus = {
    " " + eintrag + " "
  }
}

