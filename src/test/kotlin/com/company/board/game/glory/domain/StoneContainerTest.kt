package com.company.board.game.glory.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class StoneContainerTest {

    @ParameterizedTest
    @EnumSource(Stone::class)
    fun shouldAddStone(stone: Stone) {
        val container = StoneContainer()
        val addedStone = container.addStone(stone, 1)
        assertThat(addedStone.stones[stone]).isEqualTo(1)
        println(addedStone)
    }

    @ParameterizedTest
    @EnumSource(Stone::class)
    fun shouldRemoveStone(stone: Stone) {
        val container = StoneContainer(Stone.entries.associateWith { 1 })
        val addedStone = container.remove(stone, 1)
        assertThat(addedStone.stones[stone]).isEqualTo(0)
        println(addedStone)
    }

}