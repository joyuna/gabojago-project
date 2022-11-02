package com.bitcamp.gabojago.dao.search;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExhibitionSearchDAO {
  
  List<Map<String, String>> detailResultByTitle(String[] keyword);
  
  List<Map<String, String>> detailResultByContent(String[] keyword);
  
  List<Map<String, String>> detailResultByTitleAndContent(String[] keyword);
    
  List<Map<String, String>> detailResultByDate(Date date);
  
}
