//Main module view routing and state routing
angular.module('myApp', [
    'ui.router',
    'ngRoute',
    'myApp.filters',
    'myApp.services',
    'myApp.directives',
    'myApp.controllers'
])
    .config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {
        $routeProvider.when('/home', {
            templateUrl: 'partials/home.html',
            controller: 'HomeController',
            controllerAs: 'controller'
        }).when('/login', {
            templateUrl: 'partials/login.html',
            controller: 'NavigationController',
            controllerAs: 'controller'
        }).when('/post', {templateUrl: 'partials/posts.html', controller: 'PostController'})
            .when('/post/:id', {
                templateUrl: 'partials/postDetail.html',
                controller: 'PostViewController',
                controllerAs: 'post'
            })
            .when('/create', {templateUrl: 'partials/addPost.html', controller: 'PostController', controllerAs: 'post'})
            .otherwise({redirectTo: '/post'});
 }]);
