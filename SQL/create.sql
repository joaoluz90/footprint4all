/************************************************************
*	Grupo: 3   |  Curso: L-IG
*	Grupo: 3   |  Curso: L-IG
*  	UC: Bases de Dados
*
*	Pojeto: Footprint4all
*
*  	Nome: André Costa (20190933)
*  	Nome: João Luz (20190798)
*
************************************************************/
drop database if exists footprint4all;
Create database footprint4all;

use footprint4all;

/************************************************************
*  Lista de Entidades Informaconais Primárias
************************************************************/

Create Table Formulario (
	form_id int auto_increment,
    form_data date not null,
    form_nome varchar(50) default 'Formulário',
    primary key (form_id));
    
Create Table CodigoPostal (
	cod_id int auto_increment,
    cod_nrporta int not null,
    cod_concelho varchar(50) not null,
    cod_localidade varchar(50) not null,
    cod_distrito varchar(50) not null,
    primary key (cod_id));
    
Create Table Escala (
	esc_id int auto_increment,
    esc_valor int not null,
    esc_desc varchar(20) not null,
    primary key(esc_id),
    check (esc_valor>0 and esc_valor<=5),
    check ((esc_valor = 1 and esc_desc = 'Muito poluidor') or (esc_valor = 2 and esc_desc = 'Poluidor') or (esc_valor = 3 and esc_desc = 'Razoável') or (esc_valor = 4 and esc_desc = 'Pouco Poluidor') or (esc_valor = 5 and esc_desc = 'Ambientalista')));
    
    
Create Table ResTipo (
	resTipo_id int auto_increment,
    resTipo_nome varchar(50) not null,
    primary key(resTipo_id),
    constraint chk_resTipo check (resTipo_nome = 'Múltipla' or resTipo_nome = 'Verdadeiro ou Falso' or resTipo_nome = 'Extensa'));
    
Create Table PerTipo (
	perTipo_id int auto_increment,
    perTipo_nome varchar(50) not null,
    primary key(perTipo_id),
    constraint chk_perTipo check (perTipo_nome = 'Múltipla' or perTipo_nome = 'Verdadeiro ou Falso' or perTipo_nome = 'Extensa'));
    
    
/************************************************************
*  Lista de Entidades Informaconais com FK
************************************************************/

Create Table Utilizador (
	uti_id int auto_increment, 
    uti_nome varchar(100) not null, 
    uti_email varchar(50) not null, 
    uti_dnsc date not null,
    uti_morada varchar(100) not null, 
    uti_genero char not null,
    uti_idade int,
    uti_naci varchar(50) not null,
    uti_cod_id int not null unique,
    primary key (uti_id),
    foreign key(uti_cod_id) references CodigoPostal (cod_id),
    check (uti_idade >= 18),
    check (uti_naci = 'portuguesa'));
    
    
Create Table Administrador (
	admi_id int auto_increment,
    admi_datainicio datetime not null,
    admi_datafinal datetime not null,
    admi_uti_id int not null unique,
    primary key (admi_id),
    foreign key(admi_uti_id) references Utilizador (uti_id));
	
Create Table Seccao (
	sec_id int auto_increment,
    sec_nome varchar(50) default 'Geral',
    primary key(sec_id));
    
Create Table Pergunta (
	per_id int auto_increment,
    per_string varchar(100) not null,
    per_perTipo_id int not null unique,
    primary key(per_id),
    foreign key(per_perTipo_id) references PerTipo (perTipo_id));
    
Create Table Resposta (
	res_id int auto_increment,
    res_string varchar(100) default 'Sem resposta',
    res_data date,
    res_resTipo_id int not null unique,
    res_uti_id int not null unique,
    res_quest_id int not null unique,
    primary key(res_id),
    foreign key(res_resTipo_id) references restipo (resTipo_id),
    foreign key(res_uti_id) references Utilizador (uti_id));
    

/************************************************************
*  Lista de Entidades de Associação 
************************************************************/

Create Table relaciona (
	rel_uti_id int not null unique,
    rel_admi_id int not null unique,
    primary key(rel_uti_id, rel_admi_id),
    foreign key(rel_uti_id) references Utilizador (uti_id),
    foreign key(rel_admi_id) references Administrador (admi_id));
    
Create Table possui (
	pos_uti_id int not null unique,
    pos_cod_id int not null unique,
    primary key(pos_uti_id, pos_cod_id),
    foreign key(pos_uti_id) references Utilizador (uti_id),
    foreign key(pos_cod_id) references CodigoPostal (cod_id));
    
    
Create Table da(
	da_uti_id int not null unique,
    da_res_id int not null unique,
    primary key(da_uti_id, da_res_id),
    foreign key(da_uti_id) references Utilizador (uti_id),
    foreign key(da_res_id) references Resposta (res_id));
    
Create Table Questionario (
	quest_id int auto_increment,
	quest_per_id int not null unique,
    quest_sec_id int not null unique,
    quest_form_id int not null unique,
    primary key(quest_id),
    foreign key(quest_sec_id) references Seccao(sec_id),
    foreign key(quest_per_id) references Pergunta(per_id),
    foreign key(quest_form_id) references Formulario(form_id));
	
    
Create Table edita (
	edi_id int not null auto_increment,
    edi_data datetime,
    edi_admi_id int not null unique,
    edi_form_id int not null unique,
    primary key(edi_id),
    foreign key(edi_admi_id) references Administrador (admi_id),
    foreign key(edi_form_id) references Formulario (form_id));
    
Create Table classificado (
	cla_data datetime,
    cla_uti_id int not null,
    cla_esc_id int not null,
    primary key(cla_uti_id, cla_esc_id),
    foreign key(cla_uti_id) references Utilizador (uti_id),
    foreign key(cla_esc_id) references Escala (esc_id));
    

alter table Resposta add foreign key(res_quest_id) references Questionario(quest_id);
    
    