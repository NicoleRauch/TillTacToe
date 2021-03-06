package scalaCode
import java.util.Scanner

object Konsole {

  def main(args: Array[String]) {
    val spielbrett = new Spielbrett();
    zeichneSpielbrett(spielbrett);

    while (spielbrett.werHatGewonnen() == Niemand && !spielbrett.sindAlleFelderBelegt()) {
      fuehreSpielerZugAus(spielbrett)
      fuehreComputerZugAus(spielbrett)
      zeichneSpielbrett(spielbrett)
    }

    if (!hatJemandGewonnen(spielbrett)) {
      println("Unentschieden...")
    }
  }

  def fuehreComputerZugAus(spielbrett: Spielbrett) {
    val strategie = new AbwehrStrategie(spielbrett)
    spielbrett.naechsterZugAuf(strategie.naechsterZug)
  }

  def zeichneSpielbrett(spielbrett: Spielbrett) {
    for (zeile <- 0 to 2) {
      for (spalte <- 0 to 2) {
        if (spalte == 0) {
          print(" ")
        }
        print(symbol(spielbrett.getSpieler(zeile, spalte)));
        if (spalte < 2) {
          print(" | ");
        }
      }
      println();
      if (zeile < 2) {
        println("---+---+---");
      }
    }
  }

  def symbol(spieler: Spieler) = {
    spieler match {
      case Niemand => " "
      case Kreuz => "X"
      case Kreis => "O"
    }
  }

  private def fuehreSpielerZugAus(spielbrett: scalaCode.Spielbrett) = {
    val sc = new Scanner(System.in);
    print("Zeile (0-2): ")
    val zeile = sc.nextInt()
    print("Spalte (0-2): ")
    val spalte = sc.nextInt()
    spielbrett.naechsterZugAufFeld(zeile, spalte)
  }

  def hatJemandGewonnen(spielbrett: scalaCode.Spielbrett) = {
    if (spielbrett.werHatGewonnen() != Niemand) {
      println(symbol(spielbrett.werHatGewonnen()) + " hat gewonnen!")
      true
    } else
      false
  }
}

