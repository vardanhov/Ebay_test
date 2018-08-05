INSERT INTO Doc_Type (version, code, name) VALUES
( 0, 010, 'Паспорт иностранного гражданина'),
( 0, 013, 'Удостоверение беженца'),
( 0, 021,'Паспорт гражданина Российской Федерации');



INSERT INTO Country (version, code, name) VALUES
( 0, 007, 'Россия'),
( 0, 374, 'Армения'),
( 0, 375, 'Белоруссия');


INSERT INTO Organization (version, name, full_name, inn, kpp, address, phone, is_active) VALUES
(0, 'MTS',       'MTS ',     '333333333',   '777777777',    'Moscow', '+555555555', TRUE),
(0, 'Megafon',   'Megafon',   '1111111111',  '555555555',   'Ufa',   '+1111111', TRUE),
(0, 'Rostelecom', 'Rostelecom', '2222222222', '666666666',  'Sochi', '+2222222', TRUE);



INSERT INTO Office (version, name, address, phone, is_active, organization_id) VALUES
(0, 'Megafon  first office', 'Russia, Ufa', '+444444444444', TRUE, 2),
(0, 'Megafon  second office','Russia, Ufa', '+111111111111', TRUE, 2),
(0, 'Megafon  third office', 'Russia, Ufa', '+333333333333', TRUE, 2);




INSERT INTO User (version, first_name, second_name, middle_name, position, phone, doc_id, country_id, office_id, is_identified) VALUES
(0, 'firstName1', 'secondName1', 'middleName1', 'manager', '11111', 1, 1, 2, TRUE),
(0, 'firstName2', 'secondName2', 'middleName2', 'security', '22222', 2, 1, 2, TRUE),
(0, 'firstName3', 'secondName3', 'middleName3', 'economist', '55555', 3, 1, 2, TRUE);



INSERT INTO Document (version, number, date, doc_type_id) VALUES
( 0, '22222', '2008-06-03',1),
( 0, '55555', '2011-05-08',1),
( 0, '66666', '2006-03-07',1);