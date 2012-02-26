object Spiel {

  def main(args : Array[String]){
    println("Die Einträge:")
    println(Spieler.KREIS)
    println(Spieler.LEER)
    println(Spieler.KREUZ)
    
    println("Ein Kästchen:")
    println("#" + new Kaestchen + "#")
    
    println("Das Spielbrett:")
    println(new Spielbrett)
    
    new GrafikSpielfeld();
  }
}