package xczcdjx.book.project.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import xczcdjx.book.project.component.PageItem
import xczcdjx.book.project.constants.bookTest
import xczcdjx.book.project.nativeService.DeviceService
import xczcdjx.book.project.viewmodel.Dispatch
import xczcdjx.book.project.viewmodel.HomeViewModel

object HomeScreen : Screen {
    @Composable
    override fun Content() {
        val bookData = remember { mutableStateListOf(*bookTest.toTypedArray()) }
        val pageState = rememberPagerState(0) {
            bookData.size
        }
        val vm = rememberScreenModel { HomeViewModel() }
        val count by vm.uiState.collectAsState()
        Column {
            Text("Count: ${count.count}")
            TextButton({vm.dispatch(Dispatch.Increment)}){
                Text("+1")
            }
            TextButton({vm.dispatch(Dispatch.Decrement)}){
                Text("-1")
            }
        }
        /*HorizontalPager(
            pageState,
            contentPadding = PaddingValues(
                start = 32.dp,
                end = 32.dp,
                top = 32.dp,
                bottom = (DeviceService.getBottomHeight() + 32).dp
            ),
            pageSpacing = 16.dp
        ) {
            PageItem(bookData[it])
        }*/
    }
}