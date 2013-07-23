<%--
  Created by IntelliJ IDEA.
  User: Karim
  Date: 22/07/13
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="custom"/>
    <title>Achievement</title>

</head>

<body>
<div class="content">
    <div class="wrapper-content">
        <div class="container-fluid">
            <div class="row-fluid">
                <h1>Achievements</h1>

                <g:each in="${achievements}" var="achievement" status="i">
                    <g:render template="templates/singleAchievement" bean="${achievement}"></g:render>
                </g:each>
            </div>
        </div>
    </div><!-- wrapper-content -->
</div><!-- content -->
</body>
</html>