(function(){
    'use strict';
    angular
        .module("MovieFlix")
        .controller("MovieListController",MovieListController);

    MovieListController.$inject =["movieService","$window","store", "userService"];
    function MovieListController(movieService,$window,store, userService){
        var vm = this;
        vm.getAllMovies = getAllMovies;
        vm.deleteMovie = deleteMovie;
        vm.topRatedMovies = topRatedMovies;
        vm.topRatedSeries = topRatedSeries;
        vm.isAdmin = userService.isAdmin();
        init();
        function init() {
            getAllMovies();
            vm.sorter = {
                sortBy: "title",
                sortOrder: false
            };
            vm.searchText = {};
            vm.searchText.type = {};
        }
        function getAllMovies() {

            movieService
                .getAllMovies()
                .then(function (response) {
                    vm.movies = response;
                })
                .catch(function(error){
                    console.log(error);
                });
        }
        function deleteMovie(id) {
            movieService
                .deleteMovie(id);
            _.remove(vm.movies,function (movie) {
                return id === movie.id;
            })
        }
        function topRatedMovies(){
            vm.searchText.type.value="movie";
            vm.sorter.sortBy="imdb.imdbRating";
        }
        function topRatedSeries(){
            vm.searchText.type.value="series";
            vm.sorter.sortBy="imdb.imdbRating";
        }
    }
})();