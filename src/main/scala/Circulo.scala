class Circulo(coord1: Int,coord2: Int,nuevoRadio:Int) extends Figura{

  super.setPosicion(coord1,coord2)
  var radio: Int = nuevoRadio

  override def trasladar(coord1:Int,coord2:Int,figura:Figura):Figura = {
    var figuraRes = new Circulo(coord1,coord2,50)
    figuraRes.cambiarPosicion(figura.posicion)
    figuraRes
  }

  override def mover(coord1: Int, coord2: Int, figura: Figura): Figura = {
    var figuraRes = new Circulo(coord1,coord2,50)
    figuraRes
  }

  def cambiarRadio(proporcion:Double): Unit ={
    this.radio = this.radio * 2
  }

  override def escalar(proporcion:Double): Circulo ={
    var figuraRes = new Circulo(0,0,50)
    figuraRes.cambiarRadio(proporcion)
    figuraRes
  }

  override def duplicar(figura: Figura): Circulo ={
    figura.escalar(2).asInstanceOf[Circulo]
  }

  override def cuadruplicar(figura: Figura): Circulo ={
    figura.escalar(4).asInstanceOf[Circulo]
  }
}
