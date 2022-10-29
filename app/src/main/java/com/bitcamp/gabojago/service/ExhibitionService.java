package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.vo.Exhibition;

import java.util.List;


public interface ExhibitionService {

  List<Exhibition> exhibitionList() throws Exception;

  Exhibition exhibitionSelect(int exno) throws Exception;

  void insert(Exhibition exhibition) throws Exception;

}