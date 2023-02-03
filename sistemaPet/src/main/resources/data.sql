INSERT INTO paciente(id, cpf,nome_animal,tutor) VALUES 
( 1,'12345678901','Thor'      , 'Thiago Henrique Alves Sales'),
( 2,'78945612311','Felicia'   , 'Maria Julia Alves Sales'), 
(3,'12345678589','Uba'        ,'Maria Laura Alves Sales' ) ,
(4,'45612374894','Kika'      , 'Maria Carolina Alves Sales') ;

INSERT INTO consulta(ID_CONSULTA, DATA, PACIENTE_ID, VETERINARIO_CRMV)  VALUES
(1,'2023-02-06',          1,            2587),
(2,'2023-02-22',          1,            5478),
(3,'2023-03-16',          1,            1234),
(4,'2023-02-06',          2,            2587),
(5,'2023-02-22',          2,            5478),
(6,'2023-03-16',          2,            1234),
(7,'2023-02-06',          3,            2587),
(8,'2023-02-22',          3,            5478),
(9,'2023-03-16',          3,            1234),
(10,'2023-02-06',          4,            2587),
(11,'2023-02-22',          4,            5478),
(12,'2023-03-16',          4,            1234);

INSERT INTO veterinario(CRMV, ESPECIALIDADE, NOME) VALUES
(1234,'Cardiologia Veterinaria','Enrico Santos'),
(2587,'Anestesia Veterinaria'	,'Maria Luiza Jesus'),
(4563,' Endocrinologia Veterinaria'	,'Erick Fernandes'),
(5478,'Fisioterapia Veterinaria',	'Jota Pedro Cardoso'),
(7802,'Cardiologista Veterinario',	'Arthur Silva'),
(9632,'Cirurgia Veterinaria',	'Rebeca Dias');

INSERT INTO exames(ID, NOME, TAXA, PACIENTE_ID) VALUES
 (1,'Contagem de Plaquetas    ',150000  ,      1),                 
 (2,'Contagem de Reticulocitos',  1.5	,          1),                 
 (3,'Contagem de Plaquetas    ',150000  ,      2),                 
 (4,'Contagem de Reticulocitos',  1.5	,          2),
 (5,'Contagem de Plaquetas    ',150000  ,      3),                 
 (6,'Contagem de Reticulocitos',  1.5	,          3),
 (7,'Contagem de Plaquetas    ',150000  ,      4),                 
 (8,'Contagem de Reticulocitos',  1.5	,          4);