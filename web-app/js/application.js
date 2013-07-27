function init(pageName) {
    if(pageName == 'quest') {
        addTaskHandler();
    }
}

/**
 * Add handler to tasks. If a task is completed details sent to server
 * Retrieves json feed and updates page accordingly
 */
function addTaskHandler() {
    console.log("handler added")
    var $quest =  $('div.quest');
    $quest.on('click', '.task', function(e) {

        e.preventDefault();
        e.stopPropagation();
        console.log("task clicked");
        console.log("Task Id = " + $(this).attr('id'))
        var $this = $(this),
            $quest = $('div.quest')

        //If as task is already complete no need to do anything
        // or if quest is not open
        if($this.hasClass('taskComplete') || !($quest.hasClass('questOpen'))) {
            console.log("task complete NOT SENT")
        } else {
            console.log("task complete SENT")

            var taskId,
                questId,
                data;

            questId = $quest.attr('id');
            taskId = $this.attr('id');

            data = {
                'questId':questId,
                'taskId':taskId
            };
            console.log("Getting json from server")

            $.getJSON('completeTask', data, function(data) {
                if(data != null) {
                    console.log("recieved json from server")
                    if(data.levelUp) {
                        showLevelUpNotification(data.xpGain, data.newLevel);
                    }

                    if(data.questComplete) {
                        //Update quest look
                        $quest.removeClass('questOpen')
                        $quest.addClass('questComplete')
                    }

                    showXpGainNotification(data.xpGain)

                    //mark task as complete
                    $this.addClass('taskComplete');

                }
            });
        }


    });
}

function showLevelUpNotification(xpGain, newLevel) {
    console.log("level up: " + newLevel);
}

function showXpGainNotification(xpGain) {
    console.log("xp gain! + " + xpGain);
}