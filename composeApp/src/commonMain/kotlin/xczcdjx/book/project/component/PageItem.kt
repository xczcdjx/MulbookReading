package xczcdjx.book.project.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import bookreading.composeapp.generated.resources.Qt
import bookreading.composeapp.generated.resources.Res
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.ktor.http.Url
import org.jetbrains.compose.resources.Font
import xczcdjx.book.project.entity.BookEntity
@Composable
fun PageItem(p: BookEntity, modifier: Modifier = Modifier) {
    Card(
        modifier.fillMaxSize(),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.elevatedCardElevation(10.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        p.apply {
            val t = asyncPainterResource(imgUrl)
            Row(
                modifier.padding(10.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(buildAnnotatedString {
                    val dates = date.split('-')
                    withStyle(SpanStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)) {
                        append(dates.last())
                    }
                    append(" / ")
                    append(dates.first() + "." + dates[1])
                })
                Text(week)
            }
            KamelImage(t, null, modifier.fillMaxWidth().height(220.dp))
            Text(
                content,
                modifier.padding(horizontal = 8.dp, vertical = 36.dp).fillMaxWidth(),
                textAlign = TextAlign.Center,
                lineHeight = 35.sp,
                fontSize = 30.sp,
                fontFamily = FontFamily(Font(Res.font.Qt))
            )
            Text(
                author,
                modifier.padding(horizontal = 8.dp).fillMaxWidth(),
                textAlign = TextAlign.End
            )
        }
    }
}