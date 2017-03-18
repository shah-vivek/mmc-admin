define([
	'angular',
	'pikaday',
	'moment'

], function (
	ng,
	pikaday,
	moment
) {
	'use strict';
	return [ '$scope' , '$location', '$state' , 'localStorageService' ,
	function ( $scope ,  $location , $state ,  localStorageService) {
        $scope.logOut = function() {

            localStorageService.remove('user');
            $state.go('login');
        };

	}];
});