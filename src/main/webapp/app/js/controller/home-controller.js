app.controller('HomeController', ['$scope', function ($scope) {

    $scope.user = {};
    $scope.user.name = '';

    $scope.get = function () {
        $.ajax({
            type: "GET",
            cache: false,
            url: '/getRandomData',
            data: "",
            success: function (response) {
                var html = "";
                $.each(response.data, function (i) {
                    html = html + response.data[i] + "<br/>";
                });
                $('#container').html(html);
            }
        });
    };

    $scope.post = function () {
        if (!$scope.user.name) {
            alert("Enter your data!");
        } else {
            $.ajax({
                type: "POST",
                cache: false,
                url: '/persist',
                data: {
                    'data': $scope.user.name
                },
                success: function (response) {
                }
            });
        }
    };
}]);