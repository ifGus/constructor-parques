% BASE DE CONOCIMIENTO

% PARQUE CON TRES AREAS
area('ni�os').
area('recreacion').
area('descanso').

%Area de ni�os
subarea('a1','ni�os').
subarea('a2','ni�os').
subarea('a3','ni�os').
subarea('a4','ni�os').
subarea('a5','ni�os').
subarea('a6','ni�os').
subarea('a7','ni�os').
subarea('a8','ni�os').

%Area de recreaci�n
subarea('a9','recreacion').
subarea('a10','recreacion').
subarea('a11','recreacion').
subarea('a12','recreacion').
subarea('a13','recreacion').

subarea('a14','descanso').
subarea('a15','descanso').
subarea('a16','descanso').
subarea('a17','descanso').
subarea('a18','descanso').
subarea('a19','descanso').

subarea('a20','ni�os').
subarea('a21','recreacion').
subarea('a22','descanso').

% palinificaion en �rea de ni�os
sobre('resbalin','a1').
sobre('columpio','a2').
sobre('pasamanos','a3').
sobre('tobogan','a4').
sobre('carrucel','a5').
sobre('piscina','a6').
sobre('sube y baja','a7').
sobre('kiosco','a8').

%planificacion en �rea de recreaci�n
sobre('cancha polifuncional','a9').
  sobre('arcos','cancha polifuncional').
     sobre('tablero','arcos').
sobre('ciclovia','a10').
sobre('fronton','a11').
sobre('pista de patinaje','a12').
sobre('kiosco','a13').

%planificacion en �rea de descanso
sobre('jardines','a14').
sobre('fuente de agua','a15').
sobre('snack','a16').
sobre('mesas de cemento','a17').
sobre('churrasqueras','a18').
sobre('arboles','a19').

sobre('ba�o','a20').
sobre('ba�o','a21').
sobre('ba�o','a22').

%Limitaciones
vecino('ni�os','recreacion').
vecino('recreacion','descanso').


%Instalaciones generales
instalar('iluminacion','ni�os',23).
instalar('iluminacion','recreacion',24).
instalar('iluminacion','descanso',25).

instalar('banca','ni�os',26).
instalar('banca','recreacion',27).
instalar('banca','descanso',28).


%orden de ejecucion por prioridad
ejecutar(1,'a1').
ejecutar(2,'a2').
ejecutar(3,'a3').
ejecutar(4,'a4').
ejecutar(5,'a5').
ejecutar(6,'a6').
ejecutar(7,'a7').
ejecutar(8,'a8').
ejecutar(9,'a9').
ejecutar(10,'a10').
ejecutar(11,'a11').
ejecutar(12,'a12').
ejecutar(13,'a13').
ejecutar(14,'a14').
ejecutar(15,'a15').
ejecutar(16,'a16').
ejecutar(17,'a17').
ejecutar(18,'a18').
ejecutar(19,'a19').
ejecutar(20,'a20').
ejecutar(21,'a21').
ejecutar(22,'a22').

ejecutar(23,'ni�os').
ejecutar(24,'recreacion').
ejecutar(25,'descanso').

ejecutar(26,'ni�os').
ejecutar(27,'recreacion').
ejecutar(28,'descanso').


%Condiciones
es_del_area(Y,X):- area(X),subarea(M,X),sobre(Y,M).  %saber el area al que corresponde segun el objeto a instalar
es_del_area(Y,X):- area(X),ejecutar(Y,M),subarea(M,X).
es_del_area(Y,X):- ejecutar(Y,X). %caso iluminacion

procesando_elemento(N,E):- ejecutar(N,S),sobre(E,S).

vecino_de(X,Y):- vecino(X,Y).
vecino_de(X,Y):- vecino(Y,X).

es_elemento(X,Y):- ejecutar(X,Z),sobre(Y,Z).
%es_elemento(X,Y):- ejecutar(X,M),poner(Y,M). % caso banco
es_elemento(X,Y):- ejecutar(X,M),instalar(Y,M,X).  %Caso iluminacion





















