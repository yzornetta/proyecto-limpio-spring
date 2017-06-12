--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE IF NOT EXISTS `proyecto` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `horasEstimadas` int(11) NOT NULL,
  `horasReales` int(11) NOT NULL,
  `porcentajeAvance` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

ALTER TABLE `proyecto`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `proyecto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
