package com.bitcamp.gabojago.service.search;

import java.util.Date;
import java.util.List;
import javax.management.BadStringOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitcamp.gabojago.dao.search.ExhibitionSearchDAO;
import com.bitcamp.gabojago.vo.Exhibition;

@Service
public class ExhibitionSearchService implements SearchService<Exhibition>{

  @Autowired
  ExhibitionSearchDAO searchDAO;
  
  @Override
  public List<Exhibition> getResult(String searchType, String keyword) throws BadStringOperationException {
    switch(searchType) {
      case "title":
        return searchDAO.exhibitionResultByTitle(keyword);
        
      case "content":
        return searchDAO.exhibitionResultByContent(keyword);
        
      case "titleWithContent":
        return searchDAO.exhibitionResultByTitleWithContent(keyword);
        
      case "review":
        return searchDAO.exhibitionResultByReview(keyword);
        
    }
    
    throw new BadStringOperationException(keyword + " -> 사용할 수 없는 검색 조건입니다. 사용 가능 조건(title, content, titleWithContent, review)");
  }
  
  @Override
  public List<Exhibition> getResultByBetweenDates(Date startDate, Date endDate,
      String keyword) {
    if (startDate.compareTo(endDate) > 0) {
      throw new IllegalArgumentException(
        "종료시간(" + endDate + ") 가 시작시간(" + startDate + ")보다 빠를 수 없습니다.");
    }
    
    return searchDAO.exhibitionResultByDate(startDate, endDate, keyword);
  }
}
