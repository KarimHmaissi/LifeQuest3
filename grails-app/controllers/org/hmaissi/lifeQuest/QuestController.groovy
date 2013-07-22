package org.hmaissi.lifeQuest

class QuestController {

    //Show quest library
    def index() {

    }

    //Show individual quest page
    def showQuest() {
        def questId = params.questId
        if (questId != null) {
            Quest quest = Quest.get(questId)
            if (quest != null) {
                render(view: "quest", model: [quest:quest])
            }

        }
    }
}
