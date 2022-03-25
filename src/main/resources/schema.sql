DROP TABLE IF EXISTS Comment;
DROP TABLE IF EXISTS Likes;
DROP TABLE IF EXISTS Regram;
DROP TABLE IF EXISTS Tag;
DROP TABLE IF EXISTS Contact;
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Post;
DROP TABLE IF EXISTS UserSession;
DROP TABLE IF EXISTS Follow;
DROP TABLE IF EXISTS tagPostMapping;
DROP TABLE IF EXISTS Feed;
DROP TABLE IF EXISTS deletePost;
DROP TABLE IF EXISTS Trending;
DROP TABLE IF EXISTS Explore;

CREATE TABLE `Comment` (
    `commentId`	    int PRIMARY KEY AUTO_INCREMENT,
    `userId`	    int	NOT NULL,
    `postId`	    int	NOT NULL,
    `content`	    text NULL,
    `updatedAt`	    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `createdAt`	    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `Likes` (
    `likesId`	    int	PRIMARY KEY AUTO_INCREMENT,
    `postId`	    int	NOT NULL,
    `userId`	    int	NOT NULL,
    `createdAt`	    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `Regram` (
    `regramId`	    int	PRIMARY KEY AUTO_INCREMENT,
    `userId`	    int	NOT NULL,
    `postId`  	    int	NOT NULL,
    `createdAt`	    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `Tag` (
    `tagId`	        int	PRIMARY KEY AUTO_INCREMENT,
    `content`       varchar(100) NOT NULL,
    `mapId`	        int	NOT NULL,
    `tagCount`	    int	NOT NULL DEFAULT 1,
    `weekCount`	    int	NOT NULL DEFAULT 0
);

CREATE TABLE `Contact` (
    `contactId`	    int	PRIMARY KEY AUTO_INCREMENT,
    `userName`	    varchar(50)	NOT NULL,
    `phoneNumber`	varchar(20)	NOT NULL,
    `content`	    varchar(200) NOT NULL,
    `createdAt`	    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `User` (
    `userId`	    int	PRIMARY KEY AUTO_INCREMENT,
    `email`	        varchar(100) NOT NULL,
    `userName`	    varchar(50)	 NULL,
    `password`	    varchar(200) NOT NULL,
    `profileImg`	varchar(200) NULL,
    `birthDate`	    datetime NULL,
    `gender`	    int	NOT NULL DEFAULT 0,
    `videoSet`	    int	NOT NULL	DEFAULT 0,
    `notificationSet`	int	NOT NULL DEFAULT 0,
    `createdAt`	    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`	    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `nickname`	    varchar(100) NOT NULL,
    `introduce`	    varchar(200) NULL
);

CREATE TABLE `Post` (
    `postId`	    int	PRIMARY KEY AUTO_INCREMENT,
    `userId`	    int	NOT NULL,
    `content`	    text NULL,
    `createdAt`	    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`	    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `imgUrl`	    varchar(255) NOT NULL
);

CREATE TABLE `UserSession` (
    `sessionId`	    int	PRIMARY KEY AUTO_INCREMENT,
    `userId`	    int	NULL,
    `updatedAt`	    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE `Follow` (
    `followId`      int NOT NULL,
    `userId`	    int	NOT NULL
);

CREATE TABLE `tagPostMapping` (
    `mapId`	        int	PRIMARY KEY AUTO_INCREMENT,
    `tagId`	        int	NOT NULL,
    `postId`	    int	NOT NULL
);

CREATE TABLE `Feed` (
    `feedId`	    int	PRIMARY KEY AUTO_INCREMENT,
    `userId`	    int	NOT NULL,
    `postId`	    int	NOT NULL,
    `createdAt`	    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `deletePost` (
    `deletePostId`	int	PRIMARY KEY AUTO_INCREMENT,
    `userId`	    int	NULL,
    `postId`	    int	NOT NULL,
    `content`	    text NULL,
    `createdAt`	    datetime NULL,
    `updatedAt`	    datetime NULL,
    `deletedAt`	    datetime NULL
);

CREATE TABLE `Trending` (
    `trendId`	    int	PRIMARY KEY AUTO_INCREMENT,
    `postId`	    int	NOT NULL,
    `createdAt`	    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `Explore` (
    `exploreId`	    int	PRIMARY KEY AUTO_INCREMENT,
    `tagId`	        int	NOT NULL,
    `createdAt`	    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
);