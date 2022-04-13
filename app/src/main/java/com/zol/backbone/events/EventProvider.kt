/**
 * Created by Spencer Searle on 4/27/21.
 */

package com.zol.backbone.events

import com.cren90.eventbus.EventBus
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
object EventProvider {

    fun post(event: Any) {
        EventBus.post(event)
    }

    fun getEvents(includeCurrentValue: Boolean = false): Flow<Any> =
        EventBus.getEvents(includeCurrentValue)
}