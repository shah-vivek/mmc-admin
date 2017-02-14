define([
	'angular'

], function (
	ng
) {
	'use strict';
	return [ '$scope' , '$location', '$stateParams', 'memberService',
	function ( $scope ,  $location , $stateParams , memberService) {

            var getMemberSuccess = function( data ) {

                $scope.member = data;
                $scope.memberClone = ng.copy( $scope.member );

            };

            var getMemberError = function( data ) {

            };

            memberService.get( $stateParams.user ).success( getMemberSuccess ).error( getMemberError );



            var updateSuccess = function( data ) {
                $scope.member = ng.copy( $scope.memberClone );
                alert(data.statusMsg);
            };

            var updateError = function( data ) {

            };

            $scope.save = function() {
                 memberService.update( $scope.memberClone ).success( updateSuccess ).error( updateError );
            };

            $scope.reset = function() {
                $scope.memberClone = ng.copy( $scope.member );
            };


	}];
});