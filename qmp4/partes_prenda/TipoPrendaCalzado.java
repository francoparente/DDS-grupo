package partes_prenda;

public enum TipoPrendaCalzado implements TipoPrenda {
  ZAPATILLAS, ZAPATOS, BOTAS, OJOTAS;

  @Override
  public boolean puedeSerDeMaterial(TipoTela unaTela) {
    return unaTela != TipoTela.SEDA;
  }
}
