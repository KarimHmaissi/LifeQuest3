package org.hmaissi.lifeQuest

class PlayerController {

    def springSecurityService

    def index() {

    }

    def addQuestToOpen() {
        def player = Player.get(springSecurityService.principal.id)
        def questId = params.questId
        if (player && questId) {
            def quest = Quest.get(questId)
            player.addToOpenQuests(quest)
            player.save()
            redirect(controller: "quest", action: "openQuests")
        } else {
            //TODO error
        }
    }
}