CREATE TABLE `tt_city` (
  `id` varchar(36) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `postcode` varchar(36) COLLATE utf8_unicode_ci NOT NULL,
  `approved` tinyint(1) COLLATE utf8_unicode_ci NOT NULL,
  `ref_country_code` varchar(2) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

ALTER TABLE `tt_city` CHANGE `approved` `allowed` tinyint(1) COLLATE utf8_unicode_ci NOT NULL;
