package web.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component //스프링 빈으로 등록하기 - component-scan 설정 필요
@Aspect //AspectJ 관리를 받도록 설정하기
public class LogAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	//포인트컷 설정 메소드 - Advice가 적용될 위치설정 (AOP를 적용하기 위해 지정된 조인 포인트)
	
	//sol1) execution 명시자 - 포인트컷을 설정할 때 사용하는 지정자
	// * : 모든 값을 표현 가능하게 한다. ex) 반환타입이 int이거나 String이거나 모든값을 표현하고 싶을경우 * 로 표현한다.
	// .. : 0개 이상의 값을 표현한다.
	// "execution(* web.service.impl.*ServiceImpl.*(..))" -> ServiceImpl 클래스에 있는 모든 메소드를 뜻한다.
//	@Pointcut("execution(* web.service.impl.*ServiceImpl.*(..))")
	
	//sol2) 스프링빈을 이용하여 포인트컷으로 지정할 수 있다.
	@Pointcut("bean(*ServiceImpl)")
	private static void logPointCut() {}

	
	//어드바이스 코드 작성 - 포인트 컷을 함께 지정한다.
	@Before("logPointCut()")
	public void logBefore(JoinPoint joinPoint) {
		
		//어드바이스 코드가 실행되는 메소드에 대한 정보 객체
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		
		//실행된 메소드의 이름을 로그로 출력
		logger.info("##### Before - Method : {}", signature.toString());
		
	}
	
	// 1. @PointCut("execution ~~")을 통하여 Advice
	// (공통 기능으로 구현될 코드)가 적용될 파일 위치를 설정 해준다.
	
	// 2. @Before("@PointCut이 적용된 메소드 이름")을 통하여 메소드의 
	// 매개변수로 JoinPoint interface를 가지는 메소드 정의한다.
	// 이 때 JoinPoint interface는 이전에 @PointCut을 통하여 적용한 파일위치에 대한 메소드
	// 정보가 있을 것이고  MethodSignature 객체에 저장한다.
	
	// 3. logger를 이용하여 method의 경로와 이름이 출력된다.
	
}
