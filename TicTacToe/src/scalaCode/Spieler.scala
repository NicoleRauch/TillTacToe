package scalaCode;

sealed trait Spieler {
  def istNiemand = false
  def istKreis = false
  def istKreuz = false
}

object Niemand extends Spieler {
  override def istNiemand = true
}
object Kreuz extends Spieler {
  override def istKreuz = true
}
object Kreis extends Spieler {
  override def istKreis = true
}

