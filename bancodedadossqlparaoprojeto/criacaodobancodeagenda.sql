create table agenda.evento (
	id_evento serial primary key not null,
	titulo_evento varchar(45),
	inicio_evento date,
	fim_evento date,
	desc_evento text,
	status_evento boolean
	);

insert into agenda.evento (titulo_evento, inicio_evento, fim_evento, desc_evento, status_evento)
values ('Primeiro teste', '2017-08-11', '2017-08-14', 'Registro gravado via comando SQL, antes de iniciar a construção do projeto da agenda.',false);

