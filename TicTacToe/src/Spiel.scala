object Spiel {

  def main(args : Array[String]){
    println("Die Eintr�ge:")
    println(Eintrag.KREIS)
    println(Eintrag.LEER)
    println(Eintrag.KREUZ)
    
    println("Ein K�stchen:")
    println("#" + (new Kaestchen gibAus) + "#")
    
    println("Das Spielbrett:")
    println(new Spielbrett gibAus)
  }
}