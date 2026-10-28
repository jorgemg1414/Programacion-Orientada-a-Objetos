# Caso integrador: Hotel Nodora

Explicación del código para que todo el equipo lo pueda defender.

- **Equipo:** De Anda Gomez Santiago, Martin Gomez Jorge, Martin Valencia Oscar Jesus, Yanez Sanchez Eduardo
- **Entrega:** 30-10-2026, 10:00 en Classroom (proyecto comprimido + `.jar`)
- **Código:** `Hotel_Nodora/src/main/java/com/mycompany/hotel_nodora/` en la raíz del repo
- **Entregables:** `Hotel_Nodora/Entregables/` (3 diagramas en PNG, `Hotel_Nodora.jar` y `Hotel_Nodora.zip`)

## Cómo correrlo

- En NetBeans: abrir el proyecto `Hotel_Nodora` y darle **Run**.
- Desde la terminal, en la raíz del repo:

```bash
java -jar Hotel_Nodora/Entregables/Hotel_Nodora.jar
```

El programa arranca con estos datos de ejemplo (se crean en `cargarDatosDeEjemplo`, `Hotel_Nodora.java` línea 75):

| Qué | Datos |
| --- | --- |
| Cuartos | 101-103 Simple ($800), 201-203 Doble ($1500), 301-303 Matrimonial ($1200) |
| Socios | Ana Lopez Ruiz `LORA900514MJCPZN03` y Carlos Ramirez Torres `RATC851102HJCMRRA5` |
| Reservaciones | 101 Ana (28/10/2026, 5 noches), 201 Luis, esporádico (10/11/2026, 3 noches), 302 Carlos (15/11/2026, 2 noches) |
| Ganancias que debe dar | Octubre 2026: $2160.00 · Noviembre 2026: $8100.00 |

## 1. La idea general: 3 capas

| Capa | Clases | Qué hace |
| --- | --- | --- |
| Los menús | `Hotel_Nodora` | Platica con el usuario: muestra menús, lee con `Scanner` y valida lo que teclean. **No calcula nada.** |
| El cerebro | `Hotel` | Guarda todos los datos (cuartos, socios, reservaciones) y tiene un método por cada operación del enunciado. |
| Las "cosas" | `Cuarto` y sus 3 hijas, `Cliente` y sus 2 hijas, `Reservacion` | Representan lo que existe en el hotel. |

La frase clave para la defensa: **los menús solo piden datos y le piden al hotel que haga el trabajo.** Por ejemplo, la opción 1 del recepcionista:

```java
case 1: {
    String tipo=elegirTipo();
    hotel.listarDisponibles(tipo);
    break;
}
```

El menú pregunta el tipo y el hotel hace la búsqueda. El programa arranca en `main` (`Hotel_Nodora.java` línea 24): crea el `Hotel`, le carga los datos de ejemplo y muestra el menú principal con `do-while` + `switch`, igual que HotelApp. Cada rol (recepcionista, administrador y cliente) tiene su propio menú hecho de la misma forma.

## 2. Los 4 pilares de POO

**Abstracción.** `Cuarto` (`Cuarto.java` línea 22) y `Cliente` (`Cliente.java` línea 21) son `abstract`: no se puede hacer `new Cuarto(...)`. Declaran métodos sin cuerpo (`getTipo()`, `getCapacidad()`, `dibujar()`…) que dicen *qué* debe saber hacer todo cuarto, pero no *cómo*. Es lo mismo que `FigurasGeometricas` con `dibujar()`, `area()` y `perimetro()`.

**Herencia.** `CuartoSimple extends Cuarto` y le manda el número y el precio al padre con `super(numero,precio)`. `ClienteHabitual extends Cliente` usa `super(curp,nombre)`. En `ClienteHabitual.java` línea 48, `super.mostrarInfo()` reutiliza la versión del padre y solo agrega el teléfono y el descuento.

**Encapsulamiento.** Los atributos son `private`; los de los padres son `protected` para que las hijas los usen. `Reservacion` solo tiene getters y ningún setter: una reservación no se puede modificar desde fuera, solo crear o eliminar.

**Polimorfismo.** El hotel guarda todos los cuartos en un solo `ArrayList<Cuarto>`; al hacer `c.getTipo()` o `c.dibujar()`, cada objeto ejecuta **su** versión. El mejor ejemplo es `aplicarDescuento` (`Cliente.java` línea 40):

```java
public double aplicarDescuento(double precio){
    return precio-precio*getDescuento()/100;
}
```

Se escribió una sola vez en el padre, pero `getDescuento()` regresa 10 si el objeto es `ClienteHabitual` y 0 si es `ClienteEsporadico`, sin ningún `if` que pregunte qué tipo de cliente es.

> [!TIP] Sobrecarga contra sobrescritura
> - **Sobrescritura:** `getTipo()` en cada hija, con el mismo nombre y los mismos parámetros que el padre, y `@Override`.
> - **Sobrecarga:** `leerEntero(mensaje)` y `leerEntero(mensaje, min, max)` (`Hotel_Nodora.java` líneas 362 y 380): mismo nombre, diferentes parámetros.

