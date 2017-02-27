app.controller('PropertyStudentController', ['$scope', '$state', '$stateParams', 'Student', function ($scope, $state, $stateParams, Student) {

    $scope.student = {};

    //var id = $stateParams.id;
    //if (id) {
    //    Student.get({id: id}, function (data) {
    //        $scope.student = data;
    //    });
    //}
    //
    //$scope.post = function () {
    //    Student.save($scope.student);
    //};
}]);