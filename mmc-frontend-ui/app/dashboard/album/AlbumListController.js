define([
	'angular'

], function (
	ng
) {
	'use strict';
	return [ '$scope' , '$location', 'albumService' ,
	function ( $scope ,  $location , albumService ) {


	        var getSuccess = function( data ) {
	            console.log(data);
	            $scope.albums = data;
	        };

            var getError = function( data ) {
                console.log(data);
            };

            albumService.get().success( getSuccess ).error( getError );




	}];
});