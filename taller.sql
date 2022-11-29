-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-11-2022 a las 04:19:42
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `taller`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bicicleta`
--

CREATE TABLE `bicicleta` (
  `numero_serie` bigint(20) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `color` varchar(20) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `borrado` tinyint(1) NOT NULL,
  `marca` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `bicicleta`
--

INSERT INTO `bicicleta` (`numero_serie`, `tipo`, `color`, `id_cliente`, `id`, `borrado`, `marca`) VALUES
(789567, 'Cromada', 'Roja', 1, 1, 0, 'Cannondale'),
(786794, 'Comun', 'Azul', 2, 2, 0, 'Specialized'),
(789565, 'Carreras', 'Marron', 1, 4, 0, 'Trek'),
(783537, 'Cromada', 'Blanco', 3, 5, 1, 'Cannondale'),
(735578, 'Comun', 'Gris', 4, 6, 0, 'Specialized'),
(735453, 'Cromada', 'Azul', 4, 7, 0, 'Cannondale'),
(746553, 'Carreras', 'Negro', 5, 8, 0, 'Trek');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `dni` bigint(20) NOT NULL,
  `domicilio` varchar(50) NOT NULL,
  `celular` bigint(20) NOT NULL,
  `id` int(11) NOT NULL,
  `borrado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`nombre`, `apellido`, `dni`, `domicilio`, `celular`, `id`, `borrado`) VALUES
('Carlos', 'Gaston', 45768563, 'La punta', 266435646, 1, 0),
('Ailen', 'Bustillos', 6457348, 'San Luis', 266468649, 2, 0),
('Ezequiel', 'Sosa', 44752756, 'San Luis', 266433930, 3, 0),
('Martin', 'Panelo', 5457434, 'San Luis', 266456746, 4, 0),
('Marcos', 'Lopez', 6574634, 'La Punta', 266455664, 5, 0),
('Pedro', 'Sosa', 67464363, 'Villa Mercedes', 266478954, 6, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `item_detalle`
--

CREATE TABLE `item_detalle` (
  `id_detalle` int(11) NOT NULL,
  `id_reparacion` int(11) NOT NULL,
  `id_repuesto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `suma_precios` double DEFAULT NULL COMMENT 'Valor de repuesto por cantidad de repuesto',
  `borrado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `item_detalle`
--

INSERT INTO `item_detalle` (`id_detalle`, `id_reparacion`, `id_repuesto`, `cantidad`, `suma_precios`, `borrado`) VALUES
(4, 2, 1, 2, NULL, 1),
(6, 7, 1, 2, 9000, 0),
(8, 4, 6, 2, NULL, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reparacion`
--

CREATE TABLE `reparacion` (
  `id` int(11) NOT NULL,
  `id_bicicleta` int(11) NOT NULL,
  `id_servicio` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL COMMENT '(1 = Resuelto, 0 = pendiente)',
  `precio_final` double DEFAULT NULL COMMENT '15% iva',
  `fecha_entrada` date NOT NULL,
  `borrado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reparacion`
--

INSERT INTO `reparacion` (`id`, `id_bicicleta`, `id_servicio`, `estado`, `precio_final`, `fecha_entrada`, `borrado`) VALUES
(2, 1, 1, 1, NULL, '2022-11-14', 0),
(3, 2, 2, 0, NULL, '2022-10-19', 0),
(4, 4, 1, 0, NULL, '2022-11-17', 0),
(5, 5, 6, 0, NULL, '2022-10-12', 1),
(6, 7, 5, 0, NULL, '2022-11-17', 0),
(7, 5, 1, 0, 17000, '2022-11-17', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `repuesto`
--

CREATE TABLE `repuesto` (
  `numero_serie` bigint(20) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `precio` double NOT NULL,
  `id` int(11) NOT NULL,
  `borrado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `repuesto`
--

INSERT INTO `repuesto` (`numero_serie`, `nombre`, `descripcion`, `precio`, `id`, `borrado`) VALUES
(75234, 'Pedal', 'Pedales para la bicicleta', 4500, 1, 0),
(76567, 'Cadena', 'Cadena para bicicletas', 2450.69, 2, 0),
(34534, 'Manubrios', 'Manubrios para bicicleta', 20000, 4, 1),
(54554, 'Frenos', 'Frenos para bicicleta', 12000, 5, 0),
(74854, 'Ruedas', 'Ruedas para bicicletas', 800, 6, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `codigo` int(11) NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  `costo` double NOT NULL,
  `id` int(11) NOT NULL,
  `borrado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`codigo`, `descripcion`, `costo`, `id`, `borrado`) VALUES
(10, 'Cambio de partes', 700, 1, 0),
(9, 'Limpieza', 2500, 2, 0),
(5, 'Ajustes de tornillos', 500, 3, 0),
(4, 'Engrasar bicicleta', 1000, 5, 1),
(2, 'Inflar ruedas', 200, 6, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bicicleta`
--
ALTER TABLE `bicicleta`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `numero_serie` (`numero_serie`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `item_detalle`
--
ALTER TABLE `item_detalle`
  ADD PRIMARY KEY (`id_detalle`),
  ADD KEY `id_reparacion` (`id_reparacion`),
  ADD KEY `id_repuesto` (`id_repuesto`);

--
-- Indices de la tabla `reparacion`
--
ALTER TABLE `reparacion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_bicicleta` (`id_bicicleta`),
  ADD KEY `reparacion_ibfk_2` (`id_servicio`);

--
-- Indices de la tabla `repuesto`
--
ALTER TABLE `repuesto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `numero_serie` (`numero_serie`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo` (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bicicleta`
--
ALTER TABLE `bicicleta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `item_detalle`
--
ALTER TABLE `item_detalle`
  MODIFY `id_detalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `reparacion`
--
ALTER TABLE `reparacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `repuesto`
--
ALTER TABLE `repuesto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bicicleta`
--
ALTER TABLE `bicicleta`
  ADD CONSTRAINT `bicicleta_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`);

--
-- Filtros para la tabla `item_detalle`
--
ALTER TABLE `item_detalle`
  ADD CONSTRAINT `item_detalle_ibfk_1` FOREIGN KEY (`id_reparacion`) REFERENCES `reparacion` (`id`),
  ADD CONSTRAINT `item_detalle_ibfk_2` FOREIGN KEY (`id_repuesto`) REFERENCES `repuesto` (`id`);

--
-- Filtros para la tabla `reparacion`
--
ALTER TABLE `reparacion`
  ADD CONSTRAINT `reparacion_ibfk_1` FOREIGN KEY (`id_bicicleta`) REFERENCES `bicicleta` (`id`),
  ADD CONSTRAINT `reparacion_ibfk_2` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
