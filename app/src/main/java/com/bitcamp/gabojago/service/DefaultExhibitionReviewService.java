package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.dao.ExhibitionReviewDao;
import com.bitcamp.gabojago.vo.ExhibitionReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultExhibitionReviewService implements ExhibitionReviewService {
  @Autowired
  ExhibitionReviewDao exhibitionReviewDao;

  public List<ExhibitionReview> exhibitionReviewList(int exno) throws Exception {
    return exhibitionReviewDao.exhibitionReviewList(exno);
  }

}
