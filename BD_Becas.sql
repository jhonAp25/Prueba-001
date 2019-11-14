create database BD_BECAS1;

use BD_BECAS1;


create table usuario(
usu_Id int primary key auto_increment not null,
usu_nombre varchar(40) not null,
usu_apellido varchar(40) not null,
usu_dni char(8) not null,
usu_usuario varchar(50) not null,
usu_contraseña varchar(50) not null,
usu_correo varchar(100) not null,
usu_telefono char(9) not null,
usu_sexo char(1) not null,
ciu_id int not null,
idTipoEm int not null
);

create table tipo_empleado(
idTipoEm int primary key not null,
tipoDescr varchar(20) not null
);

create table detalleBeca(
id_beca int not null ,
est_cod int not null ,
PRIMARY KEY (id_beca,est_cod)
);

create table beca(
id_beca int primary key auto_increment not null,
pat_cod int null,
inst_id int not null,
fechaRegistro date not null,
fechaInic date not null,
fechaFin date null,
estado varchar(20) not null,
usu_Id int not null);

create table estudiante(
est_cod int primary key auto_increment not null,
est_dni char(8) not null,
est_apellidos varchar(50) not null,
est_nombres varchar(50) not null,
est_sexo char(1) not null,
est_fecnac date not null,
est_direccion varchar(100) not null,
est_telefono char(9),
est_correo varchar(100) ,
dist_id int not null,
estado varchar(20) not null
);

create table patrocinador(
pat_cod int primary key auto_increment not null,
pat_dni char(8) not null,
pat_apellidos varchar(50) not null,
pat_nombre varchar(50) not null,
pat_telefono varchar(10)not null,
pat_correo varchar(100) not null,
ciu_id int not null,
estado varchar(20) not null
);

create table pais(
pais_id int primary key auto_increment not null,
pais_descripcion varchar(100)
);

create table ciudad(
ciu_id int primary key auto_increment not null,
ciu_descripcion varchar(100),
pais_id int not null
);

create table distrito(
dist_id int primary key auto_increment not null,
dist_nombre varchar(50) not null
);

create table carrera(
carre_id int primary key auto_increment not null,
carre_nombre varchar(50) not null,
inst_id int not null
);

create table institucion(
inst_id int primary key auto_increment not null,
inst_nombre varchar(50) not null,
dist_id int not null,
tip_inst_id int not null
);

create table tipo_institucion(
tip_inst_id int primary key auto_increment not null,
tip_inst_nombre varchar(50) not null
);

insert into tipo_institucion values(null,'Instituto');
insert into distrito values(null,'San Juan de Lurigancho');

/*alter table tipo_institucion drop pro_id;*/


alter table estudiante add foreign key (dist_id) references distrito (dist_id);
alter table usuario add foreign key (ciu_id) references ciudad (ciu_id);
alter table usuario add foreign key (idTipoEm) references tipo_empleado(idTipoEm);
alter table beca add foreign key (pat_cod) references patrocinador(pat_cod);
alter table beca add foreign key (inst_id) references   institucion(inst_id);
alter table beca add foreign key (usu_Id) references  usuario (usu_Id);
alter table institucion add foreign key (dist_id) references distrito (dist_id);
alter table institucion add foreign key (tip_inst_id) references tipo_institucion (tip_inst_id);
alter table carrera add foreign key (inst_id)  references institucion (inst_id);
alter table ciudad add foreign key (pais_id) references  pais (pais_id);
alter table patrocinador add foreign key(ciu_id) references ciudad (ciu_id);


delimiter $
CREATE PROCEDURE insertarEstudiante(in
_est_dni char(8) ,
_est_apellidos varchar(50) ,
_est_nombres varchar(50) ,
_est_sexo char(1) ,
_est_fecnac date ,
_est_direccion varchar(100) ,
_est_telefono char(9) ,
_est_correo varchar(100) ,
_dist_id int(11) ,
_estado varchar(20)
)
BEGIN
	insert into estudiante values(null,_est_dni,_est_apellidos,_est_nombres,_est_sexo,_est_fecnac,
    _est_direccion,_est_telefono,_est_correo,_dist_id,_estado);
END$ 
delimiter $
CREATE PROCEDURE InsertarIntitucion(in
_inst_nombre varchar(50) ,
_dist_id int(11) ,
_tip_inst_id int(11)
)
BEGIN
insert into institucion values(null,_inst_nombre,_dist_id,_tip_inst_id);
END$

call InsertarIntitucion('Idat',1,1);

call InsertarIntitucion('Zegel Ipae',1,1);
call InsertarIntitucion('Sise',1,1);
call InsertarIntitucion('Certus',1,1);
call InsertarIntitucion('Arzobispo Loayza',1,1);
call InsertarIntitucion('Daniel Alcides Carrión',1,1);
call InsertarIntitucion('Senati',1,1);
call InsertarIntitucion('Telesup',1,1);


insert into distrito values(null,'San Juan de Lurigancho');

