INSERT INTO `tt_customer` (`id`, `name`, `contact_person`, `ref_country_code`, `address`, `city`, `postcode`, `telephone`, `email`, `memo`, `status`) VALUES 
('1096edc8-c972-4abb-a43a-d2aee20678ee', 'Westum', 'Igor Milosevic', 'RS', 'Kozjacka 6', 'Beograd', '11000', '011 123456', 'office@westum.com', 'Blah', 1);

INSERT INTO `tt_user` (`id`, `ref_customer_id`, `first_name`, `last_name`, `username`, `password`, `terms_accepted`, `deadline`, `access`) VALUES 
('1096edc8-c972-4abb-a43a-d2aee20678ef', '1096edc8-c972-4abb-a43a-d2aee20678ee', 'Igor', 'Milosevic', 'admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', 0, '2020-12-12 00:00:00', 1);
