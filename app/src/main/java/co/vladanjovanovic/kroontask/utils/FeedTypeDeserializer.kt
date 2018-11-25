package co.vladanjovanovic.kroontask.utils

import co.vladanjovanovic.kroontask.data.model.FeedType
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type

class FeedTypeDeserializer : JsonDeserializer<FeedType> {

    @Throws(JsonParseException::class)
    override fun deserialize(element: JsonElement, arg1: Type, arg2: JsonDeserializationContext): FeedType? {
        return FeedType.valueOf(element.asJsonPrimitive.asString.toUpperCase())
    }
}