insert into distrito values
(null,'Callao'),(null,'Bellavista'),(null,'Carmen de La Legua'),(null,'La Perla'),
(null,'La Punta'),(null,'Mi Perú'),(null,'Ventanilla'),(null,'Lima'),(null,'Ancón'),
(null,'Ate'),(null,'Barranco'),(null,'Breña'),(null,'Carabayllo'),(null,'Cieneguilla'),
(null,'Chaclacayo'),(null,'Chorrillos'),(null,'Comas'),(null,'El Agustino'),(null,'Independencia'),
(null,'Jesús María'),(null,'La Molina'),(null,'La Victoria'),(null,'Lince'),(null,'Los Olivos'),
(null,'Lurigancho'),(null,'Lurin'),(null,'Magdalena del Mar'),(null,'Miraflores'),(null,'Pachacámac'),
(null,'Pucusana'),(null,'Pueblo Libre'),(null,'Puente Piedra'),(null,'Punta Hermosa'),(null,'Punta Negre'),
(null,'Rímac'),(null,'San Bartolo'),(null,'San Borja'),(null,'San Isidro'),(null,'San Juan de Miraflores'),
(null,'San Luis'),(null,'San Martín de Porres'),(null,'San Miguel'),(null,'Santa Anita'),(null,'Santa Anita'),
(null,'Santa María del Mar'),(null,'Santa Rosa'),(null,'Santiago de Surco'),(null,'Surquillo'),
(null,'Villa El Salvador'),(null,'Villa María del Triunfo');

insert into pais values(null,'Estados Unidos');

insert into estudiante values(null,'75680099','apaza','john','M','2000-04-24','Mariscal Caceres','979680180','apazajhon@gmail.com','1','activo');

call insertarEstudiante('73016102','cordova','hansel','M','2000-11-23','Av. san hilarion','986030492','hanselc@gmail.com',1,'inactivo');

/*------------INNER JOIN DE PRUEBA----------*/
select inst_nombre as 'INSTITUO',dist_nombre AS 'DISTRITO',tip_inst_nombre AS 'TIPO DE INSTITUCIÓN' from institucion 
inner join distrito on distrito.dist_id = institucion.dist_id
inner join tipo_institucion on tipo_institucion.tip_inst_id = institucion.tip_inst_id;


insert into ciudad values
(null,'California',1),(null,'Florida',1),(null,'Texas',1),(null,'California',1),(null,'Hawai',1),(null,'Pennsylvania',1),(null,'New Jersey',1),
(null,'Arizona',1),(null,'Alabama',1),(null,'Alaska',1),(null,'Arkansas',1),(null,'California',1),(null,'Colorado',1),(null,'Connecticut',1),
(null,'North Carolina',1),(null,'South Carolina',1),(null,'North Dakota',1),(null,'South Dakota',1),(null,'Delaware',1),(null,'Florida',1),
(null,'Georgia',1),(null,'Idaho',1),(null,'Wyoming',1),(null,'Wisconsin',1),(null,'Washington',1),(null,'West Virginia',1),(null,'Vermont',1),
(null,'Utah',1),(null,'Tennessee',1),(null,'Ohio',1),(null,'Oklahoma',1),(null,'Oregon',1),(null,'New Mexico',1),(null,'New York',1),(null,'Nevada',1),
(null,'Nebraska',1),(null,'Montana',1),(null,'Misun',1); 

select * from ciudad;
select * from estudiante;


INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Administración de Empresas', '1');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Gestión de Recursos Humanos', '1');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Negocios Internacionales', '1');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Administración Bancaria', '1');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Administración de Negocios', '1');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Marketing', '1');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Contabilidad', '1');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Gestión Logística', '1');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Diseño Gráfico', '1');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Computación e Informatica', '1');

INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Diseño y Gestión de Modas', '2');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Computación e Informática', '2');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Redes y Seguridad Informática', '2');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Secretariado Ejecutivo', '2');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Gastronomía', '2');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Administración de Hoteles y Restaurantes', '2');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Comunicación Audiovisual', '2');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Periodismo Audiovisual', '2');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Enfermería', '2');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Fisioterapia y Rehabilitación', '2');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Técnica en Farmacia', '2');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Administración Bancaria y Financiera', '2');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Contabilidad', '2');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Administración de Empresas', '2');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Marketing', '2');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Administración de Negocios Internacionales', '2');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Administración Logística', '2');

INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Administración de Empresas', '3');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Administración de Negocios Bancarios y Financieros', '3');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Administración de Negocios Internacionales', '3');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Contabilidad', '3');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Marketing', '3');

INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Farmacia Técnica', '5');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Técnica en Prótesis Dental', '5');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Lab. Clínico y Anatomía Patológica', '5');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Técnica en Fisioterapia y Rehabilitación', '5');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Cosmiatría', '5');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Salud y Seguridad Ocupacional', '5');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Nutrición y Dietética', '5');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Enfermería Técnica', '5');

INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Enfermería', '4');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Farmacia', '4');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Fisioterapía', '4');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Prótesis Dental', '4');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Laboratorio Clínico', '4');

INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Administración Industrial', '6');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Electricista Industrial', '6');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Mecánico Automotriz', '6');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Desarrollo de Software', '6');

INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Administración de Empresa', '7');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Contabilidad', '7');
INSERT INTO `bd_becas1`.`carrera` (`carre_nombre`, `inst_id`) VALUES ('Sistema de Información', '7');




select * from usuario;
select * from tipo_empleado;
insert into tipo_empleado values (1,'Administrador'),(2,'Coordinadora');
insert into usuario values (null,'Josh','Bautista','74851425','JBautista','123','Bautista@gmail.com','965845875','M',5,1),
 (null,'Victoria','Bautista','74851425','VBautista','123','Bautista@gmail.com','965842355','F',5,2);
 select u.usu_nombre, u.usu_apellido, t.tipoDescr from usuario as u inner join tipo_empleado as t on u.idTipoEm= t.idTipoEm where u.usu_usuario= 'VBautista';





