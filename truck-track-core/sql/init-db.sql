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

CREATE TABLE `tt_cargo` (
  `id` varchar(36) NOT NULL,
  `published` timestamp,
  `deadline` timestamp,
  `ref_country_code_from` varchar(2),
  `city_from` varchar(255),
  `postcode_from` varchar(255),
  `ref_country_code_to` varchar(2),
  `city_to` varchar(255),
  `postcode_to` varchar(255),
  `dim_length` decimal(5,1),
  `dim_weight` decimal(5,1),
  `vehicle_type` tinyint(5),
  `ref_customer_id` varchar(36),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `tt_vehicle` (
  `id` varchar(36) NOT NULL,
  `published` timestamp,
  `deadline` timestamp,
  `ref_country_code_from` varchar(2),
  `city_from` varchar(255),
  `postcode_from` varchar(255),
  `ref_country_code_to` varchar(2),
  `city_to` varchar(255),
  `postcode_to` varchar(255),
  `dim_length` decimal(5,1),
  `dim_weight` decimal(5,1),
  `vehicle_type` tinyint(5),
  `ref_customer_id` varchar(36),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



