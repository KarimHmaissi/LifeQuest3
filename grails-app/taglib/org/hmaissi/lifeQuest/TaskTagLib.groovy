package org.hmaissi.lifeQuest

class TaskTagLib {
//    static nameSpace = "lq"

    def displayTask = {attrs, body ->

        def number = attrs.number
        def completedTasks = attrs.completedTasks
        def task = attrs.task

        def taskCompleted = isComplete(task.id, completedTasks)

        out << renderTask(taskCompleted, number, task)
    }

    def renderTask(taskCompleted, number, task) {
        render(template: "templates/singleTask", model:
                [task:task, number:number, taskCompleted:taskCompleted])
    }

    private boolean isComplete(taskId, completedTasks) {
        for(Long completedTaskId : completedTasks.id) {
            if (taskId == completedTaskId) {
                return true
            }
        }

        return false
    }

}
