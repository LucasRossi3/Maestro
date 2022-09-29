drop table IF EXISTS tb_pessoas;
drop table IF EXISTS tb_empresas;
drop table IF EXISTS tb_parceiros;
drop table IF EXISTS tb_clientes;
drop table IF EXISTS tb_setores;
drop table IF EXISTS tb_unidades;
drop table IF EXISTS tb_moradores;

create table tb_pessoas(
	codigo int auto_increment,
    nome varchar (150) not null,
    documento_rg varchar (9),
    dococumento_cpf varchar (11),
    data_nascimento datetime,
    contato_1 varchar (11),
    contato_2 varchar (11),
    contato_3 varchar (11),
    email varchar (100),
    CONSTRAINT PRIMARY KEY  PK_tb_pessoas_codigo (codigo)
);

create table tb_empresas(
	codigo int auto_increment,
    razao_social varchar (200) not null,
    fantasia varchar (100) not null,
	cnpj varchar (15),
    inscricao_estadual varchar (11),
    data_abertura datetime,
    contato_1 varchar (11),
    contato_2 varchar (11),
    contato_3 varchar (11),
    email varchar (100),
    CONSTRAINT PRIMARY KEY PK_tb_empresas_codigo (codigo)
);
    
create table tb_parceiros(
	codigo int auto_increment,
    id varchar (2),
    CONSTRAINT PRIMARY KEY PK_tb_parceiros_codigo (codigo),
    CONSTRAINT FOREIGN KEY FK_tb_parceiros_empresa_codigo (empresa_codigo) references tb_empresas
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