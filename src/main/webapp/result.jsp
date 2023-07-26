<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
    table {
            border-collapse: collapse;
            width: 60%;
            border: 1px solid black; /* Set the table border */
        }

        th, td {
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #00008B;
            border-bottom: 1px solid black; /* Set the header cell bottom border */
            color: white;
        }

        tr:last-child td {
            border-bottom: 1px solid black; /* Set the last row cells bottom border */
        }

        td:not(:last-child) {
            border-right: 1px solid black; /* Set the right border for non-last cells in a row */
        }
</style>
<script>
	function showName(studNm) {
		alert("Student Name: " + studNm);
	}
</script>
<head>
    <title>Welcome Page</title>
</head>
<body>

    <h2>Welcome ${userName}</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Department</th>
                <th>Student ID</th>
                <th>Marks</th>
                <th>Pass %</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${stdslist}" varStatus="loop">
            	<c:choose>
		            <c:when test="${loop.first || !student.departmentId.equals(prevDepartmentId)}">
		                <c:set var="prevDepartmentId" value="${student.departmentId}" />
		                <tr>
		                    <td rowspan="${departmentRowspanMap[student.departmentId]}">${student.departmentId}</td>
		                    <td><a href="#" onclick="showName('${student.studentName}')">${student.studentId}</a></td>
		                    <td>${student.marks}</td>
		                    <td rowspan="${departmentRowspanMap[student.departmentId]}">${atPercentages[student.departmentId]}</td>
		                </tr>
		            </c:when>
		            <c:otherwise>
		                <tr>
		                    <td><a href="#" onclick="showName('${student.studentName}')">${student.studentId}</a></td>
		                    <td>${student.marks}</td>
		                </tr>
		            </c:otherwise>
            	</c:choose>
          </c:forEach>
        </tbody>
    </table>
</body>
</html>
