TPC I : MacoWins

Lautaro Moyano - K3053

Parte I: Identificación de requerimientos

En base a la información provista durante la charla, se identifica la necesidad de algún tipo de aplicación que provea las siguientes funcionalidades:

- Que el usuario (el vendedor, entendería) pueda consultar por una prenda, y conocer su clasificación y su precio.
- Las prendas deberían de tener un identificador (para poder buscarlas)
   - Este último es definido en base a un “estado” en el que se encuentra la prenda. El usuario debería poder tener control estos mismos (“...Promoción: Le resta un valor fijo decidido por el usuario.”)
   - No se menciona si el usuario debería tener control sobre el agregado o quitado de prendas al sistema, ni la definición del precio base. El control de stock tampoco parece ser relevante.
- Tener un registro de las ventas realizadas y poder determinar las ganancias obtenidas durante un determinado día.
   - El usuario debería poder seleccionar las prendas que se van a vender, su cantidad y establecer el medio de pago. El sistema entonces debería calcular y devolver     el total a pagar en base a lo anterior.
- Concretada la venta, esta debería quedar registrada con los siguientes datos:
   - Prendas vendidas y su cantidad
   - Fecha de venta
   - Ganancia total (no dicho explícitamente, pero necesario para la determinación de las ganancias de un dia)

Parte II: Desarrollo de Solución

Se me ocurrió tener al principio un objeto que opere como una interfaz inicial entre el usuario y el sistema. Sería un “punto de entrada”, permitiendo buscar ropa y “crear” nuevas ventas. No quiero que tenga una cantidad de responsabilidades excesiva - en tanto pueda, que las consultas de datos sobre la ropa y el agregado de productos a un venta a concretar sea realizado por otros objetos.

Dicho esto, el diagrama de clases:

[diagrama]https://github.com/nullspace1/macowinsPrimeraIteracion/blob/main/Ej%20I.drawio.png


Algunos comentarios:

- Para el primer requerimiento, la consulta por una prenda se realiza primero a CoordinadorDeVentas1 - este se encarga de buscar en la colección (o base de datos, lo que sea) de ropa disponible y devolver un objeto de Ropa, al cual podemos realizar todas las consultas pertinentes, o establecer el parámetro de estado.
Similarmente, para el segundo requerimiento, se le envía un mensaje a CoordinadorDeVentas para que cree una nueva instancia de una Venta a realizar, además de registrarla en su colección (o base de datos, idem que con arriba)
- Podría decirse que CoordinadorDeVentas no “conoce” a las prendas - conoce a una lista de estas, o una conexión a una base de datos, depende de cómo se implementa la lógica del modelo. Idem con Venta. Por ende no se si las relaciones usadas están adecuadamente aplicadas en este caso.

