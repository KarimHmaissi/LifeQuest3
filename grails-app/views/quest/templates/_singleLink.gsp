<div class="row-fluid linkContainer">
    <div class="span1">
        <div class="number">${number}</div>
    </div>
    <div class="span11">

        <h3>${it.title}</h3>

        <div class="row-fluid">
            <div class="span11">
                <div class="linkType">
                    <p><strong>${it.type}</strong></p>
                </div>
                <div class="linkDescription">
                    <p>${it.description}</p>
                </div>
            </div>
        </div>

        <h4>XP Gain: +${it.xpGain} Points</h4>

        %{--<div class="progress progress-striped">--}%
            %{--<div class="bar" style="width: ${it.xpGain}%;"></div>--}%
        %{--</div>--}%
    </div>
</div>