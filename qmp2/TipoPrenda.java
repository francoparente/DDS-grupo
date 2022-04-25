class TipoPrenda{
    
   Categoria categoria

   constructor(Categoria categoria)
      this.categoria = categoria

   method categoria() 
      return this.categoria

    constant ZAPATO = new TipoPrenda(CALZADO)
    constant REMERA = new TipoPrenda(PARTE_SUPERIOR)
    constant PANTALON = new TipoPrenda(PARTE_INFERIOR)
    // (...)
}