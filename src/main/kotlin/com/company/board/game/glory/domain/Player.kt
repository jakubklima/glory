package com.company.board.game.glory.domain

import com.company.board.game.glory.domain.card.Card
import com.company.board.game.glory.domain.stone.StoneContainer

data class Player(val name: String, var stones: StoneContainer, val cards: List<Card>) {}
