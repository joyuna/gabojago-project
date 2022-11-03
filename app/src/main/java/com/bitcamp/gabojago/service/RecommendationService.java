package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.vo.JangSoReview;
import com.bitcamp.gabojago.vo.Recommendation;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;


public interface RecommendationService {

  void add(JangSoReview jangSoReview) throws Exception;

  boolean update(Recommendation recommendation) throws Exception;

  //Recommendation get(int no) throws Exception;

  //boolean delete(int no) throws Exception;

  List<Recommendation> recommendationList() throws Exception;

  //AttachedFile getAttachedFile(int fileNo) throws Exception;

  //boolean deleteAttachedFile(int fileNo) throws Exception;


}