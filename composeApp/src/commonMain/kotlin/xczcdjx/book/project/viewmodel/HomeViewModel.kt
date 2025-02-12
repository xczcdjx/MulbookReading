package xczcdjx.book.project.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import xczcdjx.book.project.service.ArticleService
import xczcdjx.book.project.service.TestArticleService
import xczcdjx.book.project.service.TimeService

// mvi
data class CountState(val count: Int)
sealed class Dispatch {
    data object Increment : Dispatch()
    data object Decrement : Dispatch()
}

class HomeViewModel : ScreenModel {
    private val timeService = TimeService.instance
    private val _uiState = MutableStateFlow(CountState(0))
    val uiState: StateFlow<CountState> = _uiState.asStateFlow()
    fun dispatch(action: Dispatch) {
        val oldV = _uiState.value.count
        when (action) {
            Dispatch.Increment -> _uiState.value = _uiState.value.copy(oldV + 1)
            Dispatch.Decrement -> _uiState.value = _uiState.value.copy(oldV - 1)
        }
    }

    //    private val articleService=TestArticleService.instance()
    init {
        screenModelScope.launch {
//            val timeEntityResp=timeService.getTime()
//            println("timeEntityResp : $timeEntityResp")
//            val res=articleService.getArticle()
//            println("res $res")
        }
    }
}