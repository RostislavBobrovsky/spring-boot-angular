app.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

    $stateProvider
        .state('home', {
            name: 'home',
            url: '/home',
            templateUrl: 'html/home.html'
        });

    $urlRouterProvider.otherwise('/home');
}]);