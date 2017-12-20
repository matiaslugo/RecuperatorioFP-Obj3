class Figura {

  var posicion: Punto = new Punto

  def setPosicion(coord1: Int, coord2: Int) {
    this.posicion.setCoord(coord1, coord2)
  }

  def cambiarPosicion(punto: Punto) {
    posicion.cambiarCoord(punto.coordx, punto.coordy)
  }

  def trasladar(coord1: Int, coord2: Int, figura: Figura): Figura = {
    figura
  }

  def mover(coord1: Int, coord2: Int, figura: Figura): Figura = {
    figura
  }

  def escalar(proporcion:Double): Figura = {
    this
  }
    def moverX(coord1: Int) (coord2: Int) (figura: Figura): Figura = {
    figura.mover(coord1,figura.posicion.coordy,figura)
  }

  def moverY(coord1: Int) (coord2: Int) (figura: Figura): Figura = {
    figura.mover(figura.posicion.coordx,coord2,figura)
  }

  def trasladarXeY(coord1: Int) (coord2: Int) (figura: Figura): Figura = {
    figura.trasladar(coord1,coord2,figura)
  }

  def duplicar(figura: Figura): Figura = {
    figura
  }

  def cuadruplicar(figura: Figura): Figura = {
    figura
  }

  def doble(figura: Figura): Figura = {
    figura
  }
}