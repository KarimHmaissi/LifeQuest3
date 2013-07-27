package org.hmaissi.lifeQuest

class QuestTagLib {

    def displayQuest = {attrs, body ->
        def completedQuests = attrs.completedQuests
        def openQuests = attrs.openQuests
        def quest = attrs.quest
        def allOpen = attrs.allOpen
        def allCompleted = attrs.allCompleted

        if (allOpen == true) {
            out << renderQuest(quest, true, false)
        }

        if (allCompleted == true) {
            out << renderQuest(quest, false, true)
        }

        if (allCompleted == false && allOpen == false) {
            if (completedQuests != null && openQuests != null) {
                def isOpen = isQuestOpen(openQuests, quest.id)
                def isCompleted = isQuestCompleted(completedQuests, quest.id)

                out << renderQuest(quest, isOpen, isCompleted)
            } else {
                out << renderQuest(quest, false, false)
            }

        }

    }

    def renderQuest(quest, isOpen, isCompleted) {
        render(template: "templates/questThumbnail", model:
                [quest:quest, isOpen:isOpen, isCompleted:isCompleted])
    }

    private boolean isQuestOpen(openQuests, questId) {
        for(Long openQuestId : openQuests.id) {
            if(openQuestId == questId) {
                return true
            }
        }

        return false
    }

    private boolean isQuestCompleted(completedQuests, questId) {
        for(long completedQuestId : completedQuests.id) {
            if (completedQuestId == questId) {
                return true
            }
        }

        return false
    }

}
