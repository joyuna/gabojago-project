package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.dao.MyCommentsDao;
import com.bitcamp.gabojago.vo.ExhibitionReview;
import com.bitcamp.gabojago.vo.JangComment;
import com.bitcamp.gabojago.vo.Notice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyCommentsServiceImpl implements MyCommentsService {

    MyCommentsDao myCommentsDao;

    public MyCommentsServiceImpl(MyCommentsDao myCommentsDao) {
        this.myCommentsDao = myCommentsDao;
    }

    // 코스추천 댓글
    @Override
    public List<JangComment> myRecommendationCommentsList(String id) throws Exception {
        return myCommentsDao.myRecommendationCommentsList(id);
    }

    // 전시회 댓글
    @Override
    public List<ExhibitionReview> myExhibitionCommentsList(String id) throws Exception {
        return myCommentsDao.myExhibitionCommentsList(id);
    }

    // paging_게시물 총개수
    @Override
    public int count() throws Exception {
        return myCommentsDao.count();
    }

    // 게시물 목록 + paging
    @Override
    public List<ExhibitionReview> myExhibitionReviewListPage(int displayPost, int size, String id) throws Exception {
        return myCommentsDao.myExhibitionReviewListPage(displayPost, size, id);
    }
}
