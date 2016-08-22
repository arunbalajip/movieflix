(function(){
    'use strict';
    angular
        .module("MovieFlix")
        .controller("MovieDetailController",MovieDetailController);

    MovieDetailController.$inject =["movieService","$routeParams", "userService"];
    function MovieDetailController(movieService,$routeParams, userService){
        var vm = this;
        vm.getMovie = getMovie;
        vm.updateMovie = updateMovie;
        vm.isAdmin = userService.isAdmin();
        init();
        function init() {
            getMovie();
        }

        function getMovie() {
            movieService
                .getMovie($routeParams.id)
                .then(function (response) {
                    vm.movie = response;
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                });
        }

        function updateMovie(updateForm) {
            updateForm.$setPristine();
            vm.isUpdate = vm.isAdmin&&!vm.newuserComments? vm.isUpdate=!vm.isUpdate : false;
            vm.movie.userreviews = vm.movie.userreviews || [];
            if (vm.newuserComments) {
                vm.newuserComments.user = userService.getUsername(); // To the user name
                vm.movie.userreviews.push(vm.newuserComments);

            }
            vm.newuserComments = null;
            movieService
                .updateMovie(vm.movie, $routeParams.id)
                .then(function (response) {
                    vm.movie = response;
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                });

        }

    }
})();