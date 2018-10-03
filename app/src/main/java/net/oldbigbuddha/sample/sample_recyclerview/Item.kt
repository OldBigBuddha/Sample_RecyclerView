package net.oldbigbuddha.sample.sample_recyclerview

import java.util.*

data class Item(
        val mId: String = UUID.randomUUID().toString(),
        val mName: String,
        val mCreatedAt: Date = Date()
)