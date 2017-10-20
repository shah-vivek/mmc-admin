define([
	'angular'

], function (
	ng
) {
	'use strict';
	return [ '$scope' , '$location', '$stateParams', 'membershipTypeService',
	function ( $scope ,  $location , $stateParams , membershipTypeService) {

            var getMemberSuccess = function( data ) {

                $scope.membership = data;
                $scope.membershipClone = ng.copy( $scope.membership );

            };

            var getMemberError = function( data ) {

            };

            membershipTypeService.get( $stateParams.id ).success( getMemberSuccess ).error( getMemberError );



            var updateSuccess = function( data ) {
                $scope.membership = ng.copy( $scope.membershipClone );
                alert(data.statusMsg);
            };

            var updateError = function( data ) {

            };

            $scope.save = function() {
                 membershipTypeService.update( $scope.membershipClone ).success( updateSuccess ).error( updateError );
            };

            $scope.reset = function() {
                $scope.membershipClone = ng.copy( $scope.membership );
            };


	}];
});