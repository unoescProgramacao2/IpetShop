INSERT INTO usuarios (id,username, password, enabled) VALUES(1,'admin@gmail.com', '$2a$08$sFd33JOHRlbRYE4j1NDnZezggfaoRKGjAAXN10iIltiiTWhHX.q.2', true);
INSERT INTO usuarios (id,username, password, enabled) VALUES(2,'yamamoto@yahoo.com;br', '$2a$08$sFd33JOHRlbRYE4j1NDnZezggfaoRKGjAAXN10iIltiiTWhHX.q.2', true);
INSERT INTO usuarios (id,username, password, enabled) VALUES(3,'kon@hotmail.com', '$2a$08$sFd33JOHRlbRYE4j1NDnZezggfaoRKGjAAXN10iIltiiTWhHX.q.2', false);
INSERT INTO usuarios (id,username, password, enabled) VALUES(4,'ulquiorra@sad.com', '$2a$08$sFd33JOHRlbRYE4j1NDnZezggfaoRKGjAAXN10iIltiiTWhHX.q.2', false);
INSERT INTO usuarios (id,username, password, enabled) VALUES(5,'vitames@a.com', '$2a$08$T6.5admGKDYC17HTWd4/VOSvgOgOC2x4dhYzafpbNql7AaOhiQ3NG', true);

INSERT INTO AUTHORITY (id,AUTHORITY) VALUES(1,'ADMIN');
INSERT INTO AUTHORITY (id,AUTHORITY) VALUES(2,'USER');


INSERT INTO  AUTHORITIES_USERS (USUARIO_ID, AUTHORITY_ID) VALUES (1,1);
INSERT INTO  AUTHORITIES_USERS (USUARIO_ID, AUTHORITY_ID) VALUES (2,2);
INSERT INTO  AUTHORITIES_USERS (USUARIO_ID, AUTHORITY_ID) VALUES (3,2);
INSERT INTO  AUTHORITIES_USERS (USUARIO_ID, AUTHORITY_ID) VALUES (4,2);

INSERT INTO produto_categoria (id,nome,data_criacao,data_atualizacao) VALUES (1,'Eletronicos',now(),now());

INSERT INTO produto (id, nome, descricao, valor, unidade, data_atualizacao, data_criacao, marca, situacao, categoria_id) VALUES(1,'Produto 1','Descrição do produto 1', 10.00, 10, now(), now(), 'teste', 'disponível', 1);
;
