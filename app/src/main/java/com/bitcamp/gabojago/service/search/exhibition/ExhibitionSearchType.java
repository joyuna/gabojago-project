package com.bitcamp.gabojago.service.search.exhibition;

import java.util.List;
import java.util.Map;
import com.bitcamp.gabojago.dao.search.ExhibitionSearchDAO;

// execute 인터페이스로 빼기 가능? (이펙티브자바 #34 참고)
public enum ExhibitionSearchType{
  TITLE{
    @Override
    protected List<Map<String, String>> execute(ExhibitionSearchDAO dao, String[] keyword) {
      return dao.detailResultByTitle(keyword);
    }
  },
  CONTENT{
    @Override
    protected List<Map<String, String>> execute(ExhibitionSearchDAO dao, String[] keyword) {
      return dao.detailResultByContent(keyword);
    }
  },
  TITLE_WITH_CONTENT{
    @Override
    protected List<Map<String, String>> execute(ExhibitionSearchDAO dao, String[] keyword) {
      return dao.detailResultByTitleAndContent(keyword);
    }
  },
  DATE{
    @Override
    protected List<Map<String, String>> execute(ExhibitionSearchDAO dao, String[] keyword) {
      return null;
      //dao.detailResultByDate(AbstractDetailSearchService.parseKeyword(keyword));
    }
  };
  
  protected abstract List<Map<String, String>> execute(ExhibitionSearchDAO dao, String[] keyword);
}
