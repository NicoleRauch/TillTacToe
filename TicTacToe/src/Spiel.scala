object Spiel {

  def main(args : Array[String]){
    println("Die Einträge:")
    println(Eintrag.KREIS)
    println(Eintrag.LEER)
    println(Eintrag.KREUZ)
    
    println("Ein Kästchen:")
    println("#" + (new Kaestchen gibAus) + "#")
    
    println("Das Spielbrett:")
    println(new Spielbrett gibAus)
  }
}