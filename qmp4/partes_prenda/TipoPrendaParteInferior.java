package partes_prenda;

public enum TipoPrendaParteInferior implements TipoPrenda {
  PANTALON_LARGO_VESTIR, PANTALON_CORTO, POLLERA, SHORT_JEAN;

  @Override
  public boolean puedeSerDeMaterial(TipoTela unaTela) {
    return true;
  }
  
  @Override
  public Temperature temperaturaLimite() {
    return calido;
  }
}
/*
prendasquesepuedanusaren(temperatura);

frio(0K,4)
templado(5,18)
calido(19,28)
caluroso(29,+infinito)
*/
public class TipoPrendaParteInferior {

  constructor("pantalon corto",temperatura);
  
  //Interpretamos que la temperatura la ingresa el que crea la prenda.
  tipoPrenda =  to_upper(string);
  int temperaturaLimite;


  int getTemperaturaLimite();
}

interfaceTipoPrenda 
    getTemperaturaLimite();


class RemeraMangasLargas {
  getTemperaturaLimite() {
    return 20;
}

}

frio (0K)
