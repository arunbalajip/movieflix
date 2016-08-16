(function () {
    angular.module('MovieFlix')
        .filter('ifEmpty', ifEmpty);
    function ifEmpty() {
        return function (input, defaultValue) {
            if (angular.isUndefined(input) || input === null || input === '') {
                return defaultValue;
            }

            return input;
        }
    }



})();
