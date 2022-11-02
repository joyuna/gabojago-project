package com.bitcamp.gabojago.service.search;

public abstract class AbstractDetailSearchService implements DetailSearchService{
  
  public final String[] parseKeyword(String keyword) {
    return keyword.split(" ");
  }
}
