package com.bitcamp.gabojago.service.search.exhibition;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.management.BadStringOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitcamp.gabojago.dao.search.ExhibitionSearchDAO;
import com.bitcamp.gabojago.service.search.AbstractDetailSearchService;

@Service
public class ExhibitionSearchService extends AbstractDetailSearchService{
  
  @Autowired
  ExhibitionSearchDAO searchDAO;
  
  @Override
  public List<Map<String, String>> getDetailResult(String type, String keyword) throws BadStringOperationException {
    for(ExhibitionSearchType searchType : ExhibitionSearchType.values()) {
      if(searchType.getType().equals(type)) {
        return searchType.execute(searchDAO, parseKeyword(keyword));
      }
    }
    throw new BadStringOperationException(keyword + " -> 사용할 수 없는 검색 조건입니다. 사용 가능 조건{"
        + ExhibitionSearchType.TITLE.getType() + ", "
        + ExhibitionSearchType.CONTENT.getType() + ", "
        + ExhibitionSearchType.TITLE_WITH_CONTENT.getType() + ", "
        + ExhibitionSearchType.DATE.getType()
        + "}");
  }
  
  
  @Override
  public List<Map<String, String>> getDetailResultByDates(Date date) {
    return searchDAO.detailResultByDate(date);
  }
}
