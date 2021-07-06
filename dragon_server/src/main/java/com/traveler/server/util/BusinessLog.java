package com.traveler.server.util;

import com.traveler.server.model.enums.PlatformEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BusinessLog {

    String value() default "";

    PlatformEnum platForm() default PlatformEnum.ADMIN;

    String param() default "";
}
