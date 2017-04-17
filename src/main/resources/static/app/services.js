'use strict';

angular.module('myApp.services', ['ngResource']).factory('Posts', function($resource) {
    return $resource('/posts/:id', { id: '@_id' }, {
        update: {
            method: 'PUT'
        },
        queryForPostId: {
            isArray: false
        }
    });
}).factory('Comments', function($resource) {
    return $resource('/comments/:id', { id: '@_id' }, {
        update: {
            method: 'PUT'
        },
        queryForPostId: {
            isArray: false
        }
    });
});