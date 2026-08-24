package com.company.board.game.glory.domain

data class StoneContainer(
    val stones : Map<Stone, Int> = Stone.entries.associateWith { 0 },
) {

    fun addStone(stone: Stone, count: Int): StoneContainer {
        return StoneContainer(stones + (stone to (stones[stone] ?: 0) + count))
   }

    fun remove(stone: Stone, count: Int): StoneContainer {
        return StoneContainer(stones + (stone to (stones[stone] ?: 0) - count))
    }
}
