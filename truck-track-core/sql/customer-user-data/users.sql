
INSERT INTO `tt_customer` (`id`, `name`, `contact_person`, `ref_country_code`, `address`, `city`, `postcode`, `telephone`, `email`, `memo`, `status`) VALUES 
('28ecb305-bee8-434d-8fc7-715f6ad7a8d0', 'Polet d.o.o', 'Milan Jocic', 'RS', 'Glavicki put bb', 'Paracin', '35250', '+381 (0)35 8 566 566', 'office@poletparacin.com', '', 1),
('d3e99255-9d68-4dd0-a2ad-15e3eb222641', 'Alfa Prime d.o.o', 'Jovan Prokic', 'RS', 'Dunavska 49', 'Beograd', '11000', '+381 (0)11 257 3824', 'office@alfaprime.com', '', 1),
('e9a4f7dd-8efc-4992-a11e-97d3a4e70cb3', 'Geo Invest d.o.o', 'Dragan Jovanovic', 'RS', 'Zrenjaninski put bb', 'Beograd', '11000', '+381 (0)60 131 64 64', 'office@geo-invest.com', '', 1),
('d46ea5ef-e348-416b-aebd-d82ef0397f0e', 'Milsped d.o.o', 'Petar Strugar', 'RS', 'Savski nasip 7', 'Beograd', '11070', '+381 (0)11 20 15 100', 'office@milsped.com', '', 1),

('1b80fc2a-3023-424e-88c0-18a034bebe89', 'WorldFreight GmbH', 'Jurgen Kohl', 'AT', 'Schlossenhofstarsse 65', 'Graz', '43316', '+43 5687464', 'office@ultraspeed.at', '', 1),
('fe579ff7-8e19-4878-ad3d-a85c0b58e68c', 'Schenker AG', 'Martin Schultz', 'AT', 'Berghoffgasse 2', 'Wien', '43101', '+43 10125454', 'office@dsv-road.at', '', 1),
('9adc8945-e5e2-4328-abd7-9675315b60a8', 'CargoBull Schmitz AG', 'Uli Holz', 'AT', 'Mittelweg 32', 'Salzburg', '43221', '+43 22197755', 'office@cargobull-schmitz.at', '', 1),
('3b3824a7-7ac5-494c-996b-0a360908d848', 'Cargo partner Gmbh', 'Axel Banacki', 'AT', 'Hochstrasse 54', 'Wien', '43151', '+43 15196875', 'office@cargopartner.at', '', 1),

('63070ccb-7a69-486d-8bbe-603013703a8f', 'LKW Walter Gmbh', 'Heinrich Muller', 'DE', 'Wasserstrasse 8', 'Munchen', '80151', '+44 808077213', 'office@lkw-walter.de', '', 1),
('c792f97b-0ac9-43da-b7d6-37232f62e729', 'Intermove GmbH', 'Gerd Drolh', 'DE', 'Riemerstrasse 22', 'Nurnberg', '53242', '+44 505066617', 'office@intermove.de', '', 1),
('6e731794-7042-4602-a886-4093c4c468d2', 'Brandl Transport GmbH', 'Johan Dietmann', 'DE', 'Kirchstrasse 47', 'Stuttgart', '476646', '+44 474069717', 'office@brandltrans.de', '', 1),
('1feeea3e-6e12-474c-a740-e59aef4faa65', 'Gateway Cargo Systems GmbH', 'Markus Grohe', 'DE', 'Baumgartenstrasse 71', 'Hamburg', '35760', '+44 3576062760', 'office@gatewaycargo.de', '', 1);

INSERT INTO `tt_user` (`id`, `ref_customer_id`, `first_name`, `last_name`, `username`, `password`, `terms_accepted`, `deadline`, `access`) VALUES 
('b644a231-086e-4d37-a49c-b76edff6b158', '28ecb305-bee8-434d-8fc7-715f6ad7a8d0', 'Milan', 'Jocic', 'milan', 'c5983e484db0b621516387b3e50af84020b214c0', 0, '2020-12-12 00:00:00', 0),
('55a9d5be-e09b-4787-867b-e9f3eb4120a1', 'd3e99255-9d68-4dd0-a2ad-15e3eb222641', 'Jovan', 'Prokic', 'jovan', '0a5aa8b5cc8edc9a93228608c30f1e68639f7000', 0, '2020-12-12 00:00:00', 0),
('a71be6b3-8e70-4143-8f6a-296933405de1', 'e9a4f7dd-8efc-4992-a11e-97d3a4e70cb3', 'Dragan', 'Jovanovic', 'dragan', '93bd06f2538d3e1d33c643fb4393d8448b81d611', 0, '2020-12-12 00:00:00', 0),
('eef15e86-4cf3-47c1-be2b-d0f203d0a700', 'd46ea5ef-e348-416b-aebd-d82ef0397f0e', 'Petar', 'Strugar', 'petar', '60b10b2e264e52742e352def31dffa82c6d6a7fc', 0, '2020-12-12 00:00:00', 0),

('14553532-4490-4b77-92df-a3e1c7e82f68', '1b80fc2a-3023-424e-88c0-18a034bebe89', 'Jurgen', 'Kohl', 'jurgen', '6c769ca3981f421eb697e4385a1e533eb9c5d001', 0, '2020-12-12 00:00:00', 0),
('703eff90-f2a8-4823-8881-f06522dd75b9', 'fe579ff7-8e19-4878-ad3d-a85c0b58e68c', 'Martin', 'Schultz', 'martin', '54669547a225ff20cba8b75a4adca540eef25858', 0, '2020-12-12 00:00:00', 0),
('5e7db64c-d162-4745-b804-7121b93e9f61', '9adc8945-e5e2-4328-abd7-9675315b60a8', 'Uli', 'Holz', 'uli', '5e2de4d5026564827edbc016673ca420588c4240', 0, '2020-12-12 00:00:00', 0),
('09ddf32c-cbc1-4cba-9d1c-1d6714d8af1a', '3b3824a7-7ac5-494c-996b-0a360908d848', 'Axel', 'Banacki', 'axel', '86057438fbc6889b91f258c30d1da4db8d71d7c8', 0, '2020-12-12 00:00:00', 0),

('09dde8d1-303a-4f57-8e75-7673a25f1078', '63070ccb-7a69-486d-8bbe-603013703a8f', 'Heinrich', 'Muller', 'heinrich', 'baa1a147bb0739be005ca72b1c87115593442c44', 0, '2020-12-12 00:00:00', 0),
('71e57699-d3c5-480c-bce0-3655e76f93e2', 'c792f97b-0ac9-43da-b7d6-37232f62e729', 'Gerd', 'Drolh', 'gerd', '087ae13aa9024dd32f97adba60e0a79fd8442519', 0, '2020-12-12 00:00:00', 0),
('96c2c4a6-c94b-40f7-9404-623e6e5ea5bf', '6e731794-7042-4602-a886-4093c4c468d2', 'Johan', 'Dietmann', 'johan', '759412786bc533369b22377bf83fb9056c5b25b2', 0, '2020-12-12 00:00:00', 0),
('746baf6a-1adf-44a6-ab74-d09afeda3134', '1feeea3e-6e12-474c-a740-e59aef4faa65', 'Markus', 'Grohe', 'markus', '300a2d193222dd0c23d880e16d727d352b404a01', 0, '2020-12-12 00:00:00', 0);