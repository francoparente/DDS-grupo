object macowins {

	var ventas = [];

	method determinarGananciasDeUnDia(unDia) {
		const ventasDelDia = ventas.filter{ venta => fueVendidoElDia(venta,unDia)};
		return ventasDelDia.sum{ venta => venta.precioFinalDeLaVenta()};
	}

	method registrarVenta(unaVenta) {
		ventas.add(unaVenta);
	}
}

class Venta {

	const prendasVendidas = [unasPrendas];
	const fechaVenta = new Date();
	const metodoDePago = unMetodo;

	method consultarPrecioDePrendas() { 
		return prendasVendidas.sum{ prendaVendida => prendaVendida.calcularPrecio()}
}
	
	method precioFinalDeLaVenta() = self.consultarPrecioDePrendas() + metodoDePago.aplicarRecargo(self.consultarPrecioDePrendas())

	method cantidadVendidas() = rendasVendidas.size()

}

class EstadoClase{
	method calcularPrecio(precioBase);    // NO HACE FALTA CLASE ABSTRACTA, SE PUEDE UTILIZAR POLIMORFISMO
}

object nueva {

	method calcularPrecio(precioBase) {
		return precioBase;
	}

}

class Promocion inherits EstadoPrenda{

	const valorFijo;

	method calcularPrecio(precioBase) {
		return precioBase - valorFijo;
	}

}

object liquidacion {

	method calcularPrecio(precioBase) {
		return precioBase * 0.5;
	}
}

class MetodoDePago {

	method aplicarRecargo(){}	// NO HACE FALTA CLASE ABSTRACTA, SE PUEDE UTILIZAR POLIMORFISMO CON LA INTERFAZ

}

class Tarjeta inherits MetodoDePago {

	var property cuotas
	const coeficienteFijo

	method aplicarRecargo(preciosPrendasVendidas) {
		return cuotas * coeficienteFijo + preciosPrendasVendidas * 0.01
	}
}

object efectivo {

		method aplicarRecargo(preciosPrendasVendidas){ 
			return preciosPrendasVendidas;
	}
}

class Prenda {

	const precioBase
	const tipoDePrenda
	var estadoPrenda

	method calcularPrecio() {
		return estadoPrenda.calcularPrecio(precioBase)
	}

	method tipoDePrenda() = tipoDePrenda;

}
