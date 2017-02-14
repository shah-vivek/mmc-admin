define([
	'angular'

], function (
	ng
) {
	'use strict';
	return [ '$scope' , '$location', '$stateParams', 'albumService' ,
	function ( $scope ,  $location ,  $stateParams , albumService ) {

            $scope.showUpload = true;

	        var getSuccess = function( data ) {
	            console.log(data);
	            $scope.images = data;
	        };

            var getError = function( data ) {
                console.log(data);
            };

            albumService.getAlbum( $stateParams.id ).success( getSuccess ).error( getError );


            var uploadSuccess = function( data ){
                console.log(data);
                albumService.getAlbum( $stateParams.id ).success( getSuccess ).error( getError );
            };

            var uploadError = function( data ){
                console.log(data);
            };
            $scope.uploadFile = function() {
            				var file = $scope.myFile;
            				var name = 'Salil';
            				var albumId = $stateParams.id;
            				var date = new Date();
            				    date = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
            				console.log('file is ' + JSON.stringify(file));
            				albumService.upload( file, name, albumId , date).success( uploadSuccess ).error( uploadError );
            };

            $scope.cancel = function(){
                $scope.myFile = undefined;
            };

            // initial image index
            $scope._Index = 0;
            // if a current image is the same as requested image
            $scope.isActive = function (index) {
                 return $scope._Index === index;
            };
            // show prev image
            $scope.showPrev = function () {
                    $scope._Index = ($scope._Index > 0) ? --$scope._Index : $scope.images.length - 1;
            };
            // show next image
            $scope.showNext = function () {
                    $scope._Index = ($scope._Index < $scope.images.length - 1) ? ++$scope._Index : 0;
            };
            // show a certain image
            $scope.showPhoto = function (index) {
                    $scope._Index = index;
            };
	}];
});