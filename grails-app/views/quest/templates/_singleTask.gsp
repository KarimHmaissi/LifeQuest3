<div class="row-fluid linkContainer">
    <div class="span1">
        <div class="number">${number}</div>
    </div>
    <div class="span11">

        <g:if test="${taskCompleted == true}">
            <a class="task taskComplete" href="${task.url}" id="${task.id}"><h3>${task.title}</h3></a>
        </g:if>
        <g:else>
            <a class="task" href="${task.url}" id="${task.id}"><h3>${task.title}</h3></a>
        </g:else>


        <div class="row-fluid">
            <div class="span11">
                <div class="linkType">
                    <p><strong>${task.type}</strong></p>
                </div>
                <div class="linkDescription">
                    <p>${task.description}</p>
                </div>
            </div>
        </div>

        <h4>XP Gain: +${task.xpGain} Points</h4>


        %{--<div class="progress progress-striped">--}%
            %{--<div class="bar" style="width: ${it.xpGain}%;"></div>--}%
        %{--</div>--}%
    </div>
</div>