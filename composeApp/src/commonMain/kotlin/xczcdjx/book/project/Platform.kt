package xczcdjx.book.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform