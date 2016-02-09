app.controller('TeacherController', ['$scope', 'Student', function ($scope, Student) {
    $rootScope.currentActiveState = 'teacher';

    $scope.student = {};

    Student.get({id: 1}, function (data) {
    });

    $scope.get = function () {
        Student.getAll(function (students) {
            var html = "";
            $.each(students, function (i) {
                html = html + JSON.stringify(students[i]) + "<br/>";
            });
            $('#container').html(html);
        });
    };

    $scope.post = function () {
        Student.save($scope.student);
    };
}]);