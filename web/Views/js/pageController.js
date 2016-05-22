var angularApp = angular.module('angularApp');
angularApp.controller('pageController', function($scope, $http){
    var chooseNavbarItem = function (item) {
        var navbar = document
            .getElementById('navbar')
            .getElementsByTagName('li');
        var activeBtnClass = 'active';

        $(navbar).each(function () {
            $(this).removeClass(activeBtnClass);
        });
        $(item).addClass(activeBtnClass);
    }

});
