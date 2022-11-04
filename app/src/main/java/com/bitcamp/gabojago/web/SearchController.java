package com.bitcamp.gabojago.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bitcamp.gabojago.service.search.exhibition.ExhibitionSearchService;
import com.bitcamp.gabojago.service.search.exhibition.ExhibitionSearchType;

@Controller
@RequestMapping("/")
public class SearchController {
  
  @Autowired
  ExhibitionSearchService searchService;
  
  @GetMapping("search")
  public String search(Model model) throws Exception {
    
    return "search";
  }
  
  @GetMapping("searchResult")
  public String searchResult(Model model, String keyword) throws Exception {
    model.addAttribute("result", searchService.getDetailResult(ExhibitionSearchType.TITLE, keyword));
    
    return "searchResult";
  }
  
}
