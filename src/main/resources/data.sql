insert into User(userId, email, userName, password, profileImg, birthDate, gender, videoSet, NotificationSet, nickname, introduce)
values (1, 'bpaulo0@skyrock.com', 'Beryle Paulo', 'xqiOzMID', 'http://dummyimage.com/246x100.png/cc0000/ffffff', '2021-11-22', false, true, false, 'Rhea americana', 'Energique, Inc.');
insert into User(userId, email, userName, password, profileImg, birthDate, gender, videoSet, NotificationSet, nickname, introduce)
values (2, 'snieass1@delicious.com', 'Stefa Nieass', 'JzOSMD', 'http://dummyimage.com/163x100.png/ff4444/ffffff', '2022-10-21', false, true, false, 'Mazama gouazoubira', 'Skin Alive, Ltd.');
insert into User(userId, email, userName, password, profileImg, birthDate, gender, videoSet, NotificationSet, nickname, introduce)
values (3, 'acrush2@nhs.uk', 'Arlen Crush', 'MRLEpJo', 'http://dummyimage.com/216x100.png/cc0000/ffffff', '2022-03-11', true, true, true, 'Cervus unicolor', 'Philosophy, Inc.');


insert into Post(postId, userId, content)
values (1, 1, 'BB&T Corporation');
insert into Post(postId, userId, content)
values (2, 1, 'Deutsche Bank AG');
insert into Post(postId, userId, content)
values (3, 2, 'FlexShopper, Inc.');
insert into Post(postId, userId, content)
values (4, 2, 'Innovative Industrial Properties, Inc.');
insert into Post(postId, userId, content)
values (5, 3, 'Rite Aid Corporation');
insert into Post(postId, userId, content)
values (6, 3, 'Summer Infant, Inc.');

Insert into Comment values (2, 2, 1, 'hi two', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (1, 2, 1, 'hi one', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (3, 3, 1, 'hi three', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (4, 1, 2, 'yes one', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (5, 2, 2, 'yes two', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (6, 3, 2, 'yes three', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (7, 1, 3, 'wow one', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (8, 2, 3, 'wow two', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
