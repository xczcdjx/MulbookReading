package xczcdjx.book.project.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.path
import xczcdjx.book.project.entity.ArticleEntity
import xczcdjx.book.project.entity.BaseDataRes
import xczcdjx.book.project.network.Network

interface ArticleService {
    suspend fun getArticle(): BaseDataRes<List<ArticleEntity>>

    companion object {
        val instance = ArticleServiceImpl(Network.client)
    }
}

class ArticleServiceImpl(val http: HttpClient) : ArticleService {
    override suspend fun getArticle(): BaseDataRes<List<ArticleEntity>> =
        http.get("/article").body()
        /*http.get {
            url {
                path("/article")
                parameters.append("pageSize", "10")
            }
        }.body()*/
       /* http.post("/article") {
            setBody("")
        }.body()*/
}