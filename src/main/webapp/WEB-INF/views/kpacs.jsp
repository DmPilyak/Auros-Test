<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>KPacs Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>

<h1>KPac List</h1>

<c:if test="${!empty listKPacs}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Title</th>
            <th width="120">Description</th>
            <th width="120">Date</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listKPacs}" var="kpac">
            <tr>
                <td>${kpac.id}</td>
                <td><a href="${kpac.id}" target="_blank">${kpac.title}</a></td>
                <td>${kpac.descript}</td>
                <td>${kpac.date}</td>
                <td><a href="<c:url value='/remove/${kpac.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:url var="addAction" value="/kpac/add"/>

<form:form action="${addAction}" modelAttribute="kpac">
    <table>
        <c:if test="${!empty kpac.title}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="title">
                    <spring:message text="Title"/>
                </form:label>
            </td>
            <td>
                <form:input path="title"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="descript">
                    <spring:message text="Description"/>
                </form:label>
            </td>
            <td>
                <form:input path="descript"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="date">
                    <spring:message text="Date"/>
                </form:label>
            </td>
            <td>
                <form:input type="date" path="date"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty kpac.title}">
                    <input type="submit"
                           value="<spring:message text="Edit kpac"/>"/>
                </c:if>
                <c:if test="${empty kpac.title}">
                    <input type="submit"
                           value="<spring:message text="Add kpac"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

</html>