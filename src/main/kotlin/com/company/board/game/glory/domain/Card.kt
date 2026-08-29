package com.company.board.game.glory.domain

data class Card(val id: CardId,
                val level: LevelCard,
                val bonusStone: Stone,
                val cost: StoneContainer,
                val prestigePoint: Int) {
}