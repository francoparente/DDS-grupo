package categoria_prenda;

import partes_prenda.TipoPrendaAccesorio;
import partes_prenda.TipoPrenda;

public class Accesorio implements Categoria {
  public boolean aceptaCategoria(TipoPrenda tipo) {
    return tipo instanceof TipoPrendaAccesorio;
  }
}
