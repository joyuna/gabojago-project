package com.bitcamp.gabojago.service.search;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.management.BadStringOperationException;

public interface SearchService<T> {
  
  List<T> getResult(String searchType, String keyword) throws BadStringOperationException;
  
  default List<T> getResultByDates(Date date){
    return Collections.emptyList();
  }
  
  default List<T> getResultByStars(int star, String keyword){
    return Collections.emptyList();
  }
}
