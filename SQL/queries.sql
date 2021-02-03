-- Mostrar os utilizadores com valor menor que 2 e que sejam homens ou utilizadores com valor igual a 5 e que sejam mulheres -- 
SELECT uti_nome as Utilizador , uti_dnsc as Data_Nascimento , uti_morada as Morada , esc_desc as Descricao
FROM utilizador , escala
WHERE esc_valor < 2 AND uti_genero = 'M' OR esc_valor = 5 AND uti_genero = 'F';


-- Devolve os utilizadores que têm idade máxima classificados no valor da escala 3 --
SELECT uti_nome as Utilizador , uti_morada as Morada, uti_idade as Idade ,esc_valor as Valor , esc_desc as Descricao
FROM utilizador , escala
WHERE uti_idade = (SELECT MAX(uti_idade) FROM utilizador) AND esc_valor = 3;


-- Demonstra a última data em que foi atribuída uma classificação ao utilizador --
SELECT Utilizador.uti_nome as Nome , Classificado.cla_data as Data_classificacao
FROM utilizador 
LEFT JOIN Classificado ON Utilizador.uti_id = Classificado.cla_uti_id
ORDER BY Utilizador.uti_nome;


-- Mostrar qual a classificacao do User mais novo --
SELECT uti_nome as Nome , MIN(uti_idade) as Idade, esc_valor as Valor , esc_desc as Descricao
FROM utilizador , escala
WHERE esc_valor <= 5;


-- Mostrar a média de idades dos utilizadores para uma classificacao específica--
SELECT  AVG(uti_idade) as Media_idade , esc_valor as Valor, esc_desc as Descricao
FROM utilizador , escala
WHERE esc_valor =3;



-- Devolve os Users que respoderam "Sim" a uma pergunta --
SELECT *
FROM utilizador
WHERE uti_id
IN (SELECT res_uti_id FROM resposta WHERE res_string = 'Sim');


-- Devolve os Users com classificação igual ou menor a 2 -- 
SELECT *
FROM utilizador
WHERE uti_id 
IN (SELECT cla_uti_id FROM classificado WHERE cla_esc_id <= 2);


-- Devolve os Users com classificação igual a 5 --
SELECT *
FROM utilizador
WHERE uti_id 
IN (SELECT cla_uti_id FROM classificado WHERE cla_esc_id = 5);


-- Devolve os Users com classificação igual a 3 --
SELECT *
FROM utilizador
WHERE uti_id 
IN (SELECT cla_uti_id FROM classificado WHERE cla_esc_id = 3);


-- Devolve a idade mínima dos utilizadores com classificação de valor 1 -- 
SELECT MIN(uti_idade) as Idade_mínima 
FROM utilizador
WHERE uti_id IN (SELECT cla_uti_id FROM classificado WHERE cla_esc_id 
IN (SELECT esc_id FROM escala WHERE esc_valor = '1'));


-- Devolve a idade mínima dos utilizadores com classificação de valor 2 -- 
SELECT MIN(uti_idade) as Idade_mínima 
FROM utilizador
WHERE uti_id IN (SELECT cla_uti_id FROM classificado WHERE cla_esc_id 
IN (SELECT esc_id FROM escala WHERE esc_valor = '2'));


-- Devolve a idade mínima dos utilizadores com classificação de valor 3 -- 
SELECT MIN(uti_idade) as Idade_mínima 
FROM utilizador
WHERE uti_id IN (SELECT cla_uti_id FROM classificado WHERE cla_esc_id 
IN (SELECT esc_id FROM escala WHERE esc_valor = '3'));


-- Devolve a idade mínima dos utilizadores com classificação de valor 4 -- 
SELECT MIN(uti_idade) as Idade_mínima 
FROM utilizador
WHERE uti_id IN (SELECT cla_uti_id FROM classificado WHERE cla_esc_id 
IN (SELECT esc_id FROM escala WHERE esc_valor = '4'));


-- Devolve a idade mínima dos utilizadores com classificação de valor 5 -- 
SELECT MIN(uti_idade) as Idade_mínima 
FROM utilizador 
WHERE uti_id IN (SELECT cla_uti_id FROM classificado WHERE cla_esc_id 
IN (SELECT esc_id FROM escala WHERE esc_valor = '5'));


-- Devolve o valor médio das classificações dos Utilizadores residentes em Alfornelos -- 
SELECT AVG(esc_valor) as Valor_médio 
FROM escala
WHERE esc_id IN (SELECT cla_esc_id FROM classificado WHERE cla_uti_id 
IN (SELECT uti_id FROM utilizador WHERE uti_cod_id 
IN (SELECT cod_id FROM codigopostal WHERE cod_localidade = 'Alfornelos')));