## 3. Lo que más nos pueden preguntar

### El precio de los cuartos

Cada cuarto guarda su precio en el atributo `precio` (`Cuarto.java` línea 26), igual que `precioPorNoche` en HotelApp. Todos los cuartos del mismo tipo empiezan con el mismo precio en `cargarDatosDeEjemplo`.

Para cambiar el precio de un tipo, `cambiarPrecioDelTipo` (`Hotel.java` línea 107) recorre todos los cuartos y le cambia el precio a cada uno que sea de ese tipo:

```java
for(Cuarto c : cuartos){
    if(c.getTipo().equals(tipo)){
        c.setPrecio(nuevoPrecio);
    }
}
```

Para preguntar el precio de un tipo, `getPrecioDelTipo` (línea 96) regresa el del primer cuarto de ese tipo, porque todos cuestan lo mismo.

### El descuento es `static`

```java
private static int porcentajeDescuento=10;   //en ClienteHabitual
```

Está en `ClienteHabitual.java` línea 25. El descuento es el mismo para todos los socios, por eso es `static`: todos los objetos `ClienteHabitual` comparten esa misma variable, y cuando el administrador la cambia, cambia para todos. Se consulta sin necesidad de un objeto: `ClienteHabitual.getPorcentajeDescuento()`.

### El diccionario (HashMap)

```java
private HashMap<String, Cliente> clientesHabituales=new HashMap<>();
```

Está en `Hotel.java` línea 30. La clave es la CURP y el valor es el cliente con sus datos. Se usan 4 métodos:

- `put` para registrar,
- `get` para buscar (regresa `null` si no es socio),
- `containsKey` para no registrar dos veces la misma CURP,
- `values()` para recorrer a todos los socios.

¿Por qué no un ArrayList? Porque con la CURP se encuentra al cliente directo, sin el `for` que usamos en E_ArrayListClase para buscar un correo. Además, el enunciado lo pide así.

### Socio o esporádico

"Registrarse como cliente" quiere decir hacerse socio (cliente habitual). Al reservar, `hacerReservacion` (`Hotel_Nodora.java` línea 296) busca la CURP en el diccionario:

- si está, el cliente es un `ClienteHabitual` y tiene descuento;
- si no está, se le pide el nombre y se crea un `ClienteEsporadico`, sin descuento.

Los dos quedan en una variable de tipo `Cliente`, que otra vez es polimorfismo.

### Disponible = sin reservación

`estaDisponible` (`Hotel.java` línea 61) solo revisa si ese cuarto tiene una reservación. Cada cuarto tiene como máximo una, y por eso el recepcionista puede eliminar una reserva solo con el número de cuarto.

### El precio se congela al reservar

En el constructor de `Reservacion` (`Reservacion.java` línea 40) se guarda el precio por noche ya con descuento:

```java
this.precioPorNoche=cliente.aplicarDescuento(cuarto.getPrecio());
```

Si después el administrador cambia el precio o el descuento, las reservaciones que ya existían no cambian, igual que en un hotel real.

### Ganancias de un mes (meses de 30 días)

`nochesEnMes` (`Reservacion.java` línea 55) recorre la reservación noche por noche con un `for`, como si se fueran pasando las hojas de un calendario donde todos los meses tienen 30 días:

- si la noche cae en el mes que se pide, se cuenta;
- luego se pasa al día siguiente (`d++`); si pasa del día 30, se va al día 1 del mes siguiente, y si pasa del mes 12, a enero del año siguiente.

Con la reservación de Ana (llega el 28/10, 5 noches):

| Noche | Fecha | ¿Cuenta en octubre? | ¿Cuenta en noviembre? |
| --- | --- | --- | --- |
| 1 | 28/10 | sí | no |
| 2 | 29/10 | sí | no |
| 3 | 30/10 | sí | no |
| 4 | 1/11 | no | sí |
| 5 | 2/11 | no | sí |

Octubre cuenta **3 noches** y noviembre **2**. Luego `calcularGanancias` (`Hotel.java` línea 246) suma `noches × precioPorNoche` de cada reservación. Noviembre: 2×720 + 3×1500 + 2×1080 = **$8100**.

### Agregar tipos nuevos (extensibilidad)

Para agregar una Suite:

1. crear `class Suite extends Cuarto` con `getTipo()`, `getCapacidad()` y `dibujar()`;
2. agregar la opción `4. Suite` en `elegirTipo` (`Hotel_Nodora.java` línea 340);
3. agregar sus cuartos en `cargarDatosDeEjemplo`, por ejemplo `hotel.agregarCuarto(new Suite(401, 3000));`.

El resto del programa funciona igual, porque todo trabaja con variables de tipo `Cuarto`. Esa es la extensibilidad que pide el enunciado:

