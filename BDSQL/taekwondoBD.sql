--Tabla de Usuario con los atributos username, password y tipo de usuario
--Llave primaria username. No puede haber NULL en ninguno de los
--atributos.
CREATE TABLE `usuario` (
  `username` varchar(20) NOT NULL,
  `password` varchar(45) NOT NULL,
  `tipo_usuario` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--Tabla para alumno, llave primaria id_alumno autoincrementable,
--llave foránea username que referencia a un usuario, puede ser NULL.
CREATE TABLE `alumno` (
  `id_Alumno` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `a_paterno` varchar(50) NOT NULL,
  `a_materno` varchar(50) DEFAULT NULL,
  `fotografia` blob NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `seguro_medico` varchar(50) NOT NULL,
  `certificado_medico` blob NOT NULL,
  `carta_responsiva` blob NOT NULL,
  `actividad` varchar(45) NOT NULL,
  `grado` varchar(45) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_Alumno`),
  KEY `alumnofk1_idx` (`username`),
  CONSTRAINT `alumnofk1` FOREIGN KEY (`username`) REFERENCES `usuario` (`username`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--Tabla para evento, llave primaria id_evento autoincrementable,
CREATE TABLE `evento` (
  `id_evento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `fecha_inicio` datetime NOT NULL,
  `fecha_fin` datetime NOT NULL,
  `costo` double NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`id_evento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--Tabla para examen, llave primaria id_examen autoincrementable
CREATE TABLE `examen` (
  `id_examen` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `costo` double NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `fecha` datetime NOT NULL,
  `actividad` varchar(45) NOT NULL,
  `grado` varchar(45) NOT NULL,
  PRIMARY KEY (`id_examen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--Tabla para tipo_evento, llave primaria id_tipo autoincrementable.
CREATE TABLE `tipo_evento` (
  `id_tipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--Tabla participa que nos indica que alumnos participan en que evento.
--Solo tiene dos atributos, ambos llaves foráneas.
CREATE TABLE `participa` (
  `id_alumno` int(11) NOT NULL,
  `id_evento` int(11) NOT NULL,
  KEY `participafk1_idx` (`id_alumno`),
  KEY `participafk2_idx` (`id_evento`),
  CONSTRAINT `participafk1` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_alumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `participafk2` FOREIGN KEY (`id_evento`) REFERENCES `evento` (`id_evento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--Tabla presentar que nos indica que alumnos han presentado que examenes.
--Solo tiene dos tributos, ambos llaves foráneas.
CREATE TABLE `presentar` (
  `id_alumno` int(11) NOT NULL,
  `id_examen` int(11) NOT NULL,
  KEY `presentarfk1_idx` (`id_alumno`),
  KEY `presentarfk2_idx` (`id_examen`),
  CONSTRAINT `presentarfk1` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_alumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `presentarfk2` FOREIGN KEY (`id_examen`) REFERENCES `examen` (`id_examen`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--Tabla relacionar que nos indica que actividades están presentes o se
--relacionan con qué eventos.
--Cuenta con un atributo que es llave foránea.
CREATE TABLE `relacionar` (
  `id_evento` int(11) NOT NULL,
  `actividad` varchar(45) NOT NULL,
  KEY `relacionarfk1_idx` (`id_evento`),
  CONSTRAINT `relacionarfk1` FOREIGN KEY (`id_evento`) REFERENCES `evento` (`id_evento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--Tabla tener que nos indica que tipod de eventos tenemos en un evento.
--Cuenta con dos atributos, ambos llaves foráneas.
CREATE TABLE `tener` (
  `id_tipo` int(11) DEFAULT NULL,
  `id_evento` int(11) NOT NULL,
  KEY `tenerfk1_idx` (`id_tipo`),
  KEY `tenerfk2_idx` (`id_evento`),
  CONSTRAINT `tenerfk1` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_evento` (`id_tipo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tenerfk2` FOREIGN KEY (`id_evento`) REFERENCES `evento` (`id_evento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci