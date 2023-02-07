package trip.cafe.tripcafebackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trip.cafe.tripcafebackend.domain.Address;
import trip.cafe.tripcafebackend.domain.Member;
import trip.cafe.tripcafebackend.service.Memberservice;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {

    private final Memberservice memberService;

//    @GetMapping("members/new")
//    public String createForm(Model model) {
//        model.addAttribute("memberForm", new MemberForm());
//        return "members/createMemberForm";
//    }

//    @PostMapping(value = "/members/new")
//    public String create(@Valid MemberForm form, BindingResult result) {
//
//        if (result.hasErrors()) {
//            return "members/createForm";
//        }
//
//        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());
//        Member member = new Member();
//
//        return "redirect:/";
//
//    }
}
