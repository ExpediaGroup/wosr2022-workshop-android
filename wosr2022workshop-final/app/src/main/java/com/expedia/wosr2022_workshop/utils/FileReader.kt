package com.expedia.wosr2022_workshop.utils

import android.content.Context
import java.io.InputStream

object FileReader {
    fun readFile(context: Context, fileName: String): InputStream? {
        return context.classLoader?.getResourceAsStream(fileName)
    }
}