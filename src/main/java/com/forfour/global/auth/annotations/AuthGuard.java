package com.forfour.global.auth.annotations;

import com.forfour.global.auth.guards.Authorizable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthGuard {
    Class<? extends Authorizable>[] value();
}
