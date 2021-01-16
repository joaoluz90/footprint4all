SELECT * FROM utilizador;

SELECT * FROM formulario;

SELECT * FROM codigopostal;

SELECT * FROM escala;

SELECT * FROM resTipo;

SELECT * FROM perTipo;

SELECT * FROM administrador;

SELECT * FROM seccao;

SELECT * FROM pergunta;

SELECT * FROM resposta;

SELECT * FROM relaciona;

SELECT * FROM possui;

SELECT * FROM da;

SELECT * FROM associadaapergunta;

SELECT * FROM questionario;

SELECT * FROM tem;

SELECT * FROM edita;

SELECT * FROM ao;

select * from questionario;

(SELECT * FROM classificado);


-- Mostrar o user mais novo --
SELECT uti_nome as Nome , uti_idade as Min_age
FROM utilizador
WHERE uti_idade = 18;



-- Devolve todos os utilizadores que são homens --
SELECT uti_nome as Nome 
FROM utilizador
WHERE uti_genero = 'M';



-- Devolve o Email de cada utilizador com Id menor que 20 --
SELECT uti_nome as Nome, uti_email as Email 
FROM utilizador
WHERE uti_id <=20
GROUP BY uti_email;



-- Devolve a data de nascimento do User com Id menor que 20 --
SELECT uti_id as ID , uti_nome as Nome , uti_dnsc as Birthday
FROM utilizador
WHERE uti_id <=20
GROUP BY uti_dnsc;



-- Devolve os Users que respoderam "Sim" a uma pergunta --
SELECT uti_nome as Nome
FROM utilizador
WHERE uti_id
IN (SELECT res_uti_id FROM resposta WHERE res_string = 'Sim');

-- Devolve os Users com classificação igual ou menor a 2 -- 
SELECT uti_nome as Nome
FROM utilizador
WHERE uti_id 
IN (SELECT cla_uti_id FROM classificado WHERE cla_esc_id <= 2);

-- Devolve os Users com classificação igual a 5 --
SELECT uti_nome as Nome
FROM utilizador
WHERE uti_id 
IN (SELECT cla_uti_id FROM classificado WHERE cla_esc_id = 5);

-- Devolve os Users com classificação igual a 3 --
SELECT uti_nome as Nome
FROM utilizador
WHERE uti_id 
IN (SELECT cla_uti_id FROM classificado WHERE cla_esc_id = 3);

-- Devolve os concelhos dos Users com Id menor ou igual a 20 -- 
SELECT cod_concelho as Concelho
FROM codigopostal
WHERE cod_id IN (SELECT uti_cod_id FROM utilizador WHERE uti_id <= 20);


-- Devolve o número da porta de cadar User com Id maior ou igual a 9 --
SELECT cod_nrporta as NrPorta
FROM codigopostal
WHERE cod_id IN (SELECT uti_cod_id FROM utilizador WHERE uti_id >= 9);




