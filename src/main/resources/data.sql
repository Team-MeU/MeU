insert into User(userId, email, userName, password, profileImg, birthDate, gender, videoSet, notificationSet, nickname, introduce)
values (1, 'jaemin@codepresso.com', 'Choi jaemin', 'asdf1', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/user1.jpeg', '2022-10-21', false, true, false, 'jaemin', 'Hi, My name is jaemin');
insert into User(userId, email, userName, password, profileImg, birthDate, gender, videoSet, notificationSet, nickname, introduce)
values (2, 'jiwon@codepresso.com', 'Yum jiwon', 'asdf2', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/user2.jpeg', '2022-03-11', true, true, true, 'jiwon', 'Hi, My name is jiwon');
insert into User(userId, email, userName, password, profileImg, birthDate, gender, videoSet, notificationSet, nickname, introduce)
values (3, 'jinsol@codepresso.com', 'Jeong jinsol', 'asdf3', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/user3.jpeg', '1998-03-30', true, true, true, 'jinsol', 'Hi, My name is jinsol');
insert into User(userId, email, userName, password, profileImg, birthDate, gender, videoSet, notificationSet, nickname, introduce)
values (4, 'chapssal@codepresso.com', 'Jeong Chapssal', 'asdf4', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/user4.jpeg', '2020-11-26', false, true, false, 'chapssarry', 'Hi, My name is chapssal');
insert into User(userId, email, userName, password, profileImg, birthDate, gender, videoSet, notificationSet, nickname, introduce)
values (5, 'jingoo@codepresso.com', 'Choi Jingoo', 'asdf5', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/jingoo.png', '2020-11-26', false, true, false, 'jingoo', 'Hi, My name is jingoo');


insert into Post(postId, userId, content, imgUrl)
values (1, 1, 'post content 1', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post1.jpeg');
insert into Post(postId, userId, content, imgUrl)
values (2, 2, 'post content 2', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post2.jpeg');
insert into Post(postId, userId, content, imgUrl)
values (3, 3, 'ㅋ기아가 야구를 또 졌다. 6이닝 0자책 하고도 패전투수가 된 우리 대투수 1패는 누가 책임질 건지... 기아는 병살 치는 특훈을 받는 것이 틀림 없다. 오늘의 #패전타자 는 #김00 당신입니다.', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post3.jpeg');
insert into Post(postId, userId, content, imgUrl)
values (4, 4, '엄마 사과 빨리 깎아줘... 배고프단 말이야.... #배고파 #간식줘', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post4.jpeg');
insert into Post(postId, userId, content, imgUrl)
values (5, 1, 'post content 5', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post5.jpeg');
insert into Post(postId, userId, content, imgUrl)
values (6, 2, 'post content 6', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post6.jpeg');
insert into Post(postId, userId, content, imgUrl)
values (7, 3, '친구와 생일파티를 했다. 민증 검사를 해서 기분이 좀 좋았는데 민증과 내 얼굴을 번갈아가며 보더니 주민번호를 확인하길래 다시 기분이 나빠졌다. #너 #몇살이야', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post7.jpeg');
insert into Post(postId, userId, content, imgUrl)
values (8, 4, '이웃집 몽실이 누나는 내 마음을 알까....? 오늘도 같은 시간에 산책을 나갔는데 누나가 안 보여서 슬펐ㄷr... #몽실이누나 #미워', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post8.jpeg');
insert into Post(postId, userId, content, imgUrl)
values (9, 3, 'post content 9', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post3.jpeg');
insert into Post(postId, userId, content, imgUrl)
values (10, 1, 'post content 10', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post4.jpeg');
insert into Post(postId, userId, content, imgUrl)
values (11, 2, 'post content 11', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post5.jpeg');
insert into Post(postId, userId, content, imgUrl)
values (12, 3, 'post content 12', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post6.jpeg');
insert into Post(postId, userId, content, imgUrl)
values (13, 2, 'post content 13', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post2.jpeg');


Insert into Comment values (2, 2, 1, 'hi two', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (1, 1, 1, 'hi one', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (3, 3, 1, 'hi three', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (4, 1, 2, 'yes one', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (5, 2, 2, 'yes two', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (6, 3, 2, 'yes three', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (7, 1, 3, 'wow one', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (8, 2, 4, 'wow two', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into comment values (9, 3, 5, 'wow one', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into comment values (10, 2, 6, 'test comment', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into comment values (11, 1, 1, 'test comment', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into comment values (12, 3, 2, 'test comment1', '2022-03-15 18:09:22', '2022-03-15 18:09:42');
Insert into comment values (13, 3, 3, 'test comment', '2022-03-15 18:09:24', '2022-03-15 18:09:42');
Insert into comment values (14, 1, 4, 'test comment', '2022-03-15 18:09:25', '2022-03-15 18:09:42');
Insert into comment values (15, 1, 5, 'test comment2', '2022-03-15 18:09:26', '2022-03-15 18:09:42');
Insert into comment values (16, 2, 6, 'test comment3', '2022-03-15 18:09:27', '2022-03-15 18:09:42');
Insert into comment values (17, 3, 1, 'test comment4', '2022-03-15 18:09:28', '2022-03-15 18:09:42');
Insert into comment values (18, 2, 2, 'test comment5', '2022-03-15 18:09:29', '2022-03-15 18:09:42');
Insert into comment values (19, 1, 3, 'test comment6', '2022-03-15 18:09:30', '2022-03-15 18:09:42');
Insert into comment values (20, 3, 1, 'test comment7', '2022-03-15 18:09:31', '2022-03-15 18:09:42');
Insert into comment values (21, 2, 2, 'test comment9', '2022-03-15 18:09:32', '2022-03-15 18:09:42');
Insert into comment values (22, 1, 3, 'test comment10', '2022-03-15 18:09:33', '2022-03-15 18:09:42');
Insert into comment values (23, 2, 6, 'test comment11', '2022-03-15 18:09:31', '2022-03-15 18:09:42');
Insert into comment values (24, 3, 6, 'test comment12', '2022-03-15 18:09:32', '2022-03-15 18:09:42');
Insert into comment values (25, 1, 6, 'test comment13', '2022-03-15 18:09:33', '2022-03-15 18:09:42');


Insert into likes(postId, userId, createdAt) values (6, 1, '2022-03-15 18:09:42');
Insert into likes(postId, userId, createdAt) values (6, 2, '2022-03-15 18:09:42');
Insert into likes(postId, userId, createdAt) values (6, 3, '2022-03-15 18:09:42');
Insert into likes(postId, userId, createdAt) values (5, 1, '2022-03-15 18:09:42');
Insert into likes(postId, userId, createdAt) values (5, 2, '2022-03-15 18:09:42');
Insert into likes(postId, userId, createdAt) values (4, 3, '2022-03-15 18:09:42');
Insert into likes(postId, userId, createdAt) values (3, 2, '2022-03-15 18:09:42');


Insert into tag(tagId, content) values (1, '패전타자');
Insert into tag(tagId, content) values (2, '김00');
Insert into tag(tagId, content) values (3, '배고파');
Insert into tag(tagId, content) values (4, '간식줘');
Insert into tag(tagId, content) values (5, '너');
Insert into tag(tagId, content) values (6, '몇살이야');
Insert into tag(tagId, content) values (7, '몽실이누나');
Insert into tag(tagId, content) values (8, '미워');


Insert into tagpostmapping(tagId, postId) values (1, 3);
Insert into tagpostmapping(tagId, postId) values (2, 3);
Insert into tagpostmapping(tagId, postId) values (3, 4);
Insert into tagpostmapping(tagId, postId) values (4, 4);
Insert into tagpostmapping(tagId, postId) values (5, 7);
Insert into tagpostmapping(tagId, postId) values (6, 7);
Insert into tagpostmapping(tagId, postId) values (7, 8);
Insert into tagpostmapping(tagId, postId) values (8, 8);


