package xczcdjx.book.project.nativeService

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.UIKit.UIApplication
import platform.UIKit.UIWindow
import platform.UIKit.UIWindowScene

actual object DeviceService {
    // 获取底部安全区的高度
    @OptIn(ExperimentalForeignApi::class)
    actual fun getBottomHeight(): Double {
        val scene=UIApplication.sharedApplication.connectedScenes.first() as UIWindowScene
        val window=scene.windows.first() as UIWindow
        window.safeAreaInsets.useContents {
            return this.bottom
        }
    }
}