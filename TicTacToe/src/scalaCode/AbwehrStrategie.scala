package scalaCode
import javaCode.ISpielbrett;
import scala.util.Random

class AbwehrStrategie(spielbrett: Spielbrett) {

  def naechsterZug: (Int, Int) = {
    for (kombi <- gewinnKombinationen) {
      for (wieOft <- 0 to 3)
        if (spielbrett.spieler(drehen(wieOft, kombi(0))) == ich && spielbrett.spieler(drehen(wieOft, kombi(1))) == ich
          && spielbrett.spieler(drehen(wieOft, kombi(2))) == Niemand)
          return drehen(wieOft, kombi(2))
    }

    for (kombi <- gewinnKombinationen) {
      for (wieOft <- 0 to 3)
        if (spielbrett.spieler(drehen(wieOft, kombi(0))) == gegner && spielbrett.spieler(drehen(wieOft, kombi(1))) == gegner
          && spielbrett.spieler(drehen(wieOft, kombi(2))) == Niemand)
          return drehen(wieOft, kombi(2))
    }

    sucheErstesFreiesFeld
  }

  def gewinnKombinationen = {
    Array((0, 1), (1, 1), (2, 1)) :: // Nr. 1
      Array((2, 0), (1, 1), (0, 2)) :: // Nr. 2
      Array((0, 0), (1, 0), (2, 0)) :: // Nr. 3
      Array((0, 1), (2, 1), (1, 1)) :: // Nr. 4
      Array((0, 0), (2, 0), (1, 0)) :: // Nr. 5
      Array((0, 2), (2, 0), (1, 1)) :: // Nr. 6
      Nil
  }

def drehen(wieOft: Int, zug: (Int, Int)): (Int, Int) = {
    if (wieOft == 0) zug
    else if (wieOft == 1) drehen(zug)
    else if (wieOft == 2) drehen(drehen(zug))
    else drehen(drehen(drehen(zug)))
  }

  def drehen(zug: (Int, Int)): (Int, Int) = {
    val zeile = zug._1
    val spalte = zug._2
    if (zeile == 0 && spalte == 0) (0, 2)
    else if (zeile == 0 && spalte == 1) (1, 2)
    else if (zeile == 0 && spalte == 2) (2, 2)
    else if (zeile == 1 && spalte == 0) (0, 1)
    else if (zeile == 1 && spalte == 1) (1, 1)
    else if (zeile == 1 && spalte == 2) (2, 1)
    else if (zeile == 2 && spalte == 0) (0, 0)
    else if (zeile == 2 && spalte == 1) (1, 0)
    else (2, 0)
  }

  def sucheErstesFreiesFeld: (Int, Int) = {
    var zeile = Random.nextInt(3)
    var spalte = Random.nextInt(3)
    while (spielbrett.getSpieler(zeile, spalte) != Niemand) {
      zeile = Random.nextInt(3)
      spalte = Random.nextInt(3)
    }
    (zeile, spalte)
  }

  def ziehe = {
    spielbrett.naechsterZugAuf(naechsterZug);
  }

  def ich = {
    spielbrett aktuellerSpieler
  }

  def gegner = {
    ich gegner
  }

}