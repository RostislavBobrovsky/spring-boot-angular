app.controller('StudentController', ['$scope', 'Student', function ($scope, Student) {

    $scope.student = {};

    Student.get({id: 1}, function (data) {
    });

    $scope.get = function () {
        Student.getAll(function (students) {
            $scope.students = students;
        });
    };

    $scope.post = function () {
        Student.save($scope.student);
    };
}]);