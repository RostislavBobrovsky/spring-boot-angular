app.controller('StudentController', ['$scope', '$state', 'Student', function ($scope, $state, Student) {

    $scope.student = {};

    Student.getAll(function (students) {
        $scope.students = students;
    });

    $scope.post = function () {
        Student.save($scope.student);
    };

    function getSelectedStudent() {
        for (var i = 0; i < $scope.students.length; i++) {
            if ($scope.students[i].hasOwnProperty('selected') && $scope.students[i].selected) {
                return $scope.students[i];
            }
        }

        return null;
    }

    $scope.goToState = function (state, additionalParams) {
        var selectedStudents = getSelectedStudent();
        if (selectedStudents) {
            var params = {id: selectedStudents.id};
            if (additionalParams) {
                params[additionalParams.key] = additionalParams.value;
            }
            $state.go(state, params);
        }
    };
}]);