-- Devolve o valor médio das classificações dos Utilizadores residentes na Falagueira -- 
SELECT AVG(esc_valor) as Valor_médio 
FROM escala
WHERE esc_id IN (SELECT cla_esc_id FROM classificado WHERE cla_uti_id 
IN (SELECT uti_id FROM utilizador WHERE uti_cod_id 
IN (SELECT cod_id FROM codigopostal WHERE cod_localidade = 'Falagueira')));


-- Devolve o valor médio das classificações dos Utilizadores residentes na Brandoa -- 
SELECT AVG(esc_valor) as Valor_médio 
FROM escala
WHERE esc_id IN (SELECT cla_esc_id FROM classificado WHERE cla_uti_id 
IN (SELECT uti_id FROM utilizador WHERE uti_cod_id 
IN (SELECT cod_id FROM codigopostal WHERE cod_localidade = 'Brandoa')));


-- Devolve o valor médio das classificações dos Utilizadores residentes em Laranjeiras -- 
SELECT AVG(esc_valor) as Valor_médio 
FROM escala
WHERE esc_id IN (SELECT cla_esc_id FROM classificado WHERE cla_uti_id 
IN (SELECT uti_id FROM utilizador WHERE uti_cod_id 
IN (SELECT cod_id FROM codigopostal WHERE cod_localidade = 'Laranjeiras')));


-- Devolve os utilizadores que responderam ao formulário numa data específica -- 
SELECT *
FROM utilizador
WHERE uti_id IN ( SELECT res_uti_id FROM resposta WHERE res_quest_id 
IN ( SELECT quest_id FROM questionario WHERE quest_form_id
IN (SELECT form_id FROM formulario WHERE form_data = str_to_date('2020.12.31','%Y.%m.%d'))));


DELIMITER //
DROP PROCEDURE IF EXISTS sp_utilizadores_classificacoes//

CREATE PROCEDURE sp_utilizadores_classificacoes (IN p_nValor INT)
BEGIN
	SELECT uti_id AS 'ID Utilizador', uti_nome AS Nome, uti_morada AS Morada, esc_valor AS 'Classificação', esc_desc AS 'Descrição'
    FROM utilizador INNER JOIN classificado ON uti_id = cla_uti_id
					INNER JOIN escala 		ON esc_id = cla_esc_id
    GROUP BY uti_id, uti_nome, esc_valor, esc_desc
    HAVING esc_valor = p_nValor;
    END//
DELIMITER ;

call sp_utilizadores_classificacoes(3)


DELIMITER //
DROP PROCEDURE IF EXISTS sp_adicionar_utilizador//

CREATE PROCEDURE sp_adicionar_utilizador(OUT p_id INT,
										 IN  p_nome VARCHAR(100),
                                         IN	 p_email VARCHAR(50),
                                         IN  p_dnsc  DATE,
                                         IN  p_morada VARCHAR(100),
                                         IN  p_genero CHAR,
                                         IN p_idade INT,
                                         IN  p_naci   VARCHAR(50),
                                         IN p_cod_id VARCHAR(50))
BEGIN 
	DECLARE idUti INT DEFAULT 0;
    
    SELECT uti_id INTO idUti FROM utilizador WHERE cod_localidade = p_cod_id;
    
    INSERT INTO utilizador(uti_nome, uti_email, uti_dnsc, uti_morada, uti_genero, uti_idade, uti_naci, uti_cod_id)
				    VALUES(p_nome, p_email, p_dnsc, p_morada, p_genero, p_idade, p_naci, idUti);
	SELECT last_insert_id() INTO p_id;
    SELECT p_id AS newId;
    END//
    DELIMITER ;
    
    call sp_adicionar_utilizador(@id, 'André', 'shhsdhs@gmail.com', '1999-07-22', 'Brandoa', 'M', '22', 'portuguesa', 'Falagueira');
    
    
DELIMITER //
DROP PROCEDURE IF EXISTS sp_consultar_classificacao//

CREATE PROCEDURE sp_consultar_classificacao(IN p_nID INT)
BEGIN
	SELECT uti_id AS 'ID Utilizador', uti_nome AS Nome, uti_morada AS Morada , esc_valor AS 'Classificação', esc_desc AS 'Descrição'
    FROM utilizador INNER JOIN classificado ON cla_uti_id= uti_id
					INNER JOIN escala 		ON esc_id = cla_esc_id						
					INNER JOIN resposta 	ON res_uti_id = uti_id
					INNER JOIN questionario ON res_quest_id = quest_id
                    INNER JOIN pergunta     ON quest_per_id = per_id
    GROUP BY uti_id, uti_nome, uti_morada, esc_valor, esc_desc
    HAVING uti_id = p_nID;
END//
DELIMITER ;

call sp_consultar_classificacao('6')
                                         
	

