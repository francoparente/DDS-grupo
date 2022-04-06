object macowins {

	var prendas = []
	var ventas = []

	method determinarGanancias(dia) {
		// Implementar control de día
		const ventasDelDia = ventas.filter{ venta => venta.fechaVenta() == dia }
		return ventasDelDia.sum{ venta => venta.consultarVenta() }
	}

	method cobrarVenta(venta) {
		ventas.add(venta)
	}

	method calcularPrecioPrenda(prenda) {
		prenda.calcularPrecio()
	}

}

class Venta {

	var prendasVendidas = []
//date property fechaVenta
	const metodoDePago

	method consultarVenta() {
		metodoDePago.consultarVenta()
	}

	method cobrarse() {
		macowins.cobrarVenta(self)
	}

	method cantidadVendidas() = prendasVendidas.size()

}

class MetodoDePago {

	method consultarVenta(prendasVendidas) {
		return prendasVendidas.sum{ prendaVendida => prendaVendida.calcularPrecio() }
	}

}

class Tarjeta inherits MetodoDePago {

	var property cuotas
	const coeficienteFijo

	method aplicarRecargo(prendasVendidas) {
		return cuotas * coeficienteFijo + prendasVendidas * 0.01
	}

	override method consultarVenta(prendasVendidas) {
		return super(prendasVendidas) + self.aplicarRecargo(prendasVendidas)
	}

}

class Efectivo inherits MetodoDePago {

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

