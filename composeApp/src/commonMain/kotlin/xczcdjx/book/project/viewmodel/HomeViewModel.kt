package xczcdjx.book.project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.launch
import xczcdjx.book.project.service.TimeService

class HomeViewModel:ScreenModel{
    private val timeService=TimeService.instance
    init {
        screenModelScope.launch {
            val timeEntityResp=timeService.getTime()
            println("timeEntityResp : $timeEntityResp")
        }
    }
}