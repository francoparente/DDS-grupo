package prenda;

import partes_prenda.Tela;
import categoria_prenda.Categoria;
import partes_prenda.Color;
import partes_prenda.TipoTela;
import partes_prenda.TipoTrama;
import partes_prenda.TipoPrenda;

// BUILDER DE PRENDA
public class BorradorPrenda {
  private TipoPrenda tipo;
  private final Categoria categoria;
  private TipoTela tela;
  private TipoTrama trama;
  private Color colorPrimario;
  private Color colorSecundario;

  BorradorPrenda(Categoria unaCategoria) {
    this.categoria = unaCategoria;
  }

  void colorPrimario(Color unColor) {
    this.colorPrimario = unColor;
  }

  void colorSecundario(Color unColor) {
    this.colorSecundario = unColor;
  }

  void tipoDePrenda(TipoPrenda tipo) {
    if (!categoria.aceptaCategoria(tipo)) {
      throw new RuntimeException("La categoría elegída no es válida para el tipo de prenda");
    }
    this.tipo = tipo;
  }

  void definirTela(TipoTela unaTela) {
    if (!tipo.puedeSerDeMaterial(unaTela)) {
      throw new RuntimeException("Esta prenda no puede ser de ese material");
    }
    this.tela = unaTela;
  }

  void definirTrama(TipoTrama unaTrama) {
    this.trama = unaTrama;
  }

  Prenda build() {
    this.todosLosParametrosEstanCompletos();
    return new Prenda(tipo, categoria, (new Tela(tela, trama)), colorPrimario, colorSecundario);
  }

  void todosLosParametrosEstanCompletos() {
    if (tipo == null) {
      throw new RuntimeException("el tipo de la prenda debe ser especificada");
    }

    if (tela == null) {
      throw new RuntimeException("la tela de la prenda debe ser especificada");
    }

    if (trama == null) {
      this.trama = TipoTrama.LISA;
    }

    if (colorPrimario == null) {
      throw new RuntimeException("El color primario de la prenda debe ser especificado");
    }
  }
}

