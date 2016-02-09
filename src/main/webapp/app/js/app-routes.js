app.config(['$stateProvider', '$urlRouterProvider', '$httpProvider', '$provide',
    function ($stateProvider, $urlRouterProvider, $httpProvider, $provide) {

        $provide.factory('MainHttpInterceptor', ['$q', '$rootScope', function ($q, $rootScope) {
            return {
                request: function (config) {
                    return config || $q.when(config);
                },
                requestError: function (rejection) {
                    return $q.reject(rejection);
                },
                response: function (response) {
                    return response || $q.when(response);
                },
                responseError: function (rejection) {

                    if (rejection.status == 401 || rejection.status == 405) {
                        alert(JSON.stringify(rejection));
                    } else if (rejection.status == 403) {
                        alert(JSON.stringify(rejection));
                    } else if (rejection.status == 404) {
                        alert(JSON.stringify(rejection));
                    } else if (rejection.status == 409) {
                        alert(JSON.stringify(rejection));
                    } else if (rejection.status == 422) {
                        alert(JSON.stringify(rejection));
                    }

                    return $q.reject(rejection);
                }
            };
        }]);

        $httpProvider.interceptors.push('MainHttpInterceptor');

        $urlRouterProvider.otherwise('/student');

        $stateProvider
            .state('student', {
                name: 'student',
                url: '/student',
                templateUrl: 'html/student.html'
            })
            .state('teacher', {
                name: 'teacher',
                url: '/teacher',
                templateUrl: 'html/teacher.html'
            })
        ;
    }
]);