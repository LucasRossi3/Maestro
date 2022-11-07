drop table IF EXISTS tb_person;
drop table IF EXISTS tb_empresas;
drop table IF EXISTS tb_parceiros;
drop table IF EXISTS tb_clientes;
drop table IF EXISTS tb_setores;
drop table IF EXISTS tb_unidades;
drop table IF EXISTS tb_moradores;

create table tb_person(
	id int auto_increment,
	name varchar (150) not null,
	doc_rg varchar (9),
	doc_cpf varchar (11),
	birthday datetime,
	contact_1 varchar (11),
	contact_2 varchar (11),
	contact_3 varchar (11),
	email varchar (100),
	CONSTRAINT PRIMARY KEY  PK_tb_person_id (id)
);

create table tb_company(
	id int auto_increment,
	company_name varchar (200) not null,
	trading_name varchar (100) not null,
	doc_cnpj varchar (15),
	doc_inscricao_estadual varchar (11),
	company_start datetime,
	contact_1 varchar (11),
	contact_2 varchar (11),
	contact_3 varchar (11),
	email varchar (100),
	CONSTRAINT PRIMARY KEY PK_tb_company_id (id)
);
    
create table tb_partner(
	id int auto_increment,
	partner_id varchar (2),
	CONSTRAINT PRIMARY KEY PK_tb_partner_id (id),
	CONSTRAINT FOREIGN KEY FK_tb_partner_company_id (company_id) references tb_company
);

create table tb_clientes(
	codigo int,
    id varchar (4),
    tipo varchar (15),
    CONSTRAINT PRIMARY KEY PK_tb_clientes_codigo (codigo),
    CONSTRAINT CK_tb_clientes_tipo CHECK (tipo in ('RESIDENCIAL', 'COMERCIAL')),
    CONSTRAINT FOREIGN KEY FK_tb_clientes_parceiro_codigo (parceiro_codigo) references tb_parceiros,
    CONSTRAINT FOREIGN KEY FK_tb_clientes_empresa_codigo (empresa_codigo) references tb_empresas,
    CONSTRAINT FOREIGN KEY FK_tb_clientes_pessoa_codigo (pessoa_codigo) references tb_pessoas
);

create table tb_setores(
	codigo int,
    departamento varchar (30),
    setor varchar (30),
    CONSTRAINT PRIMARY KEY PK_tb_setores_codigo (codigo),
    CONSTRAINT FOREIGN KEY FK_tb_setores_cliente_codigo (cliente_codigo) references tb_clientes
);

create table tb_unidades(
	codigo int,
    unidade varchar (4),
    bloco varchar (4),
    quadra varchar (4),
    lote varchar (4),
    CONSTRAINT PRIMARY KEY PK_tb_unidades_codigo (codigo),
    CONSTRAINT FOREIGN KEY FK_tb_unidades_cliente_codigo (cliente_codigo) references tb_clientes
);

create table tb_colaboradores(
	codigo int,
    tipo varchar (30),
    permissao_autorizar CHAR default 'N',
    CONSTRAINT PRIMARY KEY PK_tb_colaboradores_codigo (codigo),
    CONSTRAINT FOREIGN KEY FK_tb_colaboradores_pessoas_codigo (pessoa_codigo) references tb_clientes,
    CONSTRAINT FOREIGN KEY FK_tb_colaboradores_setores_codigo (setor_codigo) references tb_setores,
    CONSTRAINT FOREIGN KEY FK_tb_colaboradores_unidades_codigo (unidade_codigo) references tb_unidades,
    CONSTRAINT CK_tb_colaboradores_permissao_autorizar CHECK (permissao_autorizar in ('S', 'N'))
);

create table tb_moradores(
	codigo int,
    tipo varchar (30),
    permissao_autorizar CHAR default 'N',
    CONSTRAINT PRIMARY KEY PK_tb_moradores_codigo (codigo),
    CONSTRAINT FOREIGN KEY FK_tb_moradores_pessoas_codigo (pessoa_codigo) references tb_clientes,
    CONSTRAINT FOREIGN KEY FK_tb_moradores_setores_codigo (setor_codigo) references tb_setores,
    CONSTRAINT FOREIGN KEY FK_tb_moradores_unidades_codigo (unidade_codigo) references tb_unidades,
    CONSTRAINT CK_tb_moradores_permissao_autorizar CHECK (permissao_autorizar in ('S', 'N'))
);
