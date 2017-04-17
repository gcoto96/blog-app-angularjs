'use strict';

angular.module('myApp.services', ['ngResource']).factory('Posts', function($resource) {
    //Resource Factory for Posts
    return $resource('/posts/:id', { id: '@_id' }, {
        update: {
            method: 'PUT'
        },
        queryForPostId: {
            isArray: false
        }
    });
}).factory('Comments', function($resource) {
    //Resource Factory for Comments
    return $resource('/comments/:id', { id: '@_id' }, {
        update: {
            method: 'PUT'
        },
        queryForPostId: {
            isArray: false
        }
    });
});