package com.ads.datae.Dragger

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class MessageQulifiler()


@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class EmailQulifiler()