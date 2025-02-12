package xczcdjx.book.project.service

import de.jensklingenberg.ktorfit.http.GET
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.path
import xczcdjx.book.project.entity.ArticleEntity
import xczcdjx.book.project.entity.BaseDataRes
import xczcdjx.book.project.network.NetWorkFit
import xczcdjx.book.project.network.Network

interface TestArticleService {
    @GET("/article")
    suspend fun getArticle(): Any

    companion object {
        fun instance()= NetWorkFit.client.create<TestArticleService>()
    }
}