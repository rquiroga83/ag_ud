# ag_ud
Agud es un software que implementa la libreria jgap y permite configurar algoritmos geneticos para diversos problemas mediante la personalizacion de la funcion de fitness. 

Esta personalizacion se realiza mediante scripts en un leguaje propio con sintaxis c, los cuales son interpretados por una maquina de pila.

# Configuracion

![alt text](https://github.com/rquiroga83/ag_ud/blob/ag_ud/imagenes/configuracion1.png) ![alt text](https://github.com/rquiroga83/ag_ud/blob/ag_ud/imagenes/configuracion2.png)

Aquí es donde se configura el algoritmo genético. La primera pestaña de configuración general contiene los siguientes ítems:
 
## Cantidad de población: 
Es el numero de la población, Hay que tener en cuenta que entre mas población el problema tendera a solucionarse en menos generaciones pero se ocupara mas memoria y el algoritmo correrá mas lento.
 
## Tipo de mutación: 
Casilla donde se selecciona la mutación el programa tiene 3 tipos. Una es la mutación aleatoria en la que se selecciona un gen al azar de un cromosoma y lo cambia en el rango especificado para el mismo. Otra es la mutación de intercambio que no varia el valor de los genes solo los intercambia unos con otros. Y por ultimo la mutación de dos vías, que verifica el impacto de cambiar un gen en el cromosoma y cuado ha seleccionado los que tiene menor un menor impacto aplica una mutación aleatoria sobre estos.  
 
## Rata de mutación: 
Es la probabilidad en porcentaje que tiene cada gen de ser mutado.
 
## Tipo de crossover: 
El programa tiene tres tipos de crossover y una opción de no crossover. El primer tipo es el  de punto de cruce aleatorio que selecciona un punto de cruza al asar e intercambia los genes de hay. El segundo es llamado crosover promediado, que es igual que el alterior pero la rata de crossover no es fija depende cuales cromosomas son mas aptos. Y el crossover de punto de cruce gen a gen el cual es como el primero pero no cambia los alelos de cada gen si no que los mantiene constantes es decir solo cruza  los genes como tal.
 
## Rata de crossover:  
Indica que cantidad de la población será cruzada se divide la población sobre este numero es decir si se indica 2 la mitad de la población será cruzada si se indica 3 la tercera parte etc … .
 
## Tipo de Selección : 
Indica cual el tipo de selección de genes aptos que se usara. La primera es selección natural que como su nombre lo indica escoge a los mejores, la segunda es la selección por torneo que hace un torneo entre algunos individuos de la población y selecciona a los ganadores de dicho torneo y por ultimo esta la selección por rueda de la ruleta que selecciona individuos al asar de la población.
 
## Tamaño del torneo: 
Casilla que solo aplica para la selección por torneo y indica cuantos participan en este.
 
## Probabilidad de selección: 
Es un numero de 0 a 1 que indica que probabilidad tiene cada individuo particular de la población de ser seleccionado.
 
## Función Fiteness de Maximización: 
Si esta chequeado indica que la se buscara la maximización del fitness si no se buscara la minimización.
 
## Numero Máximo de Evoluciones: 
Indica cuantas generaciones máximo generara el programa.
 
## La pestaña de genes contiene los siguientes ítems:
 
### Tamaño del cromosoma: 
Indica la longitud del cromosoma.
 
### Numero de alelos: 
Indica la longitud de cada gen.
 
### Rango: 
Indica el rango en que varia el valor de los alelos de cada gen.
 
### Genes alfabéticos: 
Indica si los genes a cargar son alfabéticos.
 
### Inicialización aleatoria de genes: 
Se cheque si las genes se inicializan aleatoriamente o si se toma el modelo para inicializar la población.
 
### Caja de texto de genes: 
Aquí se puede editar el modelo de los genes que se usaran en el algoritmo genético, hay que tener en cuenta que cada fila representa un gen del cromosoma al cual se le pueden colocar un determinado numero de alelos, cada valor debe estar separado por un tabulador, y entre gen y gen del cromosoma se debe separar todo por un enter, los genes creados se pueden guardar en archivos de extensión  .crm y cargados desde los mismos.



# Función de Fitness.

![alt text](https://github.com/rquiroga83/ag_ud/blob/ag_ud/imagenes/fitness.jpg)

En esta pantalla se digita el algoritmo que evaluara cada cromosoma, este será cargado por el programa y se utilizara como parte integral del mismo para evaluar a cada individuo de la población generada por el algoritmo genético, es impórtate tener en cuenta que esta función retorna un valor escalar que es colocado en la pila del programa por medio de la función  “pop ( valor ); ”, y que esta se limita únicamente a dar un puntaje a cada cromosoma es decir a indicar que tan apto es el cromosoma para resolver un problema determinado por medio de un numero.
 
Esta pantalla contiene dos botones en la parte inferior los cuales sirven para guardar y cargar archivos de extensión .spl  que contiene el código de Fitness estos archivos pueden ser editados desde el WordPad o desde la misma pantalla de edición.
 
El programa esta diseñado para usar una sintaxis de  C simplificada  y soporta las siguientes características:


### Funciones generales :
 ```c
  /** Retorna el coseno de un valor determinado. */
  cos(valor)
  
  /** Retorna el seno de un valor determinado.*/
  sin(valor)
 
  /** Retorna la potencia de un valor determinado.*/
  pow(valor,potencia)
  
  /** Retorna la raíz cuadrada de un valor determinado. */
  sqrt(valor)
  
  /** 
   * Se utiliza para extraer el un gen del cromosoma a evaluar 
   * se da una posición de gen y el alelo y retorna el valor 
   * de dicho alelo en el gen.
   */
  gen(gen_pos,alelo)    
 
  /** Retorna el minimo de dos valores.*/
  min(valor1,valor2)
  
  /** Retorna el maximo de dos valores.*/
  max(valor1,valor2)
 
  /** Retorna el valor absoluto de un valor.*/
  abs(valor)
 
  /** Coloca un valor el la pila de programa retorna 0 si es posible colocar dicho valor de lo contrario retorna –1.*/
  pop(valor)             
 
  /**
   * Extrae un valor de la pila si opción es 0, 
   * si opción es 1 borrara toda la pila y retorna 0 si es posible borrarla 
   * de lo contrario retorna –1.
   */
  get(opcion)            
  
```
