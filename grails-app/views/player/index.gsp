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
    <title>Profile</title>

</head>

<body>
<div class="content">
    <div class="wrapper-content">
        <div class="container-fluid">
            <h1>Your Profile</h1>
            <div class="row-fluid">
                <g:render template="templates/profileInfo" bean="${player}"></g:render>
                <g:render template="templates/openQuests" bean="${player}"></g:render>
                <g:render template="templates/completedQuests" bean="${player}"></g:render>


            </div>
        </div>
    </div><!-- wrapper-content -->
</div><!-- content -->
</body>
</html>