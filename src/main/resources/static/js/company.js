var app = angular.module('companyApp', []);


/* This is How you can share data between controllers, We have one controller in this page though */
app.factory('factoryData', function () {

    var data = {deptId: ''};

    function getDeptId() {
        return data.deptId;
    }

    function setDepartmenttId(deptId) {
        data.deptId = deptId;
    }

    return {
        getDeptId: getDeptId,
        setDeptId: setDepartmenttId
    };
});


app.service('companySharedServices', function () {
    this.listDeptEmps = function ($scope, $http, deptId) {
        $http.get('/SpringBootMvcSecurityJpaApplication/rest/depts/' + deptId + '/emps').then
        (
            function (response) {
                $scope.emps = response.data;
            }
        )

    }
});

/////////////////////////////////////////deptsEmpsMainController////////////////////////////////////////////////////////

app.controller('deptsEmpsMainController', function ($scope, $http, factoryData, companySharedServices) {
    /* Returns All Deps */
    $http.get("/SpringBootMvcSecurityJpaApplication/rest/depts/").then(
        function (response) {
            $scope.depts = response.data;
        }
        ,
        function (response) {
            $scope.depts = "Something went wrong";
        }
    )

    /* Returns All Emps */
    $http.get('/SpringBootMvcSecurityJpaApplication/rest/emps').then(
        function (response) {
            $scope.emps = response.data;
        }
    )

    /* Returns Depts Emps */
    $scope.listDeptEmps = function (deptId) {
        factoryData.setDeptId(deptId);
        companySharedServices.listDeptEmps($scope, $http, factoryData.getDeptId(deptId));
    }

    /* delete Emp */
    $scope.deleteEMP = function (empId) {
        $http.delete('/SpringBootMvcSecurityJpaApplication/rest/emps/' + empId).then(
            function (response) {
                companySharedServices.listDeptEmps($scope, $http, factoryData.getDeptId());
            }
        )
    }

    $scope.submitForm = function () {

        $scope.emp.deptId = factoryData.getDeptId();
        $http.post('/SpringBootMvcSecurityJpaApplication/rest/depts/' + $scope.emp.deptId + '/emps', $scope.emp).then(
            function (response) {
                if (response.status == '201') {
                    companySharedServices.listDeptEmps($scope, $http, factoryData.getDeptId());
                    $scope.emp = null;
                }

            }
        )
    }
});


/* All applications have a $rootScope which is the scope created on the HTML element that contains the ng-app directive. */

