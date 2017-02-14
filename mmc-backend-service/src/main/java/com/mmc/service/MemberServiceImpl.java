package com.mmc.service;


import com.mmc.entity.MemberEntity;
import com.mmc.entity.MemberEntityPK;
import com.mmc.model.*;
import com.mmc.repository.MemberRepository;
import com.mmc.util.CryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by SGaurav on 05/12/2016.
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    private CryptUtil cryptUtil = new CryptUtil();

    public boolean addMember(PasswordInfo passwordInfo) throws Exception{
        System.out.println("Adding member ===================>" + passwordInfo.toString());
        MemberEntity member = memberRepository.findByEmail(passwordInfo.getEmail());
        if( member == null  ) {

            MemberEntity memberEntity = new MemberEntity();
            MemberEntityPK memberEntityPK = new MemberEntityPK();

            memberEntityPK.setEmail(passwordInfo.getEmail());

            memberEntity.setMemberEntityPk(memberEntityPK);
            memberEntity.setPass(cryptUtil.encrypt(passwordInfo.getPassword()));
            memberEntity.setMemberEntityPk(memberEntityPK);
            memberEntity.setRole("user");
            memberRepository.save(memberEntity);
            return true;
        }else {
            return false;
        }
    }

    public boolean addMember(SignUpModel signUpModel) throws Exception{
        System.out.println("Siginup member ===================>" + signUpModel.toString());
        MemberEntity member = memberRepository.findByEmail(signUpModel.getEmail());
        if( member == null  ) {

            MemberEntity memberEntity = new MemberEntity();
            MemberEntityPK memberEntityPK = new MemberEntityPK();

            memberEntityPK.setEmail(signUpModel.getEmail());
            memberEntity.setFirstName(signUpModel.getFirstName());
            memberEntity.setLastName(signUpModel.getLastName());
            memberEntity.setMemberEntityPk(memberEntityPK);
            memberEntity.setPass(cryptUtil.encrypt(signUpModel.getPass()));
            memberEntity.setRole("user");
            memberEntity.setMemberEntityPk(memberEntityPK);
            memberEntity.setPin(signUpModel.getPin());
            memberRepository.save(memberEntity);
            return true;
        }else {
            return false;
        }
    }


    public boolean updateMember(MemberInfo memberInfo) throws Exception {
        System.out.println("Updating member ===================>" + memberInfo.toString());
        MemberEntity member = memberRepository.findByEmail(memberInfo.getEmail());
        if(member == null){
            return false;
        }else{
            member.setFirstName(memberInfo.getFirstName() != null ? memberInfo.getFirstName():member.getFirstName());
            member.setLastName(memberInfo.getLastName() != null ? memberInfo.getLastName():member.getLastName());
            member.setPhone(memberInfo.getPhone() != null ? memberInfo.getPhone():member.getPhone());
            member.setType(memberInfo.getType() != null ? memberInfo.getType():member.getType());
            member.setAddress(memberInfo.getAddress() != null ? memberInfo.getAddress():member.getAddress());
            memberRepository.save(member);
            return true;
        }
    }

    public List<MemberInfo> getAllMembers() throws Exception {
        List<MemberInfo> memberInfoList = new ArrayList<MemberInfo>();
        Iterable<MemberEntity> memberEntityList = memberRepository.findAll();
        for (MemberEntity member: memberEntityList
             ) {
            memberInfoList.add(new MemberInfo(member));
        }
        System.out.println("Listing members ===================>" + memberInfoList.toString());
        return  memberInfoList;
    }

    public MemberInfo getMember(String email) throws Exception {
        System.out.println("Querying member ===================>" + email);
        return new MemberInfo(memberRepository.findByEmail(email));
    }

    public void deleteMember(String email) throws Exception {
        System.out.println("Deleting member ===================>" + email);
        memberRepository.delete(memberRepository.findByEmail(email));
    }

    public String getPassword(GetPassword getPassword) throws Exception {
        MemberEntity memberEntity = memberRepository.findByEmail(getPassword.getEmail());
        String password = null;
        if( memberEntity != null ) {
            if(memberEntity.getPin().equals(getPassword.getPin())) {
                password = cryptUtil.decrypt(memberEntity.getPass());
            } else {
                password = "XXXX"; // It implicates pin is incorrect
            }
        }
        return password;
    }
}
