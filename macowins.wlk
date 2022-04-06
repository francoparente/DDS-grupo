object macowins {

	var prendas = []
	var ventas = []

	method determinarGanancias(dia) {
		// Implementación
		// ...
		const ventasDelDia = ventas.filter{ venta => venta.fechaVenta() == dia }
		return ventasDelDia.sum()
	}

}

class Venta {

	var prendasVendidas = []
//date property fechaVenta
	var metodoDePago

	method cobrarse(precio) = metodoDePago.cobrarse(precio, prendasVendidas)

	method cantidadVendidas() = prendasVendidas.size()

}

class MetodoDePago {

	method cobrarse(precio, prendasVendidas) {
		return prendasVendidas.sum()
	}

}

class Tarjeta inherits MetodoDePago {

	var property cuotas
	const coeficienteFijo

	method aplicarRecargo(prendasVendidas) {
		return cuotas * coeficienteFijo + prendasVendidas * 0.01
	}

	override method cobrarse(precio, prendasVendidas) {
		return super(precio,prendasVendidas) + self.aplicarRecargo(prendasVendidas)
	}

}

class Efectivo inherits MetodoDePago {

}

class Prenda {

	const precioBase
	var property tipoDePrenda
	var property estadoPrenda

	method calcularPrecio() {
		return estadoPrenda.calcularPrecio(precioBase)
	}

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

