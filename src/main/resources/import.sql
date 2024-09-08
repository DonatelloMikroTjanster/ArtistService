-- INSERT INTO ARTISTS(genre_id, artist_name) VALUES (1, 'J Balvin'), (2,'Eminem'), (3, 'Metallica'), (4, 'Bob Marley'), (5, 'Romeo Santos');
--
-- INSERT INTO ALBUMS(artist_id, album_title, release_date) VALUES (1, 'Vibras', '2018-05-25'),(2, 'The Eminem Show', '2002-05-26'),    (3, 'Kill \Em All', '1983-07-25'), (4, 'Confrontation', '1983-05-23'),(5, 'Formula, Vol. 2', '2014-02-25');
--


INSERT INTO artists (name) VALUES ('J Balvin');
INSERT INTO artists (name) VALUES ('Eminem');
INSERT INTO artists (name) VALUES ('Metallica');
INSERT INTO artists (name) VALUES ('Bob Marley');
INSERT INTO artists (name) VALUES ('Romeo Santos');
INSERT INTO artists (name) VALUES ('Joe Rogan');

INSERT INTO albums (name, artist_id, media_category) VALUES ('Vibras', 1, 'MUSIC');
INSERT INTO albums (name, artist_id, media_category) VALUES ('The Eminem Show', 2, 'MUSIC');
INSERT INTO albums (name, artist_id, media_category) VALUES ('Kill \Em All', 3, 'MUSIC');
INSERT INTO albums (name, artist_id, media_category) VALUES ('Confrontation', 4, 'MUSIC');
INSERT INTO albums (name, artist_id, media_category) VALUES ('Formula, Vol. 2', 5, 'MUSIC');
INSERT INTO albums (name, artist_id, media_category) VALUES ('Encore', 2, 'MUSIC');
INSERT INTO albums (name, artist_id, media_category) VALUES ('#2191 Russel Crowe', 6, 'PODCAST');





