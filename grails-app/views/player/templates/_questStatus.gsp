<li>
    <span class="btn-disable"> <i class="icon-refresh"></i></span>  ${quest?.title} <strong class="label label-info"> ${percentComplete}%</strong>
    <div class="progress">
        <div class="bar" style="width: ${percentComplete}%;"></div>
    </div>
    <g:link class="btn btn-small btn-primary" controller="quest" action="viewQuest" params="[questId:quest?.id]">View Quest</g:link>
</li>