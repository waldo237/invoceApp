-- SQL Manager Lite for PostgreSQL 5.9.4.51539
-- ---------------------------------------
-- Host      : localhost
-- Database  : postgres
-- Version   : PostgreSQL 10.5 on x86_64-pc-mingw64, compiled by gcc.exe (Rev5, Built by MSYS2 project) 4.9.2, 64-bit



SET check_function_bodies = false;
--
-- Definition for function paramd5 (OID = 33583) : 
--
SET search_path = public, pg_catalog;
CREATE FUNCTION public.paramd5 (
)
RETURNS trigger
AS 
$body$
DECLARE
  SES record;
BEGIN
	SELECT INTO SES idsession, fecha FROM public.session 
    WHERE  idsession = NEW.idsession;
    UPDATE public.session
    SET 
     md5code = md5(SES::varchar)
    WHERE 
      idsession = NEW.idsession;
  RETURN NEW;  
END;
$body$
LANGUAGE plpgsql;
--
-- Definition for function setDur (OID = 33651) : 
--
CREATE FUNCTION public."setDur" (
)
RETURNS trigger
AS 
$body$
DECLARE
inicio date;
final date;
BEGIN
  UPDATE public.session
    SET 
     tiempo = session.fecha::integer - session.duracion::integer
    WHERE 
      idsession = OLD.idsession;
      RETURN NEW; 
END;
$body$
LANGUAGE plpgsql;
--
-- Structure for table productos (OID = 16384) : 
--
CREATE TABLE public.productos (
    idproducto varchar(10) NOT NULL,
    descripcion varchar(20) NOT NULL,
    cantidad integer DEFAULT 0,
    precio numeric(15,2) DEFAULT 0,
    costo numeric(15,2) DEFAULT 0,
    tax numeric(9,2) DEFAULT 0,
    ultima_fecha_venta timestamp without time zone
)
WITH (oids = false);
--
-- Structure for table cliente (OID = 16395) : 
--
CREATE TABLE public.cliente (
    idcliente serial NOT NULL,
    nombre varchar(20),
    direccion varchar(30)
)
WITH (oids = false);
--
-- Structure for table orden (OID = 16403) : 
--
CREATE TABLE public.orden (
    no_orden serial NOT NULL,
    fecha timestamp without time zone DEFAULT now(),
    idcliente integer NOT NULL,
    comentario text
)
WITH (oids = false);
--
-- Structure for table orden_detalle (OID = 16413) : 
--
CREATE TABLE public.orden_detalle (
    no_orden integer NOT NULL,
    idproducto varchar NOT NULL,
    cantidad integer DEFAULT 0 NOT NULL,
    precio numeric(15,2) DEFAULT 0 NOT NULL,
    costo numeric(15,2) DEFAULT 0 NOT NULL,
    tax numeric(15,2) DEFAULT 0 NOT NULL,
    detalleid serial NOT NULL
)
WITH (oids = false);
--
-- Structure for table user (OID = 33561) : 
--
CREATE TABLE public."user" (
    iduser serial NOT NULL,
    name varchar(20) NOT NULL,
    password varchar(10)
)
WITH (oids = false);
--
-- Structure for table session (OID = 33571) : 
--
CREATE TABLE public.session (
    idsession serial NOT NULL,
    md5code varchar,
    fecha time(0) with time zone DEFAULT now(),
    iduser integer NOT NULL,
    duracion time(0) without time zone
)
WITH (oids = false);
--
-- Data for table public.productos (OID = 16384) (LIMIT 0,9)
--
INSERT INTO productos (idproducto, descripcion, cantidad, precio, costo, tax, ultima_fecha_venta)
VALUES ('P001', 'MOUSE PAD', 34, 25.00, 20.00, 10.00, '2018-12-02 23:20:35.010804');

INSERT INTO productos (idproducto, descripcion, cantidad, precio, costo, tax, ultima_fecha_venta)
VALUES ('A423', 'AUDIFONOS GRANDES', 20, 130.00, 190.00, 18.00, '2018-12-01 01:05:21.784952');

INSERT INTO productos (idproducto, descripcion, cantidad, precio, costo, tax, ultima_fecha_venta)
VALUES ('T009', 'CARGADOR USB', 0, 150.00, 100.00, 18.00, NULL);

INSERT INTO productos (idproducto, descripcion, cantidad, precio, costo, tax, ultima_fecha_venta)
VALUES ('D534', 'PROTECTOR PANTALLA', 97, 123.50, 68.75, 18.00, '2018-11-16 15:35:16.690468');

