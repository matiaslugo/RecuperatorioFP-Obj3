import scala.collection.mutable.ArrayBuffer

class Motor {
  var figuras: ArrayBuffer[Figura] = new ArrayBuffer[Figura]()
  var ultimaTransf = new Figura().doble _

  def agregarFigura(figura: Figura){
    this.figuras.append(figura)
  }

  def getFiguras():Unit={
    this.figuras.foreach{figura =>
      println(figura.getClass,figura.posicion.coordx,figura.posicion.coordy)
    }
  }

  def getEstadoAnterior(): Unit ={
      println(this.figuras.last.getClass(),this.figuras.last.estadoAnterior.posicion.coordx,this.figuras.last.estadoAnterior.posicion.coordy)
    }

  def getEstados(): Unit ={
    this.figuras.foreach{ figura =>
      println(figura.estadoAnterior.getClass,figura.estadoAnterior.posicion.coordx,figura.estadoAnterior.posicion.coordy,
        figura.getClass,figura.posicion.coordx,figura.posicion.coordy)
    }
  }

  def transformar(f:Figura =>Figura): Unit ={
    var resFiguras = new ArrayBuffer[Figura]
    this.figuras.foreach{figura =>
      var nuevaFigura = f(figura)
      nuevaFigura.guardarEstadoAnterior(figura)
      resFiguras.append(nuevaFigura)
    }
    this.ultimaTransf = f
    this.figuras = resFiguras
  }

  def volverAlEstadoAnterior(): Unit ={
    var figurasAnteriores = new ArrayBuffer[Figura]
    this.figuras.foreach{figura =>
      figurasAnteriores.append(figura.estadoAnterior)
    }
    this.figuras = figurasAnteriores
  }

  def rollback(n:Int): Unit ={
    for(i <- 1 to n){
      this.volverAlEstadoAnterior()
    }
  }

  def repetir(): Unit ={
    transformar(this.ultimaTransf)
  }
}
