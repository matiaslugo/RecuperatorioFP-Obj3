import org.scalatest
import org.scalatest.FlatSpec
import scala.util.Try

class tests extends FlatSpec {


  "Test" should "Trasladar" in {
    var circulo = new Circulo(2, 1, 50)

    val nuevaFigura = circulo.trasladar(2, -1, circulo)
    assert(nuevaFigura.posicion.coordx == 4)
    assert(nuevaFigura.posicion.coordy == 0)
  }

  "Test" should "Mover" in {
    var circulo = new Circulo(2, 1, 50)

    val nuevaFigura = circulo.mover(2, -1, circulo)
    assert(nuevaFigura.posicion.coordx == 2)
    assert(nuevaFigura.posicion.coordy == -1)
  }

  "Test" should "EscalarCirculo" in {
    var circulo = new Circulo(2, 1, 50)

    val nuevaFigura = circulo.escalar(2)
    assert(nuevaFigura.radio == 100)

  }

  "Test" should "EscalarRectangulo" in {
    var rectangulo = new Rectangulo(10, 6, 4, 6)

    val nuevaFigura = rectangulo.escalar(0.5)
    assert(nuevaFigura.alto == 5)
    assert(nuevaFigura.ancho == 3)

  }

  "Test" should "MoverX" in {
    var rectangulo = new Rectangulo(5, 4, 3, 4)
    val moverFigura = rectangulo.moverX(2)(-1) _
    val nuevaFigura = moverFigura(rectangulo)
    assert(nuevaFigura.posicion.coordx == 2)
  }

  "Test" should "MoverY" in {
    var segmento = new Segmento(5, 4, 3, 4)
    val moverFigura = segmento.moverY(0)(0) _
    val nuevaFigura = moverFigura(segmento)
    assert(nuevaFigura.posicion.coordy == 0)
  }

  "Test" should "TrasladarXeY" in {
    var segmento = new Segmento(5, 4, 3, 4)
    val moverFigura = segmento.trasladarXeY(2)(0) _
    val nuevaFigura = moverFigura(segmento)
    assert(nuevaFigura.posicion.coordx == 7)
    assert(nuevaFigura.posicion.coordy == 4)

  }

  "Test" should "Duplicar" in {
    var circulo = new Circulo(2, 5, 70)

    val duplicarFigura = circulo.duplicar _
    val nuevaFigura = duplicarFigura(circulo)

    assert(nuevaFigura.radio == 140)

  }

  "Test" should "Cuadruplicar" in {
    var rectangulo = new Rectangulo(2, 5, 7, 0)

    val duplicarFigura = rectangulo.cuadruplicar _
    val nuevaFigura = duplicarFigura(rectangulo)

    assert(nuevaFigura.ancho == 8)
    assert(nuevaFigura.alto == 20)


  }

  def moverAlOrigen (figura: Figura): Figura = {
    figura.mover(0,0,figura)
  }

  def trasladar(coord1:Int,coord2:Int,figura:Figura):Figura = {
    var figuraRes = new Rectangulo(2,2,coord1,coord2)
    figuraRes.cambiarPosicion(figura.posicion)
    figuraRes
  }

  def trasladarXeY(coord1: Int) (coord2: Int) (figura: Figura): Figura = {
    figura.trasladar(coord1,coord2,figura)
  }

  def doble(f:Figura => Figura) (figura: Figura): Figura ={
    val funcion = f.apply(figura)
    val funcion1 = f.apply(funcion)
    funcion1
  }

  "Test" should "DobleTraslacion" in {
    var rectangulo = new Rectangulo(2, 5, 2, 0)
    val dobleTraslacion = doble(trasladarXeY(2)(2) _ ) _
    var nuevaFigura = dobleTraslacion(rectangulo)

    assert(nuevaFigura.posicion.coordx == 6)
    assert(nuevaFigura.posicion.coordy == 4)
  }

  "Test" should "Motor" in {
    val unCirculo = new Circulo(1, 1, 5)
    var motor = new Motor
    motor.agregarFigura(unCirculo)

    assert(motor.figuras.contains(unCirculo))
  }

  "Test" should "Transformar" in {
    val unCirculo = new Circulo(1, 1, 5)
    var motor = new Motor
    motor.agregarFigura(unCirculo)

    motor.transformar(trasladarXeY(2)(2)_)
    motor.figuras.foreach{figura =>
      assert(figura.posicion.coordx == 3)
      assert(figura.posicion.coordy == 3)
    }

    motor.transformar(moverAlOrigen _)
    motor.figuras.foreach{figura =>
      assert(figura.posicion.coordx == 0)
      assert(figura.posicion.coordy == 0)
    }

  }
}