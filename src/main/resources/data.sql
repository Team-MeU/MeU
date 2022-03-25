insert into User(userId, email, userName, password, profileImg, birthDate, gender, videoSet, notificationSet, nickname, introduce)
values (1, 'jaemin@codepresso.com', 'Choi jaemin', 'asdf1', 'http://dummyimage.com/163x100.png/ff4444/ffffff', '2022-10-21', false, true, false, 'jaemin', 'Hi, My name is jaemin');
insert into User(userId, email, userName, password, profileImg, birthDate, gender, videoSet, notificationSet, nickname, introduce)
values (2, 'jiwon@codepresso.com', 'Yum jiwon', 'asdf2', 'http://dummyimage.com/216x100.png/cc0000/ffffff', '2022-03-11', true, true, true, 'jiwon', 'Hi, My name is jiwon');
insert into User(userId, email, userName, password, profileImg, birthDate, gender, videoSet, notificationSet, nickname, introduce)
values (3, 'jinsol@codepresso.com', 'Jeong jinsol', 'asdf3', 'http://dummyimage.com/206x100.png/dd0000/ffffff', '2022-03-30', true, true, true, 'jinsol', 'Hi, My name is jinsol');

insert into Post(postId, userId, content, imgUrl)
values (1, 1, 'post content 1', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post1.jpeg');
insert into Post(postId, userId, content, imgUrl)
values (2, 2, 'post content 2', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post2.jpeg');
insert into Post(postId, userId, content, imgUrl)
values (3, 3, 'post content 3', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post3.jpeg');
insert into Post(postId, userId, content, imgUrl)
values (4, 1, 'post content 4', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post4.jpeg');
insert into Post(postId, userId, content, imgUrl)
values (5, 2, 'post content 5', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post5.jpeg');
insert into Post(postId, userId, content, imgUrl)
values (6, 3, 'post content 6', 'https://webproject-meu.s3.ap-northeast-2.amazonaws.com/post6.jpeg');

Insert into Comment values (2, 2, 1, 'hi two', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (1, 2, 1, 'hi one', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (3, 3, 1, 'hi three', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (4, 1, 2, 'yes one', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (5, 2, 2, 'yes two', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (6, 3, 2, 'yes three', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (7, 1, 3, 'wow one', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into Comment values (8, 2, 4, 'wow two', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into comment values (9, 3, 5, 'wow one', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into comment values (10, 2, 6, 'test comment', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into comment values (11, 1, 7, 'test comment', '2022-03-15 18:09:42', '2022-03-15 18:09:42');
Insert into comment values (12, 2, 8, 'test comment1', '2022-03-15 18:09:22', '2022-03-15 18:09:42');
Insert into comment values (13, 3, 3, 'test comment', '2022-03-15 18:09:24', '2022-03-15 18:09:42');
Insert into comment values (14, 1, 7, 'test comment', '2022-03-15 18:09:25', '2022-03-15 18:09:42');
Insert into comment values (15, 2, 8, 'test comment2', '2022-03-15 18:09:26', '2022-03-15 18:09:42');
Insert into comment values (16, 2, 8, 'test comment3', '2022-03-15 18:09:27', '2022-03-15 18:09:42');
Insert into comment values (17, 2, 8, 'test comment4', '2022-03-15 18:09:28', '2022-03-15 18:09:42');
Insert into comment values (18, 2, 8, 'test comment5', '2022-03-15 18:09:29', '2022-03-15 18:09:42');
Insert into comment values (19, 2, 8, 'test comment6', '2022-03-15 18:09:30', '2022-03-15 18:09:42');
Insert into comment values (20, 2, 8, 'test comment7', '2022-03-15 18:09:31', '2022-03-15 18:09:42');
Insert into comment values (21, 2, 8, 'test comment9', '2022-03-15 18:09:32', '2022-03-15 18:09:42');
Insert into comment values (22, 2, 8, 'test comment10', '2022-03-15 18:09:33', '2022-03-15 18:09:42');
Insert into comment values (23, 2, 7, 'test comment11', '2022-03-15 18:09:31', '2022-03-15 18:09:42');
Insert into comment values (24, 3, 7, 'test comment12', '2022-03-15 18:09:32', '2022-03-15 18:09:42');
Insert into comment values (25, 1, 7, 'test comment13', '2022-03-15 18:09:33', '2022-03-15 18:09:42');


