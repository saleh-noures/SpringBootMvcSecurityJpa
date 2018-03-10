<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html ng-app='companyApp'>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="<c:url value="/js/company.js"/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/company.css"/>"/>
    <title>Company</title>
</head>
<body>

<form action="/SpringBootMvcSecurityJpaApplication/logout" method="post">
    <input type="submit" value="Sign Out"/>
</form>

<div ng-controller='deptsEmpsMainController' class='main'>

    <table class='striped center'>
        <tr>
            <th>Dept Id</th>
            <th>Dept Name</th>
            <th>Dept Location</th>
        </tr>
        <tr ng-repeat="dept in depts | orderBy : 'deptId'" ng-click='listDeptEmps(dept.deptId)'>
            <td>{{ dept.deptId }}</td>
            <td>{{ dept.deptName }}</td>
            <td>{{ dept.location }}</td>
        </tr>
    </table>

    <br><br>
    <input type='checkbox' ng-model="showAddEmp" style="margin-left: 25px; margin-bottom: 10px"> Show Add Employee
    <div>
        <div class='smallPane center' ng-show='showAddEmp'>
            <span class='header3'>Add New Employee:</span>
            <form ng-submit="submitForm()">
                <table>
                    <tr>
                        <td><label for="eName">Name: </label></td>
                        <td><input type='text' name='eName' id='eName' ng-model='emp.name'></td>
                    </tr>
                    <tr>
                        <td><label for="eSalary">Salary: </label></td>
                        <td><input type='number' name='eSalary' id='eSalary' ng-model='emp.salary'></td>
                    </tr>
                    <tr>
                        <td><label for="eHiredate">Hire date: </label></td>
                        <td><input type='date' name='eHiredate' id='eHiredate' ng-model='emp.hiredate'></td>
                    </tr>
                    <tr>
                        <td><label for="eGender">Sex: </label></td>
                        <td><select name='sex' id='sex' ng-model='emp.gender'>
                            <option value='m'>Male</option>
                            <option value='f'>Female</option>
                        </select> <br></td>
                    </tr>
                    <tr>
                        <td><label for="eDeptId">DeptId: </label></td>
                        <td><input type='text' name='eDeptId' id='eDeptId' ng-model='emp.deptId'></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type='submit' value='Add'></td>
                    </tr>
                </table>
            </form>
            <pre>emp = {{ emp | json }}</pre>
        </div>

        <br><br>

        <div>
            <table class='striped center'>
                <tr>
                    <th>Emp Id</th>
                    <th>Emp Name</th>
                    <th>Salary</th>
                    <th>Hire date</th>
                    <th>Gender</th>
                    <th></th>
                </tr>
                <tr ng-repeat="emp in emps | orderBy : 'empId'">
                    <td>{{ emp.empId }}</td>
                    <td>{{ emp.name }}</td>
                    <td>{{ emp.salary }}</td>
                    <td>{{ emp.hiredate | date : 'dd/MM/yyyy' }}</td>
                    <td>{{ emp.gender == 'm' ? 'Male' : 'Female' }}</td>
                    <td><span ng-click="deleteEMP(emp.empId)" style="color:red">X</span></td>
                </tr>
            </table>
        </div>

    </div>

</div>

<br>


</body>
</html>