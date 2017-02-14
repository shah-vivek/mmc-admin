define([
	'angular'

], function (
	ng
) {
	'use strict';
	return [ '$scope' , '$location', 'albumService' ,
	function ( $scope ,  $location , albumService ) {


                $scope.album = {
                               albumId: null,
                               albumName: null
                              };
                $scope.addAlbum = function(){

                    albumService.add($scope.album).success( addSuccess ).error( addError );
                };

                var addSuccess = function( data ) {
                    console.log(data);
                    alert(data.statusMsg);
                    $scope.album.albumName = null;
                };

                var addError = function( data ) {
                    console.log(data);
                };

	}];
});