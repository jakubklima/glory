package com.company.board.game.glory.domain

import com.company.board.game.glory.domain.card.Card
import com.company.board.game.glory.domain.card.CardContainer
import com.company.board.game.glory.domain.card.CardId
import com.company.board.game.glory.domain.stone.StoneContainer

class Board(val players: List<Player>, var cards: CardContainer, var stones: StoneContainer) {
    var playerWhoPlay: Player = players.first()

    fun takeCard(player: Player, cardId: CardId, stones: StoneContainer) {
        val card = cards.cards.get(cardId)
        validateStonesBeforeTakingCard(player.cards,player.stones, card)

    }

    fun validateStonesBeforeTakingCard(playersCard: List<Card>, playersStones: StoneContainer,
                                       cart: Card
    ) {

    }

}