package xczcdjx.book.project.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import xczcdjx.book.project.entity.BaseDataRes
import xczcdjx.book.project.entity.BaseRes
import xczcdjx.book.project.entity.TimeEntity
import xczcdjx.book.project.entity.TimeEntityRes
import xczcdjx.book.project.network.Network

interface TimeService {
    suspend fun getTime(): BaseDataRes<TimeEntity>

    companion object {
        val instance = TimeServiceImpl(Network.client)
    }
}
class TimeServiceImpl(private val http:HttpClient) : TimeService {
    override suspend fun getTime(): BaseDataRes<TimeEntity> =
        http.get("/client/time").body()
}