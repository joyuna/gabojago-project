package com.bitcamp.gabojago.web;

import com.bitcamp.gabojago.service.MemberService;
import com.bitcamp.gabojago.service.MyCommentsService;
import com.bitcamp.gabojago.vo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/myPage/myComments/")
public class MyCommentsController {

    private MyCommentsService myCommentsService;

    private MemberService memberService;

    private int PAGE_CORRECTION = 1;

    public MyCommentsController(MyCommentsService myCommentsService, MemberService memberService) {
        this.myCommentsService = myCommentsService;
        this.memberService = memberService;
    }

    // 코스추천 댓글
    @GetMapping("myRecommendationCommentsList")
    public void myRecommendationCommentsList(JangComment jangComment,
                                             HttpSession session,
                                             Model model) throws Exception {

        Member loginMember = (Member) session.getAttribute("loginMember");

        if (loginMember == null) {

            model.addAttribute("myPageFailMessage", "로그인이 필요한 항목입니다. 회원가입 또는 로그인해 주세요.");

//            return "myPage/myPageFail";

        } else {
            Member member = memberService.get(loginMember.getId());

            model.addAttribute("id", member.getId());
            model.addAttribute("name", member.getName());
            model.addAttribute("profileFig", member.getProfileFig());
            model.addAttribute("nickName", member.getNickName());
            model.addAttribute("mbti", member.getMbti());
            model.addAttribute("snsAddress", member.getSnsAddress());

        }

        jangComment.setWriter((Member) session.getAttribute("loginMember"));
        model.addAttribute("jangComments", myCommentsService.myRecommendationCommentsList(jangComment.getWriter().getId()));
    }

    // 전시회 댓글 (게시물 목록 + paging)
    @GetMapping("myExhibitionReviewListPage")
    public void myExhibitionReviewListPage(ExhibitionReview exhibitionReview,
                                         HttpSession session,
                                         Model model,
                                         @RequestParam("page") Integer page, @RequestParam(value = "size", defaultValue = "3") Integer size) throws Exception {

        Member loginMember = (Member) session.getAttribute("loginMember");

        if (loginMember == null) {

            model.addAttribute("myPageFailMessage", "로그인이 필요한 항목입니다. 회원가입 또는 로그인해 주세요.");

//            return "myPage/myPageFail";

        } else {
            Member member = memberService.get(loginMember.getId());

            model.addAttribute("id", member.getId());
            model.addAttribute("name", member.getName());
            model.addAttribute("profileFig", member.getProfileFig());
            model.addAttribute("nickName", member.getNickName());
            model.addAttribute("mbti", member.getMbti());
            model.addAttribute("snsAddress", member.getSnsAddress());

        }

        // 게시물 총개수
        int total = myCommentsService.count();

        page -= PAGE_CORRECTION;
        exhibitionReview.setWriter((Member) session.getAttribute("loginMember"));
        List<ExhibitionReview> ExhibitionReviewList = myCommentsService.myExhibitionReviewListPage((page) * size, size, exhibitionReview.getWriter().getId());
        PageResponseDto<ExhibitionReview> pageResponseDto = new PageResponseDto<>(page, size, total, ExhibitionReviewList);

        model.addAttribute("myExhibitionReviews", pageResponseDto.getDtoList());
        model.addAttribute("pages", pageResponseDto.getPage());
        model.addAttribute("pageNum", pageResponseDto.getTotal());
        model.addAttribute("pageStart", pageResponseDto.getStart());
        model.addAttribute("pageEnd", pageResponseDto.getEnd());
        model.addAttribute("prev", pageResponseDto.isPrev());
        model.addAttribute("next", pageResponseDto.isNext());


    }
}
