Problema: El ferrocarril de cercanías local presta servicios a varias ciudades en Kiwiland. Debido a problemas monetarios, todas las vías son de 'un solo sentido'. Es decir, una ruta de Kaitaia a Invercargill no implica la existencia de una ruta de Invercargill a Kaitaia. De hecho, aunque ambas rutas existan, son distintas y no necesariamente tienen la misma distancia.

El propósito de este problema es ayudar al ferrocarril a proporcionar a sus clientes información sobre las rutas. En particular, se calculará la distancia a lo largo de una ruta determinada, el número de rutas diferentes entre dos ciudades y la ruta más corta entre dos ciudades.

Entrada: Un grafo dirigido donde un nodo representa una ciudad y un borde representa una ruta entre dos ciudades. El peso del borde representa la distancia entre las dos ciudades. Una ruta dada nunca aparecerá más de una vez, y para una ruta dada, la ciudad de inicio y la ciudad de destino no serán la misma ciudad.

Salida: Para la entrada de prueba del 1 al 5, si no existe tal ruta, se debe imprimir 'NO SUCH ROUTE'. De lo contrario, sigue la ruta tal como se da; ¡no hagas paradas adicionales! Por ejemplo, el primer problema implica comenzar en la ciudad A, luego viajar directamente a la ciudad B (una distancia de 5), luego directamente a la ciudad C (una distancia de 4).

1) La distancia de la ruta A-B-C.
2) La distancia de la ruta A-D.
3) La distancia de la ruta A-D-C.
4) La distancia de la ruta A-E-B-C-D.
5) La distancia de la ruta A-E-D.
6) El número de viajes que comienzan en C y terminan en C con un máximo de 3 paradas. En los datos de muestra a continuación, hay dos viajes de este tipo: C-D-C (2 paradas) y C-E-B-C (3 paradas).
7) El número de viajes que comienzan en A y terminan en C con exactamente 4 paradas. En los datos de muestra a continuación, hay tres viajes de este tipo: A a C (vía B, C, D); A a C (vía D, C, D); y A a C (vía D, E, B).
8) La longitud de la ruta más corta (en términos de distancia a recorrer) de A a C.
9) La longitud de la ruta más corta (en términos de distancia a recorrer) de B a B.
10) El número de rutas diferentes de C a C con una distancia de menos de 30. En los datos de muestra, los viajes son: C-D-C, C-E-B-C, C-E-B-C-D-C, C-D-C-E-B-C, C-D-E-B-C, C-E-B-C-E-B-C, C-E-B-C-E-B-C-E-B-C.

Entrada de prueba:
Para la entrada de prueba, las ciudades se nombran usando las primeras letras del alfabeto de la A a la D. Una ruta entre dos ciudades (de A a B) con una distancia de 5 se representa como AB5.
Grafo: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7

Salida esperada:
1) Salida #1: 9
2)Salida #2: 5
3) Salida #3: 13
4) Salida #4: 22
5) Salida #5: NO SUCH ROUTE
6) Salida #6: 2
7) Salida #7: 3
8) Salida #8: 9
9) Salida #9: 9
10) Salida #10: 7