- un tipo de cliente nuevo (por ejemplo VIP) es una hija de `Cliente` con su propio `getDescuento()`;
- una consulta nueva es un método en `Hotel` más una opción en el menú.

### Que el programa no truene

- `leerEntero` (`Hotel_Nodora.java` línea 362) lee la línea completa con `nextLine` y la convierte con `Integer.parseInt` dentro de un `try/catch`, como en Ejercicio1. Si tecleas letras se lanza `NumberFormatException` y lo vuelve a pedir. En FigurasGeometricas usamos `nextInt`, que deja el salto de línea pendiente.
- `leerCurp` (línea 393) vuelve a pedir la CURP hasta que tenga 18 caracteres, y la pasa a mayúsculas con `toUpperCase()` para aceptarla aunque la escriban en minúsculas.

## 4. Una reservación de principio a fin

Cuando el recepcionista elige la opción 6 (`Hotel_Nodora.java` línea 150):

1. Muestra los cuartos libres y pide el número.
2. `buscarCuarto` regresa `null` si el cuarto no existe y `estaDisponible` regresa `false` si está ocupado.
3. Pide la CURP y la busca en el diccionario para saber si es socio o esporádico.
4. Pide los huéspedes con máximo `cuarto.getCapacidad()`: 1, 4 o 2 según el tipo (polimorfismo).
5. Pide la fecha de llegada y las noches.
6. Crea el `new Reservacion(...)`, cuyo constructor congela el precio, y `agregarReservacion` (`Hotel.java` línea 194) la guarda en la lista.
7. Muestra la reservación con su total.

Es exactamente el diagrama de actividades, así que se puede explicar con el diagrama en pantalla.

## 5. Preguntas probables

| Pregunta | Respuesta corta |
| --- | --- |
| ¿Por qué `Cuarto` es abstracta? | No existe un "cuarto genérico": todo cuarto es simple, doble o matrimonial, y cada uno tiene que decir su tipo, capacidad y dibujo. |
| ¿Dónde está el polimorfismo? | En `ArrayList<Cuarto>` con `getTipo()` y `dibujar()`, y en `aplicarDescuento()` con `getDescuento()`. |
| ¿Por qué el descuento es `static`? | Porque es el mismo para todos los socios: se cambia una vez y aplica a todos. |
| ¿Cómo cambia el precio de un tipo? | Con un `for` que le cambia el precio a cada cuarto de ese tipo. |
| ¿Por qué un HashMap? | Para encontrar al socio directo por su CURP. |
| ¿Qué pasa si cambian el precio después de reservar? | Nada: la reservación guarda el precio con el que se hizo. |
| ¿Qué pasa si tecleo letras? | El `try/catch` atrapa `NumberFormatException` y lo vuelve a pedir. |
| ¿Por qué se borran los datos al cerrar? | Se guardan en memoria (ArrayList y HashMap); todavía no vimos archivos. |
| ¿Cómo se ejecuta el `.jar`? | Con `java -jar Hotel_Nodora.jar`. En el `pom.xml` se configuró la clase principal y Java 17. |

## 6. Cómo repartir la defensa

- **Uno:** las clases de cuartos y clientes (abstracción, herencia y el descuento `static`).
- **Otro:** la clase `Hotel` (HashMap, disponibilidad, precios y ganancias del mes).
- **Otro:** los menús y la validación de datos (`do-while`, `switch`, `try/catch`, CURP).
- **Otro:** los diagramas de clases, casos de uso y actividades.

## 7. Para practicar

Intenten contestar antes de abrir la respuesta.

**1.** Si el administrador sube los cuartos Doble a $2000, ¿cuánto paga por noche Luis (cuarto 201, ya reservado)? ¿Y cuánto pagaría un cliente esporádico que reserve el 202 después?

<details>
<summary>Respuesta</summary>

Luis sigue pagando $1500 por noche, porque su reservación guardó el precio al momento de reservar. El cliente esporádico que reserva después paga $2000 por noche. Si fuera socio, pagaría $1800 por el 10% de descuento.

</details>

**2.** Si alguien llega el 29/12/2026 y se queda 4 noches, ¿cuántas noches cuentan para diciembre y cuántas para enero?

<details>
<summary>Respuesta</summary>

2 y 2. Duerme el 29 y el 30 de diciembre (diciembre tiene 30 días en este programa) y el 1 y el 2 de enero de 2027.

</details>

**3.** ¿Por qué `hotel.dibujarTipo("Doble")` dibuja dos camas sin que haya ningún `if` que pregunte qué dibujo usar?

<details>
<summary>Respuesta</summary>

`dibujarTipo` recorre la lista y se queda con el primer cuarto cuyo tipo es `"Doble"`. Ese objeto es un `CuartoDoble` guardado en una variable de tipo `Cuarto`. Al llamar `dibujar()` se ejecuta la versión de `CuartoDoble`, porque Java usa la versión del objeto real y no la del tipo de la variable. Eso es polimorfismo.

</details>
