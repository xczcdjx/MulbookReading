package xczcdjx.book.project.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import xczcdjx.book.project.component.PageItem
import xczcdjx.book.project.constants.bookTest
import xczcdjx.book.project.nativeService.DeviceService
import xczcdjx.book.project.viewmodel.HomeViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
//    val bookData by remember { mutableStateOf(bookTest) }
    val bookData = remember { mutableStateListOf(*bookTest.toTypedArray()) }
    val pageState = rememberPagerState(0) {
        bookData.size
    }
    val vm=HomeViewModel()
    HorizontalPager(
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
    }
}