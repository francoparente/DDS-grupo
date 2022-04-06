object macowins {

	var prendas = []
	var ventas = []

	method determinarGanancias(dia) {
		// Implementar control de día
		const ventasDelDia = ventas.filter{ venta => venta.fechaVenta() == dia }
		return ventasDelDia.sum{ venta => venta.precioFinalDeLaVenta() }
	}

	method cobrarVenta(venta) {
		ventas.add(venta)
	}

	method calcularPrecioPrenda(prenda) {
		prenda.calcularPrecio()
	}

}

class Venta {

	const prendasVendidas = []
//date property fechaVenta
	const metodoDePago

	method consultarPrecioDePrendas() = prendasVendidas.sum{ prendaVendida => prendaVendida.calcularPrecio() }
	
	method precioFinalDeLaVenta() = self.consultarPrecioDePrendas() + metodoDePago.aplicarRecargo(self.consultarPrecioDePrendas())

	method cobrarse() {
		macowins.cobrarVenta(self)
	}

	method cantidadVendidas() = prendasVendidas.size()

}

class MetodoDePago {

	method aplicarRecargo(){} // Clase abstracta que cada metodo de pago debe tener

}

class Tarjeta inherits MetodoDePago {

	var property cuotas
	const coeficienteFijo

	method aplicarRecargo(preciosPrendasVendidas) {
		return cuotas * coeficienteFijo + preciosPrendasVendidas * 0.01
	}
}

class Efectivo inherits MetodoDePago {

	method aplicarRecargo(preciosPrendasVendidas){} // EL EFECTIVO MANTIENE EL MISMO PRECIO
}

class Prenda {

	const precioBase
	const tipoDePrenda
	var property estadoPrenda

	method calcularPrecio() {
		return estadoPrenda.calcularPrecio(precioBase)
	}

	method tipoDePrenda() = tipoDePrenda

}

object nueva {

	method calcularPrecio(precioBase) {
		return precioBase
	}

}

class Promocion {

	const valorFijo

	method calcularPrecio(precioBase) {
		return precioBase - valorFijo
	}

}

object liquidacion {

	method calcularPrecio(precioBase) {
		return precioBase * 0.5
	}

}

