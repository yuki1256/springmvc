package hello.springmvc.basic;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController//@Controller는 Mapping이후 String타입이면 view리졸버가 뷰 이름을 찾지만,
                  //@RestController는 반환이 String여도 그냥 값을 넘겨줌(메세지 바디에) REST API를 위한 애노테이션
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(LogTestController.class); @Slf4j가 롬복에서 제공되는 애노테이션인데 생성을 생략시켜줌

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("스프링 로그");

        /**
         *#hello.springmvc 패키지와 그 하위 로그 레벨 설정
         *logging.level.hello.springmvc=debug
         * 로그 등급 아래로 갈 수록 심각도 높아짐
         * ("trace log = " + name) 할 시 연산이 일어난다
         * trace를 위 처럼 할 경우 나오진 않지만 쓸데없이 연산을 하게 되어 쓸데없게 메모리를 잡아먹는다
         * 그러니 아래 예제처럼 쿼리파라미터처럼 사용하면 연산없이 효율적이게 사용이 가능하다
         */
        log.trace("trace log = {}", name);//로컬 단계 ~ error(내 개인용 컴퓨터에서 사용가능한 등급)
        log.debug("trace log = {}", name);//개발용 단계 ~ error (계발 단계에서 사용가능한 등급)
        log.info("info log = {}",name);//윤영 단계 ~ error(실제 서버, 배포 했을 때 남길 로그들)
        log.warn("trace log = {}", name);
        log.error("trace log = {}", name);
        
        return "ok";
    }
}
