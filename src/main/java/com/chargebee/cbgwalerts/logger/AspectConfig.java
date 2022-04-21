package com.chargebee.cbgwalerts.logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectConfig {
    private Logger log = LoggerFactory.getLogger(AspectConfig.class);
    @Pointcut(value="execution(* com.chargebee.cbgwalerts.*.*.*(..))\"")
    //inlcude the files where log is req
    public void myPointcut(){
    }

    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper mapper=new ObjectMapper();
        mapper.findAndRegisterModules();
        String methodName=pjp.getSignature().getName();
        String classname=pjp.getTarget().getClass().toString();
        Object[] array=pjp.getArgs();
        log.info("Method invoked " + classname + "." + methodName + "()" + " arguments : " + mapper.writeValueAsString(array));
        Object object = pjp.proceed();
        return object;
    }
}


