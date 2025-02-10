package xczcdjx.book.project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import xczcdjx.book.project.service.TimeService

class HomeViewModel{
    private val timeService=TimeService.instance
    private val mainScope= MainScope()
    init {
        mainScope.launch {
            val timeEntityResp=timeService.getTime()
            println("timeEntityResp : $timeEntityResp")
        }
    }
}