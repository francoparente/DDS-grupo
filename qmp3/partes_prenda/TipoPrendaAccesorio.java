package partes_prenda;

public enum TipoPrendaAccesorio implements TipoPrenda {
  PULSERA, RELOJ, COLLAR, ARETES;

  @Override
  public boolean puedeSerDeMaterial(TipoTela unaTela) {
    return unaTela != TipoTela.JEAN;
  }
}
