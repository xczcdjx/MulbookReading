package xczcdjx.book.project.entity

import kotlinx.serialization.Serializable

@Serializable
abstract class BaseRes {
    abstract val code:Int
    abstract val msg:String
}

@Serializable
data class BaseDataRes<T>(val data:T,val code:Int,val msg:String)