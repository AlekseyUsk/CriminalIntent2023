package com.bignerdranch.android.criminalintent.model

import java.util.Date
import java.util.UUID

data class Crime(val id: UUID = UUID.randomUUID(), //генерирования универсально-уникальных идентификаторов
                 var title: String = "",
                 var date: Date = Date(),          // дата преступления по умолчанию
                 var isSolved : Boolean = false
)
