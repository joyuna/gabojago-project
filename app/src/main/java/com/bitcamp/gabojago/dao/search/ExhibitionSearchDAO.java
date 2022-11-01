package com.bitcamp.gabojago.dao.search;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExhibitionSearchDAO {
  
//  List<Exhibition> resultByTitle(String keyword);
//  
//  List<Exhibition> resultByContent(String keyword);
//  
//  List<Exhibition> resultByTitleWithContent(String keyword);
//  
//  List<Exhibition> resultByReview(String keyword);
//  
//  List<Exhibition> resultByDate(Date startDate, Date endDate, String keyword);
  
  List<Map<String, String>> detailResultByTitle(String keyword);
  
  List<Map<String, String>> detailResultByContent(String keyword);
  
  List<Map<String, String>> detailResultByTitleWithContent(String keyword);
  
  List<Map<String, String>> detailResultByReview(String keyword);
  
  List<Map<String, String>> detailResultByDate(Date startDate, Date endDate, String keyword);
  
}
