package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.vo.JangSoReview;
import com.bitcamp.gabojago.vo.JangSoReviewAttachedFile;
import com.bitcamp.gabojago.vo.Member;
import com.bitcamp.gabojago.vo.Recommendation;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;


public interface RecommendationService {

  // recommendationAdd
  void recommendationAdd(Recommendation recommendation) throws Exception;

  // recommendationList
  List<Recommendation> recommendationList() throws Exception;

  // recommendationDetail - 1
  Recommendation getRecommendation(int recono) throws Exception;

  // recommendationDetail - 2
  List<JangSoReview> getJangSoReviewList(int recono) throws Exception;

  // recommendationDisable
  boolean disableRecommend(int recono) throws Exception;

  // recommendationUpdate
  void recommendationUpdate(Recommendation recommendation) throws Exception;

  // Comment Insert
  void setCntRecommendation(int recono) throws Exception;

  void recommendationReportAdd(String id, int recono, String rsn) throws Exception;

  int countReportById(String reportedId) throws Exception;

  void updateStatus(Member reportedUser) throws Exception;
}