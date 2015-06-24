/* Dev branch */

CREATE TABLE `tt_customer` (
  `id` varchar(36) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `contact_person` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ref_country_code` varchar(3) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `city` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `postcode` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `telephone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `memo` text COLLATE utf8_unicode_ci,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `tt_customer` (`id`, `name`, `contact_person`, `ref_country_code`, `address`, `city`, `postcode`, `telephone`, `email`, `memo`, `status`) VALUES 
('1096edc8-c972-4abb-a43a-d2aee20678ee', 'Westum', 'Igor Milosevic', 'RS', 'Kozjacka 6', 'Beograd', '11000', '011 123456', 'office@westum.com', 'Blah', 1);


CREATE TABLE `tt_cargo` (
  `id` varchar(36) NOT NULL,
  `published` timestamp NOT NULL,
  `deadline` timestamp NOT NULL,
  `ref_country_code_from` varchar(2) NOT NULL,
  `address_from` varchar(255) NOT NULL,
  `city_from` varchar(255) NOT NULL,
  `postcode_from` varchar(255) NOT NULL,
  `ref_country_code_to` varchar(2) NOT NULL,
  `address_to` varchar(255) NOT NULL,
  `city_to` varchar(255) NOT NULL,
  `postcode_to` varchar(255) NOT NULL,
  `dim_length` double DEFAULT NULL,
  `dim_weight` double DEFAULT NULL,
  `type` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `tt_user` (
  `id` varchar(36) COLLATE utf8_unicode_ci NOT NULL,
  `ref_customer_id` varchar(36) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `terms_accepted` tinyint(4) DEFAULT NULL,
  `deadline` timestamp NOT NULL,
  `access` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `tt_user` (`id`, `ref_customer_id`, `first_name`, `last_name`, `username`, `password`, `terms_accepted`, `deadline`, `access`) VALUES 
('1096edc8-c972-4abb-a43a-d2aee20678ef', '1096edc8-c972-4abb-a43a-d2aee20678ee', 'Igor', 'Milosevic', 'admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', 0, '2020-12-12 00:00:00', 1);

