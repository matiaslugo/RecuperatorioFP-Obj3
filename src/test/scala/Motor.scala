import scala.collection.mutable.ArrayBuffer

class Motor {

  var figuras: ArrayBuffer[Figura] = new ArrayBuffer[Figura]()

  def agregarFigura(figura: Figura){
    this.figuras.append(figura)
  }

  def getFiguras():Unit={
    this.figuras.foreach{figura =>
      println(figuras)
    }
  }

  def transformar(f:Figura =>Figura): Unit ={
    var resFiguras = new ArrayBuffer[Figura]
    this.figuras.foreach{figura =>
      var nuevaFigura = f(figura)
      resFiguras.append(nuevaFigura)
    }
    this.figuras = resFiguras
  }

}
