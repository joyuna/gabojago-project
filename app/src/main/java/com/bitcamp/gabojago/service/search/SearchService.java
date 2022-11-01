package com.bitcamp.gabojago.service.search;

import java.util.Date;
import java.util.List;
import javax.management.BadStringOperationException;

public interface SearchService<T> {
  
  List<T> getResult(String searchType, String keyword) throws BadStringOperationException; 
  
  default List<T> getResultByBetweenDates(Date startDate, Date endDate, String keyword){
    throw new UnsupportedOperationException();
  }
  
  default List<T> getResultByStars(int star, String keyword){
    throw new UnsupportedOperationException();
  }
}