INSERT INTO productos (idproducto, descripcion, cantidad, precio, costo, tax, ultima_fecha_venta)
VALUES ('H123', 'FORROS DE CELULAR', 93, 50.00, 38.50, 19.00, '2018-09-24 17:31:47.766711');

INSERT INTO productos (idproducto, descripcion, cantidad, precio, costo, tax, ultima_fecha_venta)
VALUES ('F435', 'CARGADOR BATERIA', 37, 100.00, 65.50, 18.00, '2018-09-26 18:35:16.696593');

INSERT INTO productos (idproducto, descripcion, cantidad, precio, costo, tax, ultima_fecha_venta)
VALUES ('adsf', 'MOCHILA GRANDE', 18, 800.00, 500.00, 18.00, '2018-12-01 01:05:21.804954');

INSERT INTO productos (idproducto, descripcion, cantidad, precio, costo, tax, ultima_fecha_venta)
VALUES ('K001', 'BATERIA LITIO S4', 15, 500.00, 400.00, 18.00, '2018-12-01 01:10:34.821857');

INSERT INTO productos (idproducto, descripcion, cantidad, precio, costo, tax, ultima_fecha_venta)
VALUES ('R123', 'AUDIFONOS BLUETOOTH', 0, 200.00, 180.00, 15.00, NULL);

--
-- Data for table public.cliente (OID = 16395) (LIMIT 0,9)
--
INSERT INTO cliente (idcliente, nombre, direccion)
VALUES (1, 'Almacenes Perez', 'Santiago');

INSERT INTO cliente (idcliente, nombre, direccion)
VALUES (2, 'MiniMarket Rossy', 'La Vega');

INSERT INTO cliente (idcliente, nombre, direccion)
VALUES (3, 'MiniMarket Perez', 'Moca');

INSERT INTO cliente (idcliente, nombre, direccion)
VALUES (4, 'Tienda Maria', 'La Vega');

INSERT INTO cliente (idcliente, nombre, direccion)
VALUES (5, 'Tienda Julian & Asoc', 'Moca');

INSERT INTO cliente (idcliente, nombre, direccion)
VALUES (6, 'Tienda La Opera', 'Santiago');

INSERT INTO cliente (idcliente, nombre, direccion)
VALUES (7, 'La Sirena', 'Santiago');

INSERT INTO cliente (idcliente, nombre, direccion)
VALUES (10, 'Almacenes Mendez', 'Santiago Rodriguez');

INSERT INTO cliente (idcliente, nombre, direccion)
VALUES (9, 'Tienda 20 y 10', 'Cienfuegos, Santiago');

--
-- Data for table public.orden (OID = 16403) (LIMIT 0,12)
--
INSERT INTO orden (no_orden, fecha, idcliente, comentario)
VALUES (24, '2018-09-24 16:40:08.671452', 3, 'Esta es la ultima y la primera venta');

INSERT INTO orden (no_orden, fecha, idcliente, comentario)
VALUES (25, '2018-09-24 17:07:51.602567', 5, 'esta es la segunda venta probando los updates de las fechas.');

INSERT INTO orden (no_orden, fecha, idcliente, comentario)
VALUES (26, '2018-09-24 17:12:58.525122', 5, '');

INSERT INTO orden (no_orden, fecha, idcliente, comentario)
VALUES (27, '2018-09-24 17:15:34.642051', 10, 'esta es otra compra');

INSERT INTO orden (no_orden, fecha, idcliente, comentario)
VALUES (28, '2018-09-24 17:17:26.814467', 6, 'a las 5 17');

INSERT INTO orden (no_orden, fecha, idcliente, comentario)
VALUES (29, '2018-09-24 17:31:47.599701', 10, 'venta a Almacenes Mendez');

INSERT INTO orden (no_orden, fecha, idcliente, comentario)
VALUES (31, '2018-11-16 15:35:16.586462', 5, '');

INSERT INTO orden (no_orden, fecha, idcliente, comentario)
VALUES (32, '2018-11-29 23:51:15.789061', 5, '');

INSERT INTO orden (no_orden, fecha, idcliente, comentario)
VALUES (33, '2018-11-30 18:29:14.525543', 4, '');

INSERT INTO orden (no_orden, fecha, idcliente, comentario)
VALUES (34, '2018-12-01 01:05:21.554939', 4, 'Esta es una factora hecha en diciembre');

INSERT INTO orden (no_orden, fecha, idcliente, comentario)
VALUES (35, '2018-12-01 01:10:34.754853', 4, 'otra factura de diciembre');

INSERT INTO orden (no_orden, fecha, idcliente, comentario)
VALUES (36, '2018-12-02 23:20:34.890797', 4, '');

--
-- Data for table public.orden_detalle (OID = 16413) (LIMIT 0,19)
--
INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (24, 'D534', 5, 123.50, 68.75, 111.15, 1);

INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (24, 'A423', 3, 130.00, 190.00, 70.20, 2);

INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (24, 'T009', 7, 150.00, 100.00, 189.00, 3);

INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (25, 'D534', 12, 123.50, 68.75, 266.76, 4);

INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (25, 'K001', 2, 500.00, 400.00, 180.00, 5);

INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (26, 'adsf', 5, 800.00, 500.00, 720.00, 6);

INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (26, 'A423', 1, 130.00, 190.00, 23.40, 7);

INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (26, 'A423', 1, 130.00, 190.00, 23.40, 8);

INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (27, 'P001', 10, 25.00, 20.00, 45.00, 9);

INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (27, 'F435', 10, 100.00, 65.50, 180.00, 10);

INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (28, 'K001', 1, 500.00, 400.00, 90.00, 11);

INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (29, 'H123', 1, 50.00, 38.50, 9.00, 12);

INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (29, 'H123', 1, 50.00, 38.50, 9.00, 13);

INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (31, 'D534', 1, 123.50, 68.75, 22.23, 14);

INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (33, 'A423', 1, 130.00, 190.00, 23.40, 15);

INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (34, 'A423', 1, 130.00, 190.00, 23.40, 16);

INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (34, 'adsf', 1, 800.00, 500.00, 144.00, 17);

INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (35, 'K001', 1, 500.00, 400.00, 90.00, 18);

INSERT INTO orden_detalle (no_orden, idproducto, cantidad, precio, costo, tax, detalleid)
VALUES (36, 'P001', 1, 25.00, 20.00, 4.50, 19);

--
-- Data for table public."user" (OID = 33561) (LIMIT 0,2)
--
INSERT INTO "user" (iduser, name, password)
VALUES (1, 'waldo', '12345');

INSERT INTO "user" (iduser, name, password)
VALUES (2, 'carlos', '12345');

--
-- Data for table public.session (OID = 33571) (LIMIT 0,39)
--
INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (8, '573c14680b4a5991b4803f4f6fc76b21', '11:17:24-04', 1, '11:17:24');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (9, '7d0a113276422a9be18468190d09cc06', '11:30:16-04', 1, '11:30:16');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (10, '831c5ccb0058e3b604dcbd642b3161da', '11:47:06-04', 1, '11:47:06');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (11, '5d8b784b040bc1aa2012553d49e2bc33', '11:55:41-04', 1, '11:55:41');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (40, '0df8b698919b2fbac3ca7feaa711df9b', '09:07:35-04', 2, '09:07:35');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (41, '765ebd06f82f96b2c0cc13f58c9d0008', '09:10:02-04', 2, '09:10:02');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (42, '5bae6ddb1f4a52b8ebde71273c929160', '09:18:59-04', 2, '09:18:59');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (43, 'b51f2bc2e33a31e8b52258ea0fa9e8ed', '09:36:54-04', 2, '09:38:56');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (44, '6b7f6d6e56a27af770280900f75bc570', '09:45:31-04', 1, '09:45:31');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (45, '8d21ceca79ee50d5ae2248771815647d', '09:48:47-04', 2, '09:48:47');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (46, 'e9e135aff2bf5e09901e84eff09c39d8', '09:52:07-04', 2, '09:52:07');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (47, '0af046b7a65df1249d52c9eb9cc0592b', '09:56:53-04', 2, '09:56:53');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (17, 'aba9cdc96c49f4e4e8eba1b557fcd037', NULL, 1, '15:14:29');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (48, '433afaf53f2a26be94d2332ece848eff', '19:02:37-04', 2, '19:02:37');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (18, '81025ad3469ca341efe9ff00eaf2c518', '15:16:56-04', 1, '15:18:08');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (19, 'c3373d52abdcaf0c4f5d73ed299b1c9b', '15:42:00-04', 1, '15:42:00');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (20, 'c7715420598b8195e846658bb89f3ef4', '15:48:04-04', 1, '15:48:04');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (21, '3782f2646a174e830d958a4c08ae1d79', '15:52:48-04', 1, '15:52:48');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (22, 'bbc1f6f64c0bf9915337c1bcb67e0bbb', '15:55:45-04', 1, '15:55:45');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (49, '493481fe3afeb99904dfef64cffe6346', '19:07:42-04', 1, '19:07:42');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (23, '194726140faa345ff710f39e14bd3052', '16:03:28-04', 1, '16:28:02');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (24, 'f257b934979e864aa4051f634ae0f3ed', '16:32:00-04', 1, '16:32:00');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (25, 'd98a6de4d3293f3fc6bdce8ccae873ef', '16:33:42-04', 1, '16:33:42');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (26, '07954951fc1e866f17d5b72eb7bd5b87', '16:35:47-04', 1, '16:35:47');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (27, 'c070b48fff26ff203867c01bfb97ccc1', '18:33:03-04', 1, '18:33:03');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (28, 'c6fc8c0ebc8794cb7ae952745a42bd7b', '18:56:12-04', 1, '18:56:12');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (29, 'bd8849ef3d02b6d2532bc8126a575286', '19:05:58-04', 1, '19:06:35');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (30, 'edf8b3bdec9855872383d3e30ae4f1e9', '20:45:11-04', 1, '20:45:47');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (50, '9bedbd47c138ba8b37cfa1976ec289e4', '20:49:37-04', 2, '20:52:14');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (31, 'ea380b84f0ed5cbc908aea4806aeb079', '20:54:32-04', 1, '20:55:49');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (32, '4991d641824acb3a1ae6993f88c4a478', '20:59:53-04', 1, '20:59:53');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (33, '86776ec41538d35f0553ad4e59473dff', '21:16:08-04', 1, '21:16:08');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (51, 'dda12cc33293687525f2879787d44a2b', '14:54:48-04', 1, '14:54:48');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (34, 'f2c9642a4f8e990827408f36bc4457e5', '21:22:52-04', 1, '21:24:06');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (36, 'a98e43b2f03c17866f9c03d2dad09990', '23:15:42-04', 1, '23:15:42');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (52, '2ae23e45a2cb2a31eae7724807cdba75', '14:56:47-04', 2, '14:56:47');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (37, 'ad8413716a8ce929abf42f29e022264d', '23:19:36-04', 2, '23:20:45');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (38, 'db932286df742c623a0d3544ba9dbe5f', '01:34:27-04', 2, '01:34:27');

