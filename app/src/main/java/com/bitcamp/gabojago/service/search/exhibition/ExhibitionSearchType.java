package com.bitcamp.gabojago.service.search.exhibition;

import java.util.List;
import java.util.Map;
import com.bitcamp.gabojago.dao.search.ExhibitionSearchDAO;

enum ExhibitionSearchType{
  TITLE("title"){
    @Override
    protected List<Map<String, String>> execute(ExhibitionSearchDAO dao, String[] keyword) {
      return dao.detailResultByTitle(keyword);
    }
  },
  CONTENT("content"){
    @Override
    protected List<Map<String, String>> execute(ExhibitionSearchDAO dao, String[] keyword) {
      return dao.detailResultByContent(keyword);
    }
  },
  TITLE_WITH_CONTENT("titleWithContent"){
    @Override
    protected List<Map<String, String>> execute(ExhibitionSearchDAO dao, String[] keyword) {
      return dao.detailResultByTitleAndContent(keyword);
    }
  },
  DATE("date"){
    @Override
    protected List<Map<String, String>> execute(ExhibitionSearchDAO dao, String[] keyword) {
      return null;
      //dao.detailResultByDate(AbstractDetailSearchService.parseKeyword(keyword));
    }
  };
  
  private String type;
  
  private ExhibitionSearchType(String type) {
    this.type = type;
  }
  
  public String getType() {
    return type;
  }
  
  protected abstract List<Map<String, String>> execute(ExhibitionSearchDAO dao, String[] keyword);
}
