USE zoodb;

SHOW TABLES;

INSERT INTO animal (common_name, scientific_name, specie, family) VALUES ('León', 'Panthera leo', 'Felidae', 'Felidae');

INSERT INTO animal (common_name, scientific_name, specie, family) VALUES ('Elefante africano', 'Loxodonta africana', 'Loxodonta', 'Elephantidae');

INSERT INTO animal (common_name, scientific_name, specie, family) VALUES ('Tigre de Bengala', 'Panthera tigris tigris', 'Panthera tigris', 'Felidae');

INSERT INTO animal (common_name, scientific_name, specie, family) VALUES ('Gorila occidental de llanura', 'Gorilla gorilla gorilla', 'Gorilla gorilla', 'Hominidae');

INSERT INTO animal (common_name, scientific_name, specie, family) VALUES ('Oso polar', 'Ursus maritimus', 'Ursus maritimus', 'Ursidae');

INSERT INTO animal (common_name, scientific_name, specie, family) VALUES ('Cebra de Grevy', 'Equus grevyi', 'Equus grevyi', 'Equidae');

INSERT INTO animal (common_name, scientific_name, specie, family) VALUES ('Panda gigante', 'Ailuropoda melanoleuca', 'Ailuropoda melanoleuca', 'Ursidae');

INSERT INTO animal (common_name, scientific_name, specie, family) VALUES ('Rinoceronte blanco', 'Ceratotherium simum', 'Ceratotherium simum', 'Rhinocerotidae');

INSERT INTO animal (common_name, scientific_name, specie, family) VALUES ('Jirafa', 'Giraffa camelopardalis', 'Giraffa camelopardalis', 'Giraffidae');

INSERT INTO animal (common_name, scientific_name, specie, family) VALUES ('Lobo gris', 'Canis lupus', 'Canis lupus', 'Canidae');

SELECT *
FROM animal;