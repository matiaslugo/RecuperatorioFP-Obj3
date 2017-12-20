class Segmento(coord1:Int,coord2:Int,coord3:Int,coord4:Int) extends Figura {

  super.setPosicion(coord1,coord2)
  var puntoFinal: Punto = new Punto
  puntoFinal.setCoord(coord3,coord4)

  def cambiarPuntoFinal(punto:Punto): Unit ={
    this.puntoFinal.cambiarCoord(punto.coordx, punto.coordy)
  }

  def trasladar(coord1:Int,coord2:Int,figura:Segmento):Figura = {
    var figuraRes = new Segmento(2,2,coord1,coord2)
    figuraRes.cambiarPosicion(figura.posicion)
    figuraRes.cambiarPuntoFinal(figura.puntoFinal)

    figuraRes
  }

  override def mover(coord1: Int, coord2: Int, figura: Figura): Figura = {
    var figuraRes = new Segmento(2,2,coord1,coord2)
    figuraRes.setPosicion(figura.posicion.coordx,figura.posicion.coordy)
    figuraRes
  }

  def calcularDistancia(): Double = {
    Math.sqrt(Math.pow(this.puntoFinal.coordx - this.posicion.coordx, 2).toInt + Math.pow(this.puntoFinal.coordy - this.posicion.coordy, 2).toInt)
  }

  def cambiarPuntos(proporcion: Double){
    this.puntoFinal.setCoord((Math.sqrt(Math.sqrt(this.calcularDistancia()) - Math.pow(this.puntoFinal.coordy - this.posicion.coordy, 2).toInt) + this.posicion.coordx).toInt,this.puntoFinal.coordy)
  }

  override def escalar(proporcion:Double): Segmento ={
    var figuraRes = new Segmento(2,2,this.posicion.coordx,this.posicion.coordy)
    figuraRes.cambiarPuntos(proporcion)
    figuraRes
  }

  override def duplicar(figura: Figura): Segmento ={
    figura.escalar(2).asInstanceOf[Segmento]
  }

  override def cuadruplicar(figura: Figura): Segmento ={
    figura.escalar(4).asInstanceOf[Segmento]
  }
}
