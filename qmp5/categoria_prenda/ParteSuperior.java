package categoria_prenda;

import partes_prenda.TipoPrendaParteSuperior;
import partes_prenda.TipoPrenda;

public class ParteSuperior implements Categoria {
  public boolean aceptaCategoria(TipoPrenda tipo) {
    return tipo instanceof TipoPrendaParteSuperior;
  }
}
