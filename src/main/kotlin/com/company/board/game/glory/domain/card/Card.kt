package com.company.board.game.glory.domain.card

import com.company.board.game.glory.domain.stone.Stone
import com.company.board.game.glory.domain.stone.StoneContainer

data class Card(val id: CardId,
                val level: LevelCard,
                val bonusStone: Stone,
                val cost: StoneContainer,
                val prestigePoint: Int) {
}