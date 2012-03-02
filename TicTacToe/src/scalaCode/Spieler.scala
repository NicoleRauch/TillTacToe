package scalaCode;

sealed trait Spieler {
  def istNiemand = false
  def istKreis = false
  def istKreuz = false
}

object Niemand extends Spieler {
  override def istNiemand = true
  override def toString() = ""
}
object Kreuz extends Spieler {
  override def istKreuz = true
  override def toString() = "X"
}
object Kreis extends Spieler {
  override def istKreis = true
  override def toString() = "O" 
}

