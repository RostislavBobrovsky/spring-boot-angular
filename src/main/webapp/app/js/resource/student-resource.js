app.factory('Student', ['$resource', function ($resource) {

    return $resource("/student/:id", {}, {
        getAll: {
            method: "GET",
            url: "/student/all-bookings",
            isArray: true
        }
    });
}]);