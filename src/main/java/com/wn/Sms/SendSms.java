package com.wn.Sms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.wn.pojo.Code;
import org.springframework.web.util.WebUtils;

import java.security.CodeSource;
import java.util.Random;

public class SendSms {
    private static final String accessKeyId = "LTAI4G7xKsSyC9jVhwSWWN7X";
    private static final String accessSecret = "xlJzSw2Uv1Cb0u3zHlPJgjVgl55MgP";
    private static final String TemplateCode = "SMS_205616233";
    private static final String SignName = "Yasushi的项目";

    public String sendCaptcha(String phoneNum) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNum);
        request.putQueryParameter("SignName", SignName);
        request.putQueryParameter("TemplateCode", TemplateCode);
        String str="0123456789";
        StringBuilder captcha = new StringBuilder(4);
        for(int i=0;i<4;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            captcha.append(ch);
        }
        String captcha2 = captcha.toString();
        Code code = new Code(captcha2);
        String captcha3 = JSON.toJSONString(code);

        request.putQueryParameter("TemplateParam", captcha3);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());

        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return captcha2;
    }
}


