class Punto {

  var coordx: Int = 0
  var coordy: Int = 0

  def setCoord(c1: Int, c2: Int) {
    this.coordx = c1
    this.coordy = c2
  }

  def cambiarCoord(c1: Int, c2: Int) {
    this.coordx = c1 + this.coordx
    this.coordy = c2 + this.coordy
  }

}