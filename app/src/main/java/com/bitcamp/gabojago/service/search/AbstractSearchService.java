package com.bitcamp.gabojago.service.search;

public abstract class AbstractSearchService<T> implements SearchService<T>{
  
  public abstract static class AbstractSearchByKeyword{
    public abstract void execute();
  }
  
  public static final String[] parseKeyword(String keyword) {
    return keyword.split(" ");
  }
}
