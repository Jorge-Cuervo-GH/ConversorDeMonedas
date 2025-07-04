# 💱 Conversor de Monedas en Java con la API de ExchangeRate

Hola, soy Jorge Cuervo, y este es un proyecto que desarrollé con el apoyo y el aprendizaje que me brindo el programa ONE de oracle y los instructores de Alura, con quienes aprendimos y practicamos conceptos clave de Java aplicados a una solución real. Se trata de un conversor de monedas que utiliza una API pública [API de ExchangeRate](https://www.exchangerate-api.com/). para obtener tasas de cambio actualizadas y realizar conversiones entre las principales divisas del mundo.

Lo que me motivó a crear este proyecto fue el interés por combinar varias habilidades al mismo tiempo: trabajar con interfaces gráficas en Java (usando Swing), consumir servicios web mediante APIs REST, organizar el código de forma modular y profesional, y también guardar un historial de uso que permita consultar o registrar las conversiones hechas.

Además de todo lo técnico, este proyecto me ayudó a ver cómo una idea sencilla puede convertirse en una herramienta útil si se desarrolla con buenas prácticas. Cada componente del programa tiene una función clara, y esto no solo facilita el mantenimiento, sino que permite pensar en futuras mejoras, tal como nos lo enseñan en Alura.

Está diseñado para funcionar en cualquier equipo con Java 11 o superior, y puede ser usado tanto por curiosidad como por necesidad práctica, por ejemplo si estás planeando un viaje, haciendo cálculos financieros o simplemente quieres automatizar una tarea cotidiana como convertir divisas.

Más abajo encontrarás instrucciones detalladas para usarlo, las características, la estructura del proyecto, las tecnologías que utilicé, y una pequeña reflexión con las conclusiones que me dejó esta experiencia.

¡Gracias por pasarte por aquí y espero que este proyecto sea de tu agrado!

-------------------------------------------------
## 🎥 Demostración en Video

[![Ver demostración en video](43144ba1-7b9a-4cb0-bbec-ea600dc0a126.png)](https://somup.com/cTifo5LNB2)


-------------------------------------------------

## ⚙️ Características

- ✅ **Interfaz gráfica amigable**: construida con Java Swing, permite al usuario seleccionar fácilmente las divisas, ingresar la cantidad y obtener resultados en tiempo real.
- 🌐 **Conexión con API en tiempo real**: utiliza la API de [ExchangeRate](https://www.exchangerate-api.com/) para obtener tasas de cambio actualizadas entre múltiples monedas del mundo.
- 💡 **Amplio soporte de divisas**: incluye las monedas más importantes como USD, EUR, COP, JPY, GBP, MXN, BRL, entre otras. en el programa contamos con 50 divisas pero con posibilidad de añadir más fácilmente.
- 🧠 **Conversión precisa**: realiza los cálculos utilizando tasas actuales y muestra el resultado con formato claro y comprensible.
- 📚 **Historial detallado de conversiones**: cada conversión queda registrada con fecha, hora, monedas y montos involucrados.
- 💾 **Guardado del historial en archivo**: el historial puede exportarse a un archivo `.txt`, ideal para llevar un registro o compartir.
- 🧩 **Diseño modular**: el código está organizado por componentes separados (lógica de conversión, interfaz, historial, estructura de datos), lo que facilita el mantenimiento y posibles mejoras futuras.
- 🆕 **Uso de `record` en Java**: se implementa la nueva estructura `record` para representar cada conversión de forma simple, segura y legible.
- 🚫 **Manejo de errores y validaciones**: el programa informa al usuario si hay errores con la conexión, API o si se ingresan datos inválidos.


----------------------------------------------
## 🧩 Estructura del proyecto

```
 📂 conversorDeMonedas-java
├── ConversorMonedas.java              # Conexión a la API y lógica de conversión
├── ConversorInterfazGrafica.java      # Interfaz gráfica
├── HistorialConversiones.java         # Historial y guardado
├── Conversion.java                    # record para representar conversiones
├── gson-2.13.1.jar                    # Librería para manejar JSON
└── historial_conversiones.txt         # Archivo generado con el historial
```
----------------------------------------------
## 💻 Tecnologías utilizadas

- **Java 11+**
- **Swing** para la interfaz gráfica
- **HttpClient (Java 11+)** para solicitudes HTTP
- **ExchangeRate API** para obtener tasas de cambio
- **Gson 2.10.1** para leer y procesar JSON
- **record (Java 14)** para representar objetos de forma inmutable
- **Archivos de texto (.txt)** para guardar el historial
- **Modularidad Java** (organización por clases)
-----------------------------------------------

## 📄 Conclusiones

Este proyecto demuestra cómo integrar una API REST en una aplicación Java de escritorio utilizando buenas prácticas de diseño modular.

El uso de record permite representar los datos de forma clara y concisa.

La librería GSON facilita el manejo de JSON sin escribir mucho código adicional.

Gracias a Swing, se puede crear una interfaz gráfica amigable sin necesidad de herramientas externas.

Este proyecto puede ser una excelente base para aprender a trabajar con APIs, GUIs, archivos y estructuras modernas de Java.

Desarrollar este conversor de monedas en Java fue una experiencia muy enriquecedora que me permitió aplicar varios conceptos clave de la programación en Java. A lo largo del proyecto, no solo reforcé mis conocimientos sobre estructuras como `record` y el manejo de excepciones, sino que también aprendí a consumir servicios web mediante APIs externas como ExchangeRate.

Me di cuenta de la importancia de mantener un diseño modular: separar la interfaz gráfica, la lógica de negocio, el modelo de datos (`Conversion`) y el historial, facilita muchísimo el mantenimiento y la escalabilidad del programa. Por ejemplo, si en un futuro quiero reemplazar la API o agregar más funcionalidades (como gráficos de tipo de cambio o soporte offline), puedo hacerlo sin tener que rehacer todo el sistema.

Otra parte valiosa fue trabajar con la librería GSON, que simplifica bastante el trabajo con JSON en Java. Me ayudó a entender mejor cómo se estructuran las respuestas de una API y cómo mapear esos datos a objetos Java para procesarlos con seguridad.

Además, fue gratificante integrar una interfaz gráfica con Swing. Aunque existen frameworks más modernos, Swing sigue siendo una herramienta poderosa para proyectos educativos y funcionales como este.

Finalmente, una de las cosas que más valoro de este proyecto es que no es solo un ejercicio de código, sino una herramienta útil que conecta con el mundo real. Convertir monedas es algo cotidiano, y poder automatizarlo de forma práctica me motivó mucho a cuidar cada detalle del programa.

Este proyecto me deja como conclusión que, con una buena organización, un poco de paciencia y ganas de aprender, es posible construir soluciones completas que combinan interfaz, lógica, persistencia de datos y conexión con servicios externos.
