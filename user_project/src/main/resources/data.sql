
INSERT INTO Doc_Type (id, version, code, name) VALUES( 1, 0, '10', 'Passport of a foreign citizen');
INSERT INTO Doc_Type (id, version, code, name) VALUES( 2, 0, '13', 'Refugee certificate');
INSERT INTO Doc_Type (id, version, code, name) VALUES( 3, 0, '21', 'Passport of the russian federation');
INSERT INTO Doc_Type (id, version, code, name) VALUES( 4, 0, '07', 'Military identity card');


INSERT INTO Country (id, version, code, name) VALUES ( 1, 0, '007', 'Russia');
INSERT INTO Country (id, version, code, name) VALUES ( 2, 0, '374', 'Armenia');
INSERT INTO Country (id, version, code, name) VALUES ( 3, 0, '375', 'Belarus');
INSERT INTO Country (id, version, code, name) VALUES ( 4, 0, '804', 'Ukraine' );



INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
VALUES(1, 0, 'MTS',       'MTS ',     '333333333',   '777777777',    'Moscow', '+555555555', TRUE);
INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
VALUES(2, 0, 'Megafon',   'Megafon',   '1111111111',  '555555555',   'Ufa',   '+1111111', TRUE);
INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
VALUES(3, 0, 'Rostelecom', 'Rostelecom', '2222222222', '666666666',  'Sochi', '+2222222', TRUE);




INSERT INTO Office (id, version, name, address, phone, is_active, org_id)
VALUES (1, 0, 'Megafon  first office', 'Russia, Ufa', '+444444444444', TRUE, 1);
INSERT INTO Office (id, version, name, address, phone, is_active, org_id)
VALUES (2, 0, 'Megafon  second office','Russia, Ufa', '+111111111111', TRUE, 1);
INSERT INTO Office (id, version, name, address, phone, is_active, org_id)
VALUES (3, 0, 'Megafon  third office', 'Russia, Ufa', '+333333333333', TRUE, 1);





INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone,  country_id, office_id, is_identified)
 VALUES(1, 0, 'firstName1', 'secondName1', 'middleName1', 'manager', '11111',  1, 1, TRUE);
INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone,  country_id, office_id, is_identified)
 VALUES(2, 0, 'firstName2', 'secondName2', 'middleName2', 'security', '22222',  1, 2, TRUE);
INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone,  country_id, office_id, is_identified)
 VALUES(3, 0, 'firstName3', 'secondName3', 'middleName3', 'economist', '55555',  1, 3, TRUE);
INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone,  country_id, office_id, is_identified)
 VALUES(4, 0, 'firstName3', 'secondName3', 'middleName3', 'accountant', '444444',  1, 3, TRUE);



INSERT INTO Document (id, version, number, date, doc_type_id)
VALUES( 1, 0, '651616516', '2008-06-03',2);
INSERT INTO Document (id, version, number, date, doc_type_id)
VALUES( 2, 0, '5194894', '2011-05-08',2);
INSERT INTO Document (id, version, number, date, doc_type_id)
VALUES( 3, 0, '51151657', '2006-03-07',2);
INSERT INTO Document (id, version, number, date, doc_type_id)
VALUES( 4, 0, '51515155', '2006-03-07',2);