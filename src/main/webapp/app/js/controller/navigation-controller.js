app.controller('NavigationController', ['$scope', '$rootScope', '$location', function ($scope, $rootScope, $location) {

    $rootScope.currentActiveState = {};

    $scope.current = {};
    $scope.current.year = new Date().getFullYear();

    $scope.isActive = function (page) {
        var currentRoute = $location.path().substring(1) || 'student';

        return page === currentRoute ? 'active' : '';
    };
}]);