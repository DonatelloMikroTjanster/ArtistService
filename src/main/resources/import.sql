-- Insert Artists
INSERT INTO artist (id, name, genre)
VALUES
    (1, 'The Beatles', 'Rock'),
    (2, 'Michael Jackson', 'Pop');

-- Insert Tracks
INSERT INTO track (id, title, release_date, album_id)
VALUES
    (1, 'Come Together', '1969-09-26', 1),
    (2, 'Billie Jean', '1982-11-30', 2);


-- Insert Album-Artist relationships
INSERT INTO album_artist (album_id, artist_id)
VALUES
    (1, 1),  -- Abbey Road - The Beatles
    (2, 2);  -- Thriller - Michael Jackson