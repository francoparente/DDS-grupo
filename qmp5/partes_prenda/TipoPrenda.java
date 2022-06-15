package partes_prenda;
import partes_prenda.TipoTela;

public interface TipoPrenda {
  boolean puedeSerDeMaterial(TipoTela unaTela);
  Temperature temperaturaLimite();
}
