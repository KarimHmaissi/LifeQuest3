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

    def displayQuestStatus = {attrs, body ->
        def questList = attrs.questList
        def player = attrs.player

        def output = ""
        def percentComplete

        for(Quest quest: questList) {
            percentComplete = getQuestCompletePercentage(player, quest)
            output += render(template: "templates/questStatus", model: [quest:quest, percentComplete:percentComplete])
        }

        out << output
    }

    def renderQuestStatus() {

    }

    /**
     * Calculates how much of a quest a player has completed
     * @param player
     * @param quest
     * @return
     */
    private int getQuestCompletePercentage(Player player,Quest quest) {

        println "completed tasks by player"
        for(Long id: player.completedTasks.id) {
            print "id: " + id
        }

        println "quest tasks"
        for(Long id: quest.tasks.id) {
            print "id: " + id
        }

        def tasks = quest.tasks

        def totalTasksInQuest = tasks.size()
        def completedTasks = 0

        tasks.retainAll(player.completedTasks)

        completedTasks = tasks.size()

        if (totalTasksInQuest != 0) {
            return (completedTasks / totalTasksInQuest) * 100
        } else {
            return 0
        }


//        def tasksCompleted = player.completedTasks.id
//        def totalTasks = quest.tasks.size()
//
//
//        tasksCompleted = totalTasks.retainAll((tasksCompleted))
//
//        println "tasks completed size" + tasksCompleted.size()
//        println "total tasks " +totalTasks
//
//        if (totalTasks != 0) {
//            return (tasksCompleted.size() / totalTasks) * 100
//        } else {
//            return 0
//        }



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