INSERT INTO session (idsession, md5code, fecha, iduser, duracion)
VALUES (39, '606a3dc356e4f8142ee7da9ff97c48e4', '01:38:44-04', 2, '01:38:48');

--
-- Definition for index productos_pkey (OID = 16391) : 
--
ALTER TABLE ONLY productos
    ADD CONSTRAINT productos_pkey
    PRIMARY KEY (idproducto);
--
-- Definition for index cliente_pkey (OID = 16399) : 
--
ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_pkey
    PRIMARY KEY (idcliente);
--
-- Definition for index orden_pkey (OID = 16411) : 
--
ALTER TABLE ONLY orden
    ADD CONSTRAINT orden_pkey
    PRIMARY KEY (no_orden);
--
-- Definition for index orden_detalle_pkey (OID = 33550) : 
--
ALTER TABLE ONLY orden_detalle
    ADD CONSTRAINT orden_detalle_pkey
    PRIMARY KEY (detalleid);
--
-- Definition for index user_pkey (OID = 33565) : 
--
ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_pkey
    PRIMARY KEY (iduser);
--
-- Definition for index user_name_key (OID = 33567) : 
--
ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_name_key
    UNIQUE (name);
--
-- Definition for index session_pkey (OID = 33576) : 
--
ALTER TABLE ONLY session
    ADD CONSTRAINT session_pkey
    PRIMARY KEY (idsession);
--
-- Definition for index session_fk (OID = 33627) : 
--
ALTER TABLE ONLY session
    ADD CONSTRAINT session_fk
    FOREIGN KEY (iduser) REFERENCES "user"(iduser) ON UPDATE CASCADE ON DELETE CASCADE;
--
-- Definition for trigger session_tr (OID = 33586) : 
--
CREATE TRIGGER session_tr
    AFTER INSERT ON session
    FOR EACH ROW
    EXECUTE PROCEDURE paramd5 ();
--
-- Data for sequence public.cliente_idcliente_seq (OID = 16393)
--
SELECT pg_catalog.setval('cliente_idcliente_seq', 10, true);
--
-- Data for sequence public.orden_no_orden_seq (OID = 16401)
--
SELECT pg_catalog.setval('orden_no_orden_seq', 36, true);
--
-- Data for sequence public.orden_detalle_detalleid_seq (OID = 33547)
--
SELECT pg_catalog.setval('orden_detalle_detalleid_seq', 19, true);
--
-- Data for sequence public.user_iduser_seq (OID = 33559)
--
SELECT pg_catalog.setval('user_iduser_seq', 2, true);
--
-- Data for sequence public.session_idsession_seq (OID = 33569)
--
SELECT pg_catalog.setval('session_idsession_seq', 52, true);
--
-- Comments
--
COMMENT ON SCHEMA public IS 'standard public schema';
