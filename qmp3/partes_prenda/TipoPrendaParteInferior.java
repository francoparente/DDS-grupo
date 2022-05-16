package partes_prenda;

public enum TipoPrendaParteInferior implements TipoPrenda {
  PANTALON_LARGO, PANTALON_CORTO, POLLERA, JEAN;

  @Override
  public boolean puedeSerDeMaterial(TipoTela unaTela) {
    return true;
  }

}
