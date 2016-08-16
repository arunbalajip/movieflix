(function () {
    'use strict';

    angular
        .module("MovieFlix", ['ngRoute', 'ngMessages', 'auth0', 'angular-storage', 'angular-jwt'])
        .config(moduleConfig);

    moduleConfig.$inject = ['$routeProvider', '$provide', 'authProvider']
    function moduleConfig($routeProvider, $provide, authProvider) {
        authProvider.init({
            domain:"movieflix.auth0.com",
            clientID:"cu6KuZC7nY3vyt9EDXkXffNZF3366ke2"
        })
        $routeProvider
            .when("/movie", {
                templateUrl: "app/views/movie-list.tmpl.html",
                controller: "MovieListController",
                controllerAs: "movieVm"
            })
            .when("/movie-details/:id", {
                templateUrl: "app/views/movie-detail.tmpl.html",
                controller: "MovieDetailController",
                controllerAs: "movieDetailVm"
            })
            .when("/add-movie", {
                templateUrl: "app/views/add-movie.tmpl.html",
                controller: "AddMovieController",
                controllerAs: "addMovieVm"
            })
            .otherwise({
                redirectTo: "/movie"
            });

    }

})();