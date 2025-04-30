package hello.springmvc.basic.request;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    
    //요청에서 가져올 수 있는 것들(거의 대부분 가져오기 가능함)
    @RequestMapping("/headers")
    public String headers(
            HttpServletRequest request,// 갓 들어온 요청
            HttpServletResponse response,// 아직 만들어지지 않은 응답
            HttpMethod httpMethod,//요청 메소드
            Locale locale,//Locale은 언어 정보
            @RequestHeader MultiValueMap<String, String> headerMap,//헤더정보 다 받음
            //MultiValue는 같은 키에 여러 값이 들어 갈 수 있는 타입
            @RequestHeader("host") String host,//헤더 하나만 받기
            @CookieValue(value = "myCookie", required = false) String cookie
    ) {

        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);

        return "ok";
    }
}
