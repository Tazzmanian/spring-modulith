package com.tazz.modulith.demo.eventactioin.action;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomEventMarker {
    Action eventAction();
}
