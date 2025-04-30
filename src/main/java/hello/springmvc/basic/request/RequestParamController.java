package hello.springmvc.basic.request;


import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uesrname = request.getParameter("uesrname");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username = {}, age = {}", uesrname, age);

        response.getWriter().write("Ok");
    }

    @ResponseBody//반환값 string을 응답 바디에 넣어줌
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {
        log.info("username = {}, age = {}", memberName, memberAge);
        return "success";
    }


    @ResponseBody//반환값 string을 응답 바디에 넣어줌
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {
        log.info("username = {}, age = {}", username, age);
        return "success";
    }

    @ResponseBody//반환값 string을 응답 바디에 넣어줌
    @RequestMapping("/request-param-v4")
    public String requestParamV4(
            String username, int age) {
        log.info("username = {}, age = {}", username, age);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username, //필수 유무
            @RequestParam(required = false) Integer age) { //int 는 null이 안들어가지므로.
        //Null 과 ""은 다른 거임 예외처리 해줘야함
        log.info("username = {}, age = {}", username, age);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(defaultValue = "guest") String username,// defaultValue가 있다면 required 속성이 필요없음
            @RequestParam(defaultValue = "-1") Integer age) {//또 defaultValue는 아까 위에서 ""도 기본값으로 해줌 예외 처리 안해도됨

        log.info("username = {}, age = {}", username, age);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {

        log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));
        return "success";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
        return "OK";
    }
}
