package com.company.board.game.glory.domain

import com.company.board.game.glory.domain.card.CardId
import com.company.board.game.glory.domain.stone.Stone
import com.company.board.game.glory.domain.stone.StoneContainer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
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

    @Test
    fun test() {
       val map = mapOf(1 to 2, 2 to 4, 3 to 6)
        println(map)
        println(map.mapValues{it.value * 2})
    }

    @Test
    fun empty() {
        val cardId_1 = CardId(1)
        val cardId_2 = CardId(1)
//        println(cardId_1 === cardId_2)


        val x = 1
        val y = 1

        println(x == y)

    }

    @Test
    fun test1() {
        val x = StoneContainer(mapOf(Stone.SAPPHIRE to 1))
        println(x)
    }

}