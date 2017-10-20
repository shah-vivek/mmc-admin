define([
	'angular'

], function (
	ng
) {
	'use strict';
	return [ '$scope' , '$location',  'membershipTypeService' ,
	function ( $scope ,  $location ,  membershipTypeService) {

        $scope.membership = {
                         "id": null,
                         "name": null,
                         "description": null,
                         "duration": null,
                         "cost": null
        };


        $scope.add = function(){
            membershipTypeService.add( $scope.membership ).success( addSuccess ).error( addError );
        };

        var addSuccess  = function( data ){

                alert( data.statusMsg );
                if( data.status == 'SUCCESS'){
                    $location.path('/dashboard/membership/list');
                }
        };

        var addError = function( data ) {

        };


	}];
});