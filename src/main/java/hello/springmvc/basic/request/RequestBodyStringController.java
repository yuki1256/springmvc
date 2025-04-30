package hello.springmvc.basic.request;


import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/request-body-string-v1")
    public void requestbodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletInputStream inputStream = request.getInputStream();
        String s = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("requestbodyString: {}", s);

        response.getWriter().write("Ok");
    }

    @PostMapping("/request-body-string-v2")
    public void requestbodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException {

        String s = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("requestbodyString: {}", s);
        responseWriter.write("Ok");
    }

    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestbodyStringV3(HttpEntity<String> httpEntity) throws IOException {

        String body = httpEntity.getBody();
        log.info("requestbodyString: {}", body);

        return new HttpEntity<>("Ok");
    }


    @ResponseBody
    @PostMapping("/request-body-string-v4")
    public String requestbodyStringV4(@RequestBody String messageBody) throws IOException {//제일 자주 사용하는 방식
        log.info("requestbodyString: {}", messageBody);
        return "Ok";
    }
}
