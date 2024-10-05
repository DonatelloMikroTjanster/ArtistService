
-- Insert Artists with correct genre_id
INSERT IGNORE INTO artist (name, genre_id)
VALUES
    ('The Beatles', 3),          -- Genre ID 3 for Rock ("Come Together")
    ('Michael Jackson', 4),      -- Genre ID 4 for Pop ("Billie Jean")
    ('Elon Musk', 1),            -- Genre ID 1 for Technology ("Tech Talk Series" podcasts)
    ('David Attenborough', 2),   -- Genre ID 2 for Nature ("Planet Earth II Series" documentaries)
    ('Miles Davis', 5),          -- Genre ID 5 for Jazz ("So What")
    ('Ludwig van Beethoven', 6), -- Genre ID 6 for Classical ("Beethoven Symphony No. 9")
    ('Various Artists', 3),      -- Genre ID 3 for Rock ("Rock Legends Vol 2" and "Rock Legends Vol 3")
    ('Various Pop Artists', 4),  -- Genre ID 4 for Pop ("Pop Classics" and "Pop Forever")
    ('Jazz Ensemble', 5);        -- Genre ID 5 for Jazz ("Jazz Vibes Episode 2" and "Jazz Beats")

-- Insert Albums
INSERT IGNORE INTO album (id, name, release_date)
VALUES
    (1, 'Abbey Road', '1969-09-26'),
    (2, 'Thriller', '1982-11-30'),
    (3, 'Tech Talk Series', '2023-01-01'),
    (4, 'Planet Earth II Series', '2016-11-06');



-- Insert into album_artist link table

INSERT IGNORE INTO album_artist (album_id, artist_id)
VALUES
    (1, 1),  -- Abbey Road by The Beatles
    (2, 2),  -- Thriller by Michael Jackson
    (3, 3),  -- Tech Talk Series by Elon Musk
    (4, 4);  -- Planet Earth II Series by David Attenborough