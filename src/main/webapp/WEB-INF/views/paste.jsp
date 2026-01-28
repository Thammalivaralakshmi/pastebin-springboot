<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Paste</title>
    <style>
        body {
            background-color:#ffffff ;
            color:#121212 ;
            font-family: monospace;
        }
        pre {
            white-space: pre-wrap;
            font-size: 14px;
        }
    </style>
</head>
<body>

<pre>
<c:out value="${content}" />
</pre>

</body>
</html>