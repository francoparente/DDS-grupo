package prenda;

import partes_prenda.Tela;
import categoria_prenda.Categoria;
import partes_prenda.Color;
import partes_prenda.TipoPrenda;


public class Prenda {
  private final TipoPrenda tipo;
  private final Categoria categoria;
  private final Tela tela;
  private final Color colorPrimario;
  private final Color colorSecundario;

  public Prenda(TipoPrenda tipo, Categoria categoria, Tela tela, Color colorPrimario, Color colorSecundario) {
    this.tipo = tipo;
    this.categoria = categoria;
    this.tela = tela;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = colorSecundario;
  }

  Categoria getCategoria() {
    return categoria;
  }

  TipoPrenda getTipo() {
    return tipo;
  }
}
