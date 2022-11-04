package com.bitcamp.gabojago.service.search.exhibition;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.management.BadStringOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitcamp.gabojago.dao.search.ExhibitionSearchDAO;
import com.bitcamp.gabojago.service.search.DetailSearchService;

@Service
public class ExhibitionSearchService implements DetailSearchService<ExhibitionSearchType>{
  
  @Autowired
  ExhibitionSearchDAO searchDAO;
  
  @Override
  public List<Map<String, String>> getDetailResultByDates(Date date) {
    return searchDAO.detailResultByDate(date);
  }

  @Override
  public List<Map<String, String>> getDetailResult(ExhibitionSearchType type,
      String keyword) throws BadStringOperationException {
    for(ExhibitionSearchType searchType : ExhibitionSearchType.values()) {
      if(searchType.equals(type)) {
        return searchType.execute(searchDAO, parseKeyword(keyword));
      }
    }

    throw new BadStringOperationException(keyword + " -> 사용할 수 없는 검색 조건입니다. 사용 가능 조건{"
        + ExhibitionSearchType.TITLE.toString() + ", "
        + ExhibitionSearchType.CONTENT.toString() + ", "
        + ExhibitionSearchType.TITLE_WITH_CONTENT.toString() + ", "
        + ExhibitionSearchType.DATE.toString()
        + "}");
  }
}
