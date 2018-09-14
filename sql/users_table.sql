USE `classicmodels`;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `token` varchar(50),
  `tokenExpirationDate` datetime,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into users (id, username, password, token, tokenExpirationDate)
values (1, 'Test1', 'test1@mytest.com', null, null);

insert into users (id, username, password, token, tokenExpirationDate)
values (2, 'Test2', 'test2@mytest.com', null, null);
