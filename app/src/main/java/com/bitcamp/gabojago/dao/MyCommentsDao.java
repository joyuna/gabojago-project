package com.bitcamp.gabojago.dao;

import com.bitcamp.gabojago.vo.ExhibitionReview;
import com.bitcamp.gabojago.vo.JangComment;
import com.bitcamp.gabojago.vo.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MyCommentsDao {

    // 코스추천 댓글
    List<JangComment> myRecommendationCommentsList(String id);

    // 전시회 댓글
    List<ExhibitionReview> myExhibitionCommentsList(String id);

    // paging_게시물 총개수
    int count();

    // 게시물 목록 + paging
    List<ExhibitionReview> myExhibitionReviewListPage(@Param("displayPost") int displayPost, @Param("size") int size, @Param("id") String id);

}
