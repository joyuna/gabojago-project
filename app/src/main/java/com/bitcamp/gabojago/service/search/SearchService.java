package com.bitcamp.gabojago.service.search;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.management.BadStringOperationException;

public interface SearchService<T extends Enum<T>, V> {
  
  List<V> getDetailResult(T type, String keyword) throws BadStringOperationException; 
  
  default List<V> getResultByDates(Date date){
    return Collections.emptyList();
  }
  
  default List<V> getResultByStars(int star, String keyword){
    return Collections.emptyList();
  }
  
  default String[] parseKeyword(String keyword) {
    return keyword.split(" ");
  }
}
