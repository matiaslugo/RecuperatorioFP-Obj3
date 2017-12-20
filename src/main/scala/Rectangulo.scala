class Rectangulo(nuevoAncho:Int,nuevoAlto:Int,coord1:Int,coord2:Int) extends Figura {

  super.setPosicion(coord1,coord2)
  var ancho:Double = nuevoAncho
  var alto:Double = nuevoAlto

  override def trasladar(coord1:Int,coord2:Int,figura:Figura):Figura = {
    var figuraRes = new Rectangulo(2,2,coord1,coord2)
    figuraRes.cambiarPosicion(figura.posicion)
    figuraRes
  }

  override def mover(coord1: Int, coord2: Int, figura: Figura): Figura = {
    var figuraRes = new Rectangulo(2,2,coord1,coord2)
    figuraRes
  }
  def cambiarAltoYAncho(proporcion: Double): Unit ={
    this.alto = proporcion * this.alto
    this.ancho = proporcion * this.ancho
  }

  override def escalar(proporcion:Double): Rectangulo ={
    var figuraRes = new Rectangulo(2,2,this.posicion.coordx,this.posicion.coordy)
    figuraRes.cambiarAltoYAncho(proporcion)
    figuraRes
  }

  override def duplicar(figura: Figura): Rectangulo ={
    figura.escalar(2).asInstanceOf[Rectangulo]
  }

  override def cuadruplicar(figura: Figura): Rectangulo ={
    figura.escalar(4).asInstanceOf[Rectangulo]
  }


}
