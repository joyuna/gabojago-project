package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.vo.ExhibitionReview;
import com.bitcamp.gabojago.vo.JangComment;
import com.bitcamp.gabojago.vo.Notice;

import java.util.List;

public interface MyCommentsService {

    // 코스추천 댓글
    List<JangComment> myRecommendationCommentsList(String id) throws Exception;

    // 전시회 댓글
    List<ExhibitionReview> myExhibitionCommentsList(String id) throws Exception;

    // paging_게시물 총개수
    int count() throws Exception;

    // 게시물 목록 + paging
    List<ExhibitionReview> myExhibitionReviewListPage(int displayPost, int size, String id) throws Exception;

}
