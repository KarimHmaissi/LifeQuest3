package org.hmaissi.lifeQuest

class QuestController {

    def springSecurityService

    //Show individual quest page
    def index() {
        redirect(action:"questLibrary")
    }

    def viewQuest() {
        def questId = params.questId
//        def quests = Quest.findAll()
        /*Debug
         */
        questId = 1

        if (questId != null) {
            Quest quest = Quest.get(questId)
            if (quest != null) {
                render(view: "quest", model: [quest:quest])
            }

        } else {
            //redirect to quest library
        }
    }

    def questLibrary() {

        def quests = Quest.all
        render(view: "questLibrary", model: [quests:quests])
    }


    def openQuests() {
        def player = Player.get(springSecurityService.principal.id)
        if (player) {
            def quests = player.openQuests

            render(view: "openQuests", model: [quests:quests])
        } else {
            //redirect to login page
        }


    }

    def completedQuests() {
        def player = Player.get(springSecurityService.principal.id)
        if (player) {
            def quests = player.completedQuests

            render(view: "completedQuests", model: [quests:quests])
        } else {
            //redirect to login page
        }
    }

    def createQuest() {

    }
}
