CREATE TABLE `student` (
  `id_student` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `second_name` varchar(45) NOT NULL,
  `gender` varchar(3) NOT NULL,
  `birthday` datetime NOT NULL,
  `phone` varchar(12) NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY (`id_student`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `city` (
  `id_city` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(45) NOT NULL,
  `id_student` int(11) NOT NULL,
  PRIMARY KEY (`id_city`),
  KEY `FK_8srs3segbrudvv2t5201k7o1p_idx` (`id_student`),
  CONSTRAINT `FK_8srs3segbrudvv2t5201k7o1p` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `region` (
  `id_region` int(11) NOT NULL AUTO_INCREMENT,
  `region_name` varchar(45) NOT NULL,
  `id_city` int(11) NOT NULL,
  PRIMARY KEY (`id_region`),
  KEY `FK_a8m1c1e9l09xt9f7fagg1xin3` (`id_city`),
  CONSTRAINT `FK_a8m1c1e9l09xt9f7fagg1xin3` FOREIGN KEY (`id_city`) REFERENCES `city` (`id_city`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `country` (
  `id_country` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(45) NOT NULL,
  `id_region` int(11) NOT NULL,
  PRIMARY KEY (`id_country`),
  KEY `FK_pjclyhyup2wfylyv2pyojvq68` (`id_region`),
  CONSTRAINT `FK_pjclyhyup2wfylyv2pyojvq68` FOREIGN KEY (`id_region`) REFERENCES `region` (`id_region`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

