package io.github.felipeanchieta.profits.rest.models.request

interface TranslatableToBusinessEntity<T> {
    fun toBusinessEntity(): T
}