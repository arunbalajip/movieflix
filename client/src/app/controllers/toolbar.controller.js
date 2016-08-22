(function () {
    'use strict';
    angular
        .module("MovieFlix")
        .controller("ToolBarController", ToolBarController);

    ToolBarController.$inject = ["auth", "store", "$location", "userService"];
    function ToolBarController(auth, store, $location, userService) {
        var vm = this;
        vm.login = login;
        vm.logout = logout;
        vm.auth = auth;
        init(false);
        function init(isSignIn) {
            vm.isAdmin = userService.isAdmin();
            vm.username = userService.getUsername();
            userService.setSignIn(isSignIn);
            vm.userSignButton  = userService.isSignIn();
        }

        function login() {
            console.log(auth);
            auth.signin({}, function (profile, token) {
                store.set('profile', profile);
                store.set('token', token);
                init(true);
                $location.path("/movie");
            }, function (error) {
                console.log(error);
            });
        }

        function logout() {
            store.remove('profile');
            store.remove('token');
            auth.signout();
            init(false);
            vm.isAdmin = false;
            $location.path("/movie");
        }

    }
})();