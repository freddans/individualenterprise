package com.freddan.individualenterprise.controller;

import com.freddan.individualenterprise.entity.Member;
import com.freddan.individualenterprise.exceptions.ResourceNotFoundException;
import com.freddan.individualenterprise.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // POSTMAN METHODS
    @GetMapping("/admin/members")
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> memberList = memberService.getAllMembers();
        return ResponseEntity.ok(memberList);
    }

    @GetMapping("/admin/member/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable int id) {
        Member member = memberService.getMemberById(id);
        return ResponseEntity.ok(member);
    }

    @PutMapping("/admin/updatemember/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable int id, @RequestBody Member updatedMember) {

        return ResponseEntity.ok(memberService.updateMember(id, updatedMember));
    }

    @PostMapping("/admin/addmember")
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        return new ResponseEntity<>(memberService.addMember(member), HttpStatus.CREATED);
    }

    @PostMapping("/admin/deletemember/{id}")
    public String deleteMemberById(@PathVariable int id) {
        try {
            return memberService.deleteMember(id);
        } catch (ResourceNotFoundException e) {
            return "Member not found";
        }
    }


    // Website stuff
    @GetMapping("/admin/deletemember")
    public String getWebSiteWithMembers(Model model) {
        List<Member> membersList = memberService.getAllMembers();
        model.addAttribute("members", membersList);
        return "index";
    }
}
