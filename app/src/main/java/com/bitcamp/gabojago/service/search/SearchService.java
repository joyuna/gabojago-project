package com.bitcamp.gabojago.service.search;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.management.BadStringOperationException;

public interface SearchService {
  
  List<Map<String, String>> getResult(String searchType, String keyword) throws BadStringOperationException;
 
  default List<Map<String, String>> getResultByBetweenDates(Date startDate, Date endDate, String keyword){
    throw new UnsupportedOperationException();
  }
  
  default List<Map<String, String>> getResultByStars(int star, String keyword){
    throw new UnsupportedOperationException();
  }
}
