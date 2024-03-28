-- Lägg till 5 adresser
INSERT INTO address (street, postal_code, city) VALUES
                                                    ('Prästgårdsängen 8', '41271', 'Göteborg'),
                                                    ('Torslanda Torg 3B', '423 42', 'Torslanda'),
                                                    ('Gräddgatan 15', '412 13', 'Göteborg'),
                                                    ('Torp 2', '112 13', 'Stockholm'),
                                                    ('Grönsakstorget 2', '412 12', 'Göteborg');


-- Lägg till 5 medlemmar
INSERT INTO members (first_name, last_name, address_id, email, phone, date_of_birth) VALUES
                                                                                         ('Fredrik', 'Lundell', 1, 'flundell89@gmail.com', '+46708388404', '1989-02-10'),
                                                                                         ('Michael', 'Jordan', 2, 'michael@jordan.com', '+46722553298', '1999-01-21'),
                                                                                         ('Jonas', 'Persson', 3, 'jonas.persson@hotmail.com', '+46731296403', '1952-08-02'),
                                                                                         ('Sylvester', 'Stallone', 4, 'sly@rambo.com', '+46701253234', '1986-11-30'),
                                                                                         ('Marcus', 'Wolt', 5, 'marcuswolt@gmail.com', '+46704384312', '1978-05-25');
