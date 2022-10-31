package com.bitcamp.gabojago.dao;

import com.bitcamp.gabojago.vo.Exhibition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExhibitionDao {
  List<Exhibition> exhibitionList(); // 나중에 날짜 받기

  Exhibition exhibitionSelect(int exno);

  int exhibitionInsert(Exhibition exhibition);

  int delete(int exno);

  int update(Exhibition exhibition);

}
