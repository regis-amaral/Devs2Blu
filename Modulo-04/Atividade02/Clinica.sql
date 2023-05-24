CREATE TABLE public.pessoa (
	id serial primary key, 
	nome varchar not null, 
	nascimento date not null, 
	cpf char(11) not null unique, 
	data_cadastro timestamp not null, 
	endereco varchar(255), 
	telefone char(14),
	email varchar(100),
	criado_em timestamp not null,
	criado_por varchar(255) not null,
	modificado_em timestamp not null,
	modificado_por varchar(255) not null,
);

CREATE TABLE public.paciente (
	id serial primary key, 
	pessoa_id integer references public.pessoa(id), 
	tipo_sanguineo char(2), 
	data_cadastro timestamp not null, 
	sexo char(1),
	limitacao varchar(255), 
	alergia varchar(255), 
	convenio varchar(255), 
	observacoes varchar(55),
	criado_em timestamp not null,
	criado_por varchar(255) not null,
	modificado_em timestamp not null,
	modificado_por varchar(255) not null,
);

CREATE TABLE public.medico (
	id serial primary key, 
	pessoa_id integer references public.pessoa(id), 
	crm char(10) unique, 
	especialidade varchar(20),
	criado_em timestamp not null,
	criado_por varchar(255) not null,
	modificado_em timestamp not null,
	modificado_por varchar(255) not null,
);

CREATE TABLE public.enfermeiro (
	id serial primary key, 
	pessoa_id integer references public.pessoa(id), 
	coren char(10) unique,
	data_entrada date not null,
	criado_em timestamp not null,
	criado_por varchar(255) not null,
	modificado_em timestamp not null,
	modificado_por varchar(255) not null,
);

CREATE TABLE public.agendamento (
	id serial primary key,  
	paciente_id integer references public.paciente(id), 
	enfermeiro_id integer references public.enfermeiro(id),
	medico_id integer references public.medico(id), 
	data timestamp not null, 
	observacoes varchar(255),
	criado_em timestamp not null,
	criado_por varchar(255) not null,
	modificado_em timestamp not null,
	modificado_por varchar(255) not null,
);

CREATE TABLE public.prontuario (
	id serial primary key,
	paciente_id integer references public.paciente(id), 
	medico_id integer references public.medico(id), 
	data timestamp not null, 
	exames_solicitados varchar(255), 
	diagnosticos varchar(255), 
	encaminhamentos varchar(255),
	criado_em timestamp not null,
	criado_por varchar(255) not null,
	modificado_em timestamp not null,
	modificado_por varchar(255) not null,
);
