package com.bitcamp.gabojago.dao.search;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bitcamp.gabojago.vo.Exhibition;

@Mapper
public interface ExhibitionSearchDAO {
  
  List<Exhibition> exhibitionResultByTitle(String keyword);
  
  List<Exhibition> exhibitionResultByContent(String keyword);
  
  List<Exhibition> exhibitionResultByTitleWithContent(String keyword);
  
  List<Exhibition> exhibitionResultByReview(String keyword);
  
  List<Exhibition> exhibitionResultByDate(Date startDate, Date endDate, String keyword);
  
}
