-- Insert Artists
INSERT INTO artist (name) VALUES ('The Beatles');
INSERT INTO artist (name) VALUES ('Michael Jackson');
INSERT INTO artist (name) VALUES ('Elon Musk');
INSERT INTO artist (name) VALUES ('David Attenborough');
INSERT INTO artist (name) VALUES ('Joe Rogan');

-- Insert Albums
INSERT INTO album (name, release_date) VALUES ('Abbey Road', '1969-09-26');
INSERT INTO album (name, release_date) VALUES ('Revolver', '1966-08-05');
INSERT INTO album (name, release_date) VALUES ('Thriller', '1982-11-30');
INSERT INTO album (name, release_date) VALUES ('Tech Talk Series', '2023-01-01');
INSERT INTO album (name, release_date) VALUES ('Planet Earth II', '2016-11-06');

--Insert albums_artist
INSERT INTO album_artist (album_id, artist_id) VALUES (1,1)
INSERT INTO album_artist (album_id, artist_id) VALUES (2,1)
INSERT INTO album_artist (album_id, artist_id) VALUES (3,2)
INSERT INTO album_artist (album_id, artist_id) VALUES (4,3)
INSERT INTO album_artist (album_id, artist_id) VALUES (5,4)
INSERT INTO album_artist (album_id, artist_id) VALUES (4,5)

