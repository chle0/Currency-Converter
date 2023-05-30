package tech.task.currencyconverter.core.dto.response

import com.google.gson.annotations.SerializedName

data class BaseErrorResponse(
    @SerializedName("msg")
    val message: String,
    @SerializedName("status")
    val statusCode: Int,
    @SerializedName("error")
    val error: String
)
