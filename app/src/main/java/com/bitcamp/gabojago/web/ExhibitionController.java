package com.bitcamp.gabojago.web;

import com.bitcamp.gabojago.service.ExhibitionReviewService;
import com.bitcamp.gabojago.service.ExhibitionService;
import com.bitcamp.gabojago.vo.Exhibition;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller // 주소 전달
@RequestMapping("/exhibition/")
public class ExhibitionController {


  @Autowired
  ExhibitionService exhibitionService;

  @Autowired
  ExhibitionReviewService exhibitionReviewService;

  @GetMapping("exhibitionlist")
  public void list(Model model) throws Exception {
    model.addAttribute("exhibitions", exhibitionService.exhibitionList());
    System.out.println("ㅜㅜㅜㅜㅜ");
  }



  @GetMapping("detail")
  public void detail(int exno, Model model) throws Exception {
    model.addAttribute("exhibition", exhibitionService.exhibitionSelect(exno));
    model.addAttribute("exhibitionReviews", exhibitionReviewService.exhibitionReviewList());
  }

  @GetMapping("form")
  public void insert() throws Exception{

  }

  @PostMapping("add")
  public String insert(Exhibition exhibition, HttpSession session) throws Exception {
    exhibitionService.insert(exhibition);
// 첨부파일 나중에

    return "redirect:exhibitionlist";
}





  @ResponseBody  //데이터 전달 빠르게 확인 가능
  @RequestMapping("select-list")
  public List<Exhibition> exhibitionList() throws Exception{
    return exhibitionService.exhibitionList();
  }

  @ResponseBody  //데이터 전달
  @RequestMapping("select/{exno}")
  public Exhibition exhibitionSelect(@PathVariable("exno") int exno) throws Exception{
    return exhibitionService.exhibitionSelect(exno);
  }



}
