package com.bitcamp.gabojago.service.search;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.management.BadStringOperationException;

public interface DetailSearchService {
  
  List<Map<String, String>> getDetailResult(String searchType, String keyword) throws BadStringOperationException; 
  
  default List<Map<String, String>> getDetailResultByDates(Date date){
    return Collections.emptyList();
  }
  
  default List<Map<String, String>> getDetailResultByStars(int star, String keyword){
    return Collections.emptyList();
  }
}
