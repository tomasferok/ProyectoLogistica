
INSERT INTO `db_logistica`.`categorias`
(
`nombre`)
VALUES
(
"ALIMENTOS");

INSERT INTO `db_logistica`.`categorias`
(
`nombre`)
VALUES
(
"LIMPIEZA");


INSERT INTO `db_logistica`.`categorias`
(
`nombre`)
VALUES
(
"ELECTRONICOS");


INSERT INTO `db_logistica`.`sub_categorias`
(
`nombre`)
VALUES
("GOLOSINAS");

INSERT INTO `db_logistica`.`sub_categorias`
(
`nombre`)
VALUES
("AEROSOLES");

INSERT INTO `db_logistica`.`sub_categorias`
(
`nombre`)
VALUES
("GALLETITAS");

INSERT INTO `db_logistica`.`proveedores`
(
`contacto`,
`email`,
`nombre_prov`)
VALUES
(
"Juan Gonzales",
"provedor1@gmail.com",
"Arcor ");
INSERT INTO `db_logistica`.`proveedores`
(
`contacto`,
`email`,
`nombre_prov`)
VALUES
(
"Mariano Herrera",
"provedor2@gmail.com",
"Conaprole");


INSERT INTO `db_logistica`.`tipo_productos`
(
`codigo_de_barras`,
`descripcion`,
`neto`,
`nombre`,
`precio`,
`categoria_id`,
`id_prov`,
`sub_categoria_id`)
VALUES
(
1111,
"Alfajor de maizena",
1,
"Alfajor",
10,
1,
1,
1);
INSERT INTO `db_logistica`.`tipo_productos`
(
`codigo_de_barras`,
`descripcion`,
`neto`,
`nombre`,
`precio`,
`categoria_id`,
`id_prov`,
`sub_categoria_id`)
VALUES
(
2222,
"Caramelos de chocolate",
2,
"Caramelos",
5,
1,
2,
1);

INSERT INTO `db_logistica`.`tipo_productos`
(
`codigo_de_barras`,
`descripcion`,
`neto`,
`nombre`,
`precio`,
`categoria_id`,
`id_prov`,
`sub_categoria_id`)
VALUES
(
3333,
"Helado de crema",
2,
"Helado",
15,
1,
1,
1);

INSERT INTO `db_logistica`.`clientes`
(
`ciudad`,
`direccion`,
`documento`,
`email`,
`nombre`,
`razon_social`,
`telefono`)
VALUES
(
"Montevideo",
"Italia 231",
"12222",
"cliente1@gmail.com",
"Juan Dominguez",
"Arcor S.R.L",
"099999999");

INSERT INTO `db_logistica`.`clientes`
(
`ciudad`,
`direccion`,
`documento`,
`email`,
`nombre`,
`razon_social`,
`telefono`)
VALUES
(
"Salto",
"Derechos Humanos 212",
"21111",
"cliente2@gmail.com",
"Mario Gonzales",
"Mario Gonzalez",
"099999999");

INSERT INTO `db_logistica`.`empresas`
(
`contacto`,
`documento`,
`email`,
`nom_empresa`)
VALUES
(
"Juan Contacto",
"121334",
"empresa@gmail.com",
"Empresa Metalurgica");


INSERT INTO `db_logistica`.`empresas`
(
`contacto`,
`documento`,
`email`,
`nom_empresa`)
VALUES
(
"Maria Contacto",
"12132134",
"maria@gmail.com",
"Empresa Agricola");


INSERT INTO `db_logistica`.`productos`
(
`cantidad_disponible`,
`cantidad_reservada`,
`tipo_prod_id`,
`cantidad_cuarentena`
)
VALUES
(
0,
0,
1,
0
);

INSERT INTO `db_logistica`.`productos`
(
`cantidad_disponible`,
`cantidad_reservada`,
`tipo_prod_id`,
`cantidad_cuarentena`)
VALUES
(
1,
2,
2,
0);

INSERT INTO `db_logistica`.`productos`
(
`cantidad_disponible`,
`cantidad_reservada`,
`tipo_prod_id`,

`cantidad_cuarentena`)
VALUES
(
10,
5,
3,
0);


INSERT INTO `db_logistica`.`distribuidores`
(
`chofer`,
`matricula`,
`vehiculo`)
VALUES
(
"Marcos Fernandez",
"SAF6254",
"Camion Mercedes-Benz");



INSERT INTO `db_logistica`.`usuarios`
(
`active`,
`apellido`,
`email`,
`nombre`,
`password`,
`tipo_usuario`)
VALUES
(
true,
"ADMIN",
"admin@gmail.com",
"admin",
"123456",
"ADMIN");


