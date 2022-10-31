package com.bitcamp.gabojago.web;

import com.bitcamp.gabojago.service.ExhibitionReviewService;
import com.bitcamp.gabojago.service.ExhibitionService;
import com.bitcamp.gabojago.vo.Exhibition;
import com.bitcamp.gabojago.vo.ExhibitionReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller // 주소 전달
@RequestMapping("/exhibition-review/")
public class ExhibitionReviewController {

@Autowired
ExhibitionReviewService exhibitionReviewService;

  @ResponseBody  //데이터 전달 빠르게 확인 가능
  @RequestMapping("review-select-list/{exno}")
  public List<ExhibitionReview> exhibitionReviewList(@PathVariable("exno") int exno) throws Exception{
    return exhibitionReviewService.exhibitionReviewList(exno);
  }



}
