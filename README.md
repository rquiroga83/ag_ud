# ag_ud
Agud es un software que implementa la libreria jgap y permite configurar algoritmos geneticos para diversos problemas mediante la personalizacion de la funcion de fitness


# Configuracion

Aquí es donde se configura el algoritmo genético. La primera pestaña de configuración general contiene los siguientes ítems:
 
## Cantidad de población: 
Es el numero de la población, Hay que tener en cuenta que entre mas población el problema tendera a solucionarse en menos generaciones pero se ocupara mas memoria y el algoritmo correrá mas lento.
 
## Tipo de mutación: 
Casilla donde se selecciona la mutación el programa tiene 3 de tipos uno es la mutación aleatoria que selecciona un ge al azar de cromosoma y la cambia en el rango de cambio es pacificado para el mismo, otra es la mutación de intercambio que no varia el valor de los genes solo los intercambia unos con otros y mutación de dos vías que verifica el impacto en el cromosoma de cambiar un gen, y cuado ha seleccionado los que tiene menor impacto aplica una mutación aleatoria sobre estos.  
 
## Rata de mutación: 
Es la probabilidad en porcentaje que tiene cada gen de ser mutado.
 
## Tipo de crossover: 
El programa tiene tres tipos de crossover y una opción de no crossover el primer tipo es el  de punto de cruce aleatorio que selecciona un punto de cruza al asar e intercambia los genes de hay para aya el segundo el crosover promediado que es igual que el alterior pero la rata de crossover no es fija depende que cuales cromosomas son mas aptos, y punto de cruce gen a gen es como el promero pero no cambia los alelos de cada gen si no que los mantiene constantes es decir solo cruza  los genes como tal.
 
## Rata de crossover:  
Indica que cantidad de la población será cruzada se divide la población sobre este numero es decir si se indica 2 la mitad de la población será cruzada si se indica 3 la tercera parte etc … .
 
##Tipo de Selección : 
Indica cual el tipo de selección de genes aptos que se usara una es selección natural que como su nombre lo indica escoge a los mejores, otra es la selección por torneo que hace un torneo entre algunos individuos de la población y selecciona a los ganadores de dicho torneo y por ultimo esta la selección por rueda de la ruleta que selecciona individuos al asar de la población.
 
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
