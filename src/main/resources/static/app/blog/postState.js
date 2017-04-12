(function () {
    'use strict';

    angular.module('myApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        console.log($stateProvider);
        $stateProvider
            .state('posts', {
                url: '/posts',
                templateUrl: 'blog/postList.html',
                controller: 'postController',
                controllerAs: 'ps',
                resolve: {
                    posts: function (PostService) {
                        return PostService.search();
                    }
                }
            });
    }
})();
