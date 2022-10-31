package com.bitcamp.gabojago.web;

import com.bitcamp.gabojago.service.ExhibitionReviewService;
import com.bitcamp.gabojago.service.ExhibitionService;
import com.bitcamp.gabojago.vo.Exhibition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller // 주소 전달
@RequestMapping("/exhibition/")
public class ExhibitionController {

  ServletContext sc;
  @Autowired
  ExhibitionService exhibitionService;

  @Autowired
  ExhibitionReviewService exhibitionReviewService;



  @GetMapping("exhibitionlist")
  public void list(Model model) throws Exception {
    model.addAttribute("exhibitions", exhibitionService.exhibitionList());
  }



  @GetMapping("detail")
  public void detail(int exno, Model model) throws Exception {
    model.addAttribute("exhibition", exhibitionService.exhibitionSelect(exno));
    model.addAttribute("exhibitionReviews", exhibitionReviewService.exhibitionReviewList(exno));
  } // 강사님 보드는 map 사용

  @GetMapping("form")
  public void insert() throws Exception{
  }

  @PostMapping("add")
  public String insert(Exhibition exhibition,
                       HttpSession session) throws Exception {

    exhibitionService.insert(exhibition);
    return "redirect:exhibitionlist";
}


/*private void checkOwner(int exno, HttpSession session) throws Exception{
  Member loginMember = (Member) session.getAttribute("loginMember");
  if (exhibitionService.get(exno).getWriter().getNo() != loginMember.getNo()) {
    throw new Exception("게시글 작성자가 아닙니다.");
  }
}  추후에 어드민 추가 */

@GetMapping("delete")
public String delete(int exno, HttpSession session) throws Exception {
    //  checkOwner(no, session);
    if(!exhibitionService.delete(exno)) {
      throw new Exception("게시글을 삭제 할 수 없습니다.");
    }

    return "redirect:exhibitionlist";
}

  @GetMapping("updateform")
  public void update(int exno, Model model) throws Exception{
    model.addAttribute("exhibition", exhibitionService.exhibitionSelect(exno));
  }

@PostMapping("update")
public String update(Exhibition exhibition, HttpSession session) throws Exception{
//  파일
// 어드민추가
//  checkOwner(board.getNo(), session);

  if(!exhibitionService.update(exhibition)){
    throw new Exception("게시글을 변경할 수 없습니다.");
  }
  return "redirect:exhibitionlist";
}






  @ResponseBody  //데이터 전달 빠르게 확인 가능 CRUD만
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
