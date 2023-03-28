package ru.anb.testapi.models

data class Field(
    val flags: Flags,
    val group: Int,
    val image: String,
    val name: String,
    val show: Int,
    val type: String,
    val value: String
)