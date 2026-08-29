package com.company.board.game.glory.domain.stone

data class StoneContainer(
    val stones: Map<Stone, Int> = Stone.entries.associateWith { 0 },
) {

    companion object {
        fun of(ruby: Int = 0, sapphire: Int = 0, emerald: Int =0, diamond: Int = 0, onyx: Int = 0,
               gold: Int = 0): StoneContainer {
            return StoneContainer(mapOf(Stone.RUBY to ruby, Stone.SAPPHIRE to sapphire,
                Stone.EMERALD to emerald, Stone.DIAMOND to diamond, Stone.ONYX to onyx, Stone.GOLD to gold
            ))
        }
    }

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
