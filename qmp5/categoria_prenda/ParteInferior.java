package categoria_prenda;

import partes_prenda.TipoPrendaParteInferior;
import partes_prenda.TipoPrenda;

public class ParteInferior implements Categoria {
  public boolean aceptaCategoria(TipoPrenda tipo) {
    return tipo instanceof TipoPrendaParteInferior;
  }
}
