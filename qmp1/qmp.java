metodo atuendosDisponibles(unGuardarropa){
    
    List<Prenda> atuendosDisponibles(List<Prenda> unGuardarropa) {
      //guardarropas es una simple lista, no es conciente de las caracteristicas de su contenido
      //Opcion 1
      var partesSuperiores = unGuardarropa.filter(prenda -> prenda.esParteSuperior());
      var partesInferiores = unGuardarropa.filter(prenda -> prenda.esParteInferior());
      var calzados = unGuardarropa.filter(prenda -> prenda.esCalzado());
      var accesorios = unGuardarropa.filter(prenda -> prenda.esAccesorio());
      
      //Opcion 2
      var partesSuperiores = unGuardarropa.filter(prenda -> prenda.es(parteSuperior));
      var partesInferiores = unGuardarropa.filter(prenda -> prenda.es(parteInferior));
      var calzados = unGuardarropa.filter(prenda -> prenda.es(calzado));
      var accesorios = unGuardarropa.filter(prenda -> prenda.es(accesorio));
        var sinAccesorios = permutaciones(partesSuperiores,partesInferiores,calzados,[])
        var conAccesorios = permutaciones(partesSuperiores,partesInferiores,calzados,accesorios)
        return generarAtuendoDisponibles = sinAccesorios.unirListas(conAccesorios) 

        //subclase
        typeof prenda == Calzado
        //atributo
        (en Prenda) (una_categoria)
        this.categoria == una_categoria
        // metodo
        prenda.es(categoria);
  }

  metodo generarAtuendoDisponibles(partesSuperiores,partesInferiores,calzados,accesorios){
    //Combinación de factores no especificados  
    //retorna lista de combinaciones entre las listas de prendas
    
  }s