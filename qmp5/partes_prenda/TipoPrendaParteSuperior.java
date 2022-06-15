package partes_prenda;

public enum TipoPrendaParteSuperior implements TipoPrenda {
  REMERA_LARGA, CAMISA, REMERA_CORTA, BLUSA;

  @Override
  public boolean puedeSerDeMaterial(TipoTela unaTela) {
    return unaTela != TipoTela.CUERO;
  }
}
