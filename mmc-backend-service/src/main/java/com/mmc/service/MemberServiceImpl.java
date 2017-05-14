package com.mmc.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmc.entity.MemberEntity;
import com.mmc.entity.MemberEntityPK;
import com.mmc.entity.PINVerifivationEntity;
import com.mmc.entity.PasswordResetEntity;
import com.mmc.model.GetPassword;
import com.mmc.model.MemberInfo;
import com.mmc.model.PINInfo;
import com.mmc.model.PasswordInfo;
import com.mmc.model.PasswordResetInfo;
import com.mmc.model.SignUpModel;
import com.mmc.repository.MemberRepository;
import com.mmc.util.CryptUtil;
/**
 * Created by SGaurav on 05/12/2016.
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public boolean addMember(PasswordInfo passwordInfo) throws Exception{
        MemberEntity member = memberRepository.findByEmail(passwordInfo.getEmail());
        if( member == null  ) {

            MemberEntity memberEntity = new MemberEntity();
            MemberEntityPK memberEntityPK = new MemberEntityPK();

            memberEntityPK.setEmail(passwordInfo.getEmail());

            memberEntity.setMemberEntityPk(memberEntityPK);
            memberEntity.setPass(CryptUtil.encrypt(passwordInfo.getPassword()));
            memberEntity.setMemberEntityPk(memberEntityPK);
            memberEntity.setRole("user");
            memberRepository.save(memberEntity);
            return true;
        }else {
            return false;
        }
    }

    public boolean addMember(SignUpModel signUpModel) throws Exception{
        MemberEntity member = memberRepository.findByEmail(signUpModel.getEmail());
        if( member == null  ) {

            MemberEntity memberEntity = new MemberEntity();
            MemberEntityPK memberEntityPK = new MemberEntityPK();

            memberEntityPK.setEmail(signUpModel.getEmail());
            memberEntity.setFirstName(signUpModel.getFirstName());
            memberEntity.setLastName(signUpModel.getLastName());
            memberEntity.setMemberEntityPk(memberEntityPK);
            memberEntity.setPass(CryptUtil.encrypt(signUpModel.getPass()));
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
        return  memberInfoList;
    }

    public MemberInfo getMember(String email) throws Exception {
        return new MemberInfo(memberRepository.findByEmail(email));
    }

    public void deleteMember(String email) throws Exception {
        memberRepository.delete(memberRepository.findByEmail(email));
    }

    public String getPassword(GetPassword getPassword) throws Exception {
        MemberEntity memberEntity = memberRepository.findByEmail(getPassword.getEmail());
        String password = null;
        if( memberEntity != null ) {
            if(memberEntity.getPin().equals(getPassword.getPin())) {
                password = CryptUtil.decrypt(memberEntity.getPass());
            } else {
                password = "XXXX"; // It implicates pin is incorrect
            }
        }
        return password;
    }
    @Override
    public PINVerifivationEntity verifyPin(PINInfo pinInfo) throws Exception{
        MemberEntity memberEntity  = memberRepository.findByEmail(pinInfo.getEmail());
        PINVerifivationEntity pve = new PINVerifivationEntity();
        if( memberEntity != null ) {
            if(memberEntity.getPin().equals(pinInfo.getPin())) {
            	pve.setPinVerified(true);
            } else {
            	pve.setPinVerified(false);
            }
        }
        return pve;
    }
    
    @Override
    public PasswordResetEntity resetPassword(PasswordResetInfo pri) throws Exception{
        MemberEntity memberEntity  = memberRepository.findByEmail(pri.getEmail());
        
        PasswordResetEntity pre = new PasswordResetEntity();
        if( memberEntity != null ) {
            if(memberEntity.getPin().equals(pri.getPin())) {
            	pre.setPasswordReset(true);
            	memberEntity.setPass(CryptUtil.encrypt(pri.getPassword()));
            	memberRepository.save(memberEntity);
            } else {
            	pre.setPasswordReset(false);
            }
        }
        return pre;
    }
    
    
}
