package com.expedia.wosr2022_workshop.repositories

import android.content.Context
import com.expedia.wosr2022_workshop.model.PlacesToStay
import com.expedia.wosr2022_workshop.utils.FileReader
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.BufferedReader

class PlacesLocalRepository(private val context: Context) {

    private val placesFile = "places_to_stay.json"

    fun loadPlaces(fileName: String = placesFile): Flow<PlacesToStay> {
        return flow {
            val inputStream = FileReader.readFile(context, fileName)
            inputStream?.let {
                val reader = BufferedReader(it.reader())
                val content: String
                try {
                    content = reader.readText()

                    val propertyType = object : TypeToken<PlacesToStay>() {}.type
                    val gson = GsonBuilder()
                        .create()
                    val property: PlacesToStay = gson.fromJson(content, propertyType)
                    emit(property)
                } catch (e: Exception) {
                    print(e)
                }

            }
        }
    }
}
