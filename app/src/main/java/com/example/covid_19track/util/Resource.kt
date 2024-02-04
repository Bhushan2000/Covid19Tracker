package com.example.covid_19track.util

import androidx.lifecycle.LiveData

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    // We need a utility class that will be responsible to communicate the current
// state of Network Call to the UI Layer. We are naming that as Resource.

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String?,data: T?): Resource<T> {
            return Resource(Status.ERROR, data, message = message)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}

