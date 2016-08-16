(function () {
    angular.module("MovieFlix")
        .service("userService", userService);

    userService.$inject=["store"];
    function userService(store) {
        var vm = this;
        vm.isAdmin = isAdmin;
        vm.getUsername = getUsername;
        vm.isSignIn = isSignIn;
        vm.setSignIn = setSignIn;

        function isAdmin() {
            var isAdmin;
            var profile = store.get("profile");
            if(profile) {
                isAdmin = profile.roles[0] == "admin" ? true : false;
            }
            return isAdmin;
        }
        function getUsername() {
            var username = "guest";
            var profile = store.get("profile");
            if(profile) {
                username = profile.name;
            }
            return username;
        }
        function setSignIn(isSignIn) {
            var profile = store.get("profile");
            vm.SignIn = isSignIn || profile; // when user refreshes
        }
        function isSignIn() {
            return vm.SignIn;
        }
    }
})();