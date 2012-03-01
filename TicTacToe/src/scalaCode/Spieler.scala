package scalaCode;

sealed trait Spieler

object Niemand extends Spieler {
  override def toString() = ""
}
object Kreuz extends Spieler {
  override def toString() = "X"
}
object Kreis extends Spieler {
  override def toString() = "O" 
}

