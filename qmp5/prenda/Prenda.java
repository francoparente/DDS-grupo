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
  private EstadoPrenda estado;
  private int vecesUsada;
  private boolean estaSiendoLavada;

  public Prenda(TipoPrenda tipo, Categoria categoria, Tela tela, Color colorPrimario,
      Color colorSecundario) {
    this.tipo = tipo;
    this.categoria = categoria;
    this.tela = tela;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = colorSecundario;
    this.estado = new Limpia();
  }

  Categoria getCategoria() {
    return categoria;
  }

  TipoPrenda getTipo() {
    return tipo;
  }

  boolean esDeCategoria(Categoria categoria) {
    return this.categoria == categoria;
  }

  void usarseEnAtuendo() {
    vecesUsada++;
    estado.verificarEstado(this);
  }

  int vecesUsada() {
    return vecesUsada;
  }

  void setEstado(EstadoPrenda estado) {
    this.estado = estado;
  }

  boolean puedeUsarse() {
    return estado.puedeSerUsada();
  }

  void reiniciarVecesUsada() {
    this.vecesUsada = 0;
  }

  void lavar() { // Preguntar sobre las percudidas, se pueden lavar?
    if (estaSiendoLavada) {
      throw new RuntimeException("Esta prenda ya esta siendo lavada");
    }
    this.ponerseALavar();
    this.setEstado(new Limpia());
    this.reiniciarVecesUsada();
  }

  // Preguntar cuando deja de lavarse y pasa a limpia
  void ponerseALavar() {
    this.estaSiendoLavada = true;
  }

  boolean esSugerible() {
    return this.puedeUsarse() && !this.estaSiendoLavada;
  }
  Temperature temperaturaLimite(){
    return tipo.temperaturaLimite();
  }
  boolean esAdecuadaParaClimaActual(Clima unClima){
    return unClima.temperature() < this.temperaturaLimite();
  }
}
