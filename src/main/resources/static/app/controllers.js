'use strict';

/* Controllers */

angular.module('myApp.controllers', [])
    .controller('PostController',
        ['$scope', 'Posts','$location','$state',
            function ($scope, Posts, $location ,$state) {
                $scope.posts = {};
                $scope.posts = Posts.query({
                });

                $scope.addPost = function (post) {
                    $scope.post = {};
                    new Posts({
                        title:post.title,
                        author:post.author,
                        content:post.content[0],
                        image:post.image
                    }).$save(function (post) {
                        $scope.posts.push(post);
                        $scope.newPost = "";
                        $location.path('/posts');
                    });

                };

                // $scope.openPost = function (postId) {
                //     Posts.queryForPostId({
                //         id: postId
                //     }, function (post) {
                //         $scope.post = post;
                //        // $location.path('/post/' + postId);
                //     });
                // };

            }])
    .controller('PostViewController', function($scope, Posts, $routeParams) {
        console.log('Hello');
         Posts.get({
            id: $routeParams.id
        },function(post) {
                    $scope.post = post;
          });
    })
    .controller('NavigationController',
        ['$rootScope', '$http', '$location', '$route',
            function ($rootScope, $http, $location, $route) {
                var self = this;

                self.tab = function (route) {
                    return $route.current && route === $route.current.controller;
                };

                var authenticate = function (credentials, callback) {

                    var headers = credentials ? {
                        authorization: "Basic "
                        + btoa(credentials.username + ":"
                            + credentials.password)
                    } : {};

                    $http.get('user', {
                        headers: headers
                    }).then(function (response) {
                        if (response.data.name) {
                            $rootScope.authenticated = true;
                        } else {
                            $rootScope.authenticated = false;
                        }
                        callback && callback($rootScope.authenticated);
                    }, function () {
                        $rootScope.authenticated = false;
                        callback && callback(false);
                    });

                }

                authenticate();

                self.credentials = {};
                self.login = function () {
                    authenticate(self.credentials, function (authenticated) {
                        if (authenticated) {
                            console.log("Login succeeded")
                            $location.path("/home");
                            self.error = false;
                            $rootScope.authenticated = true;
                        } else {
                            console.log("Login failed")
                            $location.path("/login");
                            self.error = true;
                            $rootScope.authenticated = false;
                        }
                    })
                };

                self.logout = function () {
                    $http.post('logout', {}).finally(function () {
                        $rootScope.authenticated = false;
                        $location.path("/");
                    });
                }

            }])
    .controller
    ('HomeController',
        ['$scope', '$http',
            function ($scope, $http) {
                var self = this;
                $http.get('/resource/').then(function (response) {
                    self.greeting = response.data;
                });
            }]).
controller('CommentController', function($scope, Comments, $routeParams){
    console.log('Commment');
    $scope.comments = {};
    $scope.comment = {};

    $scope.addComment = function (comment) {
        new Comments({
            comment:comment.content,
            author:comment.author,
            postid:comment.postid
        }).$save(function (comment) {
            $scope.comments.push(comment);
            $scope.comment = "";
           // $location.path('/posts');
        });

    };




});;

