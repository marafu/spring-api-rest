INSERT INTO state (name) VALUES ('Rio de Janeiro');
INSERT INTO city (name, state_id) VALUES ('Duque de Caxias', 1)

INSERT INTO cuisine (name) VALUES ('brasileira');
INSERT INTO cuisine (name) VALUES ('americana');
INSERT INTO cuisine (name) VALUES ('italiana');
INSERT INTO cuisine (name) VALUES ('francesa');
INSERT INTO cuisine (name) VALUES ('japonesa');
INSERT INTO cuisine (name) VALUES ('mexicana');

-- Inserir nomes de restaurantes e taxas de frete
INSERT INTO restaurant (ship_cost, name, cuisine_id) VALUES (12.50, 'Restaurante Delícia', 1);
INSERT INTO restaurant (ship_cost, name, cuisine_id) VALUES (8.75, 'Casa da Comida Saborosa',1);
INSERT INTO restaurant (ship_cost, name, cuisine_id) VALUES (15.20, 'Rapidão Gastronômico', 2);
INSERT INTO restaurant (ship_cost, name, cuisine_id) VALUES (10.00, 'Sabor e Arte Restaurante', 3);
INSERT INTO restaurant (ship_cost, name, cuisine_id) VALUES (7.90, 'Restaurante do Chef Especial', 1);

