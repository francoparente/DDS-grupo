package categoria_prenda;

import partes_prenda.TipoPrendaCalzado;
import partes_prenda.TipoPrenda;

public class Calzado implements Categoria {
  public boolean aceptaCategoria(TipoPrenda tipo) {
    return tipo instanceof TipoPrendaCalzado;
  }
}
