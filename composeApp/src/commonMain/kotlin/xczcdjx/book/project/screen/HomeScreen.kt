package xczcdjx.book.project.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import xczcdjx.book.project.component.PageItem

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val pageState = rememberPagerState(0) {
        10
    }
    HorizontalPager(pageState, contentPadding = PaddingValues(all = 32.dp)) {
        PageItem()
    }
}