package com.bitcamp.gabojago.web;

import com.bitcamp.gabojago.service.MemberService;
import com.bitcamp.gabojago.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event/")
public class EventController {

  @Autowired
  MemberService memberService;


  @PostMapping("idCheck")
  public String idCheck(String id) throws Exception {
    Member result = memberService.idCheck(id);

    if (result == null) {
      return "true";
    } else {
      return "false";
    }
  }

}
