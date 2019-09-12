create table pessoa(
    idpessoa int not null auto_increment primary key,
    nomepessoa varchar(80) NOT NULL,
    email varchar(255) NOT NULL,
    cpf varchar(20) NOT NULL,
    rg varchar(20) NOT NULL,
    prontuario varchar(255),
    telefone varchar(20) NOT NULL,
    senha varchar(100) NOT NULL,
    crm varchar(100));
    
    
    insert into pessoa(nomepessoa, email, cpf, rg, prontuario, telefone, senha, crm) values ('Rogério', 'aa', '0909', '8787', 'prontuario', '000000', 'deus11234', 'sou medicaaaa');
   
    CREATE TABLE agendamento (
  codigo int PRIMARY KEY AUTO_INCREMENT,
	codigo_pessoa int NOT NULL,
	horario TIME NOT NULL,
	data DATE NOT NULL,
	sintomas VARCHAR(100) NOT NULL,
	especialista varchar (100) not null,
  FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(idpessoa)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into agendamento (codigo, codigo_pessoa, horario, data, sintomas, especialista) values (1, 1, '00:00:00', '2011-11-10', 'dores de barriga', 'clinico geral');