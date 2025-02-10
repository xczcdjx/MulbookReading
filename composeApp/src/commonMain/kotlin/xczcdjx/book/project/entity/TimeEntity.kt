package xczcdjx.book.project.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
data class TimeEntity(val date: String,
//                      @SerialName("weekday") val weekday: String
                      @JsonNames("weekday1") val weekday: String
)

@Serializable
data class TimeEntityRes(val data:TimeEntity, override val code: Int, override val msg: String):BaseRes()
