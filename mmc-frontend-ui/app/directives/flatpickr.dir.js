define([
	'angular',
    'flatpickr'
], function(
	ng, flatpickr
) {
	'use strict';

	var module = ng.module('app.flatpickr', []);

	module.directive('mmcFlatpickr',function() {
		return {
        		restrict : 'A',
				require : ['ngModel'],
        		link : function(scope, element, attrs, controller) {
        			var x = element.flatpickr( JSON.parse(attrs.mmcFlatpickr));
					scope.apply(function(){
						x.destroy();
						x  = element.flatpickr( JSON.parse(attrs.mmcFlatpickr));
					});
        		}
        };
	});
});