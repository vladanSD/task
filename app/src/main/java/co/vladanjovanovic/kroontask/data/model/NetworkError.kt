package co.vladanjovanovic.kroontask.data.model


data class NetworkError(
    val message: String? = null,
    val exception: Throwable? = null
)