object Spiel {

  def main(args : Array[String]){
    println("Die Eintr�ge:")
    println(Spieler.KREIS)
    println(Spieler.LEER)
    println(Spieler.KREUZ)
    
    println("Ein K�stchen:")
    println("#" + new Kaestchen + "#")
    
    println("Das Spielbrett:")
    println(new Spielbrett)
    
    new GrafikSpielfeld();
  }
}