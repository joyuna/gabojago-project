package com.bitcamp.gabojago.dao;

import com.bitcamp.gabojago.vo.Exhibition;
import com.bitcamp.gabojago.vo.Recommendation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecommendationDao {
  List<Recommendation> recommendationList(); // 나중에 날짜 받기

  Recommendation recommendationSelect(int recno);

  int exhibitionInsert(Recommendation recommendation);

  int delete(int recno);

  int update(Recommendation recommendation);

}
