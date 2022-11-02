package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.vo.JangSo;
import com.bitcamp.gabojago.vo.JangSoReview;
import com.bitcamp.gabojago.vo.JangSoReviewAttachedFile;

import java.util.List;


public interface JangSoReviewService {

  //void add(Recommendation recommendation) throws Exception;

  //boolean update(Recommendation recommendation) throws Exception;

  //Recommendation get(int no) throws Exception;

  //boolean delete(int no) throws Exception;

  List<JangSoReview> jangSoReviewList(int recono) throws Exception;

//  JangSo jangSo (int recono) throws Exception;

  JangSoReviewAttachedFile getAttachedFile(int fileNo) throws Exception;

  boolean deleteAttachedFile(int fileNo) throws Exception;


}