package com.mmc.service;

import com.mmc.entity.MemberEntity;
import com.mmc.model.LoginResponse;
import com.mmc.model.MemberInfo;
import com.mmc.model.PasswordInfo;
import com.mmc.model.Response;
import com.mmc.repository.MemberRepository;
import com.mmc.util.CryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by SGaurav on 09/12/2016.
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private MemberRepository memberRepository;

    public LoginResponse loginAdmin(PasswordInfo passwordInfo , String loginType) throws Exception{

        LoginResponse loginResponse = new LoginResponse();
        Response response = new Response();
        MemberEntity memberEntity = memberRepository.findByEmail(passwordInfo.getEmail());
        CryptUtil cryptUtil =new CryptUtil();
        String password = cryptUtil.encrypt(passwordInfo.getPassword());

        if( memberEntity != null ) {
            if( memberEntity.getRole().equals(loginType)) {
                if (password.equals(memberEntity.getPass())) {
                    loginResponse.setUserDetails(new MemberInfo(memberEntity));
                } else {
                    response.setStatusCode("L-200");
                    response.setStatus("ERROR");
                    response.setStatusMsg("Invalid password");
                    loginResponse.setStatus(response);
                }
            } else {
                response.setStatusCode("L-200");
                response.setStatus("ERROR");
                response.setStatusMsg("You are not authorised user.");
                loginResponse.setStatus(response);
            }
        }else{
            response.setStatusCode("L-200");
            response.setStatus("ERROR");
            response.setStatusMsg("Invalid user");
            loginResponse.setStatus(response);
        }
        System.out.println("Login response===============>"+loginResponse);
        return loginResponse;
    }


    public LoginResponse login(PasswordInfo passwordInfo ) throws Exception{

        LoginResponse loginResponse = new LoginResponse();
        Response response = new Response();
        MemberEntity memberEntity = memberRepository.findByEmail(passwordInfo.getEmail());
        CryptUtil cryptUtil =new CryptUtil();
        String password = cryptUtil.encrypt(passwordInfo.getPassword());

        if( memberEntity != null ) {

                if (password.equals(memberEntity.getPass())) {
                    loginResponse.setUserDetails(new MemberInfo(memberEntity));
                } else {
                    response.setStatusCode("L-200");
                    response.setStatus("ERROR");
                    response.setStatusMsg("Invalid password");
                    loginResponse.setStatus(response);
                }
        }else{
            response.setStatusCode("L-200");
            response.setStatus("ERROR");
            response.setStatusMsg("Invalid user");
            loginResponse.setStatus(response);
        }
        System.out.println("Login response===============>"+loginResponse);
        return loginResponse;
    }

}
