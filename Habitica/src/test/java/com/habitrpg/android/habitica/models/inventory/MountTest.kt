package com.habitrpg.android.habitica.models.inventory

import android.content.Context
import com.habitrpg.android.habitica.R
import com.habitrpg.android.habitica.extensions.getTranslatedType
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Test

private const val FAKE_STANDARD = "Standard"
private const val FAKE_PREMIUM = "premium"

class MountTest {
    @MockK private lateinit var mockContext: Context
    private var mount: Mount = Mount()

    @Test
    fun testGetTranslatedStringReturnsStandard() {
        mount.type = "drop"
        every { mockContext.getString(R.string.standard) } returns FAKE_STANDARD

        val result = mount.getTranslatedType(mockContext)
        result shouldBe FAKE_STANDARD
    }

    @Test
    fun testGetTranslatedStringReturnsPremiumWhenContextIsNull() {
        mount.type = "premium"

        val result = mount.getTranslatedType(null)
        result shouldBe FAKE_PREMIUM
    }
}
