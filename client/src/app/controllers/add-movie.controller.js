(function(){
    'use strict';
    angular
        .module("MovieFlix")
        .controller("AddMovieController",AddMovieController);

    AddMovieController.$inject =["movieService","$window"];
    function AddMovieController(movieService,$window) {
        var vm = this;
        vm.addNewMovie = addNewMovie;

        function addNewMovie(addMovieForm) {

            movieService
                .addMovie(vm.newmovie)
                .then(function (response) {
                })
                .catch(function(error){
                    console.log(error);
                });
            vm.newmovie = null;
            addMovieForm.$setPristine();
            $window.alert("Movie Submitted");
        }
        console.log("AddMovieController");
    }
})();