(function () {
    'use strict';
    angular.module("MovieFlix")
        .directive("thumbNail", thumbNail);
    thumbNail.$inject = ['$location'];
    function thumbNail($location) {

        var directive = {
            scope: {
                movId: "@",
                imgSrc: "@"

            },
            link: function (scope, elem, attrs) {
                var url = attrs.imgSrc;
                if (url) {
                    elem.css({
                        "background-image": "url(" + url + ")"
                    });
                }

                elem.on("click", function () {
                    scope.$apply(function () {
                        console.log(attrs.movId);
                        $location.path("movie-details"+"/"+ attrs.movId);
                    });
                });
            }
        };
        return directive;

    };

})();