package com.freddan.individualenterprise.service;

import com.freddan.individualenterprise.entity.Member;
import com.freddan.individualenterprise.exceptions.ResourceNotFoundException;
import com.freddan.individualenterprise.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepo memberRepo;

    @Autowired
    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public List<Member> getAllMembers() {
        List<Member> members = memberRepo.findAll();

        if (!members.isEmpty()) {
            return members;
        } else {
            throw new ResourceNotFoundException("List is empty, add more members");
        }

    }

    public Member getMemberById(int id) {
        Optional<Member> member = memberRepo.findById(id);
        return member.orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));
    }

    public Member updateMember(int id, Member updatedMember) {
        Member existingMember = getMemberById(id);
        if (updatedMember.getFirstName() != null) {
            existingMember.setFirstName(updatedMember.getFirstName());
        }
        if (updatedMember.getLastName() != null) {
            existingMember.setLastName(updatedMember.getLastName());
        }
        if (updatedMember.getAddress() != null) {
            existingMember.setAddress(updatedMember.getAddress());
        }
        if (updatedMember.geteMail() != null) {
            existingMember.seteMail(updatedMember.geteMail());
        }
        if (updatedMember.getPhone() != null) {
            existingMember.setPhone(updatedMember.getPhone());
        }
        if (updatedMember.getDateOfBirth() != null) {
            existingMember.setDateOfBirth(updatedMember.getDateOfBirth());
        }

        return memberRepo.save(existingMember);
    }

    public Member addMember(Member member) {
        List<Member> members = memberRepo.findAll();
        if (!members.isEmpty()) {

            // Checking if member with the same firstname, lastname and date of birth already exist
            for (Member existingmember : members) {
                if (member.getFirstName().contains(existingmember.getFirstName()) && member.getLastName().contains(existingmember.getLastName()) &&
                        member.getDateOfBirth().contains(existingmember.getDateOfBirth())) {
                    throw new ResourceNotFoundException("Person already exist with id: " + existingmember.getId());
                }
            }

        }

        return memberRepo.save(member);
    }

    public String deleteMember(int id) {
        Member memberToDelete = getMemberById(id);
        if (memberToDelete != null) {
            memberRepo.delete(memberToDelete);
            return "redirect:/";
        } else {
            throw new ResourceNotFoundException("Member", "id", id);
        }
    }
}
