package ru.anb.testapi.models

data class ParametersItem(
    val categories: Categories,
    val description: String,
    val documentation: String,
    val fields: List<Field>,
    val id: Int,
    val image: String,
    val name: String
)