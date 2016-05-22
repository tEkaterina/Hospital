var hospitalApp = angular.module('hospitalApp', [])
    .config(function($routeProvider) {
        $routeProvider
            .when('/admin/new',
            {
                templateUrl: 'views/addNewAdmin.jsp',
                controller: 'userController'
            })
            .otherwise({redirectTo:'/'});
    });

