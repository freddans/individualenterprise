package com.freddan.individualenterprise.service;

import com.freddan.individualenterprise.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberService {

    private MemberRepo memberRepo;

    @Autowired
    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }
}
