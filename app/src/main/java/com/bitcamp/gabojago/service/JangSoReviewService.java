package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.vo.RecAttachedFile;
import com.bitcamp.gabojago.vo.Recommendation;

import java.util.List;


public interface JangSoReviewService {

  //void add(Recommendation recommendation) throws Exception;

  //boolean update(Recommendation recommendation) throws Exception;

  //Recommendation get(int no) throws Exception;

  //boolean delete(int no) throws Exception;

  //List<Recommendation> list() throws Exception;

  RecAttachedFile getAttachedFile(int fileNo) throws Exception;

  boolean deleteAttachedFile(int fileNo) throws Exception;


}