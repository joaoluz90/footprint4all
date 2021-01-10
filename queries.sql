DELIMITER //
CREATE PROCEDURE GetUsers()
BEGIN
SELECT * FROM utilizador;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetUsersMinAge()
BEGIN
SELECT uti_nome, uti_idade as Min_age
FROM utilizador
WHERE uti_idade = 18
GROUP BY uti_nome;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetHomens()
BEGIN
SELECT uti_nome as Nome 
FROM utilizador
WHERE uti_genero = 'M'
Group by uti_nome;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetEmailbyID()
BEGIN
SELECT uti_nome as Nome, uti_email as Email 
FROM utilizador
WHERE uti_id <=20
GROUP BY uti_email;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetBirthdaybyID()
BEGIN
SELECT uti_id as ID , uti_nome as Nome , uti_dnsc as Birthday
FROM utilizador
WHERE uti_id <=20
GROUP BY uti_dnsc;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetForms()
BEGIN
SELECT * FROM formulario;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetCodigos()
BEGIN
SELECT * FROM codigopostal;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetEscalas()
BEGIN
SELECT * FROM escala;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetResTipo()
BEGIN
SELECT * FROM resTipo;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetPerTipo()
BEGIN
SELECT * FROM perTipo;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetAdmin()
BEGIN
SELECT * FROM administrador;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetSecc()
BEGIN
SELECT * FROM seccao;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetPergunta()
BEGIN
SELECT * FROM pergunta;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetResposta()
BEGIN
SELECT * FROM resposta;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetRelaciona()
BEGIN
SELECT * FROM relaciona;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetPossui()
BEGIN
SELECT * FROM possui;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetDa()
BEGIN
SELECT * FROM da;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetAssociada()
BEGIN
SELECT * FROM associadaapergunta;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetContem()
BEGIN
SELECT * FROM contem;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetTem()
BEGIN
SELECT * FROM tem;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetEdita()
BEGIN
SELECT * FROM edita;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetAo()
BEGIN
SELECT * FROM ao;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE GetClassificacao()
BEGIN
SELECT * FROM classificado;
END //
DELIMITER ;


/************************************************************
* Lista de Procedures do Utilizador
************************************************************/

CALL GetUsers();

CALL GetUsersMinAge();

CALL GetHomens();

CALL GetEmailbyID();

CALL GetBirthdaybyID();


/************************************************************
* Lista de Selects do Utilizador e Código Postal
************************************************************/

SELECT uti_nome as Nome
FROM utilizador
WHERE uti_id 
IN (SELECT cla_uti_id FROM classificado WHERE cla_esc_id <= 2);


SELECT uti_nome as Nome
FROM utilizador
WHERE uti_id 
IN (SELECT cla_uti_id FROM classificado WHERE cla_esc_id = 5);


SELECT uti_nome as Nome
FROM utilizador
WHERE uti_id 
IN (SELECT cla_uti_id FROM classificado WHERE cla_esc_id = 3);


SELECT cod_localidade as Localidade
FROM codigopostal
WHERE cod_id IN (SELECT uti_cod_id FROM utilizador WHERE uti_nome = 'André André');


SELECT cod_nrporta as NrPorta
FROM codigopostal
WHERE cod_id IN (SELECT uti_cod_id FROM utilizador WHERE uti_id >= 9);


/************************************************************
* Lista de Procedures Gerais
************************************************************/

CALL GetForms();

CALL GetCodigos();

CALL GetEscalas();

CALL GetResTipo();

CALL GetPerTipo();

CALL GetAdmin();

CALL GetSecc();

CALL GetPergunta();

CALL GetResposta();

CALL GetRelaciona();

CALL GetPossui();

CALL GetDa();

CALL GetAssociada();

CALL GetContem();

CALL GetTem();

CALL GetEdita();

CALL GetAo();

CALL GetClassificacao();









