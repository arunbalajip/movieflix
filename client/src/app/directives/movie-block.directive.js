(function () {
    'use strict';
    angular.module("MovieFlix")
        .directive("movieBlock", movieBlock);

    function movieBlock() {
        var directive ={
            scope: {
                movieVm: "=",
                movie: "="

            },
            templateUrl:"app/views/movie-block.tmpl.html"
        }
        return directive;
    }

})();