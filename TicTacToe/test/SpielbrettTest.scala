import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scalaCode.Spielbrett
import scalaCode.Niemand
import scalaCode.Kreis
import scalaCode.Kreuz


@RunWith(classOf[JUnitRunner])
class SpielbrettTest extends FunSuite {

  test("Auf einem leeren Spielbrett hat keiner gewonnen") {
    val brett = new Spielbrett
    assert(brett.sindAlleFelderBelegt == false)
    assert(brett.werHatGewonnen == Niemand)
  }

  test("X gewinnt in der ersten Spalte") {
    val brett = new Spielbrett
    brett.naechsterZugAufFeld(0,0)
    brett.naechsterZugAufFeld(0,1)
    brett.naechsterZugAufFeld(1,0)
    brett.naechsterZugAufFeld(0,2)
    brett.naechsterZugAufFeld(2,0)
    assert(brett.sindAlleFelderBelegt == false)
    assert(brett.werHatGewonnen == Kreuz)
  }
  
  test("X gewinnt in der zweiten Spalte") {
	  val brett = new Spielbrett
	  brett.naechsterZugAufFeld(0,1)
	  brett.naechsterZugAufFeld(0,2)
	  brett.naechsterZugAufFeld(1,1)
	  brett.naechsterZugAufFeld(1,2)
	  brett.naechsterZugAufFeld(2,1)
	  assert(brett.sindAlleFelderBelegt == false)
	  assert(brett.werHatGewonnen == Kreuz)
  }

  test("X gewinnt in der dritten Spalte") {
	  val brett = new Spielbrett
	  brett.naechsterZugAufFeld(0,2)
	  brett.naechsterZugAufFeld(0,0)
	  brett.naechsterZugAufFeld(1,2)
	  brett.naechsterZugAufFeld(1,0)
	  brett.naechsterZugAufFeld(2,2)
	  assert(brett.sindAlleFelderBelegt == false)
	  assert(brett.werHatGewonnen == Kreuz)
  }

  test("O gewinnt in der ersten Zeile") {
    val brett = new Spielbrett
    brett.naechsterZugAufFeld(1,0)
    brett.naechsterZugAufFeld(0,0)
    brett.naechsterZugAufFeld(1,1)
    brett.naechsterZugAufFeld(0,1)
    brett.naechsterZugAufFeld(2,0)
    brett.naechsterZugAufFeld(0,2)
    assert(brett.sindAlleFelderBelegt == false)
    assert(brett.werHatGewonnen == Kreis)
  }
  
  test("O gewinnt in der zweiten Zeile") {
	  val brett = new Spielbrett
	  brett.naechsterZugAufFeld(0,0)
	  brett.naechsterZugAufFeld(1,0)
	  brett.naechsterZugAufFeld(0,2)
	  brett.naechsterZugAufFeld(1,1)
	  brett.naechsterZugAufFeld(2,2)
	  brett.naechsterZugAufFeld(1,2)
	  assert(brett.sindAlleFelderBelegt == false)
	  assert(brett.werHatGewonnen == Kreis)
  }

  test("O gewinnt in der dritten Zeile") {
	  val brett = new Spielbrett
	  brett.naechsterZugAufFeld(1,1)
	  brett.naechsterZugAufFeld(2,0)
	  brett.naechsterZugAufFeld(0,0)
	  brett.naechsterZugAufFeld(2,1)
	  brett.naechsterZugAufFeld(1,0)
	  brett.naechsterZugAufFeld(2,2)
	  assert(brett.sindAlleFelderBelegt == false)
	  assert(brett.werHatGewonnen == Kreis)
  }

  test("Das Spiel endet unentschieden") {
	  val brett = new Spielbrett
	  brett.naechsterZugAufFeld(1,1)
	  brett.naechsterZugAufFeld(2,0)	  
	  brett.naechsterZugAufFeld(0,1)
	  brett.naechsterZugAufFeld(2,1)
	  brett.naechsterZugAufFeld(2,2)
	  brett.naechsterZugAufFeld(0,0)
	  brett.naechsterZugAufFeld(1,0)
	  brett.naechsterZugAufFeld(1,2)
	  brett.naechsterZugAufFeld(0,2)
	  assert(brett.sindAlleFelderBelegt == true)
	  assert(brett.werHatGewonnen == Niemand)
  }
}