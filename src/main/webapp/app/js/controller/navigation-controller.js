app.controller('NavigationController', ['$scope', '$location', function ($scope, $location) {
    $scope.current = {};
    $scope.current.year = new Date().getFullYear();

    $scope.isActive = function (page) {
        var currentRoute = $location.path().substring(1) || 'student';

        return page === currentRoute ? 'active' : '';
    };
}]);