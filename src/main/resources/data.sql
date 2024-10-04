
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
