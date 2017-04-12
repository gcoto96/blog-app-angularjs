'use strict';

/* Services */
//
// angular.module('myApp.services', ['ngResource'])
//
// .factory('postFactory', function($resource) {
//
// return $resource('/posts/:id', {
//       id: '@id'
//     }, {
//       update: {
//         method: "PUT"
//       },
//       remove: {
//         method: "DELETE"
//       },
//        queryForPostId:{
//            isArray: false
//        }
//     });
//   });



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