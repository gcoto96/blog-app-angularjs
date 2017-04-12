/**
 * Created by nasheikh on 4/9/17.
 */
(function () {
    'use strict';

    angular
        .module('myApp')
        .controller('postController', postController);

    postController.$inject = ['PostService'];

    function postController(PostService) {
        console.log('PostService1');
        var ps = this;

        ps.search = function () {
            console.log('PostService2');
            PostService.search(function (response) {
                ps.searchResults = response;
            });
        };
    }
})();
