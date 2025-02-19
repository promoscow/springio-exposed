package ru.xpendence.exposed.repository

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.xpendence.exposed.ExposedApplicationTests
import java.util.UUID
import kotlin.test.assertTrue

class RestaurantRepositoryTest : ExposedApplicationTests() {

    @Autowired
    private lateinit var repository: RestaurantRepository

    @Test
    @DisplayName("getRestaurants(): проблема N + 1. Проверяем, был ли пользователь в ресторане")
    fun getRestaurants() {
        val userId = UUID.fromString("1031f963-957c-425f-962e-767080a699cb")
        val restaurants = repository.getAllByUserOrdered(userId)

        assertTrue { restaurants.map { it.name }.contains("Три поросёнка") }
    }

    @Test
    fun getByNameILike() {
        val namePart = "большая"
        val restaurants = repository.getByNameILike(namePart)
        assertTrue { restaurants.isNotEmpty() }
    }
}