package io.github.felipeanchieta.profits.rest.models.request

abstract class TranslatableToBusinessEntity<T> {
    abstract fun toBusinessEntity(): T
}