'use strict';

/* Controllers */
//TODO refractor these controllers to separate module

//Post controller for making REST backend calls
angular.module('myApp.controllers', [])
    .controller('PostController',
        ['$scope', 'Posts', '$location', '$state',
            function ($scope, Posts, $location, $state) {
                $scope.errors = {};
                $scope.posts = {};

            //Fetching all posts
                $scope.posts = Posts.query({});

            //Adding post
                $scope.addPost = function (post) {
                    $scope.post = {};
                    new Posts({
                        title: post.title,
                        author: $scope.userName,
                        content: post.content[0],
                        image: post.image
                    }).$save(function (post) {
                        $scope.posts.push(post);
                        $scope.newPost = "";
                        $location.path('/posts');


                    });

                };

            }])
    .controller('PostViewController', function ($rootScope, $scope, Posts, $routeParams) {

        //Fetching a particular post with postId
        Posts.get({
            id: $routeParams.id
        }, function (post) {

            if (post.image) {
                $rootScope.containsImage = true;
            } else {
                $rootScope.containsImage = false;
            }
            $scope.post = post;
        });
    })
    .controller('NavigationController',
        ['$rootScope', '$http', '$location', '$route',
            function ($rootScope, $http, $location, $route) {

                // Navigation controller to do basic auth and session management (reference spring security materials)
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
                            $rootScope.userName = response.data.name;
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
                            $location.path("/index");
                            self.error = false;
                            $rootScope.authenticated = true;
                        } else {
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
            }])
    .controller('CommentControllers', function ($scope, Comments, $location) {
        // Comment controller to add comments
        $scope.comments = [];
        $scope.addComment = function () {
            console.log($scope.txtcomment);
            if ($scope.txtcomment != '') {
                new Comments({
                    content: $scope.txtcomment,
                    author: $scope.author,
                    postId: $scope.post.id
                }).$save(function (comment) {
                    $scope.post.comments.push(comment);
                });
            }

        }

    });

