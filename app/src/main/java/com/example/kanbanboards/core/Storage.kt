package com.example.kanbanboards.core

import android.content.SharedPreferences

interface Storage {
    fun save(key: String, value: Boolean)
    fun save(key: String, value: String)

    fun read(key: String, default: Boolean): Boolean
    fun read(key: String, default: String): String

    class Base(private val sharedPreferences: SharedPreferences): Storage {
        override fun save(key: String, value: Boolean) {
            sharedPreferences.edit().putBoolean(key, value).apply()
        }

        override fun save(key: String, value: String) {
            sharedPreferences.edit().putString(key, value).apply()
        }

        override fun read(key: String, default: Boolean): Boolean {
            return sharedPreferences.getBoolean(key, default)
        }

        override fun read(key: String, default: String): String {
            return sharedPreferences.getString(key, default) ?: default
        }
    }
}