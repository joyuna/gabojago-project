package com.bitcamp.gabojago.web;

import com.bitcamp.gabojago.service.MemberService;
import com.bitcamp.gabojago.vo.Member;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    String filter = "^[A-Za-z0-9]*$";
    Member result = memberService.idCheck(id);

    return inputCheck(id, result, filter);
  }

  @GetMapping("nickNameCheck")
  public String nickNameCheck(String nickName) throws Exception {
    String filter = "^[A-Za-z0-9가-힣]*$";
    Member result = memberService.nickNameCheck(nickName);

    return inputCheck(nickName, result, filter);
  }

  private String inputCheck(String inputString, Member result, String filter) throws Exception {
    if (
        Pattern.matches(filter, inputString) == true &&
        inputString.length() >= 4 &&
        inputString.length() <= 12) {
      if (result == null) {
        return "true";
      } else {
        return "duplicated";
      }
    } else {
      return "incorrect";
    }
  }

  @PostMapping("lastCheck")
  public String lastCheck(String id, String nickName) throws Exception {
    String idFilter = "^[A-Za-z0-9]*$";
    Member idResult = memberService.idCheck(id);

    String nickNameFilter = "^[A-Za-z0-9가-힣]*$";
    Member nickNameResult = memberService.nickNameCheck(nickName);

    if (
    inputCheck(id, idResult, idFilter).equals("true") &&
    inputCheck(nickName, nickNameResult, nickNameFilter).equals("true")
    ) {
      return "true";
    } else {
      return "false";
    }

  }

}
