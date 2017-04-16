# appFX
-------
```sql
CREATE SCHEMA `Project` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
```
-------
```sql
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `email` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
```
