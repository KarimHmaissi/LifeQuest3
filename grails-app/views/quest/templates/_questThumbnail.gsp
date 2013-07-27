<div class="questThumbnail">
    <h3 class="questTitle">${quest?.title}</h3>
    <g:img class="questThumbnailImage" dir="images" file="bootstrap.png"/>
    <p class="questDescription">${quest?.description}</p>
    <g:link class="btn btn-large btn-primary" action="viewQuest" params="[questId:quest?.id]">View Quest</g:link>
    <g:if test="${isOpen == true}">
        <h2>Quest Open</h2>
    </g:if>
    <g:elseif test="${isCompleted == true}">
        <h3>Quest Complete</h3>
    </g:elseif>
    <g:else>
        <g:link class="btn btn-large btn-primary" controller="player" action="addQuestToOpen" params="[questId:quest?.id]">Add to open quests</g:link>
    </g:else>

</div>