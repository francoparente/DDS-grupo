# TP MACOWINS

## Alumnos

- Aizcorbe Daniel
- Blanco Lucas
- Candia Thomas
- Maqueda Pablo
- Parente Daniel

## Fecha Entrega: 07/04/2022

## **Docente**: Gaston Oscar Prieto

# Requerimientos:

## Funcionales

- Calcular el precio de venta de una prenda.
- Consultar el tipo de cada prenda.
- Registrar ventas.
- Consultar ganancias de un determinado día.
- Las ventas pueden ser cobradas con tarjeta o en efectivo. Si es con tarjeta se le aplica un recargo según la cantidad de cuotas seleccionadas.
- Poder aplicar descuentos al precio de las prendas según su estado (nueva, promoción, liquidación).

- No se encontraron requerimientos no funcionales.

## No funcionales

- No se encontró ningún requerimiento no funcional.

# Diagrama de clases

[![Diagramas-de-Clases-Macowins-Actividad.jpg](https://i.postimg.cc/MH8M66p5/Diagramas-de-Clases-Macowins-Actividad.jpg)](https://postimg.cc/DJBy5Ks4)

# ALCANCE DEL SISTEMA

Como el enunciado no habla de “clientes”, asumimos que la parte “cliente realiza orden de compra, validamos inventario, validamos si se puede pagar, hacemos la venta y realizamos actualización de stock” esta por fuera de nuestro sistema.

## Nuestro sistema

se crea una venta (en algún lado), macowins la registra y luego puede consultar las ganancias de un determinado día.

## **Solución (pseudocódigo)**

### Macowins

```jsx
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
```

### Ventas

```jsx
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
```

### **Estados de las prendas**

Para el primer requerimiento solicitado por el cliente “*calcular el precio de venta de una prenda”:*

La composición fue parte fundamental de nuestra solución, ya que nos permite tener la flexibilidad de que un objeto pueda cambiar su estado (de promoción a liquidación por ejemplo) o si se diera el caso que un nuevo estado surja, sería fácilmente implementable, solamente habría que crear una nueva clase que entienda los mensajes básicos de un “**Estado de Prenda”.**

Al principio pensamos en una clase abstracta y que los 3 estados mencionados en los requerimientos fuesen subclases, pero por simplicidad, solo dejamos a “Promocion” como subclase, ya que los otros no tenían sentido como clases porque no se necesitaba instanciar más de una vez. En el diagrama los dejamos indicados como subclases porque nos pareció semánticamente más claro así.

```jsx
class EstadoClase{
	method calcularPrecio(precioBase);
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
```

### **Método de pago**

Al igual que en los estados de las prendas, nos pareció mejor diagramarlo como subclases por simple semántica, pero implementar “efectivo” como objeto y “Tarjeta” como clase para mayor flexibilidad.

```jsx
class MetodoDePago {

	method aplicarRecargo(){}

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
```

### **Prenda**

El cliente solicitó poder “*consultar el tipo de cada prenda”* para lo cual simplemente añadimos un getter() a un *string constante (tipoDePrenda)*

```jsx
class Prenda {

	const precioBase
	const tipoDePrenda
	var estadoPrenda

	method calcularPrecio() {
		return estadoPrenda.calcularPrecio(precioBase)
	}

	method tipoDePrenda() = tipoDePrenda;

}
```