package com.tapdevs.base.injection.qualifiers

import javax.inject.Qualifier
import kotlin.annotation.MustBeDocumented
import kotlin.annotation.Retention

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class NamedDispatcher(val value: DispatcherType = DispatcherType.IO) {

    enum class DispatcherType {
        IO, UI
    }
}