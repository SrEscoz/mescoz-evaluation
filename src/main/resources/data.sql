INSERT INTO EQUIPOS (name)
VALUES ('Nankatsu SC'),
       ('Toho Academy'),
       ('Musashi FC'),
       ('Meiwa FC');


INSERT INTO JUGADORES (nombre, apellidos, edad, email, id_equipo)
VALUES ('Tsubasa', 'Ozora', 17, 'tsubasa.ozora@nankatsu.com', 1);

INSERT INTO JUGADORES (nombre, apellidos, edad, email, id_equipo)
VALUES ('Genzo', 'Wakabayashi', 17, 'genzo.wakabayashi@nankatsu.com', 1);

INSERT INTO JUGADORES (nombre, apellidos, edad, email, id_equipo)
VALUES ('Kojiro', 'Hyuga', 18, 'kojiro.hyuga@tohoacademy.com', 2);

INSERT INTO JUGADORES (nombre, apellidos, edad, email, id_equipo)
VALUES ('Jun', 'Misugi', 17, 'jun.misugi@musashi.com', 3);

INSERT INTO JUGADORES (nombre, apellidos, edad, email, id_equipo)
VALUES ('Taro', 'Misaki', 17, 'taro.misaki@nankatsu.com', 1);

INSERT INTO JUGADORES (nombre, apellidos, edad, email, id_equipo)
VALUES ('Hikaru', 'Matsuyama', 18, 'hikaru.matsuyama@meiwa.com', 4);

INSERT INTO POSICIONES_JUGADOR (id_jugador, posicion)
VALUES (1, 'Mediocampista'),
       (1, 'Capitán');

INSERT INTO POSICIONES_JUGADOR (id_jugador, posicion)
VALUES (2, 'Portero');

INSERT INTO POSICIONES_JUGADOR (id_jugador, posicion)
VALUES (3, 'Delantero');

INSERT INTO POSICIONES_JUGADOR (id_jugador, posicion)
VALUES (4, 'Defensa'),
       (4, 'Mediocampista');

INSERT INTO POSICIONES_JUGADOR (id_jugador, posicion)
VALUES (5, 'Mediocampista Ofensivo');

INSERT INTO POSICIONES_JUGADOR (id_jugador, posicion)
VALUES (6, 'Defensa Central');
