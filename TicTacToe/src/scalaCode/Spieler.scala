package scalaCode;

sealed trait Spieler {
  def istNiemand = false
  def istKreis = false
  def istKreuz = false
  def gegner : Spieler = Niemand
}

object Niemand extends Spieler {
  override def istNiemand = true
}
object Kreuz extends Spieler {
  override def istKreuz = true
  override def gegner = Kreis
}
object Kreis extends Spieler {
  override def istKreis = true
  override def gegner = Kreuz
}

