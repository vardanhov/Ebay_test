
INSERT INTO Doc_Type ( version, code, name) VALUES(  0, '10', 'Паспорт иностранного гражданина');
INSERT INTO Doc_Type ( version, code, name) VALUES(  0, '13', 'Удостоверение беженца');
INSERT INTO Doc_Type ( version, code, name) VALUES(  0, '21', 'Паспорт гражданина Российской Федерации');
INSERT INTO Doc_Type ( version, code, name) VALUES(  0, '07', 'Военный билет');
INSERT INTO Doc_Type ( version, code, name) VALUES(  0, '15', 'Разрешение на временное проживание в Российской Федерации');


INSERT INTO Country ( version, code, name) VALUES (  0, '007', 'Российская Федерация');
INSERT INTO Country ( version, code, name) VALUES (  0, '374', 'Республика Армения');
INSERT INTO Country ( version, code, name) VALUES (  0, '375', 'Республика Беларусь');
INSERT INTO Country ( version, code, name) VALUES (  0, '804', 'Украина' );
INSERT INTO Country ( version, code, name) VALUES (  0, '995', 'Республика Грузия' );



INSERT INTO Organization ( version, name, full_name, inn, kpp, address, phone, is_active)
VALUES( 0, 'МТС','MTS', '3489692561','6468461','Москва, Ленинский пр 3', '+7(495)6515165', TRUE);
INSERT INTO Organization ( version, name, full_name, inn, kpp, address, phone, is_active)
VALUES( 0, 'Мегафон',   'Мегафон',   '9454561561',  '546868994',   'Москва, Рублевская 12', '+7(495)6548989', TRUE);
INSERT INTO Organization ( version, name, full_name, inn, kpp, address, phone, is_active)
VALUES( 0, 'Ростелеком', 'Ростелеком', '748984944', '284651817',  'Москва, Тверская 25', '+7(495)4949498', TRUE);
INSERT INTO Organization ( version, name, full_name, inn, kpp, address, phone, is_active)
VALUES( 0, 'Газпром', 'Газпром', '56448949', '49849899',  'Москва, Дмитровская 60', '+7(495)6548494', TRUE);



INSERT INTO Office ( version, name, address, phone, is_active, org_id)
VALUES ( 0, 'Мегафон  офис № 1', 'Россия, Москава', '+7(495)4862578', TRUE, 2);
INSERT INTO Office ( version, name, address, phone, is_active, org_id)
VALUES ( 0, 'Мегафон  офис № 2','Россия, Москава', '+7(495)4862578', TRUE, 2);
INSERT INTO Office ( version, name, address, phone, is_active, org_id)
VALUES ( 0, 'МТС  офис № 1', 'Россия, Москава', '+7(495)4862578', TRUE, 1);
INSERT INTO Office ( version, name, address, phone, is_active, org_id)
VALUES ( 0, 'МТС  офис № 1', 'Россия, Москава', '+7(495)4862578', TRUE, 1);




INSERT INTO Document ( version, number, date, doc_type_id)
VALUES(  0, '65161651', '24.04.2003',3);
INSERT INTO Document ( version, number, date, doc_type_id)
VALUES(  0, '51948946', '16.06.2008',3);
INSERT INTO Document ( version, number, date, doc_type_id)
VALUES(  0, '51151657', '18.07.2000',3);
INSERT INTO Document ( version, number, date, doc_type_id)
VALUES(  0, '51515155', '12.05.2010',3);
INSERT INTO Document ( version, number, date, doc_type_id)
VALUES(  0, '51515155', '22.02.2009',3);
INSERT INTO Document ( version, number, date, doc_type_id)
VALUES(  0, '51515155', '17.11.2007',3);



INSERT INTO User ( version, first_name, second_name, middle_name, position, phone,  country_id, office_id, is_identified)
 VALUES( 0, 'Антон', 'Иванов', 'Сергеевич', 'Менеджер', '+7(926)6844881',  1, 1, TRUE);
INSERT INTO User ( version, first_name, second_name, middle_name, position, phone,  country_id, office_id, is_identified)
 VALUES( 0, 'Артем', 'Смирнов', 'Дмитриевич', 'Бухгалтер', '+7(926)6468723',  1, 2, TRUE);
INSERT INTO User ( version, first_name, second_name, middle_name, position, phone,  country_id, office_id, is_identified)
 VALUES( 0, 'Кирилл', 'Кузнецов', 'Иванович', 'Экономист', '+7(926)1355489',  1, 1, TRUE);
INSERT INTO User ( version, first_name, second_name, middle_name, position, phone,  country_id, office_id, is_identified)
 VALUES( 0, 'Сергей', 'Попов', 'Борисович', 'Юрист', '+7(926)7845569', 1, 2, TRUE);
 INSERT INTO User ( version, first_name, second_name, middle_name, position, phone,  country_id, office_id, is_identified)
 VALUES( 0, 'Владимир', 'Новиков', 'Николаевич', 'охраник', '+7(926)8948948', 1, 1, TRUE);
 INSERT INTO User ( version, first_name, second_name, middle_name, position, phone,  country_id, office_id, is_identified)
 VALUES( 0, 'Олег', 'Лебедев', 'Степанович', 'директор', '+7(926)4999523', 1, 2, TRUE);

