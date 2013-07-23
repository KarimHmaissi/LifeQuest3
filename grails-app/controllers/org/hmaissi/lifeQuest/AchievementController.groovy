package org.hmaissi.lifeQuest

class AchievementController {

    def springSecurityService

    def index() {
        def player = Player.get(springSecurityService.principal.id)
        def achievements = player.achievements
        render(view: "index", model:[achievements:achievements]  )
    }




}
