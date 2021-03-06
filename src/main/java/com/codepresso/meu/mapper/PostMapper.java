package com.codepresso.meu.mapper;

import com.codepresso.meu.vo.Likes;
import com.codepresso.meu.vo.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {

    // test
    List<Post> findAll();
    List<Post> findByFeed(@Param("id") Integer id);
    List<Post> findByPage(@Param("limit") Integer limit);
    List<Post> findByExplore();

    Post findOne(@Param("id") Integer id);
    Integer save(@Param("post") Post post);
    Integer update(@Param("post") Post post);
    Integer delete(@Param("id") Integer id);
    List<Post> getMyPosts(@Param("userId") Integer userId);

    List<Likes> likesOfPost(@Param("postId") Integer postId);
    List<Likes> likesOfUser(@Param("userId") Integer userId);

    Integer insertLike(@Param("postId") Integer postId, @Param("userId") Integer userId);
    Integer deleteLike(@Param("postId") Integer postId, @Param("userId") Integer userId);
    Integer countPostLiker(@Param("postId") Integer postId);
    Integer checkLike(@Param("postId") Integer postId, @Param("userId") Integer userId);

    Integer saveFeed(@Param("userId") Integer userId, @Param("postId") Integer postId);
    List<Post> getFeed(@Param("userId") Integer userId);
    List<Post> findFeedByPage(@Param("userId") Integer userId, @Param("limit") Integer limit);
  
    List<Post> findTrending(@Param("limit") Integer limit);

}
