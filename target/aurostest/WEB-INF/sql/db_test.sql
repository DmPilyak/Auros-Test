INSERT INTO auros_test_db.k_pac (Title, Description_k_pac, Creation_date) VALUES ('Title 1', 'Description 1', '0000-00-00');
INSERT INTO auros_test_db.k_pac (Title, Description_k_pac, Creation_date) VALUES ('Title 2', 'Description 2', '0000-00-00');
INSERT INTO auros_test_db.k_pac (Title, Description_k_pac, Creation_date) VALUES ('Title 3', 'Description 3', '0000-00-00');
SELECT * FROM auros_test_db.k_pac;

INSERT INTO auros_test_db.kpac_set_kpac (id_set, id_kpac) VALUES (1, 1);
INSERT INTO auros_test_db.kpac_set_kpac (id_set, id_kpac) VALUES (2, 1);
INSERT INTO auros_test_db.kpac_set_kpac (id_set, id_kpac) VALUES (1, 3);


INSERT INTO auros_test_db.kpac_sets (Title) VALUES ("Set 1");
INSERT INTO auros_test_db.kpac_sets (Title) VALUES ("Set 2");
