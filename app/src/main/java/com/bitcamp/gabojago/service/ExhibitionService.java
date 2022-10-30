package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.vo.Exhibition;

import java.util.List;


public interface ExhibitionService {

  List<Exhibition> exhibitionList() throws Exception;

  Exhibition exhibitionSelect(int exno) throws Exception;

  void insert(Exhibition exhibition) throws Exception;

  boolean delete(int exno) throws Exception;

  boolean update(Exhibition exhibition) throws Exception;

  Exhibition get (int exno) throws Exception;


}