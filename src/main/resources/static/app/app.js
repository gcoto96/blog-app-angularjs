// (function(angular) {
//   angular.module("myApp.controllers", []);
//   angular.module("myApp.services", []);
//   angular.module("myApp", ["ngResource", "myApp.controllers", "myApp.services"]);
// }(angular));
//
// 'use strict';
// angular.module('myApp', [
//   'ui.router',
//   'ngResource'
// ]).
// config(['$stateProvider', '$urlRouterProvider', '$locationProvider', function($stateProvider, $urlRouterProvider, $locationProvider) {
//   // For any unmatched url, redirect to /view1
//   $urlRouterProvider.otherwise('/route1');
//
//   // $stateProvider
//   //     .state('route1', {
//   //       url: "/route1",
//   //       templateUrl: "route1.html"
//   //     })
//   //     .state('route1.list', {
//   //       url: "/list",
//   //       templateUrl: "route1.list.html",
//   //       controller: function($scope){
//   //         $scope.items = ["A", "List", "Of", "Items"];
//   //       }
//   //     })
//   //
//   //     .state('route2', {
//   //       url: "/route2",
//   //       templateUrl: "route2.html"
//   //     })
//   //     .state('route2.list', {
//   //       url: "/list",
//   //       templateUrl: "route2.list.html",
//   //       controller: function($scope){
//   //         $scope.things = ["A", "Set", "Of", "Things"];
//   //       }
//   //     })
//   // ;
//   $locationProvider.html5Mode({
//     enabled: true,
//     requireBase: true
//   });
//
// }]);


angular.module('myApp', [
    'ui.router',
    'ngRoute',
    'myApp.filters',
    'myApp.services',
    'myApp.directives',
    'myApp.controllers'
])
    .config(['$routeProvider','$httpProvider', function ($routeProvider, $httpProvider) {


    $routeProvider.when('/home', {
        templateUrl: 'partials/home.html',
        controller: 'HomeController',
        controllerAs: 'controller'
    }).when('/login', {
        templateUrl: 'partials/login.html',
        controller: 'NavigationController',
        controllerAs: 'controller'
    }).when('/post', {templateUrl: 'partials/posts.html', controller: 'PostController'})
        .when('/post/:id', {templateUrl: 'partials/postDetail.html', controller: 'PostViewController',controllerAs: 'post'})
        .when('/create', {templateUrl: 'partials/addPost.html', controller: 'PostController', controllerAs: 'post'})
        .otherwise({redirectTo: '/post'});

//     .config(['$stateProvider','$httpProvider', function ($stateProvider, $httpProvider) {
//
//         $stateProvider.state('home', { // state for showing all movies
//             url: '/home',
//             templateUrl: 'partials/home.html',
//             controller: 'HomeController',
//             controllerAs: 'controller'
//         }).state('login', { //state for showing single movie
//             url: '/login',
//             templateUrl: 'partials/login.html',
//             controller: 'NavigationController',
//             controllerAs: 'controller'
//         }).state('post', { //state for adding a new movie
//             url: '/post',
//             templateUrl: 'partials/posts.html', controller: 'PostController'
//         }).state('viewPost', { //state for updating a movie
//             url: '/post/:id',
//             templateUrl: 'partials/postDetail.html', controller: 'PostViewController'
//         })
//             .state('create', { //state for updating a movie
//                 url: '/create',
//                 templateUrl: 'partials/addPost.html', controller: 'PostController', controllerAs: 'post'
//             });
//
//         $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
//     }]).run(function($state) {
//     $state.go('post'); //make a transition to movies state when app starts
// });







}]);
