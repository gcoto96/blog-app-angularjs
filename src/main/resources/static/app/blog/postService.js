(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('PostService', PostService);

    PostService.$inject = ['$resource'];

    function PostService($resource) {
        console.log('PostService');
        var Post = $resource('http://localhost:9119/posts', {}, {
            'query': {isArray: true}
        });

        // var Post =  $resource('/posts/:id', {
        //     id: '@id'
        // }, {
        //     update: {
        //         method: "PUT"
        //     },
        //     remove: {
        //         method: "DELETE"
        //     }
        // });

        PostService.search = function (callback) {
            console.log('PostService search');
            Post.query(function (response) {
                console.log('PostService exe');
                var people = response._embedded.people;
                var results = people.filter(function (item) {
                    return JSON.stringify(item).toLowerCase().includes(term.toLowerCase());
                });
                return callback(results);
            });
        };

        PostService.fetch = function (id, callback) {
            Post.query(function (response) {
                var results = response.filter(function (item) {
                    return item.id === parseInt(id);
                });
                return callback(results[0]);
            });
        };

        return Post;
    }
})();
