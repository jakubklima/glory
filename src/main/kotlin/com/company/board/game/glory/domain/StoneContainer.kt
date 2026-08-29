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

    fun add(vararg pairs: Pair<Stone, Int>): StoneContainer {
        return add(pairs.toMap())
    }

    fun add(stoneContainer: StoneContainer): StoneContainer {
        return add(stoneContainer.stones)
    }

    fun add(other: Map<Stone, Int>): StoneContainer {
        val mutable = this.stones.toMutableMap()
        other.forEach { (stone, count) ->
            mutable[stone] = (mutable[stone] ?: 0) + count }
        return StoneContainer(mutable)
    }

    operator fun plus(other: StoneContainer): StoneContainer {
        return this + other.stones
    }

    operator fun plus(other: Map<Stone, Int>): StoneContainer {
        val mutable = this.stones.toMutableMap()
        other.forEach { (stone, count) ->
            mutable[stone] = (mutable[stone] ?: 0) + count }
        return StoneContainer(mutable)
    }

    operator fun minus(other: Map<Stone, Int>): StoneContainer {
        return this + other.mapValues { -it.value }
    }

    operator fun minus(other: StoneContainer): StoneContainer {
        return this - other.stones
    }
}
