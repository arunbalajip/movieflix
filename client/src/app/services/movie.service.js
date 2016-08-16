(function () {
    angular.module("MovieFlix")
        .service("movieService", movieService);

    movieService.$inject=["$http","$q"];
    function movieService($http,$q) {
        var vm = this;
        vm.getAllMovies = getAllMovies;
        vm.getMovie = getMovie;
        vm.addMovie = addMovie;
        vm.updateMovie = updateMovie;
        vm.deleteMovie = deleteMovie;
        function getAllMovies(){
            return $http
                .get("http://localhost:8080/server/api/movies/")
                .then(success,error);
        }
        function addMovie(movie) {
            return $http
                .post("http://localhost:8080/server/api/movies/", movie)
                .then(success,error);
        }
        function getMovie(id){
            return $http
                .get("http://localhost:8080/server/api/movies/"+id)
                .then(success,error);
        }
        function updateMovie(movie, id) {
            return $http
                .put("http://localhost:8080/server/api/movies/"+id, movie)
                .then(success,error);

        }
        function deleteMovie(id) {
            return $http
                .delete("http://localhost:8080/server/api/movies/"+id)
                .then(success,error);
        }
        function success(response) {
            return response.data;
        }
        function error(){
            return $q.reject(error.status);
        }
    }
})();